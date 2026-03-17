package com.dev.ninhohub.grocery.data.repository

import com.dev.ninhohub.core.database.dao.GroceryDao
import com.dev.ninhohub.grocery.data.mapper.toGroceryItemDomain
import com.dev.ninhohub.grocery.data.mapper.toGroceryItemEntity
import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain
import com.dev.ninhohub.grocery.domain.repository.GroceryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GroceryRepositoryImpl @Inject constructor(
    private val groceryDao: GroceryDao
) : GroceryRepository {

    override suspend fun saveItem(item: GroceryItemDomain) {
        groceryDao.insertItem(item.toGroceryItemEntity())
    }

    override fun getItems(): Flow<List<GroceryItemDomain>> {
        return groceryDao.getAllItems().map { list ->
            list.map { it.toGroceryItemDomain() }
        }
    }

    override suspend fun deleteItem(item: GroceryItemDomain) {
        groceryDao.deleteItem(item.toGroceryItemEntity())
    }

    override suspend fun deleteAll() {
        groceryDao.deleteAll()
    }
}
