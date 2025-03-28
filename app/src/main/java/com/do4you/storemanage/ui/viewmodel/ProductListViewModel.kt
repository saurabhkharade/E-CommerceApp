package com.do4you.storemanage.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.do4you.storemanage.data.model.ProductsItem
import com.do4you.storemanage.data.repository.ProductRepository
import com.do4you.storemanage.ui.base.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProductListViewModel(private val productRepository: ProductRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<ProductsItem>>>(UiState.Loading)


    val uiState: StateFlow<UiState<List<ProductsItem>>> = _uiState

    init {
        fetchProductList()

    }

    private fun fetchProductList() {

        viewModelScope.launch {
            productRepository.getProductList().catch { e ->

                Log.e("ProductListViewModel", "Error fetching products: ${e.localizedMessage}", e)

                _uiState.value = UiState.Error(e.toString())
            }.collect {
                _uiState.value = UiState.Success(it)
                Log.e("ProductListViewModel", "Fetched ${it.size} products")

            }
        }

    }

}