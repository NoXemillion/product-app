package com.example.productapp.presentation.authorization.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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


@Composable
fun EmailVerificationPage(
    navController: NavController,
    viewModel : AuthorizationViewModel = hiltViewModel()
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Image(painter = painterResource(R.drawable.mail_verification) ,
            contentDescription = "emailVerification")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Check your email" , style = TextStyle(
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_bold)),
            color = Color.Black
        ))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "To confirm your email address," , style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
            color = Color.Gray
        ))
        Text(text = "Tap the button in the email we" , style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
            color = Color.Gray
        ))
        Text(text = "sent to you" , style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
            color = Color.Gray
        ))
    }

}