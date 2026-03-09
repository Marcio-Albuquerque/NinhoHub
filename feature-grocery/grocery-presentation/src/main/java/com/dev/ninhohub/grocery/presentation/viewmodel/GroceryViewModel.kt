package com.dev.ninhohub.grocery.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.ninhohub.grocery.domain.model.GroceryItemDomain
import com.dev.ninhohub.grocery.domain.usecase.DeleteAllGroceryItemsUseCase
import com.dev.ninhohub.grocery.domain.usecase.DeleteGroceryItemUseCase
import com.dev.ninhohub.grocery.domain.usecase.GetGroceryItemsUseCase
import com.dev.ninhohub.grocery.domain.usecase.SaveGroceryItemUseCase
import com.dev.ninhohub.grocery.presentation.mapper.toDomain
import com.dev.ninhohub.grocery.presentation.mapper.toGroceryViewObject
import com.dev.ninhohub.grocery.presentation.model.GroceryItemViewObject
import com.dev.ninhohub.grocery.presentation.states.GroceryUiAction
import com.dev.ninhohub.grocery.presentation.states.GroceryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryViewModel @Inject constructor(
    private val getGroceryItemsUseCase: GetGroceryItemsUseCase,
    private val saveGroceryItemUseCase: SaveGroceryItemUseCase,
    private val deleteGroceryItemUseCase: DeleteGroceryItemUseCase,
    private val deleteAllGroceryItemsUseCase: DeleteAllGroceryItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<GroceryUiState>(GroceryUiState.Loading)
    val uiState: StateFlow<GroceryUiState> = _uiState.asStateFlow()

    init {
        //TODO Mock para visualizar os dados
        viewModelScope.launch {
            deleteAllGroceryItemsUseCase()
            addItem("Café", "2", null)
            addItem("Arroz", "4", "Pacote")
            addItem("Feijão", "2", null)
            addItem("Carne", "2 kg", "Apenas patina")
        }
        loadGroceries()
    }

    fun onAction(action: GroceryUiAction) {
        when (action) {
            is GroceryUiAction.SelectItem -> selectItem(action.item)
        }
    }

    private fun selectItem(item: GroceryItemViewObject) {
        viewModelScope.launch {
            saveGroceryItemUseCase(item.toDomain().copy(isChecked = !item.isChecked))
        }
    }

    private fun loadGroceries() {
        _uiState.value = GroceryUiState.Loading

        viewModelScope.launch {
            getGroceryItemsUseCase()
                .catch { e ->
                    _uiState.value = GroceryUiState.Error(e.message ?: "Erro")
                }
                .collect { items ->
                    _uiState.value = GroceryUiState.Success(
                        items = items.map { it.toGroceryViewObject() }
                    )
                }
        }
    }

    private fun addItem(name: String, quantity: String, description: String?) {
        viewModelScope.launch {
            saveGroceryItemUseCase(
                GroceryItemDomain(
                    name = name,
                    quantity = quantity,
                    description = description,
                ),
            )
        }
    }
}
