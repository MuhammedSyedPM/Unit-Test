package com.technowave.unittest.repository

import com.technowave.unittest.models.ItemModel
import com.technowave.unittest.storage.MyDao
import javax.inject.Inject

class MainRepo @Inject constructor(private val dao: MyDao) {
    suspend fun insertItem(itemModel: ItemModel) = dao.insertItem(itemModel)
    suspend fun deleteItem(itemModel: ItemModel) = dao.deleteItem(itemModel)
    suspend fun getLast10Items() = dao.getLastTenItems()
}