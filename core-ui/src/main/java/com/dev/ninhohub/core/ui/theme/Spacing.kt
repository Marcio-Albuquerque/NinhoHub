package com.dev.ninhohub.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val none: Dp = 0.dp,
    val half: Dp = 4.dp,
    val x1: Dp = 8.dp,
    val x2: Dp = 16.dp,
    val x3: Dp = 24.dp,
    val x4: Dp = 32.dp,
    val x5: Dp = 40.dp,
    val x6: Dp = 48.dp,
    val x7: Dp = 56.dp,
    val x8: Dp = 64.dp,
    val x9: Dp = 72.dp,
    val x10: Dp = 80.dp,
    val x11: Dp = 88.dp,
    val x12: Dp = 96.dp,
    val x13: Dp = 104.dp,
    val x14: Dp = 112.dp,
    val x15: Dp = 120.dp,
    val x16: Dp = 128.dp,
    val x17: Dp = 136.dp,
    val x18: Dp = 144.dp,
    val x19: Dp = 152.dp,
    val x20: Dp = 160.dp,
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }

val spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current
