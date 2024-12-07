package com.example.productapp.domain.repository

import com.example.productapp.data.remote.dto.ClothDto

interface ClothRepository {

    suspend fun getClothes(): List<ClothDto>

    suspend fun getClothById(id : Int): ClothDto
}