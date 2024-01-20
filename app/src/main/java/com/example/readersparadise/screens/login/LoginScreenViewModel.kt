package com.example.readersparadise.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readersparadise.model.MUser
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch


class LoginScreenViewModel: ViewModel() {

    //val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth


    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading


    fun signInWithEmailAndPassword(email: String, password: String, home:() -> Unit) = viewModelScope.launch {

        try {

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Todo: Navigate to home screen
                        Log.d("FB", "signInWithEmail:success:YAYAYAY  ${task.result.toString()}")
                        home()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d("FB", "signInWithEmail:failure", task.exception)
                    }
                }

        } catch (e: Exception) {
            Log.d("FB", "signInWithEmail:failure", e)
        }

    }


    fun createUserWithEmailAndPassword(email:String,
                                       password:String,
                                       home:() -> Unit) {
        if (_loading.value == false) {
            _loading.value == true
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
// To display name fromEmail
                        val displayName = task.result.user?.email?.split('@')?.get(0)

                        createUser(displayName.toString()  )


                                home()
                    }else{

                    }
                    _loading.value == false
                }
        }




    }

    private fun createUser(displayName: String) {

        val userId = auth.currentUser?.uid

        val user = MUser(userId= userId.toString(), displayName = displayName, avatarUrl = "", quote = "life is great", profession = "Android Developer",
            id= null).toMap()



        FirebaseFirestore.getInstance().collection("users")
            .add(user)



    }
}



