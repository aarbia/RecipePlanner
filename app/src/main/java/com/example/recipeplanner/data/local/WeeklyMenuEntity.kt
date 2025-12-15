package com.example.recipeplanner.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import java.util.stream.IntStream

@Entity(
    tableName = "weekly_menu",
    primaryKeys = ["weekStart", "dayOfWeek", "mealType"],
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class, // The parent entity (table)
            parentColumns = ["recipe_id"], // The primary key column in the parent entity
            childColumns = ["recipe_id"], // The foreign key column in the child entity
            onDelete = ForeignKey.CASCADE, // Action on parent deletion
            onUpdate = ForeignKey.CASCADE // Action on parent update
        )],
    indices = [Index("recipe_id")]
)

data class WeeklyMenuEntity (
    val weekStart : String,
    val dayOfWeek : Int,    // Monday = 0, Tuesday = 1 ...
    val mealType : String,
    val recipe_id : Int
)
