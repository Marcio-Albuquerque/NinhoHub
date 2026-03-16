package com.dev.ninhohub.core.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.ninhohub.core.ui.theme.White

@Composable
fun DsTopAppBarTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = White,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
    )
}
