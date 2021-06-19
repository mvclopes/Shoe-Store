package com.udacity.shoestore.view.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

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
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsAddFragment())
        }

        return binding.root
    }

}