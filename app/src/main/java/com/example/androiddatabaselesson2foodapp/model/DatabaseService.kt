package com.example.androiddatabaselesson2foodapp.model

interface DatabaseService {
    fun addFood(food: Food)
    fun getFoodById(id: Int): Food
    fun getAllFood(): ArrayList<Food>
}