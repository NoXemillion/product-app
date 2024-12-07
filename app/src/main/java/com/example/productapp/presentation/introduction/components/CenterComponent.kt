package com.example.productapp.presentation.introduction.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productapp.R
import com.example.productapp.common.Constance

@Composable
fun CenterComponent() {

    Column(modifier = Modifier.padding(bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(R.drawable.fashion_image1) ,
            contentDescription = "fashion_image_1")

        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = Modifier.fillMaxWidth()){
            Row(modifier = Modifier.fillMaxWidth() ,
                horizontalArrangement = Arrangement.Center) {
                Text(text = Constance.choose_products ,
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.monsterrat_extrabold))
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = Constance.products_desc , style = TextStyle(
                fontSize = 14.sp ,
                color = Color.Gray,
                fontFamily = FontFamily(Font(R.font.monsterrat_semibold)) ,
                textAlign = TextAlign.Center
            ),
                modifier = Modifier.alpha(0.8f)
            )

        }


    }
}