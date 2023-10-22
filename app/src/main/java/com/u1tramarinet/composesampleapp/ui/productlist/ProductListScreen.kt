package com.u1tramarinet.composesampleapp.ui.productlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import com.u1tramarinet.composesampleapp.ui.common.MainTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    onProductDetail: (Product) -> Unit,
    onAddProduct: () -> Unit,
    viewModel: ProductListViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainTopAppBar(title = "Product一覧") },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddProduct) {
                Icon(Icons.Filled.Add, "")
            }
        },
    ) { paddingValues ->
        val products = viewModel.productListFlow.collectAsState()
        ProductList(
            modifier = Modifier.padding(paddingValues),
            products = products.value,
            onItemClick = onProductDetail
        )
    }
}

@Composable
private fun ProductList(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onItemClick: (Product) -> Unit,
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        products.forEach { product ->
            ProductItem(product = product, onClick = onItemClick)
        }
    }
}

@Composable
private fun ProductItem(product: Product, onClick: (Product) -> Unit) {
    Row(modifier = Modifier.clickable { onClick(product) }) {
        Text(text = product.name)
        Spacer(modifier = Modifier.weight(weight = 1f))
        Text(text = "数量: ${product.amount}")
    }
}