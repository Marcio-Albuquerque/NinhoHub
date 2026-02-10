package com.dev.ninhohub.grocery.presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dev.ninhohub.core.navigation.Routes
import com.dev.ninhohub.grocery.presentation.ui.GroceryScreen
import com.dev.ninhohub.grocery.presentation.viewmodel.GroceryViewModel

fun NavGraphBuilder.groceryNavigation(onBackClick: () -> Unit) {
    composable<Routes.Grocery> {

        val viewModel: GroceryViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsState()

        GroceryScreen(
            uiState = uiState,
            onBackClick = onBackClick
        )
    }
}
