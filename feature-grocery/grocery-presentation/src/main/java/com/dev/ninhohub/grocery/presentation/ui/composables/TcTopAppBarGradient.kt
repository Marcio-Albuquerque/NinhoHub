package com.dev.ninhohub.grocery.presentation.ui.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.ninhohub.core.ui.components.DsTopAppBarTitle
import com.dev.ninhohub.core.ui.theme.ArrowLeft
import com.dev.ninhohub.core.ui.theme.Blue700
import com.dev.ninhohub.core.ui.theme.Blue800
import com.dev.ninhohub.core.ui.theme.Blue900
import com.dev.ninhohub.core.ui.theme.Gray
import com.dev.ninhohub.core.ui.theme.IconClose
import com.dev.ninhohub.core.ui.theme.IconSearch
import com.dev.ninhohub.core.ui.theme.White
import com.dev.ninhohub.grocery.presentation.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun TcTopAppBarGradient(
    title: String,
    onBackClick: () -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {}
) {
    var isSearchOpen by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    TcTopAppBarBackground {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .height(64.dp)
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                this@Row.AnimatedVisibility(
                    visible = !isSearchOpen,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    TitleContent(title = title, onBackClick = onBackClick)
                }

                this@Row.AnimatedVisibility(
                    visible = isSearchOpen,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(horizontal = 8.dp),
                    enter = expandHorizontally(
                        expandFrom = Alignment.End,
                        animationSpec = tween(300)
                    ) + fadeIn(),
                    exit = shrinkHorizontally(
                        shrinkTowards = Alignment.End,
                        animationSpec = tween(300)
                    ) + fadeOut()
                ) {
                    SearchField(
                        searchText = searchText,
                        isFocused = isFocused,
                        onValueChange = {
                            searchText = it
                            onSearchQueryChange(it)
                        },
                        onFocusChanged = { isFocused = it }
                    )
                }
            }

            SearchToggleButton(
                isSearchOpen = isSearchOpen,
                onClick = {
                    if (isSearchOpen) {
                        isSearchOpen = false
                        searchText = ""
                        onSearchQueryChange("")
                    } else {
                        isSearchOpen = true
                    }
                }
            )
        }
    }
}

@Composable
private fun TcTopAppBarBackground(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Blue900, Blue800, Blue700)
                )
            )
    ) {
        content()
    }
}

@Composable
private fun TitleContent(
    title: String,
    onBackClick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBackClick) {
            Icon(imageVector = ArrowLeft, contentDescription = null, tint = White)
        }
        DsTopAppBarTitle(text = title)
    }
}

@Composable
private fun SearchField(
    searchText: String,
    isFocused: Boolean,
    onValueChange: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(White, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = searchText,
            onValueChange = onValueChange,
            decorationBox = { innerTextField ->
                Box(contentAlignment = Alignment.CenterStart) {
                    if (searchText.isEmpty() && !isFocused) {
                        Text(
                            text = stringResource(id = R.string.searchHilt),
                            color = Gray,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    onFocusChanged(focusState.isFocused)
                }
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun SearchToggleButton(
    isSearchOpen: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        AnimatedContent(
            targetState = isSearchOpen,
            transitionSpec = {
                (fadeIn(animationSpec = tween(300)) + scaleIn()) togetherWith
                        (fadeOut(animationSpec = tween(300)) + scaleOut())
            },
            label = "SearchIconTransition"
        ) { isOpen ->
            Icon(
                imageVector = if (isOpen) IconClose else IconSearch,
                contentDescription = null,
                tint = White
            )
        }
    }
}
