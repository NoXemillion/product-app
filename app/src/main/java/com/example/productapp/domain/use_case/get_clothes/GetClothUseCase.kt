package com.example.productapp.domain.use_case.get_clothes

import android.util.Log
import com.example.productapp.common.Resource
import com.example.productapp.data.remote.dto.ClothDto
import com.example.productapp.data.remote.dto.toCloth
import com.example.productapp.data.remote.dto.toClothEntity
import com.example.productapp.data.repository.ClothRepositoryImpl
import com.example.productapp.domain.model.Cloth
import com.example.productapp.domain.repository.ClothRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetClothUseCase @Inject constructor(
    private val repository : ClothRepository
) {

    operator fun invoke(): Flow<Resource<List<Cloth>>> = flow {

        try {
            emit(Resource.Loading())
            val clothes = withContext(Dispatchers.IO){
                repository.getClothes().map{it.toCloth()}
            }
            emit(Resource.Success(clothes))
            Log.d("TAG4" , repository.getClothes().map{it.toCloth()}.toString())

        } catch (e: Exception) {
            Log.d("TAG1" , e.toString())
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error occurred"))
        }
    }
}