package com.example.recipeplanner.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.recipeplanner.data.local.RecipeEntity

@Entity(
    tableName = "ingredients",
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class, // The parent entity (table)
            parentColumns = ["recipe_id"], // The primary key column in the parent entity
            childColumns = ["recipe_id"], // The foreign key column in the child entity
            onDelete = ForeignKey.Companion.CASCADE, // Action on parent deletion
            onUpdate = ForeignKey.Companion.CASCADE // Action on parent update
        )],
    indices = [Index("recipe_id")]
    )
data class IngredientEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val recipe_id : Int,
    val position : Int,
    val ingredient : String
)