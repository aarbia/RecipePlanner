package com.example.recipeplanner.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeplanner.Recipes
import com.example.recipeplanner.data.ShoppingRepository
import com.example.recipeplanner.data.local.ShoppingItemsEntity
import kotlinx.coroutines.launch

class ShoppingListViewModel(
    private val repo: ShoppingRepository
) : ViewModel() {

    var shoppingRecipes by mutableStateOf<List<Recipes>>(emptyList())
        private set

    var shoppingItems by mutableStateOf<List<ShoppingItemsEntity>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                shoppingRecipes = repo.getShoppingRecipes()
                shoppingItems = repo.getShoppingItems()
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    // Recipe cards

    fun addRecipeToShopping(recipeId: Int) {
        viewModelScope.launch {
            try {
                repo.addRecipeToShopping(recipeId)
                shoppingRecipes = repo.getShoppingRecipes()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun removeRecipeFromShopping(recipeId: Int) {
        viewModelScope.launch {
            try {
                repo.removeRecipeFromShopping(recipeId)
                shoppingRecipes = repo.getShoppingRecipes()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    // Standalone items

    fun addShoppingItem(name: String) {
        viewModelScope.launch {
            try {
                repo.addShoppingItem(name)
                shoppingItems = repo.getShoppingItems()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun deleteShoppingItem(id: Int) {
        viewModelScope.launch {
            try {
                repo.deleteShoppingItem(id)
                shoppingItems = repo.getShoppingItems()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun toggleShoppingItem(itemId: Int, checked: Boolean) {
        viewModelScope.launch {
            try {
                repo.toggleShoppingItem(itemId, checked)
                shoppingItems = repo.getShoppingItems()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }
}
