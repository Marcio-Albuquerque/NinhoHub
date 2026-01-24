package com.dev.ninhohub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dev.ninhohub.core.ui.theme.NinhoHubTheme
import com.dev.ninhohub.home.presentation.HOME_ROUTE
import com.dev.ninhohub.home.presentation.homeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NinhoHubApp()
        }
    }
}

@Composable
fun NinhoHubApp() {
    NinhoHubTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE
        ) {
            homeScreen()
        }
    }
}
