package com.dev.ninhohub.grocery.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dev.ninhohub.core.ui.theme.NinhoHubTheme
import com.dev.ninhohub.grocery.presentation.R
import com.dev.ninhohub.grocery.presentation.ui.composables.TcTopAppBarGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TcTopAppBarGradient(
                title = stringResource(id = R.string.title_app_bar_grocery),
                onBackClick = onBackClick,
                onSearchQueryChange = { /* Ação de pesquisa */ }
            )
        }
    ) { innerPadding ->
        Greeting(
            name = "Grocery Screen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GroceryScreenPreview() {
    NinhoHubTheme {
        GroceryScreen(onBackClick = {})
    }
}
