package com.example.recipeplanner

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.recipeplanner.data.RecipeRepository
import com.example.recipeplanner.data.ShoppingRepository
import com.example.recipeplanner.data.WeeklyMenuRepository
import com.example.recipeplanner.data.local.RecipeDatabase
import com.example.recipeplanner.ui.RecipeViewModel
import com.example.recipeplanner.ui.ShoppingListViewModel
import com.example.recipeplanner.ui.WeeklyMenuViewModel
import com.example.recipeplanner.ui.theme.RecipePlannerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // build DB
        val db = RecipeDatabase.getInstance(applicationContext)

        // Reference DAOs
        val recipeDao = db.recipeDAO()
        val shoppingListDao = db.shoppingListDAO()
        val weeklyMenuDao = db.weeklyMenuDAO()

        // Repositories
        val recipeRepo = RecipeRepository(recipeDao)
        val shoppingListRepo = ShoppingRepository(shoppingListDao, recipeDao)
        val weeklyMenuRepo = WeeklyMenuRepository(weeklyMenuDao, recipeDao)

        // seed DB once (if empty)
        lifecycleScope.launch {
            recipeRepo.seedIfEmpty(seedRecipes)
        }

        // build Factory for all ViewModels
        val viewModelFactory = object : ViewModelProvider.Factory {
            @RequiresApi(Build.VERSION_CODES.O)
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return when {
                    modelClass.isAssignableFrom(RecipeViewModel::class.java) ->
                        RecipeViewModel(recipeRepo) as T
                    modelClass.isAssignableFrom(ShoppingListViewModel::class.java) ->
                        ShoppingListViewModel(shoppingListRepo) as T
                    modelClass.isAssignableFrom(WeeklyMenuViewModel::class.java) ->
                        WeeklyMenuViewModel(weeklyMenuRepo) as T
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            }
        }

        // Create ViewModels
        val recipeViewModel = ViewModelProvider(this, viewModelFactory)[RecipeViewModel::class.java]
        val shoppingListViewModel = ViewModelProvider(this, viewModelFactory)[ShoppingListViewModel::class.java]
        val weeklyMenuViewModel = ViewModelProvider(this, viewModelFactory)[WeeklyMenuViewModel::class.java]

        // pass ViewModel into composable
        setContent {
            RecipePlannerTheme {
                RecipePlannerApp(
                    recipeViewModel = recipeViewModel,
                    shoppingListViewModel = shoppingListViewModel,
                    weeklyMenuViewModel = weeklyMenuViewModel
                    )
            }
        }
    }
}

