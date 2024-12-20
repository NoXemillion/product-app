package com.example.productapp.presentation.main_content.common_components


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
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
import com.example.productapp.presentation.ui.theme.Red2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavBar(
    viewModel : ContentViewModel = hiltViewModel(),
    navController: NavHostController
) {



    val listOfLeftItems = listOf(
        NavigationItem.Home,
        NavigationItem.Wishlist,

    )
    val listOfRightItems = listOf(
        NavigationItem.Search,
        NavigationItem.Settings
    )
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    listOfLeftItems.forEachIndexed { index, item ->
                        val animatedScale by animateFloatAsState(
                            targetValue = if (viewModel.selectedItem.value == index) 1.1f else 1.0f
                        )

                        IconButton(
                            onClick = {
                                viewModel.selectedItem.value = index
                                viewModel.floatingActionSelected.value = false

                                if(index == 0){
                                    navController.navigate("home")
                                }
                                else{

                                }
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .size(75.dp)
                                    .scale(
                                        animatedScale
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title,
                                    tint = if (viewModel.selectedItem.value == index) Red2 else Color.Black,
                                )
                                Text(
                                    text = item.title, style = TextStyle(
                                        color = if (viewModel.selectedItem.value == index) Red2 else Color.Black,
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium))
                                    )
                                )
                            }

                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    listOfRightItems.forEachIndexed { index, item ->
                        val animatedScale by animateFloatAsState(
                            targetValue = if (viewModel.selectedItem.value == index + 2) 1.1f else 1.0f
                        )
                        IconButton(
                            onClick = {
                                viewModel.selectedItem.value = index + 2
                                viewModel.floatingActionSelected.value = false
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .size(75.dp)
                                    .scale(
                                        animatedScale
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title,
                                    tint = if (viewModel.selectedItem.value == index + 2) Red2 else Color.Black,
                                )
                                Text(
                                    text = item.title, style = TextStyle(
                                        color = if (viewModel.selectedItem.value == index + 2) Red2 else Color.Black,
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium))
                                    )
                                )
                            }

                        }
                    }
                }

            }
        },

        containerColor = Color.White,


    )

}