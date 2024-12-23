package com.example.productapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productapp.presentation.authorization.AuthorizationViewModel
import com.example.productapp.presentation.authorization.forgot_password.ForgetPasswordPage
import com.example.productapp.presentation.authorization.login.LoginPage
import com.example.productapp.presentation.authorization.registration.EmailVerificationPage
import com.example.productapp.presentation.authorization.registration.RegistrationPage
import com.example.productapp.presentation.main_content.home.GetStartedScreen
import com.example.productapp.presentation.introduction.IntroScreen
import com.example.productapp.presentation.main_content.common_components.NavigationScreen
import com.example.productapp.presentation.main_content.home.HomeScreen
import com.example.productapp.presentation.main_content.home.components.Header
import com.example.productapp.presentation.ui.theme.ProductAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val authorizationViewModel: AuthorizationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.d("TAG", "Before observe setup")
        lifecycleScope.launch {

            if(authorizationViewModel.signedButton.value){
                lifecycleScope.launch {
                    authorizationViewModel.signInByGoogle(this@MainActivity)
                }
            }
            authorizationViewModel.signedButton.collect { isSigned ->
                Log.d("TAG", "observe working $isSigned")
                if (isSigned) {
                    lifecycleScope.launch {
                        authorizationViewModel.signInByGoogle(this@MainActivity)
                    }
                }

            }
        }
        Log.d("TAG", "After observe setup")

        setContent{
            ProductAppTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController = navController , startDestination = "logoScreen"){
                        composable("introScreen") { IntroScreen(navController = navController) }
                        composable("logoScreen") { LogoScreen(navController) }
                        composable("loginPage") { LoginPage(navController) }
                        composable("registerPage") { RegistrationPage(navController) }
                        composable("verificationPage") { EmailVerificationPage(navController) }
                        composable("getStartedScreen") { GetStartedScreen(navController) }
                        composable("forgotPassword") { ForgetPasswordPage(navController) }
                        composable("navigation") { NavigationScreen(navController) }
                    }
                }
            }
        }

    }
}