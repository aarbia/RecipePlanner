package com.example.recipeplanner.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ShoppingListDAO {
    // Recipe cards for shopping list

    @Insert
    suspend fun addRecipe(recipes: ShoppingRecipesEntity)

    @Transaction
    @Query("DELETE FROM shopping_recipes WHERE recipe_id = :id")
    suspend fun removeRecipe(id : Int)

    @Transaction
    @Query("SELECT recipe_id FROM shopping_recipes")
    suspend fun getShoppingRecipeIds() : List<Int>

    // Standalone items for shopping screen
    @Transaction
    @Query("SELECT * FROM shopping_items")
    suspend fun getShoppingItems() : List<ShoppingItemsEntity>

    @Insert
    suspend fun addItem(item : ShoppingItemsEntity)

    @Query("DELETE FROM shopping_items WHERE item_id = :id")
    suspend fun deleteItem(id: Int)

    @Transaction
    @Query("UPDATE shopping_items SET isChecked = :checked WHERE item_id = :id")
    suspend fun toggleItem(id : Int, checked : Boolean)
}