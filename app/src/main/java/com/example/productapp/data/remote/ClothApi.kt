package com.example.productapp.data.remote

import com.example.productapp.data.remote.dto.ClothDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ClothApi{

    @GET("products")
    suspend fun getClothes() : ArrayList<ClothDto>

    @GET("products/{id}")
    suspend fun getClothById(@Path("id") id : Int) : ClothDto

}