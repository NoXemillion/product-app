package com.example.productapp.presentation.introduction.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.main_content.cloth_list.ClothViewModel


@Composable
fun Header(navController: NavController,
    viewModel : ClothViewModel = hiltViewModel()) {
    Row(modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.SpaceBetween){

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        Color.Black ,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.monsterrat_semibold))
                    )
                ){
                    append(viewModel.pages.value.toString())
                }
                withStyle(
                    style = SpanStyle(
                        Color.Gray ,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.monsterrat_semibold))
                    )
                ){
                    append("/3")
                }
            }
        )


        Text(text = "Skip" , style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),)
            , modifier = Modifier.clickable {
                navController.navigate("loginPage")
            }
        )
    }
}