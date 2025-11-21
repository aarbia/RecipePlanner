package com.example.recipeplanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(onRecipeClick: (Int) -> Unit, onAddClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)    //Add a padding before the first item (you could just use Modifier.padding(60.dp))
    )
    {
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
        LazyColumn() {
            // itemsIndexed is a LazyColumn extension function to iterate over a list and access both the item and index
            itemsIndexed(recipe) { index, item ->
                Card(   // Card is similar to Surface and Box, just provide different UI
                    colors = CardDefaults.cardColors(
                        containerColor = Cream
                    ),
                    modifier = Modifier.padding(8.dp)
                        .fillMaxWidth()
                        .clickable { onRecipeClick(index) }
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

