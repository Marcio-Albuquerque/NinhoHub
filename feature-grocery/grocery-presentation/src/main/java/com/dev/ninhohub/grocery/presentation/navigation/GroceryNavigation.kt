package com.dev.ninhohub.grocery.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dev.ninhohub.core.navigation.Routes
import com.dev.ninhohub.grocery.presentation.ui.GroceryScreen

fun NavGraphBuilder.groceryNavigation(onBackClick: () -> Unit) {
    composable<Routes.Grocery> {
        GroceryScreen(onBackClick = onBackClick)
    }
}
