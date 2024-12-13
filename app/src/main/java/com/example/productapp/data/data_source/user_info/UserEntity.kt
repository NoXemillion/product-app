package com.example.productapp.data.data_source.user_info

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int? ,
    @ColumnInfo(name = "avatar") val avatar : String ,
    @ColumnInfo(name = "email") val email : String ,
    @ColumnInfo(name = "username") val username : String,
    @ColumnInfo(name = "pincode") val pincode : Int? ,
    @ColumnInfo(name = "address") val address : String ,
    @ColumnInfo(name = "city") val city : String
)