package com.dev.ninhohub.grocery.data.mapper

import com.dev.ninhohub.core.database.entity.GroceryItemEntity
import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain

fun GroceryItemEntity.toGroceryItemDomain() = GroceryItemDomain(
    id = id,
    name = name,
    quantity = quantity,
    description = description,
    isChecked = isChecked
)

fun GroceryItemDomain.toGroceryItemEntity() = GroceryItemEntity(
    id = id,
    name = name,
    quantity = quantity,
    description = description,
    isChecked = isChecked
)
