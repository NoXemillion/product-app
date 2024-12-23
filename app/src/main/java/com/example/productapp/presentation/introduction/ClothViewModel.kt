package com.example.productapp.presentation.introduction

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.common.Resource
import com.example.productapp.data.remote.dto.ClothDto
import com.example.productapp.domain.model.Cloth
import com.example.productapp.domain.use_case.get_clothes.GetClothUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClothViewModel @Inject constructor(
    val getClothUseCase : GetClothUseCase
) : ViewModel() {

    private val _clothes = MutableLiveData<List<Cloth>?>()
    val clothes : MutableLiveData<List<Cloth>?> = _clothes
    var isLoading = mutableStateOf(false)
    var pages = mutableStateOf(1)

    private val _saleClothes = MutableLiveData<ArrayList<Cloth>>()
    val saleClothes : LiveData<ArrayList<Cloth>> = _saleClothes

    var saleClothListSize = mutableIntStateOf(0)
    init {
        fetchClothData()
    }

    fun nextPage() {
        if(pages.value != 3){
            pages.value++
        }
    }
    fun prevPage() {
        if(pages.value != 1){
            pages.value--
        }
    }

//    fun getSaleClothes() {
//        CoroutineScope(Dispatchers.IO).launch {
//            for(index in 1..5){
//                var saleCloth = clothes.value?.get(index)
//                Log.d("TAG1" , "Checking clothes : ${clothes.value?.get(index)}")
//                if (saleCloth != null) {
//                    _saleClothes.value?.add(saleCloth)
//                    _saleClothes.value?.get(index)?.price = saleClothes.value?.get(index)?.price?.div(
//                        2
//                    )!!
//                    _saleClothes.value?.toString()?.let { Log.d("TAG1" , "GetSaleClothes : ${it}") }
//                }
//            }
//        }
//    }

    fun fetchClothData() {
        viewModelScope.launch {
            getClothUseCase().collect { result ->
                when(result){
                    is Resource.Success -> {
                        _clothes.value = result.data
                        isLoading.value = false
                        Log.d("TAG5", "Source checking: ${_clothes.value}")
                    }
                    is Resource.Loading -> {
                        Log.d("TAG5" , "Loading")
                        isLoading.value = true
                    }
                    is Resource.Error -> {
                        Log.d("TAG5" , "Something wrong")

                    }
                }
            }
        }

    }
}