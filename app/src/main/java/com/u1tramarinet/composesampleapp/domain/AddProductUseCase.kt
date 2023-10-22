package com.u1tramarinet.composesampleapp.domain

import com.u1tramarinet.composesampleapp.data.repository.ProductRepository
import com.u1tramarinet.composesampleapp.data.repository.dto.Product
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {
    suspend operator fun invoke(product: Product) {
        productRepository.addProduct(product)
    }
}