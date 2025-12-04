package com.example.recipeplanner.data

import com.example.recipeplanner.Recipes
import com.example.recipeplanner.data.local.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepository(
    private val dao: RecipeDAO
) {

    // read all recipes as your UI model
    suspend fun getAllRecipes(): List<Recipes> = withContext(Dispatchers.IO) {
        dao.getAllRecipesWithDetails().map { it.toModel() }
    }

    // add a new recipe + its ingredients + directions
    suspend fun addRecipe(
        uiRecipe: Recipes,
        ingredients: List<String>,
        directions: List<String>
    ) = withContext(Dispatchers.IO) {
        // 1. insert into recipes table
        val recipeId = dao.insertRecipe(
            RecipeEntity(
                name = uiRecipe.name,
                prepTimeMin = uiRecipe.prepTimeMin,
                cookTimeMin = uiRecipe.cookTimeMin,
                servings = uiRecipe.servings,
                meal = uiRecipe.meal,
                image = uiRecipe.image
            )
        ).toInt()

        // 2. insert ingredients
        val ingredientEntities = ingredients
            .filter { it.isNotBlank() }
            .mapIndexed { index, txt ->
                IngredientEntity(
                    recipe_id = recipeId,
                    position = index,
                    ingredient = txt
                )
            }

        // 3. insert directions
        val directionEntities = directions
            .filter { it.isNotBlank() }
            .mapIndexed { index, txt ->
                DirectionsEntity(
                    recipe_id = recipeId,
                    step_num = index + 1,
                    direction = txt
                )
            }

        dao.insertIngredients(ingredientEntities)
        dao.insertDirections(directionEntities)
    }
}
