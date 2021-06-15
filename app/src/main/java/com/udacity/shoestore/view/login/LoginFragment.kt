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
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        viewModel.eventUserCreated.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(context, "User created.", Toast.LENGTH_SHORT).show()
                viewModel.onCreateUserComplete()
            }
        })

        viewModel.eventUserLogged.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(context, "User logged", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

}