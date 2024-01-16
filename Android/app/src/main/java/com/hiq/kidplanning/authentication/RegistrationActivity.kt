package com.hiq.kidplanning.authentication

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hiq.kidplanning.parentDashboard.DashboardActivity

class RegistrationActivity(private val activity: AppCompatActivity) {


    // Use the FirebaseManager to access FirebaseAuth
    private val auth = FirebaseManager.auth

    //This function is responsible for handling the registration button click.
    fun setRegistrationClickListener(
        emailEdit: EditText,
        passwordEdit: EditText,
        registrationBtn: Button
    ) {

        registrationBtn.setOnClickListener {
            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()

            // Preventing invalid data from being sent to Firebase by validate the user input (email and password)
            if (isValidInput(email, password)) {

                // Using FireBase to create a new user account
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Registration successful notification
                            Toast.makeText(
                                activity,
                                "Registration successful!",
                                Toast.LENGTH_SHORT
                            ).show()
                            // starting new activity.
                            val intent = Intent(activity, DashboardActivity::class.java)
                            activity.startActivity(intent)
                            activity.finish()
                        } else {
                            // Registration failed, handle the error
                            val exception = task.exception
                            Toast.makeText(
                                activity,
                                "Registration failed! $exception",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }

    private fun isValidInput(email: String, password: String): Boolean {

        // Check if the email is not empty and is in a valid format
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showShortToast("Email is invalid!")
            return false
        }
        // Check if the password is not empty and is at least 6 characters long
        if (password.isEmpty() || password.length < 6) {
            showShortToast("Password must be at least 6 characters long")
            return false
        }
        return true

    }

    private fun showShortToast(message: String) {

        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}