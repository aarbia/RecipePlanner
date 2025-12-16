package com.example.recipeplanner

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.recipeplanner.ui.RecipeViewModel
import com.example.recipeplanner.ui.ShoppingListViewModel
import com.example.recipeplanner.ui.WeeklyMenuViewModel
import com.example.recipeplanner.ui.theme.AppColorScheme
import com.example.recipeplanner.ui.theme.BurntPeach
import com.example.recipeplanner.ui.theme.MauveBark

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipePlannerApp(
    recipeViewModel: RecipeViewModel,
    shoppingListViewModel: ShoppingListViewModel,
    weeklyMenuViewModel: WeeklyMenuViewModel
) {
    val recipes = recipeViewModel.recipes
    val shoppingListRecipes = shoppingListViewModel.shoppingRecipes
    val shoppingListItems = shoppingListViewModel.shoppingItems
    var selectedRecipeId by remember { mutableStateOf<Int?>(null) }

    var menuExpanded by remember { mutableStateOf(false) }
    val navHostController = rememberNavController()

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
                            selected = currentScreen?.destination?.route == navItem.route,
                            onClick = {
                                currentColor = navItem.color
                                navHostController.navigate(navItem.route)
                            }
                        )
                    }
                }
            }
        ) { padding ->
            NavHost(
                navController = navHostController,
                startDestination = "Home",
                modifier = Modifier.padding(padding),
            ) {
                composable("Home") { HomeScreen() }
                composable("Menu") {
                    MenuScreen(
                        weeklyMenuViewModel = weeklyMenuViewModel, // DB list
                        onRecipeClick = { recipeId ->
                        selectedRecipeId = recipeId
                        navHostController.navigate("Details")
                    })
                }
                composable("Shopping") { ShoppingScreen(
                    shoppingListViewModel = shoppingListViewModel
                ) }
                composable("Recipes") {
                    RecipeListScreen(
                        recipes = recipes, // DB list
                        onRecipeClick = { recipeId ->
                            selectedRecipeId = recipeId
                            navHostController.navigate("Details")
                        },
                        onAddClick = {
                            navHostController.navigate("Add New Recipe")
                        }
                    )
                }
                composable("Details") {
                    val currentRecipes = recipeViewModel.recipes
                    val dish = currentRecipes.firstOrNull{it.id ==selectedRecipeId}
                    RecipeDetailScreen(
                        dish = dish,
                        onBack = { navHostController.popBackStack() },
                        onAddToShopping = { id -> shoppingListViewModel.addRecipeToShopping(id)},
                        recipeViewModel = recipeViewModel
                    )
                }
                composable("Add New Recipe") {
                    RecipeAddScreen(
                        onBack = { navHostController.popBackStack() },
                        onSave = { newRecipe, ingredients, directions ->
                            // save to DB
                            recipeViewModel.addRecipe(newRecipe, ingredients, directions)
                            navHostController.popBackStack() }
                    )
                }
            }
        }
    }
}
