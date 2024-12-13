package com.example.productapp.data.data_source.user_info

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user : UserEntity)

    @Delete
    suspend fun deleteUser(user : UserEntity)

    @Update
    suspend fun updateUser(user : UserEntity)
}