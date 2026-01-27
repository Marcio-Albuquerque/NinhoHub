package com.dev.ninhohub.grocery.presentation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.dev.ninhohub.core.ui.components.DsTopAppBarTitle
import com.dev.ninhohub.core.ui.theme.ArrowLeft
import com.dev.ninhohub.core.ui.theme.Transparent
import com.dev.ninhohub.core.ui.theme.Blue700
import com.dev.ninhohub.core.ui.theme.Blue800
import com.dev.ninhohub.core.ui.theme.Blue900
import com.dev.ninhohub.core.ui.theme.IconSearch
import com.dev.ninhohub.core.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TcTopAppBarGradient(
    title: String,
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            DsTopAppBarTitle(text = title)
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = ArrowLeft,
                    contentDescription = null,
                    tint = White
                )
            }
        },
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = IconSearch,
                    contentDescription = null,
                    tint = White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Transparent
        ),
        modifier = Modifier.background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Blue900,
                    Blue800,
                    Blue700
                )
            )
        )
    )
}
