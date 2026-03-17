package com.dev.ninhohub.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dev.ninhohub.core.navigation.Routes
import com.dev.ninhohub.home.presentation.HomeScreen

fun NavGraphBuilder.homeNavigation(
    onNavigateToGrocery: () -> Unit,
) {
    composable<Routes.Home> {
        HomeScreen(onNavigateToGrocery = onNavigateToGrocery)
    }
}
