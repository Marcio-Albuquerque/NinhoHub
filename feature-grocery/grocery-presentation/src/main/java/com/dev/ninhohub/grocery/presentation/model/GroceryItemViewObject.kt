package com.dev.ninhohub.grocery.presentation.model

data class GroceryItemViewObject(
    val id: Int,
    val product: String,
    val quantity: String,
    val description: String? = null,
    val isChecked: Boolean = false
)
