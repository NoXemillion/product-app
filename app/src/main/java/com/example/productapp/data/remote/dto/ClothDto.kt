package com.example.productapp.data.remote.dto


import com.example.productapp.data.data_source.ClothEntity
import com.example.productapp.domain.model.Cloth
import com.example.productapp.domain.model.ClothDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClothDto(
    @SerialName("category")
    val category: Category,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("images")
    val images: List<String>,
    @SerialName("price")
    val price: Int,
    @SerialName("title")
    val title: String
)

fun ClothDto.toClothEntity() : ClothEntity {
    return ClothEntity(
        id = id,
        title = title ,
        price = price ,
        categoryId = category.id
    )
}

fun ClothDto.toCloth() : Cloth{
    return Cloth(
        images = images,
        price = price ,
        title = title
    )
}

fun ClothDto.toClothDetail() : ClothDetail {
    return ClothDetail(
        images = images,
        price = price ,
        title = title ,
        description = description ,
        category = category
    )
}