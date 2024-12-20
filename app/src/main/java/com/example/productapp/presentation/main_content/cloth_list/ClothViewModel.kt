package com.example.productapp.presentation.main_content.cloth_list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.common.Resource
import com.example.productapp.domain.model.Cloth
import com.example.productapp.domain.use_case.get_clothes.GetClothUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClothViewModel @Inject constructor(
    val getClothUseCase : GetClothUseCase
) : ViewModel() {

    private val _clothes = MutableLiveData<List<Cloth>>()
    val clothes : LiveData<List<Cloth>> = _clothes
    var isLoading = mutableStateOf(false)

    var pages = mutableStateOf(1)

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

    private fun fetchClothData() {
        viewModelScope.launch {
            getClothUseCase().onEach { result ->
                when(result){
                    is Resource.Success -> {
                        _clothes.postValue(result.data ?: emptyList())
                        Log.d("TAG1" , clothes.toString())
                        isLoading.value = false
                    }
                    is Resource.Loading -> {
                        Log.d("TAG1" , "Loading")
                        isLoading.value = true
                    }
                    is Resource.Error -> {
                        Log.d("TAG1" , "Something wrong")

                    }
                }
            }.launchIn(viewModelScope)
        }

    }
}