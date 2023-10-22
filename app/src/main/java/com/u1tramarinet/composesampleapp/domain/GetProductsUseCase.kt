package com.u1tramarinet.composesampleapp.domain

import com.u1tramarinet.composesampleapp.data.repository.ProductRepository
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    operator fun invoke(): Flow<List<Product>> {
        return productRepository.getProductsStream()
    }
}