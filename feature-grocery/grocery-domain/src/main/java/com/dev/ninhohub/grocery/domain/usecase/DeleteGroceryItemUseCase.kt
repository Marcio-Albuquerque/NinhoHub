package com.dev.ninhohub.grocery.domain.usecase

import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain
import com.dev.ninhohub.grocery.domain.repository.GroceryRepository
import javax.inject.Inject

class DeleteGroceryItemUseCase @Inject constructor(
    private val repository: GroceryRepository
) {
    suspend operator fun invoke(item: GroceryItemDomain) = repository.deleteItem(item)
}
