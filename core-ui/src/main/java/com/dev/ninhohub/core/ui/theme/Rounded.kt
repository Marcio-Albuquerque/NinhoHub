package com.dev.ninhohub.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

data class Rounded(
    val none: RoundedCornerShape = RoundedCornerShape(0.dp),
    val xs: RoundedCornerShape = RoundedCornerShape(4.dp),
    val sm: RoundedCornerShape = RoundedCornerShape(8.dp),
    val md: RoundedCornerShape = RoundedCornerShape(12.dp),
    val lg: RoundedCornerShape = RoundedCornerShape(16.dp),
    val xl: RoundedCornerShape = RoundedCornerShape(24.dp),
    val xxl: RoundedCornerShape = RoundedCornerShape(32.dp),
    val circle: RoundedCornerShape = RoundedCornerShape(50)
)

val LocalRounded = staticCompositionLocalOf { Rounded() }

val rounded: Rounded
    @Composable
    @ReadOnlyComposable
    get() = LocalRounded.current
