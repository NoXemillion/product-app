package com.example.productapp.presentation.main_content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor() : ViewModel(){

    var floatingActionSelected = mutableStateOf(false)
    var selectedItem = mutableIntStateOf(0)

    var searchField = mutableStateOf("")
    var innerPadding = mutableStateOf<PaddingValues>(PaddingValues(0.dp))
}