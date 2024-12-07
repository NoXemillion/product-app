package com.example.productapp.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productapp.presentation.cloth_list.ClothListScreen
import com.example.productapp.presentation.introduction.IntroScreen
import com.example.productapp.presentation.ui.theme.ProductAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ProductAppTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController = navController , startDestination = "logoScreen"){
                        composable("introScreen") { IntroScreen(navController = navController) }
                        composable("logoScreen") { LogoScreen(navController) }
                    }
                }
            }
        }
    }
}