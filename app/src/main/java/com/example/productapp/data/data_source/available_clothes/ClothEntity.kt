package com.example.productapp.data.data_source.available_clothes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ClothEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "title") val title : String ,
    @ColumnInfo(name = "price") val price : Int,
    @ColumnInfo(name = "category") val categoryId : Int
)

