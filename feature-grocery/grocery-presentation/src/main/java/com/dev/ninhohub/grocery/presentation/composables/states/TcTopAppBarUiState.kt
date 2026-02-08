package com.dev.ninhohub.grocery.presentation.composables.states

data class TcTopAppBarUiState(
    val isSearchOpen: Boolean = false,
    val searchText: String = "",
    val isFocused: Boolean = false
)
