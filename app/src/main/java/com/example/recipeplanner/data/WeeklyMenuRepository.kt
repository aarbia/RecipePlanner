package com.example.recipeplanner.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.recipeplanner.Recipes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.recipeplanner.data.local.*
import java.time.DayOfWeek
import java.time.LocalDate

class WeeklyMenuRepository(
    private val weeklyDao: WeeklyMenuDAO,
    private val recipeDao: RecipeDAO
) {
    private val daysOfWeek = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

    suspend fun getWeekMenu(weekStart: String): Map<String, Map<String, Recipes?>> =
        withContext(Dispatchers.IO) {

            val entries = weeklyDao.getEntriesForWeek(weekStart)
            if (entries.isEmpty()) return@withContext emptyMap()

            val allRecipes = recipeDao.getAllRecipesWithDetails().map { it.toModel() }
            val byId = allRecipes.associateBy { it.id }

            val result = mutableMapOf<String, MutableMap<String, Recipes?>>()

            for (e in entries) {
                val dayName = daysOfWeek.getOrNull(e.dayOfWeek) ?: continue
                val mealMap = result.getOrPut(dayName) { mutableMapOf() }
                mealMap[e.mealType] = byId[e.recipe_id]
            }

            // ensure all 7 days exist
            daysOfWeek.forEach { day -> result.putIfAbsent(day, mutableMapOf()) }

            result
        }

    suspend fun generateAndSaveWeek(weekStart: String) = withContext(Dispatchers.IO) {
        val all = recipeDao.getAllRecipesWithDetails().map { it.toModel() }

        val breakfasts = all.filter { it.meal.equals("Breakfast", true) }.shuffled().take(7)
        val dinners    = all.filter { it.meal.equals("Dinner", true) }.shuffled().take(7)
        val desserts   = all.filter { it.meal.equals("Dessert", true) }.shuffled().take(7)

        val entries = mutableListOf<WeeklyMenuEntity>()
        for (i in 0..6) {
            breakfasts.getOrNull(i)?.let { r ->
                entries.add(WeeklyMenuEntity(weekStart = weekStart, dayOfWeek = i, mealType = "Breakfast", recipe_id = r.id))
            }
            dinners.getOrNull(i)?.let { r ->
                entries.add(WeeklyMenuEntity(weekStart = weekStart, dayOfWeek = i, mealType = "Dinner", recipe_id = r.id))
            }
            desserts.getOrNull(i)?.let { r ->
                entries.add(WeeklyMenuEntity(weekStart = weekStart, dayOfWeek = i, mealType = "Dessert", recipe_id = r.id))
            }
        }

        // needs replaceWeek() in DAO (recommended)
        weeklyDao.replaceWeek(weekStart, entries)
    }

    suspend fun clearWeek(weekStart: String) = withContext(Dispatchers.IO) {
        weeklyDao.deleteEntriesForWeek(weekStart)
    }
    suspend fun setSlot(
        weekStart: String,
        dayOfWeek: Int,
        mealType: String,
        recipeId: Int
    ) = withContext(Dispatchers.IO) {
        weeklyDao.upsertEntry(
            WeeklyMenuEntity(
                weekStart = weekStart,
                dayOfWeek = dayOfWeek,
                mealType = mealType,
                recipe_id = recipeId
            )
        )
    }

    suspend fun clearSlot(
        weekStart: String,
        dayOfWeek: Int,
        mealType: String
    ) = withContext(Dispatchers.IO) {
        weeklyDao.deleteEntry(weekStart, dayOfWeek, mealType)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun currentWeekStart(): String {
        val today = LocalDate.now()
        // Grab previous monday (current week start day)
        val monday = today.with(DayOfWeek.MONDAY)
        return monday.toString() // YYYY-MM-DD
    }

}
