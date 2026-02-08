package com.dev.ninhohub.grocery.presentation.composables

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.ninhohub.core.ui.components.DsTopAppBarTitle
import com.dev.ninhohub.core.ui.icons.IconsSource
import com.dev.ninhohub.core.ui.theme.Blue700
import com.dev.ninhohub.core.ui.theme.Blue800
import com.dev.ninhohub.core.ui.theme.Blue900
import com.dev.ninhohub.core.ui.theme.Gray
import com.dev.ninhohub.core.ui.theme.White
import com.dev.ninhohub.core.ui.theme.spacing
import com.dev.ninhohub.grocery.presentation.R
import com.dev.ninhohub.grocery.presentation.composables.states.TcTopAppBarUiState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun TcTopAppBarGradient(
    title: String,
    onBackClick: () -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {}
) {
    var uiState by remember { mutableStateOf(TcTopAppBarUiState()) }

    TcTopAppBarGradientContent(
        title = title,
        uiState = uiState,
        onBackClick = onBackClick,
        onToggleSearch = {
            uiState = if (uiState.isSearchOpen) {
                onSearchQueryChange("")
                uiState.copy(isSearchOpen = false, searchText = "")
            } else {
                uiState.copy(isSearchOpen = true)
            }
        },
        onSearchQueryChange = {
            uiState = uiState.copy(searchText = it)
            onSearchQueryChange(it)
        },
        onFocusChanged = {
            uiState = uiState.copy(isFocused = it)
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TcTopAppBarGradientContent(
    title: String,
    uiState: TcTopAppBarUiState,
    onBackClick: () -> Unit,
    onToggleSearch: () -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(uiState.isSearchOpen) {
        if (uiState.isSearchOpen) {
            focusRequester.requestFocus()
        } else {
            focusManager.clearFocus()
        }
    }

    TcTopAppBarBackground(modifier = modifier) {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .height(64.dp)
                .fillMaxWidth()
                .padding(horizontal = spacing.xs),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                this@Row.AnimatedVisibility(
                    visible = !uiState.isSearchOpen,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    TitleContent(title = title, onBackClick = onBackClick)
                }

                this@Row.AnimatedVisibility(
                    visible = uiState.isSearchOpen,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(horizontal = spacing.sm),
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
                        searchText = uiState.searchText,
                        focusRequester = focusRequester,
                        onValueChange = onSearchQueryChange,
                        onFocusChanged = onFocusChanged,
                        onSearchAction = { focusManager.clearFocus() }
                    )
                }
            }

            SearchToggleButton(
                isSearchOpen = uiState.isSearchOpen,
                onClick = onToggleSearch
            )
        }
    }
}

@Composable
private fun TcTopAppBarBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
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
            Icon(
                painter = IconsSource.ARROW_LEFT.asPainter,
                contentDescription = null,
                tint = White
            )
        }
        DsTopAppBarTitle(text = title)
    }
}

@Composable
private fun SearchField(
    searchText: String,
    focusRequester: FocusRequester,
    onValueChange: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    onSearchAction: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(White, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = spacing.md),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = searchText,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearchAction() }),
            decorationBox = { innerTextField ->
                Box(contentAlignment = Alignment.CenterStart) {
                    if (searchText.isEmpty()) {
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
                .focusRequester(focusRequester)
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
            val currentIcon = if (isOpen) IconsSource.CLOSE else IconsSource.SEARCH
            Icon(
                painter = currentIcon.asPainter,
                contentDescription = null,
                tint = White
            )
        }
    }
}
