package com.example.recipeplanner

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.recipeplanner.ui.RecipeViewModel
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    dish: Recipes?,
    onBack: () -> Unit,
    onAddToShopping: (Int) -> Unit,
    recipeViewModel: RecipeViewModel,
    onEditClick: (Int) -> Unit
) {
    // Delete confirmation box
    var showDeleteDialog by remember { mutableStateOf(false) }
    if (showDeleteDialog && dish != null) {
        AlertDialog(
            onDismissRequest = {showDeleteDialog = false},
            title = { Text("Delete recipe?")},
            text = { Text("This will permanently delete this recipe. Are you sure?")},
            confirmButton = {
                TextButton(onClick = {
                    recipeViewModel.deleteRecipe(dish.id)
                    showDeleteDialog = false
                    onBack()
                }
                ) {Text(text = "Delete", color = MauveBark)}
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text(text = "Cancel", color = MauveBark)
                }
            }
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text=dish?.name ?: "Unknown Recipe", style = MaterialTheme.typography.headlineSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) {  // IconButton displays a clickable icon
                        Icon(   // must provide an Icon composable and define the onClick lambda to handle the button press
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,  // <--
                            //imageVector = Icons.AutoMirrored.Default.ArrowForwardIos,  // >
                            //imageVector = Icons.AutoMirrored.Rounded.ArrowRight,  // >

                            contentDescription = "Back" // This is for accessibility (screen readers for visually impaired users).
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(24.dp)
                .verticalScroll(rememberScrollState()).fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            dish?.image?.let {resID ->
                Image(
                    painter = painterResource(id = resID),
                    contentDescription = dish.name,
                    modifier = Modifier.fillMaxWidth().height(220.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Button to add current recipe to shopping list
            dish?.let { recipe ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Cream),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .clickable { onAddToShopping(recipe.id) }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add to Shopping List"
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = "Add to Shopping List",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Prep Time (mins): ${dish?.prepTimeMin?:""}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Cook Time (mins): ${dish?.cookTimeMin?:""}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Servings: ${dish?.servings?:""}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Ingredients:", style = MaterialTheme.typography.titleMedium)
            dish?.ingredients?.forEach { ingredient ->
                Text(text = "• $ingredient")
                Spacer(Modifier.height(4.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            var stepIndex = 1
            Text(text = "Directions:", style = MaterialTheme.typography.titleMedium)
            dish?.directions?.forEach { step ->
                Text(text = "Step ${stepIndex}: $step")
                Spacer(Modifier.height(4.dp))
                stepIndex++
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Button to edit recipe
            dish?.let { recipe ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Cream),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .clickable { onEditClick(dish.id) }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "Edit Recipe"
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = "Edit Recipe",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

            // Button to delete recipe
            dish?.let { recipe ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Cream),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .clickable { showDeleteDialog = true }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Icon(
                            Icons.Default.DeleteForever,
                            contentDescription = "Delete Recipe"
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = "Delete Recipe",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

        }
    }
}
