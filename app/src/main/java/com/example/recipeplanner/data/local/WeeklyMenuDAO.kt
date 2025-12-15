package com.example.recipeplanner.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface WeeklyMenuDAO {
    @Query("SELECT * FROM weekly_menu WHERE weekStart = :weekStart")
    fun getEntriesForWeek(weekStart: String) : List<WeeklyMenuEntity>

    @Insert
    suspend fun insertEntries(entries : List<WeeklyMenuEntity>)

    @Query("DELETE FROM weekly_menu WHERE weekStart = :weekStart")
    suspend fun deleteEntriesForWeek(weekStart: String)

    // For single slot
    @Insert
    suspend fun upsertEntry(entry: WeeklyMenuEntity)

    // Remove a single slot
    @Query("DELETE FROM weekly_menu WHERE weekStart = :weekStart AND dayOfWeek = :dayOfWeek AND mealType = :mealType")
    suspend fun deleteEntry(weekStart: String, dayOfWeek: Int, mealType: String)

    @Transaction
    suspend fun replaceWeek(weekStart: String, entries: List<WeeklyMenuEntity>) {
        deleteEntriesForWeek(weekStart)
        insertEntries(entries)
    }
}