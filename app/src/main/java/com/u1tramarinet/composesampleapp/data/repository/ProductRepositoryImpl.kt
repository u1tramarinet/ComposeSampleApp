package com.u1tramarinet.composesampleapp.data.repository

import com.u1tramarinet.composesampleapp.data.datasource.LocalProductDataSource
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import com.u1tramarinet.composesampleapp.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val localDataSource: LocalProductDataSource,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
) :
    ProductRepository {
    override fun getProductsStream(): Flow<List<Product>> = localDataSource.getAllProductsStream()

    override fun getProductStream(id: Int): Flow<Product> = localDataSource.getProductStream(id)

    override suspend fun addProduct(product: Product) {
        withContext(dispatcher) {
            localDataSource.createProduct(product)
        }
    }

    override suspend fun updateProduct(product: Product) {
        withContext(dispatcher) {
            localDataSource.updateProduct(product)
        }
    }

    override suspend fun deleteProduct(product: Product) {
        withContext(dispatcher) {
            localDataSource.deleteProduct(product)
        }
    }
}