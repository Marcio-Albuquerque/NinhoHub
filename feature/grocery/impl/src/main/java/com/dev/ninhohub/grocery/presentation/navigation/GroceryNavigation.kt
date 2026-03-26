package com.dev.ninhohub.grocery.presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dev.ninhohub.feature.grocery.api.navigation.GroceryRoute
import com.dev.ninhohub.grocery.presentation.ui.GroceryScreen
import com.dev.ninhohub.grocery.presentation.viewmodel.GroceryViewModel

fun NavGraphBuilder.groceryScreen(onBackClick: () -> Unit) {
    composable<GroceryRoute> {

        val viewModel: GroceryViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()

        GroceryScreen(
            uiState = uiState,
            onAction = viewModel::onAction,
            onBackClick = onBackClick
        )
    }
}
