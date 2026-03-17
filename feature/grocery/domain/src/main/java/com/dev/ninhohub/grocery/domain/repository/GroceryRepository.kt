package com.dev.ninhohub.grocery.domain.repository

import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain
import kotlinx.coroutines.flow.Flow

interface GroceryRepository {
    suspend fun saveItem(item: GroceryItemDomain)
    fun getItems(): Flow<List<GroceryItemDomain>>
    suspend fun deleteItem(item: GroceryItemDomain)
    suspend fun deleteAll()
}
