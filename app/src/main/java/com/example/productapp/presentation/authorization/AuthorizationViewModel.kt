package com.example.productapp.presentation.authorization


import android.app.Activity
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.R
import com.example.productapp.presentation.MainActivity
import com.example.productapp.presentation.authorization.auth_methods.AuthRepository
import com.example.productapp.presentation.authorization.auth_methods.GoogleAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authRepository: AuthRepository ,
    private val googleAuthRepository: GoogleAuthRepository
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

    var isSignedInByGoogle = mutableStateOf(false);

    val _signedButton = MutableStateFlow(false)
    val signedButton: StateFlow<Boolean> = _signedButton

    var resetPassword = mutableStateOf(false)


    fun validateEmail(email: String):Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return emailRegex.matches(email)
    }


    suspend fun checkingVerification() : Boolean {
        repeat(1000) {
            authRepository.auth.currentUser?.reload()?.await()
            if (authRepository.auth.currentUser?.isEmailVerified == true) {
                return true
            }
            delay(1000L)
        }
        Log.d("TAG" , "Email isn't verified!")
        return false
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

    fun setSignedButton(value:Boolean) {
        Log.d("TAG", "setSignedButton called with value: $value")
        _signedButton.value = value
    }

    suspend fun signInByGoogle(activity: Activity):Boolean {
        googleAuthRepository.initialize(activity)
        var result = googleAuthRepository.signIn(activity)
        if(result){
            isSignedInByGoogle.value = true
            return true;
        }
        else {
            isSignedInByGoogle.value = false
            return false
        }
    }

    suspend fun signOutByGoogle(activity : Activity){
        googleAuthRepository.initialize(activity)
        googleAuthRepository.signOut()
    }

    suspend fun resetPassword(email : String):Boolean {
        if(!checkIfUserDoesntExist(email)){
            if(authRepository.resetPassword(email)){
                return true
            }
            else{
                emailVerificationError.value = true
                return false
            }
        }
        else {
            emailVerificationError.value = true
            return false
        }
    }

    suspend fun loginByEmailAndPassword():Boolean{
        if(!checkIfUserDoesntExist(email.value)){
            if(authRepository.login(email.value , password.value)){
                return true
            }
            else{
                loginError.value = true
                return false
            }
        }
        else{
            loginError.value = true
            return false
        }
    }


    suspend fun registerByEmailAndPassword():Boolean{
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
    fun resetPasswordChecking(email : String):Boolean {
        when {
            email.isBlank() -> {
                blankError.value = true
                emailValidationError.value = false
                return false
            }
            !validateEmail(email) -> {
                emailValidationError.value = true
                blankError.value = false
                return false
            }
            else -> {
                return true
            }
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
            loginError.value -> {
                loginError.value = true
                emailValidationError.value = false
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