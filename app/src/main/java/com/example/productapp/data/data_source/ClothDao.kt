package com.example.productapp.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update


@Dao
interface ClothDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCloth(cloth : ClothEntity)

    @Delete
    suspend fun deleteCloth(cloth : ClothEntity)

    @Update
    suspend fun updateCloth(cloth : ClothEntity)

}