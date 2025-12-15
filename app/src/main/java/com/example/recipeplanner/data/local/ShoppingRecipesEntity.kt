package com.example.recipeplanner.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

//A table for selected recipes in the shopping screen
@Entity(
    tableName = "shopping_recipes",
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["recipe_id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [Index("recipe_id")]
)
data class ShoppingRecipesEntity (
    @PrimaryKey val recipe_id : Int
)