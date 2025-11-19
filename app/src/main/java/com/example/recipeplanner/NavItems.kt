package com.example.recipeplanner

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val color: Color
)

// Bottom navigation icons and routes for different screens
val item = listOf(
    NavItem("Home", "Home", Icons.Filled.Home, Color(0xFF3A7BF2)),
    NavItem("Weekly Menu", "Menu", Icons.Filled.CalendarMonth, Color(0xFF3A7BF2)),
    NavItem("Shopping List", "Shopping", Icons.Filled.ShoppingCart, Color(0xFF3A7BF2)),
    NavItem("Recipes", "Recipes", Icons.Filled.LocalDining, Color(0xFF3A7BF2))
)