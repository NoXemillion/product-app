package com.example.productapp.presentation.authorization.registration.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.withContext

@Composable
fun RegistrationButton(
    viewModel : AuthorizationViewModel = hiltViewModel(),
    navController: NavController) {

    var result by remember{
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(AuthRedPink)
        .clickable {
            Log.d("TAG" , viewModel.registrChecking().toString())
            if(viewModel.registrChecking()){
                CoroutineScope(Dispatchers.IO).launch {
                    result = viewModel.registerByEmailAndPassword()
                    if(result) {
                        withContext(Dispatchers.Main){
                            navController.navigate("verificationPage")
                        }
                        if(viewModel.checkingVerification()){
                            withContext(Dispatchers.Main){
                                navController.navigate("loginPage")
                            }
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