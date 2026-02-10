package com.dev.ninhohub.grocery.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dev.ninhohub.core.ui.theme.BackgroundDarkPreview
import com.dev.ninhohub.core.ui.theme.spacing
import com.dev.ninhohub.grocery.presentation.R
import com.dev.ninhohub.grocery.presentation.composables.TcCardItemGrocery
import com.dev.ninhohub.grocery.presentation.composables.TcTopAppBarGradient
import com.dev.ninhohub.grocery.presentation.model.ListGroceryViewObject
import com.dev.ninhohub.grocery.presentation.states.GroceryUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryScreen(
    uiState: GroceryUiState,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TcTopAppBarGradient(
                title = stringResource(id = R.string.title_app_bar_grocery),
                onBackClick = onBackClick,
                onSearchQueryChange = { /* Ação de pesquisa */ }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(BackgroundDarkPreview)
        ) {
            when (uiState) {
                is GroceryUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is GroceryUiState.Success -> {
                    GroceryList(
                        items = uiState.items,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                is GroceryUiState.Error -> {
                    Text(
                        text = uiState.message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
private fun GroceryList(
    items: List<ListGroceryViewObject>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(spacing.md),
        verticalArrangement = Arrangement.spacedBy(spacing.md)
    ) {
        items.forEach { item ->
            TcCardItemGrocery(
                product = item.product,
                quantity = item.quantity,
                description = item.description
            )
        }
    }
}
