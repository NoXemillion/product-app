package com.example.productapp.presentation.authorization.login

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.authorization.common_components.ErrorScreen
import com.example.productapp.presentation.authorization.common_components.GoogleAuthScreen
import com.example.productapp.presentation.authorization.common_components.UserEmailField
import com.example.productapp.presentation.authorization.common_components.UserPasswordField
import com.example.productapp.presentation.authorization.login.components.LoginButton
import com.example.productapp.presentation.ui.theme.AuthRedPink

@Composable
fun LoginPage(navController: NavController,
              viewModel : AuthorizationViewModel = hiltViewModel()
) {
    viewModel.buttonText.value = "Login"
    viewModel.footerStart.value = "Create An Account"
    viewModel.footerEnd.value = "Sign Up"


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        verticalArrangement =  Arrangement.spacedBy(10.dp)){

        Spacer(modifier = Modifier.height(10.dp))
        Column{
            Text(text = "Welcome" , style = TextStyle(
                fontSize = 36.sp ,
                fontFamily = FontFamily(Font(R.font.monsterrat_bold)),
                color = Color.Black,
            ))

            Text(text = "Back!" , style = TextStyle(
                fontSize = 36.sp ,
                fontFamily = FontFamily(Font(R.font.monsterrat_bold)),
                color = Color.Black,
            ))
            Spacer(modifier = Modifier.height(5.dp))
            ErrorScreen()
        }
        Spacer(modifier = Modifier.height(10.dp))
        UserEmailField()
        Spacer(modifier = Modifier.height(1.dp))
        UserPasswordField()

        Row(modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.End){

            Text(text = "Forgot Password?" , style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                color = AuthRedPink
            ),
                modifier = Modifier.clickable {

                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        LoginButton(viewModel , navController)
        Spacer(modifier = Modifier.height(30.dp))
        GoogleAuthScreen(viewModel , navController)

    }

}