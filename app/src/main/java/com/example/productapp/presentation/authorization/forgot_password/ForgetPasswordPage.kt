package com.example.productapp.presentation.authorization.forgot_password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.authorization.common_components.ErrorScreen
import com.example.productapp.presentation.authorization.forgot_password.components.EmailSenderField
import com.example.productapp.presentation.authorization.forgot_password.components.SubmitButton
import com.example.productapp.presentation.ui.theme.AuthRedPink
import com.example.productapp.presentation.ui.theme.Gray3


@Composable
fun ForgetPasswordPage(
    navController : NavController,
    viewModel : AuthorizationViewModel = hiltViewModel()
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)){

        Spacer(modifier = Modifier.height(10.dp))
        Column{
            Text(text = "Forgot" , style = TextStyle(
                fontSize = 36.sp ,
                fontFamily = FontFamily(Font(R.font.monsterrat_bold)),
                color = Color.Black,
            )
            )

            Text(text = "password?" , style = TextStyle(
                fontSize = 36.sp ,
                fontFamily = FontFamily(Font(R.font.monsterrat_bold)),
                color = Color.Black,
            )
            )
            Spacer(modifier = Modifier.height(5.dp))
            ErrorScreen()
        }
        Spacer(modifier = Modifier.height(30.dp))
        EmailSenderField(viewModel)
        Spacer(modifier = Modifier.height(25.dp))

        Row(modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.Start){

            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = AuthRedPink,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_regular))
                    )
                ){
                    append("*")
                }
                withStyle(
                    style = SpanStyle(
                        color = Gray3,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_regular))
                    )
                ){
                    append("We will send you a message to set or reset")
                }
            })
        }
        Text(text = "your new password" , style = TextStyle(
            color = Gray3,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_regular))
        ))

        Spacer(modifier = Modifier.height(30.dp))
        SubmitButton(navController)



    }
}