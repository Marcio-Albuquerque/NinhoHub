package com.dev.ninhohub.navigation

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dev.ninhohub.core.navigation.Routes
import com.dev.ninhohub.grocery.presentation.navigation.groceryNavigation
import com.dev.ninhohub.home.presentation.navigation.homeNavigation

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Home,
        enterTransition = { slideIntoContainer(SlideDirection.Start, tween(700)) },
        exitTransition = { slideOutOfContainer(SlideDirection.Start, tween(700)) },
        popEnterTransition = { slideIntoContainer(SlideDirection.End, tween(700)) },
        popExitTransition = { slideOutOfContainer(SlideDirection.End, tween(700)) }
    ) {
        homeNavigation(
            onNavigateToGrocery = {
                navController.navigate(Routes.Grocery)
            }
        )
        groceryNavigation()
    }
}
