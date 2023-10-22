package com.u1tramarinet.composesampleapp.ui.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import com.u1tramarinet.composesampleapp.domain.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    getProductsUseCase: GetProductsUseCase,
) :
    ViewModel() {
    val productListFlow: StateFlow<List<Product>> = getProductsUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = listOf(),
    )
}