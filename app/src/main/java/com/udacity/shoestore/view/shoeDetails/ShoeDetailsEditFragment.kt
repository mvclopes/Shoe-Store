package com.udacity.shoestore.view.shoeDetails

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.view.shoeList.ShoeListViewModel

class ShoeDetailsEditFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailsBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.findItem(R.id.item_logout).isVisible = false
    }
}