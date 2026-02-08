package com.dev.ninhohub.grocery.presentation.states

import com.dev.ninhohub.grocery.presentation.model.ListGroceryViewObject

sealed interface GroceryUiState {
    object Loading : GroceryUiState
    data class Success(val items: List<ListGroceryViewObject>) : GroceryUiState
    data class Error(val message: String) : GroceryUiState
}