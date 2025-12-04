package com.example.recipeplanner.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.recipeplanner.data.local.DirectionsEntity
import com.example.recipeplanner.data.local.IngredientEntity
import com.example.recipeplanner.data.local.RecipeEntity

data class RecipeWithDetails(
    @Embedded val recipe: RecipeEntity,

    @Relation(
        parentColumn = "recipe_id",      // PK in RecipeEntity
        entityColumn = "recipe_id"       // FK in IngredientEntity
    )
    val ingredients: List<IngredientEntity>,

    @Relation(
        parentColumn = "recipe_id",      // PK in RecipeEntity
        entityColumn = "recipe_id"       // FK in DirectionsEntity
    )
    val directions: List<DirectionsEntity>
)
