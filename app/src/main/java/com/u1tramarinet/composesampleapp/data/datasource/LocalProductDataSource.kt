package com.u1tramarinet.composesampleapp.data.datasource

import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import kotlinx.coroutines.flow.Flow

interface LocalProductDataSource {
    fun getAllProductsStream(): Flow<List<Product>>
    fun getProductStream(id: Int): Flow<Product>
    suspend fun getAll(): List<Product>
    suspend fun get(id: Int): Product?
    suspend fun findByName(name: String): Product?
    suspend fun createProduct(product: Product): Boolean
    suspend fun updateProduct(product: Product): Boolean
    suspend fun deleteProduct(product: Product): Boolean
}