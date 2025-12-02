package com.example.recipeplanner
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity (
    @PrimaryKey(autoGenerate = true) val recipe_id : Int,
    val name : String,
    val prepTimeMin: Int,
    val cookTimeMin: Int,
    val servings: Int,
    val meal: String,
    val image: Int? = null
)