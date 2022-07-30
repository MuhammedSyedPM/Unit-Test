package com.technowave.unittest.viewModels

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.technowave.unittest.getOrAwaitValue
import com.technowave.unittest.models.ItemModel
import com.technowave.unittest.repository.MainRepo
import com.technowave.unittest.storage.MyDatabase
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest:TestCase(){
    private lateinit var viewModel: MainViewModel
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val database = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java)
            .allowMainThreadQueries().build()
        val posDao = database.getMSDao()
        val repo = MainRepo(posDao)
        viewModel = MainViewModel(repo)
    }

    @Test
    fun getLast10ItemsTest(){
        val item = ItemModel("Apple", 1000.0)
        val itemTest = ItemModel("Orange", 20.0)
        viewModel.insertItem(item)
        viewModel.getLast10Items()
       val result = viewModel.last10Items.getOrAwaitValue().find {
           it.itemName == item.itemName && it.itemPrice == item.itemPrice
       }
        assertThat(result != null).isTrue()
    }
}