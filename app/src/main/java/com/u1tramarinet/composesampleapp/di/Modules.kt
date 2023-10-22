package com.u1tramarinet.composesampleapp.di

import android.content.Context
import androidx.room.Room
import com.u1tramarinet.composesampleapp.data.datasource.LocalProductDataSource
import com.u1tramarinet.composesampleapp.data.datasource.LocalProductDataSourceImpl
import com.u1tramarinet.composesampleapp.data.datasource.room.AppDatabase
import com.u1tramarinet.composesampleapp.data.repository.ProductRepository
import com.u1tramarinet.composesampleapp.data.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {
    @Binds
    abstract fun bindsProductRepository(impl: ProductRepositoryImpl): ProductRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModules {
    @Binds
    abstract fun bindsProductDataSource(impl: LocalProductDataSourceImpl): LocalProductDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModules {
    @Provides
    fun providesAppDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "product-database"
        )
            .build()
    }
}