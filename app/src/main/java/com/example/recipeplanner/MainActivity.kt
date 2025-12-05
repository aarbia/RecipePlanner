package com.example.recipeplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.recipeplanner.data.RecipeRepository
import com.example.recipeplanner.data.local.RecipeDatabase
import com.example.recipeplanner.ui.RecipeViewModel
import com.example.recipeplanner.ui.theme.RecipePlannerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // build DB + DAO + Repository
        val db = RecipeDatabase.getInstance(applicationContext)
        val dao = db.recipeDAO()
        val repo = RecipeRepository(dao)

        // seed DB once (if empty)
        lifecycleScope.launch {
            repo.seedIfEmpty(seedRecipes)
        }

        // build ViewModel with repo
        val viewModelFactory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(RecipeViewModel::class.java)) {
                    return RecipeViewModel(repo) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }

        val recipeViewModel = ViewModelProvider(this, viewModelFactory)
            .get(RecipeViewModel::class.java)

        // pass ViewModel into composable
        setContent {
            RecipePlannerTheme {
                RecipePlannerApp(recipeViewModel)
            }
        }
    }
}

