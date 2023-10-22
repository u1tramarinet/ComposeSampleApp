package com.u1tramarinet.composesampleapp.ui.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import com.u1tramarinet.composesampleapp.ui.common.SubTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    productName: String,
    productId: Int,
    onBack: () -> Unit,
    viewModel: ProductDetailViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SubTopAppBar(
                title = productName,
                onArrowBackClick = onBack,
            )
        },
    ) { paddingValues ->
        val product: Product? = viewModel.productFlow.collectAsState().value
        Column(modifier = Modifier.padding(paddingValues)) {
            if (product != null) {
                ProductDetail(product = product)
            }
        }
    }
}

@Composable
private fun ProductDetail(product: Product) {
    Column {
        Text(text = "名前: ${product.name}")
        Text(text = "数量: ${product.amount}個")
    }
}