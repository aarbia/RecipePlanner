package com.example.recipeplanner.data

import com.example.recipeplanner.Recipes
import com.example.recipeplanner.data.local.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShoppingRepository(
    private val shoppingDao: ShoppingListDAO,
    private val recipeDao: RecipeDAO
) {

    // Recipe cards on Shopping screen
    suspend fun addRecipeToShopping(recipeId: Int) = withContext(Dispatchers.IO) {
        shoppingDao.addRecipe(ShoppingRecipesEntity(recipe_id = recipeId))
    }

    suspend fun removeRecipeFromShopping(recipeId: Int) = withContext(Dispatchers.IO) {
        shoppingDao.removeRecipe(recipeId)
    }

    // Returns FULL recipe UI models for only the recipes currently selected for shopping.
    suspend fun getShoppingRecipes(): List<Recipes> = withContext(Dispatchers.IO) {
        val ids: List<Int> = shoppingDao.getShoppingRecipeIds()
        if (ids.isEmpty()) return@withContext emptyList()

        val all: List<Recipes> = recipeDao.getAllRecipesWithDetails().map { it.toModel() }
        all.filter { it.id in ids }
            // keep the same order as ids were returned
            .sortedBy { ids.indexOf(it.id) }
    }

    // Standalone items on Shopping screen

    suspend fun getShoppingItems(): List<ShoppingItemsEntity> = withContext(Dispatchers.IO) {
        shoppingDao.getShoppingItems()
    }

    suspend fun addShoppingItem(name: String) = withContext(Dispatchers.IO) {
        val trimmed = name.trim()
        if (trimmed.isNotEmpty()) {
            shoppingDao.addItem(ShoppingItemsEntity(name = trimmed, isChecked = false))
        }
    }

    suspend fun deleteShoppingItem(id: Int) = withContext(Dispatchers.IO) {
        shoppingDao.deleteItem(id)

    }

    suspend fun toggleShoppingItem(itemId: Int, checked: Boolean) = withContext(Dispatchers.IO) {
        shoppingDao.toggleItem(itemId, checked)
    }
}
