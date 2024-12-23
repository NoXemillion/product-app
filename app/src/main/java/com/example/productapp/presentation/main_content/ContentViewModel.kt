package com.example.productapp.presentation.main_content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.R
import com.example.productapp.data.remote.dto.ClothDto
import com.example.productapp.data.repository.ClothRepositoryImpl
import com.example.productapp.domain.use_case.get_clothes.GetClothUseCase
import com.example.productapp.presentation.main_content.home.model.ClothType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val clothImpl : GetClothUseCase
) : ViewModel(){

    var floatingActionSelected = mutableStateOf(false)
    var selectedItem = mutableIntStateOf(0)

    var searchField = mutableStateOf("")
    var innerPadding = mutableStateOf<PaddingValues>(PaddingValues(0.dp))

    var isLoading = mutableStateOf(true)

    var clothTypeList = listOf(
        ClothType(
            image = R.drawable.beauty,
            title = "Beauty"
        ),
        ClothType(
            image = R.drawable.fashion,
            title = "Fashion"
        ),
        ClothType(
            image = R.drawable.kids_cloth,
            title = "Kids"
        ),
        ClothType(
            image = R.drawable.men_cloth,
            title = "Men"
        ),
        ClothType(
            image = R.drawable.women_cloth,
            title = "Women"
        ),
        ClothType(
            image = R.drawable.sigma_cloth,
            title = "Sigma"
        )
    )

    val boardList = listOf(
        R.drawable.board1,
        R.drawable.board2,
        R.drawable.board3
    )



}