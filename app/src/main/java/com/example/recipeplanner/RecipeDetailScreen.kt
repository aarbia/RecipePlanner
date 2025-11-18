package com.example.recipeplanner

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.rounded.ArrowRight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(index: Int, onBack: () -> Unit) {
    val dish = recipe.getOrNull(index)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(dish?.name ?: "Unknown") },
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
            modifier = Modifier.padding(24.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = dish?.name?:"Unknown Recipe")
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Prep Time (mins): ${dish?.prepTimeMin?:""}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Cook Time (mins): ${dish?.cookTimeMin?:""}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Ingredients:")
            dish?.ingredients?.forEach { ingredient ->
                Text(text = "• $ingredient")
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Directions:")
            dish?.directions?.forEach { step ->
                Text(text = "$step")
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Servings: ${dish?.servings?:""}")
        }
    }
}
