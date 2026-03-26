package com.dev.ninhohub.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dev.ninhohub.feature.home.api.navigation.HomeRoute
import com.dev.ninhohub.home.presentation.HomeScreen

fun NavGraphBuilder.homeScreen(
    onNavigateToGrocery: () -> Unit,
) {
    composable<HomeRoute> {
        HomeScreen(onNavigateToGrocery = onNavigateToGrocery)
    }
}
