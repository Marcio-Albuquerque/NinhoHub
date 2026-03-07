package com.dev.ninhohub.grocery.presentation.mapper

import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain
import com.dev.ninhohub.grocery.presentation.model.GroceryItemViewObject

fun GroceryItemDomain.toGroceryViewObject() = GroceryItemViewObject(
    product = name,
    quantity = quantity,
    description = description
)
