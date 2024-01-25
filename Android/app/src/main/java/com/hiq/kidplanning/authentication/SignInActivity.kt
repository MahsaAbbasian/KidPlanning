package com.hiq.kidplanning.authentication

import android.content.Intent
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.hiq.kidplanning.parentDashboard.DashboardActivity


class SignInActivity(private val activity: AppCompatActivity) {

    private val auth = FirebaseManager.auth

    //This function is responsible for handling the login button click
    fun setupLoginClickListener(emailEdt: EditText, passwordEdt: EditText, loginBtn: Button) {
        // Set up click listener for login button
        loginBtn.setOnClickListener {
            val email = emailEdt.text.toString()
            val password = passwordEdt.text.toString()

            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                // this method will call when email and password fields are empty.
                Toast.makeText(
                    activity,
                    "Please Enter Email and Password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Using Firebase to sign in
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task: Task<AuthResult>  ->
                        if (task.isSuccessful) {
                            // Login successful notification
                            Toast.makeText(
                                activity,
                                "Login successful!",
                                Toast.LENGTH_SHORT
                            ).show()

                            // starting new activity.
                            val intent = Intent(activity, DashboardActivity::class.java)
                            activity.startActivity(intent)
                            activity.finish()
                        } else {
                            // Login failed, handle the error
                            val exception = task.exception
                            Toast.makeText(
                                activity,
                                "Login failed! $exception",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }
}