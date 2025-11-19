package com.example.recipeplanner

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipePlannerApp() {
    var menuExpanded by remember { mutableStateOf(false) }
    val navHostController = rememberNavController()
    var myIndex by remember { mutableStateOf(0) }

    // observe (highlight) the correct bottom navigation icon when the user switches screens.
    val currentScreen by navHostController.currentBackStackEntryAsState()

    // destination.route: the name of the route you navigated to (e.g., "home", "profile")
    val currentTitle = currentScreen?.destination?.route?: "Error"

    var currentColor by remember { mutableStateOf(Color(0xFF3A7BF2)) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text=currentTitle, color =currentColor) },
            )
        },
        bottomBar = {
            NavigationBar {
                item.forEach { navItem ->
                    NavigationBarItem(
                        icon = { Icon(navItem.icon, contentDescription = navItem.title) },
                        label = { Text(navItem.title) },
                        colors = NavigationBarItemColors(
                            navItem.color,
                            selectedTextColor = navItem.color,
                            selectedIndicatorColor = Color.Transparent,
                            unselectedIconColor = navItem.color,
                            unselectedTextColor = navItem.color,
                            disabledIconColor = navItem.color,
                            disabledTextColor = navItem.color
                        ),
                        // selected = true : the item is highlighted (you may have customized effect).
                        selected = currentScreen?.destination?.route == navItem.route,
                        onClick = {
                            currentColor = navItem.color
                            navHostController.navigate(navItem.route)
                        }
                    )
                }
            }
        }
    ) { padding -> // "padding" (similar to "it") ensure that main content doesn't overlap with other UI (e.g.,TopAppBar)
        // Provides a place in the Compose hierarchy/map
        NavHost(
            navController = navHostController,
            startDestination = "Home",
            modifier = Modifier.padding(padding),

            ) {
            composable("Home") { HomeScreen() }
            composable("Menu") { MenuScreen() }
            composable("Shopping") { ShoppingScreen() }
            composable("Recipes") {
                RecipeListScreen(onRecipeClick = { index ->
                    myIndex = index
                    navHostController.navigate("Details")
                })
            }
            composable("Details") {
                RecipeDetailScreen(index = myIndex,
                    onBack = {navHostController.popBackStack()})
            }

        }
    }
}
