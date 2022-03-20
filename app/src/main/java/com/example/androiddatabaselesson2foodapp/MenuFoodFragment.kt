package com.example.androiddatabaselesson2foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.androiddatabaselesson2foodapp.adapter.FoodAdapter
import com.example.androiddatabaselesson2foodapp.databinding.FragmentMenuFoodBinding
import com.example.androiddatabaselesson2foodapp.db.FoodDBHelper
import com.example.androiddatabaselesson2foodapp.model.Food


class MenuFoodFragment : Fragment() {

    lateinit var binding: FragmentMenuFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuFoodBinding.inflate(inflater, container, false)
        val foodDatabase = FoodDBHelper(requireContext())
        val foodList = foodDatabase.getAllFood()
        var foodAdapter = FoodAdapter(foodList)
        binding.foodRV.adapter = foodAdapter
        foodAdapter.setOnMyItemClickListener(object : FoodAdapter.OnMyItemClickListener {
            override fun onClick(food: Food, position: Int) {
                val bundleOf = bundleOf("food" to food.id)
                findNavController().navigate(R.id.aboutFoodFragment, bundleOf)
            }

        })
        return binding.root
    }

}