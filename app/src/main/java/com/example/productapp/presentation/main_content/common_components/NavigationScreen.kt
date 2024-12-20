package com.example.productapp.presentation.main_content.common_components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.main_content.ContentViewModel
import com.example.productapp.presentation.main_content.home.HomeScreen
import com.example.productapp.presentation.main_content.home.components.Header
import com.example.productapp.presentation.ui.theme.Red2
import com.example.productapp.presentation.ui.theme.mainBackgroundColor

@Composable
fun NavigationScreen(navController: NavHostController,
    viewModel: ContentViewModel = hiltViewModel()
) {
    val animatedScale by animateFloatAsState(
        targetValue = if (viewModel.floatingActionSelected.value) 1.1f else 1.0f
    )
    val localNavController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .background(mainBackgroundColor),
        bottomBar = {
            BottomNavBar(navController = localNavController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.floatingActionSelected.value = !viewModel.floatingActionSelected.value
                    viewModel.selectedItem.intValue = 4
                },
                modifier = Modifier.offset(
                    y = (60).dp
                ).scale(animatedScale),
                containerColor = animateColorAsState(if(viewModel.floatingActionSelected.value) Red2 else Color.White).value
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    tint = if(viewModel.floatingActionSelected.value) Color.White else Color.Black,
                    contentDescription = "Shopping Card"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content =  { innerPadding ->
            MyNavHost(localNavController , innerPadding)
    }
    )

}
@Composable
fun MyNavHost(localNavController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = localNavController,
        startDestination = "home",
        modifier = Modifier.padding(innerPadding)
    ) {
        composable("home") { HomeScreen(localNavController) }
    }
}