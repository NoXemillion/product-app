package com.example.productapp.presentation.main_content.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.productapp.presentation.main_content.home.components.ClothList
import com.example.productapp.presentation.main_content.home.components.DealClothes
import com.example.productapp.presentation.main_content.home.components.DealOfDay
import com.example.productapp.presentation.main_content.home.components.Features
import com.example.productapp.presentation.main_content.home.components.Header
import com.example.productapp.presentation.main_content.home.components.SaleBoard
import com.example.productapp.presentation.main_content.home.components.Search
import com.example.productapp.presentation.ui.theme.mainBackgroundColor


@Composable
fun HomeScreen(
    localNavController: NavHostController,
    viewModel : ContentViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(viewModel.innerPadding.value)
        .background(mainBackgroundColor)){

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .padding(viewModel.innerPadding.value)
            .background(mainBackgroundColor)){

            Header(localNavController)
            Spacer(modifier = Modifier.height(35.dp))
            Search(localNavController)
            Spacer(modifier = Modifier.height(20.dp))
            Features()
            Spacer(modifier = Modifier.height(20.dp))
            ClothList(navController = localNavController)
            Spacer(modifier = Modifier.height(6.dp))
            SaleBoard(navController = localNavController)
            Spacer(modifier = Modifier.height(30.dp))
            DealOfDay(navController = localNavController)
//            Spacer(modifier = Modifier.height(30.dp))
            DealClothes(navController = localNavController)
        }


    }

}