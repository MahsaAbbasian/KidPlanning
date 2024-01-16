package com.hiq.kidplanning.main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.hiq.kidplanning.R
import com.hiq.kidplanning.authentication.RegistrationActivity
import com.hiq.kidplanning.authentication.SignInActivity

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //check if the user is logging in or registering
        val isLoggingIn = intent.getBooleanExtra("isLoggingIn", false)

        // set the content viewer based on login state
        if(isLoggingIn) {
            setContentView(R.layout.activity_login)
        }else{
            setContentView(R.layout.activity_registration)
        }

        // Initializing EditTexts and our Button
        val emailEdt = findViewById<EditText>(R.id.idEdtEmail)
        val passwordEdt = findViewById<EditText>(R.id.idEdtPassword)
        val registrationBtn = findViewById<Button>(R.id.idBtnRegister)
        val loginBtn = findViewById<Button>(R.id.idBtnLogin)

        // set up registration button click listener
        RegistrationActivity(this).setRegistrationClickListener(emailEdt, passwordEdt, registrationBtn)
        // set up login button click listener
        SignInActivity(this).setupLoginClickListener(emailEdt, passwordEdt, loginBtn)
    }

}

