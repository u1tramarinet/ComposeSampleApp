package com.u1tramarinet.composesampleapp.data.datasource

import com.u1tramarinet.composesampleapp.data.datasource.room.AppDatabase
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import com.u1tramarinet.composesampleapp.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalProductDataSourceImpl @Inject constructor(
    database: AppDatabase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) :
    LocalProductDataSource {

    private val dao = database.productDao()

    override fun getAllProductsStream(): Flow<List<Product>> =
        dao.getAllProductsStream().map { it.toExternal() }

    override fun getProductStream(id: Int): Flow<Product> =
        dao.getProductStream(id).map { it.toExternal() }

    override suspend fun getAll(): List<Product> {
        return withContext(dispatcher) {
            dao.getAllProducts().toExternal()
        }
    }

    override suspend fun get(id: Int): Product? {
        return withContext(dispatcher) {
            dao.findProductById(id)?.toExternal()
        }
    }

    override suspend fun findByName(name: String): Product? {
        return withContext(dispatcher) {
            dao.findProductByName(name)?.toExternal()
        }
    }

    override suspend fun createProduct(product: Product): Boolean {
        return withContext(dispatcher) {
            dao.insertProduct(product.toLocal())
            true
        }
    }

    override suspend fun updateProduct(product: Product): Boolean {
        return withContext(dispatcher) {
            val rowCount = dao.updateProduct(product.toLocal())
            (rowCount == 1)
        }
    }

    override suspend fun deleteProduct(product: Product): Boolean {
        return withContext(dispatcher) {
            val rowCount = dao.deleteProduct(product.toLocal())
            (rowCount == 1)
        }
    }
}