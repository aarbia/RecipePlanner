package com.example.recipeplanner.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//A table for individual items in the shopping screen
@Entity(tableName = "shopping_items")
data class ShoppingItemsEntity (
    @PrimaryKey(autoGenerate = true) val item_id : Int = 0,
    val name : String,
    val isChecked : Boolean = false
)