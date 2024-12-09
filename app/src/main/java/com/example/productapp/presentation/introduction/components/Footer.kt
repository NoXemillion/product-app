package com.example.productapp.presentation.introduction.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.productapp.R
import com.example.productapp.presentation.cloth_list.ClothViewModel
import com.example.productapp.presentation.introduction.components.footer_components.FirstPage
import com.example.productapp.presentation.introduction.components.footer_components.SecondPage
import com.example.productapp.presentation.introduction.components.footer_components.ThirdPage
import com.example.productapp.presentation.ui.theme.RedPink



@Composable
fun Footer(
    viewModel : ClothViewModel = hiltViewModel()
) {

    Row(modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.SpaceBetween){

        Text(text = if(viewModel.pages.value == 1) {
            "Prev"
        }else{
            "Prev"
        } , style = if(viewModel.pages.value == 1) {
            TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                color = Color.White
            )

        }
            else{
            TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                color = Color.Gray
            )
        } ,
            modifier = Modifier.clickable {
                viewModel.prevPage()
            }
        )

        when (viewModel.pages.value) {
            1 -> {
                FirstPage()
            }
            2 -> {
                SecondPage()
            }
            else -> {
                ThirdPage()
            }
        }

        Text(text = if(viewModel.pages.value != 3) {
            "Next"
        }else{
            "Get Started"
        } , style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
            color = RedPink
        ) , modifier = Modifier.clickable {

            viewModel.nextPage()
        }
        )
    }
}