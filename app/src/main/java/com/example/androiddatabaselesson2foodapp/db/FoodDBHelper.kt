package com.example.androiddatabaselesson2foodapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.androiddatabaselesson2foodapp.model.DatabaseService
import com.example.androiddatabaselesson2foodapp.model.Food
import com.example.androiddatabaselesson2foodapp.utils.Constant

class FoodDBHelper(context: Context) :
    SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.VERSION), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table food (${Constant.ID} integer not null primary key autoincrement unique,${Constant.NAME} text not null,${Constant.PRODUCTS} text not null,${Constant.PREPARE} text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addFood(food: Food) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.NAME, food.name)
        contentValues.put(Constant.PRODUCTS, food.products)
        contentValues.put(Constant.PREPARE, food.prepare)
        database.insert(Constant.TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun getFoodById(id: Int): Food {
        val database = this.readableDatabase
        val cursor = database.query(
            Constant.TABLE_NAME,
            arrayOf(Constant.ID, Constant.NAME, Constant.PRODUCTS, Constant.PREPARE),
            "${Constant.ID} = ?",
            arrayOf("$id"),
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        return Food(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3))
    }

    override fun getAllFood(): ArrayList<Food> {
        var foodList = ArrayList<Food>()
        val query = "select *from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val food = Food(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
                )
                foodList.add(food)
            } while (cursor.moveToNext())
        }
        return foodList
    }
}