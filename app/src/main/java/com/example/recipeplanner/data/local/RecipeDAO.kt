package com.example.recipeplanner.data.local

import androidx.room.*
import com.example.recipeplanner.data.RecipeWithDetails

@Dao
interface RecipeDAO {
    //All recipes with ingredients and directions
    @Transaction
    @Query("SELECT * FROM recipes ORDER BY name")
    suspend fun getAllRecipesWithDetails(): List<RecipeWithDetails>

    //Single recipe with ingredients and directions
    @Transaction
    @Query("SELECT * FROM recipes WHERE recipe_id = :id")
    suspend fun getRecipeWithDetails(id: Int): List<RecipeWithDetails>

    @Query("SELECT COUNT(*) FROM recipes")
    suspend fun countRecipes(): Int

    //Insert
    @Insert
    suspend fun insertRecipe(recipe: RecipeEntity): Long

    @Insert
    suspend fun insertIngredients(ingredients: List<IngredientEntity>)

    @Insert
    suspend fun insertDirections(directions: List<DirectionsEntity>)

    //Update/delete

    @Update
    suspend fun updateRecipe(recipe: RecipeEntity)

    @Delete
    suspend fun deleteRecipe(recipe: RecipeEntity)

    @Query("DELETE FROM ingredients WHERE recipe_id = :recipeID")
    suspend fun deleteIngredientsForRecipe(recipeID: Int)

    @Query("DELETE FROM directions WHERE recipe_id = :recipeID")
    suspend fun deleteDirectionsForRecipe(recipeID: Int)

}