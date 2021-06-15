package com.udacity.shoestore.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.eventUserCreated.observe(viewLifecycleOwner, Observer {
            if (it){
                Timber.i("User ${viewModel._user.value} created and logged")
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment("new user ${viewModel._user.value}"))
                viewModel.onCreateUserComplete()
            }
        })

        viewModel.eventUserLogged.observe(viewLifecycleOwner, Observer {
            if (it){
                Timber.i("User ${viewModel._user.value} logged")
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(viewModel._user.value?: "generic_user"))

            }
        })

        return binding.root
    }

}