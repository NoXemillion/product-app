package com.example.productapp.di

import android.content.Context
import androidx.room.Room
import com.example.productapp.data.data_source.ClothDao
import com.example.productapp.data.data_source.ClothDatabase
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
    fun provideDatabase(@ApplicationContext context : Context) : ClothDatabase{
        return Room.databaseBuilder(context , ClothDatabase::class.java , "cloth_database").build()
    }

    @Provides
    fun provideClothDao(database: ClothDatabase): ClothDao {
        return database.clothDao()
    }

}