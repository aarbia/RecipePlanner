package com.example.recipeplanner.data

import com.example.recipeplanner.Recipes

// This class will convert DB joined object -> UI model
fun RecipeWithDetails.toModel(): Recipes =
    Recipes(
        name = recipe.name,
        prepTimeMin = recipe.prepTimeMin,
        cookTimeMin = recipe.cookTimeMin,
        ingredients = ingredients
            .sortedBy { it.position }      // keep ingredient order
            .map { it.ingredient },
        directions = directions
            .sortedBy { it.step_num }      // keep step order
            .map { it.direction },
        servings = recipe.servings,
        meal = recipe.meal,
        image = recipe.image
    )