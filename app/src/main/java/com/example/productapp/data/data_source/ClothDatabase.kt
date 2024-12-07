package com.example.productapp.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ClothEntity::class] , version = 1)
abstract class ClothDatabase : RoomDatabase(){
    abstract fun clothDao() : ClothDao


}