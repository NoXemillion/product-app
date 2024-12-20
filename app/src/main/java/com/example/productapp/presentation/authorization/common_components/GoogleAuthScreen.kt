package com.example.productapp.presentation.authorization.common_components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.ui.theme.AuthRedPink
import com.example.productapp.presentation.ui.theme.GoogleInsideColor
import com.example.productapp.presentation.ui.theme.Gray2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun GoogleAuthScreen (
    viewModel : AuthorizationViewModel = hiltViewModel(),
    navController: NavController
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp) ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "- OR Continue with -" , style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_medium)),
            color = Gray2
        ))

        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .border(1.dp, AuthRedPink, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(GoogleInsideColor),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        CoroutineScope(Dispatchers.Main).launch {
                            viewModel.setSignedButton(true)
                        }
                        var result = viewModel.signedButton.value
                        Log.d("TAG" , "Icon working $result")
                        CoroutineScope(Dispatchers.IO).launch {
                            if(viewModel.isSignedInByGoogle.value){
                                CoroutineScope(Dispatchers.Main).launch{
                                    navController.navigate("getStartedScreen")
                                }
                            }
                        }

                    }
                ) {
                    Image(
                        painter = painterResource(R.drawable.google_icon),
                        contentDescription = "google_icon"
                    )
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.Center){


            Text(text = viewModel.footerStart.value , style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                color = Gray2
            ),
                modifier = Modifier.padding(end = 2.dp)
            )
            Box(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
            ){
                Column(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable {

                        }
                ){
                    Text(text = viewModel.footerEnd.value , style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
                        color = AuthRedPink
                    ) ,
                        modifier = Modifier.clickable {
                            if(viewModel.footerEnd.value == "Login"){
                                navController.navigate("loginPage")
                            }
                            else{
                                navController.navigate("registerPage")
                            }
                        }
                    )
                    HorizontalDivider(color = AuthRedPink)
                }
            }



        }




    }
}