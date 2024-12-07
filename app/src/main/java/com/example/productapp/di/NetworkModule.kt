package com.example.productapp.di

import com.example.productapp.common.Constance
import com.example.productapp.data.data_source.ClothDao
import com.example.productapp.data.remote.ClothApi
import com.example.productapp.data.repository.ClothRepositoryImpl
import com.example.productapp.domain.repository.ClothRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideClothApi() : ClothApi {
        return Retrofit.Builder()
            .baseUrl(Constance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClothApi::class.java)
    }

    @Provides
    @Singleton
    fun provideClothRepository(api : ClothApi , clothDao : ClothDao) : ClothRepository{
        return ClothRepositoryImpl(api , clothDao)
    }


}