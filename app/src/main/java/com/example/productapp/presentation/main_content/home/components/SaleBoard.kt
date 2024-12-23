package com.example.productapp.presentation.main_content.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.productapp.R
import com.example.productapp.presentation.main_content.ContentViewModel
import kotlinx.coroutines.delay


@Composable
fun SaleBoard(
    navController: NavHostController,
    viewModel: ContentViewModel = hiltViewModel()
) {

    var listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        while(true){
            for(index in 0 until viewModel.boardList.size){
                listState.animateScrollToItem(index)
                delay(7000)
            }
            for(index in 2 downTo 0){
                listState.animateScrollToItem(index)
                delay(7000)
            }
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.52f)
        ,
        horizontalArrangement = Arrangement.spacedBy(30.dp),
    ){
        items(viewModel.boardList.size){ item ->
            Box(modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1.64f)
                .clip(RoundedCornerShape(12.dp))){

                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(viewModel.boardList[item]),
                    contentDescription = "board image",
                    contentScale = ContentScale.Crop
                )
            }

        }
    }
}