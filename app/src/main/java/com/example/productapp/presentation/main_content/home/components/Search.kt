package com.example.productapp.presentation.main_content.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.example.productapp.R
import com.example.productapp.presentation.main_content.ContentViewModel
import com.example.productapp.presentation.ui.theme.Gray5
import com.example.productapp.presentation.ui.theme.emailPasswordBackgroundGray


@Composable
fun Search(
    localNavController: NavHostController,
    viewModel : ContentViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(Color.White))
    {
        TextField(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            value = viewModel.searchField.value,
            onValueChange = {newValue -> viewModel.searchField.value = newValue},
            placeholder = {Text(text = "Search any product.." , style = TextStyle(
                fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                fontSize = 15.sp,
                color = Gray5
            ))},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    tint = Gray5
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.monsterrat_regular)),
                fontSize = 15.sp,
                color = Color.Black
            )
        )
    }
}