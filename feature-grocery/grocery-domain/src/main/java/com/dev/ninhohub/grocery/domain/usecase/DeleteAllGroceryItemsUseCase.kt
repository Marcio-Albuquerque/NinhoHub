package com.dev.ninhohub.grocery.domain.usecase

import com.dev.ninhohub.grocery.domain.repository.GroceryRepository
import javax.inject.Inject

class DeleteAllGroceryItemsUseCase @Inject constructor(
    private val repository: GroceryRepository
) {
    suspend operator fun invoke() = repository.deleteAll()
}
