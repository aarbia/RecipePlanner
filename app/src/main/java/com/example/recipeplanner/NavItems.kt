package com.example.recipeplanner

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.recipeplanner.ui.theme.BurntPeach
import com.example.recipeplanner.ui.theme.CandyApple
import com.example.recipeplanner.ui.theme.Fern
import com.example.recipeplanner.ui.theme.Plum

data class NavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val color: Color
)

// Bottom navigation icons and routes for different screens
val item = listOf(
    NavItem("Home", "Home", Icons.Filled.Home, BurntPeach),
    NavItem("Weekly Menu", "Menu", Icons.Filled.CalendarMonth, CandyApple),
    NavItem("Shopping List", "Shopping", Icons.Filled.ShoppingCart, Fern),
    NavItem("Recipes", "Recipes", Icons.Filled.LocalDining, Plum)
)