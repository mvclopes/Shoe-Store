package com.udacity.shoestore.view.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsAddBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.view.shoeList.ShoeListViewModel
import timber.log.Timber
import kotlin.reflect.typeOf

class ShoeDetailsAddFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailsAddBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsAddBinding.inflate(inflater, container, false)
        binding.shoeDetails = Shoe()

        binding.btnSave.setOnClickListener {
            val newShoe = binding.shoeDetails!!
            viewModel.addNewShoe(newShoe)
            Timber.i("ViewModel -> ${viewModel.shoeList.value}")
            findNavController().navigateUp()
        }

        binding.btnCancel.setOnClickListener { findNavController().navigateUp() }

        return binding.root
    }

}