package com.u1tramarinet.composesampleapp.data.datasource

import com.u1tramarinet.composesampleapp.data.datasource.room.entity.ProductEntity
import com.u1tramarinet.composesampleapp.data.repository.dto.Product

fun Product.toLocal() = ProductEntity(
    id = id,
    name = name,
    amount = amount,
)

fun List<Product>.toLocal() = map(Product::toLocal)

fun ProductEntity.toExternal() = Product(
    id = id,
    name = name,
    amount = amount,
)

fun List<ProductEntity>.toExternal() = map(ProductEntity::toExternal)