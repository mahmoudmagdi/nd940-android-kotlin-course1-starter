package com.udacity.shoestore.screens.shoeDetails

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //TODO (5) Use DataBindingUtil to inflate every layout
        val binding: FragmentShoeDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel

        binding.saveBtn.setOnClickListener {
            val name = binding.nameEdit.text.toString()
            val size = binding.sizeEdit.text.toString()
            val companyName = binding.companyEdit.text.toString()
            val description = binding.descriptionEdit.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(context, "make sure to enter a valid name", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (companyName.isEmpty()) {
                Toast.makeText(
                    context,
                    "make sure to enter a valid company name",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            if (size.isEmpty()) {
                Toast.makeText(context, "make sure to enter a valid size", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (description.isEmpty()) {
                Toast.makeText(context, "make sure to enter a valid description", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }

            viewModel.addNewShoe(name, size.toDouble(), companyName, description)
            findNavController().navigateUp()
            Toast.makeText(context, "shoe added successfully", Toast.LENGTH_LONG)
                .show()
        }

        binding.cancelBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}