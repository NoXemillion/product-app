package com.example.productapp.presentation.authorization.auth_methods

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.productapp.data.data_source.user_info.UserDao
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val userDao: UserDao
) {
    var auth = firebaseAuth
    var verificationSend = mutableStateOf(false)
    var emailVerificationError = mutableStateOf(false)

    fun isLoggedIn() : Boolean {
        if(auth.currentUser != null) {
            return true
        }
        return false
    }

    fun logOut() {
        auth.signOut()
    }
    suspend fun register(
        email : String , password : String
    ) : Boolean{

        try {
            val result = suspendCoroutine { continuation ->

                auth.createUserWithEmailAndPassword(email , password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            user?.sendEmailVerification()
                                ?.addOnCompleteListener { verificationTask ->
                                    if (verificationTask.isSuccessful) {
                                        Log.d("TAG" , "Okay its working")
                                        verificationSend.value = true
                                        continuation.resume(true)
                                    } else {
                                        emailVerificationError.value = true
                                        verificationSend.value = false
                                        continuation.resume(false)
                                    }

                                }
                        }
                        else {
                            continuation.resume(false)
                        }
                    }

            }
            return result
        }
        catch(e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            Log.d("TAG", "AuthRepository: ${e.message}")
            return false
        }
    }

    suspend fun login(
        email : String , password: String
    ) : Boolean {

        try {
            val result = suspendCoroutine { continuation ->

                auth.signInWithEmailAndPassword(email , password)
                    .addOnSuccessListener {
                        continuation.resume(true)
                    }
                    .addOnFailureListener{
                        Log.d("TAG" , "Login failure : ${it.message}")
                        continuation.resume(false)
                    }
            }
            return result
        }
        catch(e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            Log.d("TAG" , "AuthRepository: ${e.message}")
            return false
        }
    }


}