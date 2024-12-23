package com.example.productapp.data.repository

import android.util.Log
import com.example.productapp.data.data_source.available_clothes.ClothDao
import com.example.productapp.data.remote.ClothApi
import com.example.productapp.data.remote.dto.ClothDto
import com.example.productapp.data.remote.dto.toClothEntity
import com.example.productapp.domain.repository.ClothRepository
import javax.inject.Inject

class ClothRepositoryImpl @Inject constructor(
    private val api : ClothApi,
    private val clothDao : ClothDao
) : ClothRepository{
    override suspend fun getClothes(): List<ClothDto> {
        try {

            val clothesFromApi = api.getClothes()
            clothesFromApi.forEach{ item ->
                clothDao.insertCloth(item.toClothEntity())
            }
            Log.d("TAG" , clothesFromApi.toString())
            return clothesFromApi

        }
        catch(e : Exception){
            throw e
        }
    }

    override suspend fun getClothById(id: Int): ClothDto {
        return api.getClothById(id)
    }
}