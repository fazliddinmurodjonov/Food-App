package com.example.androiddatabaselesson2foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androiddatabaselesson2foodapp.databinding.FragmentAboutFoodBinding
import com.example.androiddatabaselesson2foodapp.db.FoodDBHelper


class AboutFoodFragment : Fragment() {

    lateinit var binding: FragmentAboutFoodBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutFoodBinding.inflate(inflater, container, false)

        val id = arguments?.getInt("food")

        val foodDatabase = FoodDBHelper(requireContext())
        val food = foodDatabase.getFoodById(id!!)

        binding.foodNameAbout.text = food.name
        binding.foodProductsAbout.text = food.products
        binding.foodCookingAbout.text = food.prepare
        return binding.root
    }

}