package com.example.productapp.presentation.main_content.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.productapp.presentation.main_content.ContentViewModel
import com.example.productapp.presentation.main_content.home.components.Header
import com.example.productapp.presentation.main_content.home.components.Search
import com.example.productapp.presentation.ui.theme.mainBackgroundColor


@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel : ContentViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(viewModel.innerPadding.value)
        .padding(15.dp)
        .background(mainBackgroundColor)){

        Header(navController)
        Spacer(modifier = Modifier.height(10.dp))
        //    Search(navController)
    }

}