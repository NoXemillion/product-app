package com.example.productapp.presentation.main_content.home.components


import android.util.Log
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.productapp.R
import com.example.productapp.presentation.introduction.ClothViewModel
import com.example.productapp.presentation.main_content.ContentViewModel
import kotlinx.coroutines.delay


@Composable
fun DealClothes(
    navController : NavHostController,
    contentViewModel : ContentViewModel = hiltViewModel(),
    clothViewModel : ClothViewModel = hiltViewModel()
) {

    var listState = rememberLazyListState()
    LaunchedEffect(Unit) {
        while(true){
            for(index in 0 until 4){
                listState.animateScrollToItem(index)
                delay(7000)
            }
            for(index in 4 downTo 0){
                listState.animateScrollToItem(index)
                delay(7000)
            }
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(0.3f),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        items(1){ item ->
            Column(modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1.64f)
                .clip(RoundedCornerShape(12.dp))){

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(6.dp))
                ){
                    AsyncImage(
                        model = clothViewModel.clothes.value?.get(item)?.images?.get(0),
                        contentDescription = "sell image"
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Log.d("TAG5" , "DealClothes : ${clothViewModel.clothes.value?.get(1)}")
                clothViewModel.clothes.value?.get(item)?.let {
                    Text(text = it.title , style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monsterrat_medium)),
                        color = Color.Black
                    ))
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = clothViewModel.clothes.value?.get(item)?.price?.div(2).toString() , style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.monsterrat_medium)),
                    color = Color.Black
                ))
            }
        }
    }
}