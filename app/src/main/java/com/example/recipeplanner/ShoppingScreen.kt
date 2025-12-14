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
import androidx.compose.ui.Alignment

@Composable
fun ShoppingScreen(recipes: List<Recipes>) {

    //currently chosen recipe, expand shopping list
    var expandedRecipe by remember { mutableStateOf<Recipes?>(null) }
    //vert scroll
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //for each recipe in the recipe list
        items(recipes) { recipe ->

            Card(
                colors = CardDefaults.cardColors(containerColor = Cream),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
                    .clickable {
                        //expand whatever recipe is clicked on
                        expandedRecipe =
                            if (expandedRecipe == recipe) null else recipe
                    }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {


                    Text(
                        text = recipe.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = MauveBark
                    )

                    // ingreident checklist only once clicked and expanded
                    if (expandedRecipe == recipe) {
                        Spacer(modifier = Modifier.height(8.dp))
                        //for each recipe make checkboxes that can be checked off
                        recipe.ingredients.forEach { ingredient ->
                            var checked by remember { mutableStateOf(false) }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 4.dp)
                            ) {
                                //for checking off items
                                Checkbox(
                                    checked = checked,
                                    onCheckedChange = { checked = it }
                                )
                                Text(
                                    text = ingredient,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
