package com.example.productapp.data.data_source.available_clothes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.productapp.domain.model.ClothDetail


@Dao
interface ClothDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCloth(cloth : ClothEntity)

    @Delete
    suspend fun deleteCloth(cloth : ClothEntity)

    @Update
    suspend fun updateCloth(cloth : ClothEntity)

}