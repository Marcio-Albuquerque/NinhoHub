package com.dev.ninhohub.core.ui.icons

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource

/**
 * Fonte centralizada de ícones do NinhoHub.
 * Suporta ícones do Material (Vetor) e recursos locais (Drawable).
 */
enum class IconsSource(
    val key: String,
    @get:DrawableRes private val drawableId: Int? = null,
    private val vector: ImageVector? = null
) {
    SHOPPING_CART("shopping_cart", vector = Icons.Default.ShoppingCart),
    ARROW_LEFT("arrow_left", vector = Icons.AutoMirrored.Filled.ArrowBack),
    SEARCH("search", vector = Icons.Default.Search),
    CLOSE("close", vector = Icons.Default.Close);

    val asPainter: Painter
        @Composable
        get() = vector?.let { rememberVectorPainter(it) }
            ?: painterResource(id = drawableId ?: 0)

    val asVector: ImageVector
        get() = vector ?: Icons.Default.Warning

    companion object {
        fun fromKey(key: String): IconsSource? = entries.find { it.key == key }
    }
}
