package com.example.productapp.presentation.main_content.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.main_content.ContentViewModel
import com.example.productapp.presentation.ui.theme.Blue1


@Composable
fun DealOfDay(
    navController: NavController,
    viewModel : ContentViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxSize(0.3f)
            .clip(RoundedCornerShape(8.dp))
            .background(Blue1)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp , end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly){

                Text(text = "Deal of the Day" , style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                    color = Color.White
                ))

                Row{
                    Icon(
                        painter = painterResource(R.drawable.clock),
                        contentDescription = "clock",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text = "24 hours remaining" , style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_medium)),
                        color = Color.White
                    ))
                }
            }
            Box(
                modifier = Modifier
                    .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(4.dp))
                    .padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "View all ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Icon(
                        painter = painterResource(R.drawable.line),
                        contentDescription = "line",
                        tint = Color.Unspecified
                    )
                }

            }
        }
    }
}