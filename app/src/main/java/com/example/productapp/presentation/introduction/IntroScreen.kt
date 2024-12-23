package com.example.productapp.presentation.introduction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.productapp.presentation.introduction.components.CenterComponent
import com.example.productapp.presentation.introduction.components.Footer
import com.example.productapp.presentation.introduction.components.Header


@Composable
fun IntroScreen(
    navController: NavController,
    viewModel : ClothViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize().padding(30.dp),
        verticalArrangement = Arrangement.SpaceBetween){

        Header(navController ,viewModel)

        CenterComponent()

        Footer(navController, viewModel)
    }



}