package com.example.productapp.di

import android.content.Context
import androidx.room.Room
import com.example.productapp.data.data_source.available_clothes.ClothDao
import com.example.productapp.data.data_source.available_clothes.ClothDatabase
import com.example.productapp.data.data_source.user_info.UserDao
import com.example.productapp.data.data_source.user_info.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context) : ClothDatabase {
        return Room.databaseBuilder(context , ClothDatabase::class.java , "cloth_database").build()
    }

    @Provides
    fun provideClothDao(database: ClothDatabase): ClothDao {
        return database.clothDao()
    }

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context : Context) : UserDatabase {
        return Room.databaseBuilder(context , UserDatabase::class.java , "user_database").build()
    }

    @Provides
    fun provideUserDao(database : UserDatabase) : UserDao {
        return database.userDao()
    }

}