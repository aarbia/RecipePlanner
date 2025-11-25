package com.example.recipeplanner

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipeplanner.ui.theme.Cream
import com.example.recipeplanner.ui.theme.MauveBark
import kotlin.Int

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeAddScreen(onBack: () -> Unit, onSave: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var prepTimeMin by remember { mutableStateOf("") }
    var cookTimeMin by remember { mutableStateOf("") }
    var ingredientsText = remember { mutableStateListOf("") }
    var directionsText = remember { mutableStateListOf("") }
    var servings by remember { mutableStateOf("") }
    var meal by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }

    val mealOptions = listOf("Breakfast", "Lunch", "Dinner", "Snack", "Appetizer", "Dessert")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(mealOptions[0]) }

    val context = LocalContext.current


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Back to Recipes", style = MaterialTheme.typography.headlineSmall) },
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

            Text(text = "Add Recipe",
                style = MaterialTheme.typography.titleLarge,
                )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it},
                label = { Text("Recipe Name")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = { },
                    label = { Text("Meal Type") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor().fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    mealOptions.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = {Text(text = selectionOption)},
                            onClick = {
                                selectedOptionText = selectionOption
                                meal = selectionOption
                                expanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = prepTimeMin,
                onValueChange = { prepTimeMin = it},
                label = { Text("Prep Time (mins)")},

                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = cookTimeMin,
                onValueChange = { cookTimeMin = it},
                label = { Text("Cook Time (mins)")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = servings,
                onValueChange = { servings = it},
                label = { Text("Number of Servings")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            ingredientsText.forEachIndexed { index, text ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { newValue ->
                            ingredientsText[index] = newValue
                        },
                        label = { Text("Ingredient ${index + 1}") },
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { ingredientsText.removeAt(index) },
                        enabled = ingredientsText.size > 1
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Remove"
                        )
                    }
                }
            }
            Button(
                onClick = { ingredientsText.add("") },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            ) { Text("Add Ingredient")}

            directionsText.forEachIndexed { index, text ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { newValue ->
                            directionsText[index] = newValue
                        },
                        label = { Text("Step ${index + 1}") },
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { directionsText.removeAt(index) },
                        enabled = directionsText.size > 1
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Remove"
                        )
                    }
                }
            }
            Button(
                onClick = { directionsText.add("") },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            ) { Text("Add Step")}

            val formFilled = !name.isEmpty() &&
                    !prepTimeMin.isEmpty() &&
                    !cookTimeMin.isEmpty() &&
                    !servings.isEmpty() &&
                    !meal.isEmpty() &&
                    ingredientsText.any { it.isNotBlank() } &&
                    directionsText.any { it.isNotBlank() }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        when {
                            !isInteger(prepTimeMin) -> {
                                Toast.makeText(
                                    context, "Please enter a number for Prep Time.",
                                    Toast.LENGTH_SHORT).show()
                            }
                            !isInteger(cookTimeMin) -> {
                                Toast.makeText(
                                    context, "Please enter a number for Cook Time.",
                                    Toast.LENGTH_SHORT).show()
                            }
                            !isInteger(servings) -> {
                                Toast.makeText(
                                    context, "Please enter a number for Servings.",
                                    Toast.LENGTH_SHORT).show()
                            }
                            else -> {
                                val newRecipe = Recipes(name, prepTimeMin.toInt(), cookTimeMin.toInt(), ingredientsText, directionsText, servings.toInt(), meal)
                                recipe.add(newRecipe)
                                onSave()
                            }
                        }
                    },
                    enabled = formFilled,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MauveBark,
                        contentColor = Cream,
                        disabledContainerColor = Cream,
                        disabledContentColor = MauveBark
                    )
                ) { Text(text = "Save",
                    style = MaterialTheme.typography.titleMedium) }
            }
        }
    }
}

fun isInteger(s: String): Boolean {
    return s.toIntOrNull() != null
}