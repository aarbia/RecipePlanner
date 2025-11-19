package com.example.recipeplanner

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.rounded.ArrowRight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(index: Int, onBack: () -> Unit) {
    val dish = recipe.getOrNull(index)
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

        }
    }
}
