package com.example.recipeplanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.stylusHoverIcon
import androidx.compose.ui.unit.dp
import com.example.recipeplanner.ui.WeeklyMenuViewModel
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark

@Composable
fun MenuScreen(weeklyMenuViewModel: WeeklyMenuViewModel, onRecipeClick: (Int) -> Unit) {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    // Pull DB menu from view model
    val weeklyMenu = weeklyMenuViewModel.menu

    //Load when screen first appears
    LaunchedEffect(Unit) {
        weeklyMenuViewModel.loadWeek()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Weekly Menu - ${weeklyMenuViewModel.weekStart}",
                    style = MaterialTheme.typography.titleLarge,
                    color = MauveBark
                )
            }
            if (weeklyMenu.isEmpty()) {
                Button(onClick = {weeklyMenuViewModel.generateThisWeek()}) {
                    Text("Generate this week's menu!")
                }
            } else {
                OutlinedButton(onClick = { weeklyMenuViewModel.clearThisWeek()}) {
                    Text("Clear week's menu.")
                }
            }
            Spacer(Modifier.height(12.dp))
        }

        if (weeklyMenu.isEmpty()) {
            item {
                Text(
                    text = "No menu created yet. Tap Generate button to continue.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MauveBark
                )
            }
        } else {

        }
        items(daysOfWeek) { day ->
            val menuForDay = weeklyMenu[day].orEmpty()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                colors = CardDefaults.cardColors(containerColor = Cream)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = day, style = MaterialTheme.typography.titleLarge, color = MauveBark)
                    Spacer(modifier = Modifier.height(8.dp))

                    val mealOrder = listOf("Breakfast", "Lunch", "Appetizer", "Dinner", "Dessert")
                    mealOrder.forEach { mealType ->
                        val recipe = menuForDay[mealType]
                        if (recipe != null){
                            Text(
                                text = "$mealType: ${recipe.name}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                                    .clickable { onRecipeClick(recipe.id) }
                                    .padding(vertical = 2.dp)
                            )
                        } else {
                            Text(
                                text = "$mealType: -",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                                    .padding(vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
