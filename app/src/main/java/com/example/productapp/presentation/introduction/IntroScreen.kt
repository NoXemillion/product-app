package com.example.productapp.presentation.introduction

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.cloth_detail.ClothDetailViewModel
import com.example.productapp.presentation.cloth_list.ClothViewModel
import com.example.productapp.presentation.introduction.components.CenterComponent
import com.example.productapp.presentation.introduction.components.Footer
import com.example.productapp.presentation.introduction.components.Header
import kotlinx.coroutines.launch


@Composable
fun IntroScreen(
    navController: NavController,
    viewModel : ClothViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize().padding(30.dp),
        verticalArrangement = Arrangement.SpaceBetween){

        Header(viewModel)

        CenterComponent()

        Footer(viewModel)
    }



}