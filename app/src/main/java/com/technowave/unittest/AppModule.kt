package com.technowave.unittest

import android.content.Context
import androidx.room.Room
import com.technowave.unittest.storage.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRunDao(db: MyDatabase) = db.getMSDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, MyDatabase::class.java, "item_database").build()
}