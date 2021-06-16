package com.udacity.shoestore.view.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionsBinding.inflate(inflater, container, false)

        binding.fabGoShoeList.setOnClickListener{
            //TODO: navegar para tela da lista de tenis
            Toast.makeText(context, "We're gonna navigate to shoe list screen. Are you ready?!", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}