package com.example.productapp.presentation.introduction.components.footer_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.productapp.presentation.ui.theme.WhiteGray1


@Composable
fun SecondPage() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.padding(top = 7.dp)){
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color = WhiteGray1)
        )
        Box(
            modifier = Modifier
                .width(55.dp)
                .height(10.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color.Black)
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color = WhiteGray1)
        )
    }
}