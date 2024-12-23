package com.example.productapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.introduction.ClothViewModel


@Composable
fun LogoScreen(
    navController: NavController,
    viewModel : ClothViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Image(painter = painterResource(R.drawable.logo) ,
            contentDescription = "logo")
    }
    if(!viewModel.isLoading.value){
        navController.navigate("introScreen")
    }


}