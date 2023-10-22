package com.u1tramarinet.composesampleapp.domain

import com.u1tramarinet.composesampleapp.data.repository.ProductRepository
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    operator fun invoke(id: Int): Flow<Product> {
        return productRepository.getProductStream(id)
    }
}