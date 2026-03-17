package com.dev.ninhohub.grocery.presentation.mapper

import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain
import com.dev.ninhohub.grocery.presentation.model.GroceryItemViewObject

fun GroceryItemDomain.toGroceryViewObject() = GroceryItemViewObject(
    id = id,
    product = name,
    quantity = quantity,
    description = description,
    isChecked = isChecked
)

fun GroceryItemViewObject.toDomain() = GroceryItemDomain(
    id = id,
    name = product,
    quantity = quantity,
    description = description,
    isChecked = isChecked
)
