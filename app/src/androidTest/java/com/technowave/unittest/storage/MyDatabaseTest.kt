package com.technowave.unittest.storage


import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.technowave.unittest.models.ItemModel
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyDatabaseTest :TestCase(){

  private lateinit var database: MyDatabase
  private lateinit var dao: MyDao
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java).build()
        dao = database.getMSDao()
    }

    @After
    fun closeDatabase(){
        database.close()
    }

    @Test
    fun testInsertGetItems() = runBlocking{
        val item = ItemModel("Apple", 1000.0)
        val itemTest = ItemModel("Orange", 20.0)
        dao.insertItem(item)

        val items = dao.getLastTenItems()
        assertThat(items.contains(item)).isTrue()
        assertThat(items.contains(itemTest)).isFalse()
    }

}