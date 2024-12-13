package com.example.productapp.presentation.authorization.registration.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.productapp.R
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.ui.theme.authGray
import com.example.productapp.presentation.ui.theme.emailPasswordBackgroundGray
import com.example.productapp.presentation.ui.theme.emailPasswordBorderColor
import com.example.productapp.presentation.ui.theme.emailPasswordGray

@Composable
fun UserPasswordConfirmField(
    viewModel : AuthorizationViewModel = hiltViewModel()
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .border(1.dp , emailPasswordBorderColor , RoundedCornerShape(10.dp))
        .background(authGray)
    )
    {
        TextField(
            modifier = Modifier
                .fillMaxSize()
                .background(emailPasswordBackgroundGray),
            value = viewModel.confirmPassword.value,
            onValueChange = {newValue -> viewModel.confirmPassword.value = newValue},
            placeholder = { Text(text = "Confirm Password" , style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.monsterrat_medium))
            ),
                modifier = Modifier.padding(top = 4.dp)) },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.password_image),
                    tint = emailPasswordGray,
                    contentDescription = "password"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(viewModel.visibility.value),
                    tint = emailPasswordGray,
                    contentDescription = "looking",
                    modifier = Modifier.clickable {
                        if(viewModel.visibility.value == R.drawable.not_visibile){
                            viewModel.visibility.value = R.drawable.visibile
                        }
                        else{
                            viewModel.visibility.value = R.drawable.not_visibile
                        }

                    }
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                focusedContainerColor = emailPasswordBackgroundGray,
                unfocusedContainerColor = emailPasswordBackgroundGray
            ),
            textStyle = TextStyle(
                textAlign = TextAlign.Justify,
                fontSize = 16.sp
            ),
            visualTransformation =
            if(viewModel.visibility.value == R.drawable.visibile){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            }
        )

    }

}