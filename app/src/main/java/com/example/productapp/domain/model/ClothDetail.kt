package com.example.productapp.domain.model

import com.example.productapp.data.remote.dto.Category

data class ClothDetail(
    var images : List<String>,
    var price : Int ,
    var title : String,
    var description: String,
    var category: Category
)
