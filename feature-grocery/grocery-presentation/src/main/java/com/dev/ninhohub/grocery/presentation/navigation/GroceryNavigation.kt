package com.dev.ninhohub.grocery.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dev.ninhohub.grocery.presentation.ui.GroceryScreen

const val GROCERY_ROUTE = "grocery"

fun NavGraphBuilder.groceryScreen() {
    composable(route = GROCERY_ROUTE) {
        GroceryScreen()
    }
}
