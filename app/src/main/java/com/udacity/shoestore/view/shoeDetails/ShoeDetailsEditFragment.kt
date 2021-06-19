package com.udacity.shoestore.view.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsEditBinding
import com.udacity.shoestore.view.shoeList.ShoeListViewModel
import timber.log.Timber

class ShoeDetailsEditFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailsEditBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsEditBinding.inflate(inflater, container, false)
        val shoeDetailsEditFragmentArgs by navArgs<ShoeDetailsEditFragmentArgs>()
        val positionId = shoeDetailsEditFragmentArgs.positionId

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            binding.shoeDetails = it[positionId]
        })

        binding.btnSave.setOnClickListener {
            viewModel.updateShoeList(positionId, binding.shoeDetails)
            findNavController().navigateUp()
        }

        binding.btnCancel.setOnClickListener { findNavController().navigateUp() }

        return binding.root
    }

}