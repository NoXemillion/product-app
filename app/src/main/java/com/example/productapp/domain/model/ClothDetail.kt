package com.example.productapp.domain.model

import com.example.productapp.data.remote.dto.Category

data class ClothDetail(
    val images : List<String>,
    val price : Int ,
    val title : String,
    val description: String,
    val category: Category
)
