package com.example.productapp.presentation.authorization.auth_methods

import android.app.Activity
import android.util.Log
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import com.example.productapp.data.data_source.user_info.UserDao
import com.example.productapp.data.data_source.user_info.UserEntity
import com.example.productapp.presentation.MainActivity
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException
import javax.inject.Inject


class GoogleAuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth ,
    private val userDao : UserDao
) {

    lateinit var credentialManager: CredentialManager

    fun initialize(activity: Activity) {
        credentialManager = CredentialManager.create(activity)
    }

    fun isSignedIn() : Boolean {
        if(firebaseAuth.currentUser != null) {
            Log.d("TAG" , firebaseAuth.currentUser?.displayName.toString())
            return true
        }
        return false
    }


    suspend fun signIn(activity : Activity) : Boolean {
        if(isSignedIn()){
            Log.d("TAG" , "isSignedIn working")
            return true
        }

        try {
            Log.d("TAG" , "buildCredentialRequest working")
            val result = buildCredentialRequest(activity)
            return handleSignIn(result)
        }
        catch(e : Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            Log.d("TAG" , "signin error : ${e.message}")
            return false
        }
    }

    private suspend fun buildCredentialRequest(activity : Activity) : GetCredentialResponse {
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(
                GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId("444036801132-8ue63749kgtndqhuukkku4v6lhp2lo9f.apps.googleusercontent.com")
                    .setAutoSelectEnabled(false)
                    .build()
            ).build()

        return credentialManager.getCredential(
            request = request , context = activity
        )
    }

    private suspend fun handleSignIn(result : GetCredentialResponse) : Boolean {
        val credential = result.credential
        if(
            credential is CustomCredential &&
            credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
        ){
            try {
                val tokenCredential = GoogleIdTokenCredential.createFrom(credential.data)

                userDao.insertUser(UserEntity(
                    id = null ,
                    avatar = tokenCredential.profilePictureUri.toString() ,
                    email = tokenCredential.id ,
                    username = tokenCredential.displayName.toString() ,
                    pincode = null ,
                    address = "",
                    city = ""
                ))

                val authCredential = GoogleAuthProvider.getCredential(
                    tokenCredential.idToken, null
                )

                val authResult = firebaseAuth.signInWithCredential(authCredential).await()

                return authResult.user != null
            }
            catch(e : Exception){
                e.printStackTrace()
                if(e is CancellationException) throw e
                Log.d("TAG" , "GoogleIdTokenParsingException: ${e.message}")
                return false
            }
        }
        else{
            Log.d("TAG" , "GoogleIdTokenParsingException: credential is not GoogleIdTokenCredential")
            return false
        }
    }
    suspend fun signOut(){
        credentialManager.clearCredentialState(
            ClearCredentialStateRequest()
        )
        firebaseAuth.signOut()
    }

}