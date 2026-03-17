package com.dev.ninhohub.grocery.domain.usecase

import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain
import com.dev.ninhohub.grocery.domain.repository.GroceryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGroceryItemsUseCase @Inject constructor(
    private val repository: GroceryRepository
) {
    operator fun invoke(): Flow<List<GroceryItemDomain>> = repository.getItems()
}
