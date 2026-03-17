package com.dev.ninhohub.grocery.domain.model

data class GroceryItemDomain(
    val id: Int = 0,
    val name: String,
    val quantity: String,
    val description: String? = null,
    val isChecked: Boolean = false
)
