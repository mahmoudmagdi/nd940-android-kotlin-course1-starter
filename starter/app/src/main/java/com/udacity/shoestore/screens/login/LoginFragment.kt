package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding

//TODO: (7) Create a new Login destination
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //TODO (5) Use DataBindingUtil to inflate every layout
        val binding =
            FragmentLoginBinding.inflate(
                inflater,
                container,
                false
            ) //TODO: Udacity suggestion

        with(binding) { //TODO: Udacity suggestion

            loginBtn.setOnClickListener {
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }

            createBtn.setOnClickListener {
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }


        return binding.root
    }
}