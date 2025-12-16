package com.example.recipeplanner

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipeplanner.data.WeeklyMenuRepository
import com.example.recipeplanner.data.local.RecipeDatabase
import com.example.recipeplanner.ui.WeeklyMenuViewModel
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark
import java.time.LocalDate

@Composable
fun HomeScreen() {
    val context = LocalContext.current


    val db = remember { RecipeDatabase.getInstance(context) }
    val repo = remember { WeeklyMenuRepository(db.weeklyMenuDAO(), db.recipeDAO()) }
    val weeklyMenuViewModel = remember { WeeklyMenuViewModel(repo) }

    // load menu
    LaunchedEffect(Unit) {
        weeklyMenuViewModel.loadWeek()
    }

    val weeklyMenu = weeklyMenuViewModel.menu

    val today = remember {
        LocalDate.now().dayOfWeek.name
            .lowercase()
            .replaceFirstChar { it.uppercase() }
    }

    val todaysMenu = weeklyMenu[today] ?: emptyMap()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Today's Menu",
            style = MaterialTheme.typography.headlineMedium,
            color = MauveBark
        )

        Spacer(Modifier.height(16.dp))

        if (todaysMenu.isEmpty()) {
            Text(
                text = "No menu today",
                style = MaterialTheme.typography.bodyLarge,
                color = MauveBark
            )
        } else {
            val mealOrder = listOf("Breakfast", "Lunch", "Appetizer", "Dinner", "Dessert")

            mealOrder.forEach { meal ->
                val recipe = todaysMenu[meal]

                if (recipe != null) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Cream),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = meal,
                                style = MaterialTheme.typography.titleLarge,
                                color = MauveBark
                            )

                            Spacer(Modifier.height(8.dp))

                            recipe.image?.let { resId ->
                                Image(
                                    painter = painterResource(id = resId),
                                    contentDescription = recipe.name,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(180.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Spacer(Modifier.height(8.dp))
                            }

                            Text(
                                text = recipe.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
