package com.example.recipeplanner.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeplanner.Recipes
import com.example.recipeplanner.data.WeeklyMenuRepository
import kotlinx.coroutines.launch
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class WeeklyMenuViewModel(
    private val repo: WeeklyMenuRepository
) : ViewModel() {

    var weekStart by mutableStateOf(repo.currentWeekStart())
        private set

    // dayName -> (mealType -> recipe?)
    var menu by mutableStateOf<Map<String, Map<String, Recipes?>>>(emptyMap())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    val hasMenu: Boolean
        get() = menu.isNotEmpty()

    init {
        loadWeek()
    }

    fun loadWeek() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                menu = repo.getWeekMenu(weekStart)
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    // Generate a fresh randomized menu for the current week (one-time shuffle, saved in DB).
    fun generateThisWeek() {
        viewModelScope.launch {
            try {
                repo.generateAndSaveWeek(weekStart)
                menu = repo.getWeekMenu(weekStart)
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    // Clear menu for the current week (removes saved picks).
    fun clearThisWeek() {
        viewModelScope.launch {
            try {
                repo.clearWeek(weekStart)
                menu = emptyMap()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    // Optional: move to a different weekStart string you compute elsewhere.
    fun changeWeekStart(newWeekStart: String) {
        weekStart = newWeekStart
        loadWeek()
    }

    fun nextWeek() {
        val next = LocalDate.parse(weekStart).plusWeeks(1)
        changeWeekStart(next.toString())
    }

    fun previousWeek() {
        val prev = LocalDate.parse(weekStart).minusWeeks(1)
        changeWeekStart(prev.toString())
    }

}
