package com.dev.ninhohub.grocery.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.ninhohub.grocery.presentation.model.ListGroceryViewObject
import com.dev.ninhohub.grocery.presentation.states.GroceryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class GroceryViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<GroceryUiState>(GroceryUiState.Loading)
    val uiState: StateFlow<GroceryUiState> = _uiState.asStateFlow()

    init {
        loadGroceries()
    }

    private fun loadGroceries() {
        viewModelScope.launch {
            _uiState.value = GroceryUiState.Loading
            delay(1000) // Simulating network delay
            _uiState.value = GroceryUiState.Success(
                items = listOf(
                    ListGroceryViewObject(
                        product = "Arroz",
                        quantity = "5kg",
                        description = "Tipo 1, agulhinha"
                    ),
                    ListGroceryViewObject(
                        product = "Feijão",
                        quantity = "2kg",
                        description = "Carioca"
                    ),
                    ListGroceryViewObject(
                        product = "Açúcar",
                        quantity = "1kg"
                    ),
                    ListGroceryViewObject(
                        product = "Café",
                        quantity = "500g",
                        description = "Torrado e moído extra forte"
                    ),
                    ListGroceryViewObject(
                        product = "Leite",
                        quantity = "12L",
                        description = "Integral"
                    ),
                    ListGroceryViewObject(
                        product = "Óleo de Soja",
                        quantity = "2 unidades"
                    )
                )
            )
        }
    }
}
