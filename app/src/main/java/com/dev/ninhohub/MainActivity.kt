package com.dev.ninhohub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dev.ninhohub.core.ui.theme.NinhoHubTheme
import com.dev.ninhohub.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NinhoHubTheme {
                AppNavHost()
            }
        }
    }
}
