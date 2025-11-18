package com.example.recipeplanner

data class Recipes(
    val name: String,
    val prepTimeMin: Int,
    val cookTimeMin: Int,
    val ingredients: List<String>,
    val directions: List<String>,
    val servings: Int
)

val recipe = listOf(
    Recipes("Chicken Pillows", 20, 40,
        listOf("1lb Chicken Breast, diced", "1 Tbsp Cooking Oil", "2 Tbsp Minced Garlic",
            "2 Tbsp Italian Seasoning","8oz Onion and Chive Cream Cheese",
            "2 cans Crescent Rolls", "12oz Chicken Gravy, canned or homemade",
            "1/2 cup Italian Breadcrumbs"),
        listOf("Step 1: Pre-heat oven to 375F. In large skillet heat cooking oil and garlic till fragrant",
            "Step 2: Add chicken to skillet, cook through, add seasonings and salt & pepper to taste",
            "Step 3: Add cream cheese to chicken, mix thoroughly.",
            "Step 4: Fill crescent rolls with chicken mix, then roll in breadcrumbs before placing on baking sheet.",
            "Step 5: Cook pillows according to crescent roll packaging, while cooking add gravy to skillet with leftover " +
                    "chicken & cream cheese mixture. Serve warm over mashed potatoes or rice."),6)
)