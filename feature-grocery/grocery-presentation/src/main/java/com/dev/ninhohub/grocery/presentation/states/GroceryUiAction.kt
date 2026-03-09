package com.dev.ninhohub.grocery.presentation.states

import com.dev.ninhohub.grocery.presentation.model.GroceryItemViewObject

sealed interface GroceryUiAction {
    data class SelectItem(val item: GroceryItemViewObject) : GroceryUiAction
}
