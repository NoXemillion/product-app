package com.example.productapp.presentation.main_content.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.productapp.R
import com.example.productapp.presentation.main_content.ContentViewModel


@Composable
fun Features(
    viewModel : ContentViewModel = hiltViewModel()
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){

        Text(text = "All Featured" , style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ))

        Row(modifier = Modifier.width(135.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){

            Box(modifier = Modifier
                .width(61.dp)
                .height(24.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .clickable {

                }){

                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight() ,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically){


                    Text(text = "Sort" , style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ))

                    Icon(
                        painter = painterResource(R.drawable.sort_image),
                        contentDescription = "sort"
                    )
                }
            }

            Box(modifier = Modifier
                .width(61.dp)
                .height(24.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .clickable {

                }){

                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight() ,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically){


                    Text(text = "Filter" , style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ))

                    Icon(
                        painter = painterResource(R.drawable.filter_image),
                        contentDescription = "filter"
                    )
                }
            }

        }
    }
}