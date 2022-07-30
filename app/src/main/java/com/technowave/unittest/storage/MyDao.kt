package com.technowave.unittest.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.technowave.unittest.models.ItemModel

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemModel: ItemModel): Long

    @Query("SELECT * FROM item_table LIMIT 10")
    suspend fun getLastTenItems(): List<ItemModel>

    @Query("SELECT * FROM item_table WHERE item_id == :itemId")
    fun getItemById(itemId: Int): LiveData<ItemModel>

    @Delete
    suspend fun deleteItem(itemModel: ItemModel)
}