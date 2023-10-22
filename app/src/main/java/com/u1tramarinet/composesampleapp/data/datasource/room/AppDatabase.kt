package com.u1tramarinet.composesampleapp.data.datasource.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.u1tramarinet.composesampleapp.data.datasource.room.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}