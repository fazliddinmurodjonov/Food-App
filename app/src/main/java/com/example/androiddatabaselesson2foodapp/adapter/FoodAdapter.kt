package com.example.androiddatabaselesson2foodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatabaselesson2foodapp.databinding.ItemFoodBinding
import com.example.androiddatabaselesson2foodapp.model.Food

class FoodAdapter(var foodList: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {
    lateinit var listenerAdapter: OnMyItemClickListener

    interface OnMyItemClickListener {
        fun onClick(food: Food, position: Int)
    }

    fun setOnMyItemClickListener(listener: OnMyItemClickListener) {
        listenerAdapter = listener
    }

    inner class MyViewHolder(var binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(food: Food, position: Int) {
            binding.foodName.text = food.name
            binding.root.setOnClickListener {
                listenerAdapter.onClick(food, position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val food = foodList[position]
        holder.onBind(food, position)
    }

    override fun getItemCount(): Int = foodList.size
}