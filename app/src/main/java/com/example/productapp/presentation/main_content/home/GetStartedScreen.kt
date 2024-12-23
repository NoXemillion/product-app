package com.example.productapp.presentation.main_content.home



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.productapp.R
import com.example.productapp.presentation.ui.theme.AuthRedPink
import com.example.productapp.presentation.ui.theme.Gray4


@Composable
fun GetStartedScreen(
    navController: NavHostController
) {

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.get_started_background) ,
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f)),
                        startY = 0f,
                        endY = 400f
                    )
                )
        )

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){

            Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.42f) ,
                verticalArrangement = Arrangement.SpaceBetween ,
                horizontalAlignment = Alignment.CenterHorizontally){

                Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f) ,
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally){

                    Column(modifier = Modifier.fillMaxWidth() ,
                        verticalArrangement = Arrangement.spacedBy(3.dp),
                        horizontalAlignment = Alignment.CenterHorizontally){

                        Text(text = "You want" , style = TextStyle(
                            fontSize = 35.sp,
                            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                            color = Color.White
                        ))
                        Text(text = "Authentic, here" , style = TextStyle(
                            fontSize = 35.sp,
                            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                            color = Color.White
                        ))
                        Text(text = "you go!" , style = TextStyle(
                            fontSize = 35.sp,
                            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                            color = Color.White
                        ))
                    }

                    Text(text = "Find is here, buy it now!" , style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                        color = Gray4
                    ))

                }

                Box(modifier = Modifier
                    .width(280.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(AuthRedPink)
                    .clickable {
                        navController.navigate("navigation")
                    },
                    contentAlignment = Alignment.Center){

                    Text(text = "Get Started" , style = TextStyle(
                        fontSize = 23.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                        color = Color.White
                    )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}