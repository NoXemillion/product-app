package com.example.productapp.presentation.authorization.registration

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
import com.example.productapp.presentation.authorization.common_components.GoogleAuthScreen
import com.example.productapp.presentation.authorization.registration.components.RegistrationButton
import com.example.productapp.presentation.authorization.common_components.UserEmailField
import com.example.productapp.presentation.authorization.registration.components.UserPasswordConfirmField
import com.example.productapp.presentation.authorization.common_components.UserPasswordField
import com.example.productapp.presentation.ui.theme.AuthRedPink
import com.example.productapp.presentation.ui.theme.Gray3


@Composable
fun RegistrationPage(
    navController: NavController,
    viewModel : AuthorizationViewModel = hiltViewModel()
) {
    viewModel.buttonText.value = "Create Account"
    viewModel.footerStart.value = "I Already Have an Account"
    viewModel.footerEnd.value = "Login"

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        verticalArrangement =  Arrangement.spacedBy(10.dp)){

        Spacer(modifier = Modifier.height(10.dp))
        Column{
            Text(text = "Create an" , style = TextStyle(
                fontSize = 36.sp ,
                fontFamily = FontFamily(Font(R.font.monsterrat_bold)),
                color = Color.Black,
            )
            )

            Text(text = "account" , style = TextStyle(
                fontSize = 36.sp ,
                fontFamily = FontFamily(Font(R.font.monsterrat_bold)),
                color = Color.Black,
            )
            )
            Spacer(modifier = Modifier.height(5.dp))
            ErrorScreen()
        }
        Spacer(modifier = Modifier.height(10.dp))
        UserEmailField()
        Spacer(modifier = Modifier.height(1.dp))
        UserPasswordField()
        Spacer(modifier = Modifier.height(1.dp))
        UserPasswordConfirmField()
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.Start) {

            Column() {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Gray3,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.monsterrat_regular))
                            )
                        ) {
                            append("By clicking the ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = AuthRedPink,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.monsterrat_regular))
                            )
                        ) {
                            append("Register ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Gray3,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.monsterrat_regular))
                            )
                        ) {
                            append("button, you agree")
                        }
                    }
                )
                Text(
                    text = "to the public offer", style = TextStyle(
                        color = Gray3,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_regular))
                    )
                )
            }


        }
        Spacer(modifier = Modifier.height(15.dp))
        RegistrationButton(viewModel , navController)
        Spacer(modifier = Modifier.height(20.dp))
        GoogleAuthScreen(viewModel, navController)
    }
}