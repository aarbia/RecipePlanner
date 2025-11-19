package com.example.recipeplanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(onRecipeClick: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)    //Add a padding before the first item (you could just use Modifier.padding(60.dp))
    ) { // itemsIndexed is a LazyColumn extension function to iterate over a list and access both the item and index
        itemsIndexed(recipe) { index, item ->
            Card(   // Card is similar to Surface and Box, just provide different UI
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onRecipeClick(index) }
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp),)
                {
                    Text(text = item.name)
                }
            }
        }
    }

}

