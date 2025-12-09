package com.example.recipeplanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark

@Composable
fun MenuScreen(recipes: List<Recipes>, onRecipeClick: (Int) -> Unit) {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    // Pre-select 7 unique recipes for each meal type
    val breakfasts = remember(recipes) { recipes.filter { it.meal == "Breakfast" }.shuffled().take(7) }
    val lunches = remember(recipes){recipes.filter{it.meal=="Lunch"}.shuffled().take(7)}
    val appetizers = remember(recipes){recipes.filter{it.meal=="Appetizer"}.shuffled().take(7)}
    val dinners = remember(recipes) { recipes.filter { it.meal == "Dinner" }.shuffled().take(7) }
    val desserts = remember(recipes) { recipes.filter { it.meal == "Dessert" }.shuffled().take(7) }

    // Assign one recipe per meal per day
    val weeklyMenu = remember(recipes) {
        daysOfWeek.indices.associate { i ->
            daysOfWeek[i] to mapOf(
                "Breakfast" to breakfasts.getOrNull(i),
                "Lunch" to lunches.getOrNull(i),
                "Appetizer" to lunches.getOrNull(i),
                "Dinner" to dinners.getOrNull(i),
                "Dessert" to desserts.getOrNull(i)
            )
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(daysOfWeek) { day ->
            val menu = weeklyMenu[day]!!
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(containerColor = Cream)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = day, style = MaterialTheme.typography.titleLarge, color = MauveBark)
                    Spacer(modifier = Modifier.height(8.dp))

                    menu.forEach { (mealType, recipeItem) ->
                        recipeItem?.let { recipe ->
                            Text(
                                text = "$mealType: ${recipe.name}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                                    .clickable { onRecipeClick(recipes.indexOf(recipe)) }
                                    .padding(vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
