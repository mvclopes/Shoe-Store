package com.udacity.shoestore.view.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.recyclerViewShoeList.adapter = ShoeListAdapter(viewModel.shoeList)
        binding.recyclerViewShoeList.layoutManager = LinearLayoutManager(context)

        binding.fabGoShoeDetails.setOnClickListener {
            //TODO: implementar navegação para tela de SHoe Details
            Toast.makeText(context, "We're gonna shoe details screen. Are you ready?!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}