package com.example.productapp.presentation.authorization.common_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.productapp.R
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.ui.theme.AuthRedPink


@Composable
fun ErrorScreen(
    viewModel : AuthorizationViewModel = hiltViewModel()
) {
    Text(text =
        when{
            viewModel.blankError.value -> {
                "Please fill all forms"
            }
            viewModel.confirmError.value -> {
                "Passwords are not the same"
            }
            viewModel.emailValidationError.value -> {
                "Email is not valid"
            }
            viewModel.passwordLengthError.value -> {
                "Password must be at least 8 symbols"
            }
            viewModel.loginError.value -> {
                "Email or password incorrect"
            }
            viewModel.registerError.value -> {
                "Account was already created, please sign in"
            }
            viewModel.emailVerificationError.value -> {
                "Email is invalid"
            }
            else -> {
                "   "
            }
        } ,
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.monsterrat_semibold)),
            color = AuthRedPink
        ),
        modifier = Modifier.padding(top = 12.dp)
    )
}