package com.example.productapp.presentation.authorization.forgot_password.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import com.example.productapp.R
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.ui.theme.AuthRedPink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SubmitButton(navController: NavController,
    viewModel : AuthorizationViewModel = hiltViewModel()) {

    viewModel.buttonText.value = "Submit"
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(AuthRedPink)
        .clickable {
            if(viewModel.resetPasswordChecking(viewModel.email.value)){
                CoroutineScope(Dispatchers.IO).launch{
                    if(viewModel.resetPassword(viewModel.email.value)){
                        CoroutineScope(Dispatchers.Main).launch {
                            navController.navigate("loginPage")
                        }
                    }
                }
            }
        },
        contentAlignment = Alignment.Center){

        Text(text = viewModel.buttonText.value , style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
            color = Color.White
        )
        )
    }

}