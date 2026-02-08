package com.dev.ninhohub.grocery.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.ninhohub.core.ui.icons.IconsSource
import com.dev.ninhohub.core.ui.theme.Black
import com.dev.ninhohub.core.ui.theme.Blue600
import com.dev.ninhohub.core.ui.theme.Blue800
import com.dev.ninhohub.core.ui.theme.Gray100
import com.dev.ninhohub.core.ui.theme.Gray200
import com.dev.ninhohub.core.ui.theme.Gray300
import com.dev.ninhohub.core.ui.theme.Gray400
import com.dev.ninhohub.core.ui.theme.Gray50
import com.dev.ninhohub.core.ui.theme.White
import com.dev.ninhohub.core.ui.theme.rounded
import com.dev.ninhohub.core.ui.theme.spacing

@Composable
fun TcCardItemGrocery(
    product: String,
    quantity: String,
    modifier: Modifier = Modifier,
    description: String? = null
) {
    TcCardItemGroceryContent(
        product = product,
        quantity = quantity,
        description = description,
        modifier = modifier
    )
}

@Composable
private fun TcCardItemGroceryContent(
    product: String,
    quantity: String,
    description: String?,
    modifier: Modifier = Modifier
) {
    GroceryCardBackground(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = spacing.md),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GroceryIconBox()

            Spacer(modifier = Modifier.width(spacing.md))

            ProductInfo(
                product = product,
                description = description,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(spacing.md))

            QuantityBadge(quantity = quantity)
        }
    }
}

@Composable
private fun GroceryCardBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val brushDiagonal = Brush.linearGradient(
        colors = listOf(White, Gray50, Gray100, Gray200, Gray300, Gray400),
        start = Offset.Zero,
        end = Offset.Infinite
    )

    ElevatedCard(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = rounded.sm,
                spotColor = Blue600,
                ambientColor = Blue600
            )
            .border(
                width = 1.dp,
                color = Blue600.copy(alpha = 0.2f),
                shape = rounded.md
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = brushDiagonal)
        ) {
            content()
        }
    }
}

@Composable
private fun ProductInfo(
    product: String,
    description: String?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = product,
            color = Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        description?.let {
            Text(
                text = it,
                color = Black.copy(alpha = 0.6f),
                fontSize = 13.sp,
                lineHeight = 16.sp,
                maxLines = 2
            )
        }
    }
}

@Composable
private fun QuantityBadge(quantity: String) {
    Text(
        text = quantity,
        color = Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun GroceryIconBox() {
    val shape = rounded.md

    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(shape)
            .background(Gray400)
            .border(2.dp, Blue800, shape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = IconsSource.SHOPPING_CART.asPainter,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}
