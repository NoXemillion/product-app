package com.example.productapp.presentation.main_content.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.productapp.R
import com.example.productapp.presentation.main_content.ContentViewModel
import com.example.productapp.presentation.ui.theme.Purple1
import com.example.productapp.presentation.ui.theme.WhiteGray1

@Composable
fun ClothList(
    navController: NavHostController,
    viewModel : ContentViewModel = hiltViewModel()
) {

    LazyRow(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)){


        items(viewModel.clothTypeList.size){ item ->

            Column(modifier = Modifier
                .width(90.dp)
                .height(110.dp),
                horizontalAlignment = Alignment.CenterHorizontally){

                Box(modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)){


                    Image(
                        painter = painterResource(viewModel.clothTypeList[item].image),
                        contentDescription = viewModel.clothTypeList[item].title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clickable {

                        }
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = viewModel.clothTypeList[item].title , style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                    fontSize = 14.sp,
                    color = Purple1
                ))

            }
        }
    }

}