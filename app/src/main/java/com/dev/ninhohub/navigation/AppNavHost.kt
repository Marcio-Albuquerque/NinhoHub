package com.dev.ninhohub.navigation

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dev.ninhohub.feature.home.api.navigation.HomeRoute
import com.dev.ninhohub.feature.grocery.api.navigation.GroceryRoute
import com.dev.ninhohub.grocery.presentation.navigation.groceryScreen
import com.dev.ninhohub.home.presentation.navigation.homeScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        enterTransition = { slideIntoContainer(SlideDirection.Start, tween(700)) },
        exitTransition = { slideOutOfContainer(SlideDirection.Start, tween(700)) },
        popEnterTransition = { slideIntoContainer(SlideDirection.End, tween(700)) },
        popExitTransition = { slideOutOfContainer(SlideDirection.End, tween(700)) }
    ) {
        homeScreen(
            onNavigateToGrocery = {
                navController.navigate(GroceryRoute)
            }
        )
        groceryScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}
