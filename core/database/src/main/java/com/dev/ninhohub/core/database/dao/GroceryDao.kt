package com.dev.ninhohub.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dev.ninhohub.core.database.entity.GroceryItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroceryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: GroceryItemEntity)

    @Query("SELECT * FROM grocery_items")
    fun getAllItems(): Flow<List<GroceryItemEntity>>

    @Delete
    suspend fun deleteItem(item: GroceryItemEntity)

    @Query("DELETE FROM grocery_items")
    suspend fun deleteAll()
}
