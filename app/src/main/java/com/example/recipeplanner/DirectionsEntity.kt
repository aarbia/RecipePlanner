package com.example.recipeplanner

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "directions",
    foreignKeys = [
        ForeignKey(entity = RecipeEntity::class, // The parent entity (table)
            parentColumns = ["recipe_id"], // The primary key column in the parent entity
            childColumns = ["recipe_id"], // The foreign key column in the child entity
            onDelete = ForeignKey.CASCADE, // Action on parent deletion
            onUpdate = ForeignKey.CASCADE // Action on parent update
        )],
    indices = [Index("recipe_id")]
)
data class DirectionsEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val recipe_id : Int,
    val step_num : Int,
    val direction : String
)