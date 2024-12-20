package com.example.productapp.presentation.main_content.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.productapp.R
import com.example.productapp.presentation.ui.theme.mainBackgroundColor


@Composable
fun Header(
    navController: NavHostController
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(mainBackgroundColor),
        horizontalArrangement = Arrangement.SpaceBetween){

        IconButton(
            onClick = {

            }
        ) {
            Icon(
                painter = painterResource(R.drawable.left_navigation),
                tint = Color.Unspecified ,
                contentDescription = "left navigation"
            )
        }

        IconButton(
            onClick = {
//                navController.navigate("")
            }
        ){
            Icon(
                painter = painterResource(R.drawable.header_logo),
                contentDescription = "header_logo",
                tint = Color.Unspecified
            )
        }
        IconButton(
            onClick = {

            }
        ){
            Icon(
                painter = painterResource(R.drawable.avatar),
                contentDescription = "avatar",
                modifier = Modifier.size(40.dp),
                tint = Color.Unspecified
            )
        }


    }
}