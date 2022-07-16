package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //TODO (5) Use DataBindingUtil to inflate every layout
        val binding =
            FragmentShoeListBinding.inflate(
                inflater,
                container,
                false
            ) //TODO: Udacity suggestion
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        binding.shoeListViewModel = viewModel

        with(binding) {
            shoeListViewModel = viewModel

            floatingActionButton.setOnClickListener {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
            }
        }

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            for (shoeItem in shoeList) {
                val shoeBinding: ShoeItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_item, container, false)
                shoeBinding.shoe = shoeItem
                binding.shoeList.addView(shoeBinding.root)
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {

            //TODO: (13) In MainActivity, add a Logout menu to return to the login screen
            findNavController().navigate(R.id.loginFragment)
        }
        return false
    }
}