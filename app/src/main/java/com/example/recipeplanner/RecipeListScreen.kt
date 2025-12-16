package com.example.recipeplanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(recipes: List<Recipes>, onRecipeClick: (Int) -> Unit, onAddClick: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedMeal by remember { mutableStateOf("All")}
    var mealOptions = listOf("All", "Breakfast", "Lunch", "Dinner", "Appetizer", "Dessert")

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)    //Add a padding before the first item (you could just use Modifier.padding(60.dp))
    )
    {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {expanded = !expanded}
        ) {
            OutlinedTextField(
                value = selectedMeal,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Filter by Category", color = MauveBark)},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                mealOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = {Text(text = selectionOption)},
                        onClick = {
                            selectedMeal = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }
        Card(   // Card is similar to Surface and Box, just provide different UI
            colors = CardDefaults.cardColors(
                containerColor = Cream
            ),
            modifier = Modifier.padding(8.dp)
                .fillMaxWidth()
                .clickable { onAddClick() }
        ) {
            Row(modifier = Modifier.fillMaxWidth().padding(16.dp),)
            {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add Recipe"
                )
                Text(
                    text = "Add New Recipe",
                    color = MauveBark,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Spacer(Modifier.height(8.dp))

        val filteredList = remember(selectedMeal, recipes) {
            if (selectedMeal == "All") {
                recipes
            } else {
                recipes.filter { it.meal == selectedMeal }
            }
        }

        LazyColumn() {
            // itemsIndexed is a LazyColumn extension function to iterate over a list and access both the item and index
            itemsIndexed(filteredList) { index, item ->
                Card(   // Card is similar to Surface and Box, just provide different UI
                    colors = CardDefaults.cardColors(
                        containerColor = Cream
                    ),
                    modifier = Modifier.padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            onRecipeClick(item.id)
                        }
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(16.dp),)
                    {
                        Text(
                            text = item.name,
                            color = MauveBark,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}

