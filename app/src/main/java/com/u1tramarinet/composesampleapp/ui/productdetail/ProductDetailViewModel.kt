package com.u1tramarinet.composesampleapp.ui.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import com.u1tramarinet.composesampleapp.domain.GetProductUseCase
import com.u1tramarinet.composesampleapp.ui.NavDestinationsArg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    getProductUseCase: GetProductUseCase,
    savedStateHandle: SavedStateHandle,
) :
    ViewModel() {

    private val productId: Int = savedStateHandle[NavDestinationsArg.ARG_PRODUCT_ID]!!
    val productFlow: StateFlow<Product?> = getProductUseCase(productId).stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = null,
    )
}