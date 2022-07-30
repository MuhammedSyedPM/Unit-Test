package com.technowave.unittest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "item_table")
data class ItemModel(val itemName: String, val itemPrice: Double) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    var id: Int? = null
}
