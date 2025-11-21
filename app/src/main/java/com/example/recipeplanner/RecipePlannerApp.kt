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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.recipeplanner.ui.theme.AppColorScheme
import com.example.recipeplanner.ui.theme.BurntPeach
import com.example.recipeplanner.ui.theme.MauveBark


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipePlannerApp() {
    var menuExpanded by remember { mutableStateOf(false) }
    val navHostController = rememberNavController()
    var myIndex by remember { mutableStateOf(0) }

    // observe (highlight) the correct bottom navigation icon when the user switches screens.
    val currentScreen by navHostController.currentBackStackEntryAsState()

    // destination.route: the name of the route you navigated to (e.g., "home", "profile")
    val currentTitle = currentScreen?.destination?.route ?: "Error"
    val navItems = item
    var currentColor =
        navItems.find { it -> currentScreen?.destination?.route == it.route }?.color ?: Color(0xFF483228)
    MaterialTheme(
        colorScheme = AppColorScheme
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = currentTitle) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = BurntPeach,
                        titleContentColor = Color.White
                    )
                )
            },
            bottomBar = {
                NavigationBar {
                    item.forEach { navItem ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    navItem.icon,
                                    contentDescription = navItem.title,
                                )
                            },
                            label = { Text(navItem.title) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = navItem.color,
                                selectedTextColor = navItem.color,
                                unselectedIconColor = MauveBark,
                                unselectedTextColor = MauveBark,

                                indicatorColor = Color.Transparent
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
                    },
                        onAddClick = {
                        navHostController.navigate("Add New Recipe")
                    })
                }
                composable("Details") {
                    RecipeDetailScreen(
                        index = myIndex,
                        onBack = { navHostController.popBackStack() })
                }
                composable("Add New Recipe") {
                    RecipeAddScreen(
                        onBack = { navHostController.popBackStack() },
                        onSave = {
                            //need to add saving info to recipes here,
                            navHostController.popBackStack()
                        })
                }

            }
        }
    }
}