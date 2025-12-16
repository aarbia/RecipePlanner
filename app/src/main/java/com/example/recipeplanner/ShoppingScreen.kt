package com.example.recipeplanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark
import androidx.compose.ui.Alignment
import com.example.recipeplanner.ui.ShoppingListViewModel

@Composable
fun ShoppingScreen(shoppingListViewModel: ShoppingListViewModel) {

    // DB list of recipes added to list ONLY (not all)
    val recipes = shoppingListViewModel.shoppingRecipes

    // Delete confirmation box
    var showDeleteDialog by remember { mutableStateOf(false) }
    var recipePendingDelete by remember { mutableStateOf<Recipes?>(null) }
    if (showDeleteDialog && recipePendingDelete != null) {
        AlertDialog(
            onDismissRequest = {showDeleteDialog = false},
            title = { Text("Remove recipe?")},
            text = { Text("TAre you sure you want to remove ${recipePendingDelete?.name}?")},
            confirmButton = {
                TextButton(onClick = {
                    shoppingListViewModel.removeRecipeFromShopping(recipePendingDelete!!.id)
                    showDeleteDialog = false
                    recipePendingDelete = null
                }
                ) {Text(text = "Remove", color = MauveBark)}
            },
            dismissButton = {
                TextButton(onClick = {
                    showDeleteDialog = false
                    recipePendingDelete = null }) {
                    Text(text = "Cancel", color = MauveBark)
                }
            }
        )
    }

    //currently chosen recipe, expand shopping list
    var expandedRecipeId by remember { mutableStateOf<Int?>(null) }
    //vert scroll
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (recipes.isEmpty()) {
            item {
                Text(
                    text = "No recipes added. Open a recipe and select \"Add to shopping List\".",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MauveBark
                )
            }
        } else {
            //for each recipe in the recipe list
            items(recipes, key = { it.id }) { recipe ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Cream),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .clickable {
                            //expand whatever recipe is clicked on
                            expandedRecipeId =
                                if (expandedRecipeId == recipe.id) null else recipe.id
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = recipe.name,
                            style = MaterialTheme.typography.titleMedium,
                            color = MauveBark
                        )

                        // ingreident checklist only once clicked and expanded
                        if (expandedRecipeId == recipe.id) {
                            Spacer(modifier = Modifier.height(8.dp))
                            //for each recipe make checkboxes that can be checked off
                            recipe.ingredients.forEach { ingredient ->
                                var checked by remember(recipe.id, ingredient) { mutableStateOf(false) }

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
                            Spacer(Modifier.height(8.dp))
                            Button(
                                onClick = {
                                    recipePendingDelete = recipe
                                    showDeleteDialog = true
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Remove from Shopping List.")
                            }
                        }
                    }
                }
            }
        }
        item {
            ShoppingItemsLoadList(shoppingListViewModel)
            Spacer(Modifier.height(8.dp))
        }
        item {
            ShoppingItemInput(shoppingListViewModel)
            Spacer(Modifier.height(8.dp))
        }
    }
}

// grabs list of current individual items from DB
@Composable
fun ShoppingItemsLoadList(shoppingListViewModel: ShoppingListViewModel) {
    val items = shoppingListViewModel.shoppingItems

    Column {
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            ) {
                Checkbox(
                    checked = item.isChecked,
                    onCheckedChange = { checked ->
                        shoppingListViewModel.toggleShoppingItem(item.item_id, checked)
                    }
                )
                Spacer(Modifier.width(8.dp))

                Text(
                    text = item.name,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyLarge
                )
                IconButton(onClick = {
                    shoppingListViewModel.deleteShoppingItem(item.item_id)
                }) {
                    Icon(Icons.Default.Clear, contentDescription = "Delete Item")
                }
            }
        }
    }
}

// creates new text boxes to add individual shopping items & save to DB
@Composable
fun ShoppingItemInput(shoppingListViewModel: ShoppingListViewModel) {
    data class DraftItem(var text: String, var isChecked: Boolean)
    val draft = remember { mutableStateListOf(DraftItem("", false)) }

    Column {
        Text("Add Items", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        draft.forEachIndexed { index, item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            ) {
                Checkbox(
                    checked = item.isChecked,
                    onCheckedChange = {item.isChecked = it}
                )
                Spacer(Modifier.width(8.dp))

                OutlinedTextField(
                    value = item.text,
                    onValueChange = { draft[index] = item.copy(text = it)},
                    label = { Text("Item ${index + 1}")},
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )

                IconButton(
                    onClick = {
                        val name = item.text.trim()
                        if (name.isNotEmpty()) {
                            // save to DB
                            shoppingListViewModel.addShoppingItem(name)
                            draft[index] = DraftItem("", false)
                        }
                    }
                ) {
                    Icon(Icons.Default.Check, contentDescription = "Save Item")
                }
                IconButton(
                    onClick = { draft.removeAt(index)},
                    enabled = draft.size > 1
                ) {
                    Icon(Icons.Default.Clear, contentDescription = "Remove Row")
                }
            }
        }
    }
}
