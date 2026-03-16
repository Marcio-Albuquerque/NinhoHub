package com.dev.ninhohub.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.ninhohub.core.database.dao.GroceryDao
import com.dev.ninhohub.core.database.entity.GroceryItemEntity

@Database(
    entities = [GroceryItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NinhoDatabase : RoomDatabase() {
    abstract fun groceryDao(): GroceryDao
}
