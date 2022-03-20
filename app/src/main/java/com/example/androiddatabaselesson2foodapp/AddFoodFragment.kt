package com.example.androiddatabaselesson2foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.androiddatabaselesson2foodapp.databinding.FragmentAddFoodBinding
import com.example.androiddatabaselesson2foodapp.db.FoodDBHelper
import com.example.androiddatabaselesson2foodapp.model.Food

class AddFoodFragment : Fragment() {
    lateinit var binding: FragmentAddFoodBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddFoodBinding.inflate(inflater, container, false)
        val foodDatabase = FoodDBHelper(requireContext())

        binding.save.setOnClickListener {
            val foodName = binding.foodName.text.toString()
            val foodProducts = binding.foodProducts.text.toString()
            val foodCooking = binding.foodCooking.text.toString()
            var bolName = false
            var bolProducts = false
            var bolCooking = false
            for (c in foodName) {
                if (c != ' ') {
                    bolName = true
                    break
                }
            }
            for (c in foodProducts) {
                if (c != ' ') {
                    bolProducts = true
                    break
                }
            }
            for (c in foodCooking) {
                if (c != ' ') {
                    bolCooking = true
                    break
                }
            }
            if (foodName != "" && foodProducts != "" && foodCooking != "" && bolName && bolProducts && bolCooking) {
                val food = Food(foodName, foodProducts, foodCooking)
                Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
                foodDatabase.addFood(food)
                findNavController().popBackStack()
            }
        }

        return binding.root
    }


}