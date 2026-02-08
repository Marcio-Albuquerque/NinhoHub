package com.dev.ninhohub.grocery.presentation.model

data class ListGroceryViewObject(
    val product: String,
    val quantity: String,
    val description: String? = null
)