package com.technowave.unittest.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.technowave.unittest.models.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getMSDao(): MyDao
}