package com.example.productapp.presentation.authorization


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.productapp.R
import com.example.productapp.presentation.authorization.auth_methods.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")
    var visibility = mutableStateOf(R.drawable.visibile)
    var buttonText = mutableStateOf("")
    var footerStart = mutableStateOf("")
    var footerEnd = mutableStateOf("")

    var blankError = mutableStateOf(false)
    var confirmError = mutableStateOf(false)
    var emailValidationError = mutableStateOf(false)
    var passwordLengthError = mutableStateOf(false)

    var loginError = mutableStateOf(false)
    var registerError = mutableStateOf(false)
    var emailVerificationError = mutableStateOf(authRepository.emailVerificationError.value)
    var verificationMessageSend = mutableStateOf(authRepository.verificationSend.value)

    fun validateEmail(email: String):Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return emailRegex.matches(email)
    }



    suspend fun checkIfUserDoesntExist(
        email : String
    ):Boolean{
        try{
            val result = suspendCoroutine { continuation ->  
                authRepository.auth.fetchSignInMethodsForEmail(email)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            val signInMethods = task.result?.signInMethods
                            if(signInMethods.isNullOrEmpty()){
                                Log.d("TAG" , "checkIfUserDoesntExist : true")
                                continuation.resume(true)
                            }
                            else{
                                Log.d("TAG" , "checkIfUserDoesntExist : false")
                                continuation.resume(false)
                            }
                        }
                        else{
                            continuation.resume(false)
                        }

                    }
            }
            return result
        }
        catch(e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            Log.d("TAG" , "UserCheckingProblem : ${e.message}")
            return false
        }
    }

    suspend fun loginByEmailAndPassword(){
        if(checkIfUserDoesntExist(email.value)){
            authRepository.login(email.value , password.value)
        }
        else{
            loginError.value = true
        }
    }

    suspend fun registerByEmailAndPassword() : Boolean{
        if(checkIfUserDoesntExist(email.value)){
            var result = authRepository.register(email.value , password.value)
            if(result){
                return true
            }
            else{
                return false
            }

        }
        else{
            Log.d("TAG" , "It must print registerError")
            registerError.value = true
            return false
        }
    }

    fun registrChecking():Boolean {
        when {
            password.value.length < 8 || confirmPassword.value.length < 8 -> {
                passwordLengthError.value = true
                blankError.value = false
                confirmError.value = false
                emailValidationError.value = false
                registerError.value = false
                return false
            }

            email.value.isBlank() || password.value.isBlank() || confirmPassword.value.isBlank() -> {
                blankError.value = true
                passwordLengthError.value = false
                confirmError.value = false
                emailValidationError.value = false
                registerError.value = false
                return false
            }

            password.value != confirmPassword.value -> {
                confirmError.value = true
                passwordLengthError.value = false
                blankError.value = false
                emailValidationError.value = false
                registerError.value = false
                return false
            }

            !validateEmail(email.value) -> {
                emailValidationError.value = true
                passwordLengthError.value = false
                confirmError.value = false
                blankError.value = false
                registerError.value = false
                return false
            }
            registerError.value -> {
                registerError.value = true
                emailValidationError.value = false
                passwordLengthError.value = false
                confirmError.value = false
                blankError.value = false
                return false
            }
            else -> {
                return true
            }
        }
    }


    fun loginChecking():Boolean {
        when{
            password.value.length < 8 -> {
                passwordLengthError.value = true
                blankError.value = false
                emailValidationError.value = false
                return false
            }
            email.value.isBlank() || password.value.isBlank() -> {
                blankError.value = true
                passwordLengthError.value = false
                emailValidationError.value = false
                return false
            }
            !validateEmail(email.value) -> {
                emailValidationError.value = true
                passwordLengthError.value = false
                blankError.value = false
                return false
            }

            else -> {
                return true
            }
        }
    }


}