package com.dev.ninhohub.grocery.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
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
import com.dev.ninhohub.core.ui.theme.Green
import com.dev.ninhohub.core.ui.theme.White
import com.dev.ninhohub.core.ui.theme.rounded
import com.dev.ninhohub.core.ui.theme.spacing

@Composable
fun TcCardItemGrocery(
    product: String,
    quantity: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null
) {
    TcCardItemGroceryContent(
        product = product,
        quantity = quantity,
        description = description,
        isChecked = isChecked,
        onCheckedChange = onCheckedChange,
        modifier = modifier
    )
}

@Composable
private fun TcCardItemGroceryContent(
    product: String,
    quantity: String,
    description: String?,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    GroceryCardBackground(
        isChecked = isChecked,
        onClick = { onCheckedChange(!isChecked) },
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = spacing.md),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GroceryIconBox(isChecked = isChecked)

            Spacer(modifier = Modifier.width(spacing.md))

            ProductInfo(
                product = product,
                description = description,
                isChecked = isChecked,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(spacing.md))

            QuantityBadge(quantity = quantity, isChecked = isChecked)
        }
    }
}

@Composable
private fun GroceryCardBackground(
    isChecked: Boolean,
    onClick: () -> Unit,
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
            .alpha(if (isChecked) 0.6f else 1f)
            .shadow(
                elevation = 8.dp,
                shape = rounded.sm,
                spotColor = Blue600,
                ambientColor = Blue600
            )
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = if (isChecked) Green.copy(alpha = 0.4f) else Blue600.copy(alpha = 0.2f),
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
    isChecked: Boolean,
    modifier: Modifier = Modifier
) {
    val textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = product,
            color = Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            textDecoration = textDecoration
        )
        description?.let {
            Text(
                text = it,
                color = Black.copy(alpha = 0.6f),
                fontSize = 13.sp,
                lineHeight = 16.sp,
                maxLines = 2,
                textDecoration = textDecoration
            )
        }
    }
}

@Composable
private fun QuantityBadge(quantity: String, isChecked: Boolean) {
    Text(
        text = quantity,
        color = Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None
    )
}

@Composable
private fun GroceryIconBox(isChecked: Boolean) {
    val shape = rounded.md
    val icon = if (isChecked) IconsSource.CHECK else IconsSource.SHOPPING_CART
    val iconColor = if (isChecked) Green else Black

    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(shape)
            .background(Gray400)
            .border(2.dp, if (isChecked) Green else Blue800, shape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = icon.asPainter,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )
    }
}
