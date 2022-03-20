package com.example.androiddatabaselesson2foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androiddatabaselesson2foodapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.menu.setOnClickListener {
            findNavController().navigate(R.id.menuFoodFragment)
        }
        binding.addFood.setOnClickListener {
            findNavController().navigate(R.id.addFoodFragment)

        }
        return binding.root
    }


}