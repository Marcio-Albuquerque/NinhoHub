package com.dev.ninhohub.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grocery_items")
data class GroceryItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val quantity: String,
    val description: String? = null,
    val isChecked: Boolean = false
)
