package com.example.recipeplanner.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeplanner.Recipes
import com.example.recipeplanner.data.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel(private val repo: RecipeRepository) : ViewModel() {

    var recipes by mutableStateOf<List<Recipes>>(emptyList())
        private set

    init {
        loadRecipes()
    }

    fun loadRecipes() {
        viewModelScope.launch {
            recipes = repo.getAllRecipes()
        }
    }

    fun addRecipe(r: Recipes, ingredients: List<String>, directions: List<String>) {
        viewModelScope.launch {
            repo.addRecipe(r, ingredients, directions)
            loadRecipes()
        }
    }

    fun deleteRecipe(id: Int) {
        viewModelScope.launch {
            repo.deleteRecipe(id)
            loadRecipes()
        }
    }
}
