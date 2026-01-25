package com.dev.ninhohub.home.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dev.ninhohub.core.ui.theme.NinhoHubTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToGrocery: () -> Unit) {
    Scaffold() { innerPadding ->
        Button(
            onClick = onNavigateToGrocery,
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(text = "Ir para Grocery")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    NinhoHubTheme {
        HomeScreen(onNavigateToGrocery = {})
    }
}
