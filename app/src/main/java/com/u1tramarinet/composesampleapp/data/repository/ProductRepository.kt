package com.u1tramarinet.composesampleapp.data.repository

import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductsStream(): Flow<List<Product>>
    fun getProductStream(id: Int): Flow<Product>
    suspend fun addProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(product: Product)
}