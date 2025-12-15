package com.example.recipeplanner.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        RecipeEntity::class,
        IngredientEntity::class,
        DirectionsEntity::class,
        WeeklyMenuEntity::class,
        ShoppingItemsEntity::class,
        ShoppingRecipesEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDAO(): RecipeDAO
    abstract fun weeklyMenuDAO(): WeeklyMenuDAO
    abstract fun shoppingListDAO(): ShoppingListDAO

    companion object {
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getInstance(context: Context): RecipeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                                context.applicationContext,
                                RecipeDatabase::class.java,
                                "recipes.db"
                            ).fallbackToDestructiveMigrationFrom(1).build()
                INSTANCE = instance
                instance
            }
        }
    }
}