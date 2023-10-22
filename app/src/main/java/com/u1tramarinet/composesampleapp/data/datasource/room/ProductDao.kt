package com.u1tramarinet.composesampleapp.data.datasource.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.u1tramarinet.composesampleapp.data.datasource.room.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM product")
    fun getAllProductsPaging(): PagingSource<Int, ProductEntity>

    @Query("SELECT * FROM product")
    fun getAllProductsStream(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE id IN (:id)")
    fun getProductStream(id: Int): Flow<ProductEntity>

    @Query("SELECT * FROM product WHERE id IN (:id)")
    fun findProductById(id: Int): ProductEntity?

    @Query("SELECT * FROM product WHERE name LIKE :name LIMIT 1")
    fun findProductByName(name: String): ProductEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ProductEntity): Long

    @Update
    fun updateProduct(product: ProductEntity): Int

    @Delete
    fun deleteProduct(product: ProductEntity): Int
}