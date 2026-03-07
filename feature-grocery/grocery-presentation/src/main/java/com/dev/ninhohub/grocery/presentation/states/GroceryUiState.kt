package com.dev.ninhohub.grocery.presentation.states

import com.dev.ninhohub.grocery.presentation.model.GroceryItemViewObject

sealed interface GroceryUiState {
    object Loading : GroceryUiState
    data class Success(val items: List<GroceryItemViewObject>) : GroceryUiState
    data class Error(val message: String) : GroceryUiState
}
