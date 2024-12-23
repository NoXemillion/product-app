package com.example.productapp.data.data_source.available_clothes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "clothes")
data class ClothEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "title") var title : String ,
    @ColumnInfo(name = "price") var price : Int,
    @ColumnInfo(name = "category") var categoryId : Int
)

