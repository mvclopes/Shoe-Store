package com.udacity.shoestore.view.welcome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import timber.log.Timber

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var viewModelFactory: WelcomeViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val welcomeFragmentArgs by navArgs<WelcomeFragmentArgs>()
        viewModelFactory = WelcomeViewModelFactory(welcomeFragmentArgs.userName)
        viewModel = ViewModelProvider(this, viewModelFactory).get(WelcomeViewModel::class.java)

        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.fabInstructions.setOnClickListener{
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        return binding.root
    }

}