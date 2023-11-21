package com.hiq.kidplanning

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.hiq.kidplanning.parentDashboard.DashboardActivity


class MainActivity : AppCompatActivity() {
    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }
    private lateinit var sharedpreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.dashboard_textview_middle)
        button.setOnClickListener{
            val changePage = Intent(this, DashboardActivity::class.java)
            startActivity(changePage)
        }

            // Initializing EditTexts and our Button
            val emailEdt = findViewById<EditText>(R.id.idEdtEmail)
            val passwordEdt = findViewById<EditText>(R.id.idEdtPassword)
            val loginBtn = findViewById<Button>(R.id.idBtnLogin)


            // getting the data which is stored in shared preferences.
            sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

            // Retrieve email and password from shared preferences
            retrieveCredentials()

            //set up login button click listener
            setupLoginClickListener(emailEdt,passwordEdt,loginBtn)
        }
        private fun setupLoginClickListener(emailEdt: EditText, passwordEdt: EditText, loginBtn: Button) {

            // Set up click listener for login button
            loginBtn.setOnClickListener {
                if (TextUtils.isEmpty(emailEdt.text.toString()) && TextUtils.isEmpty(passwordEdt.text.toString())) {
                    // this method will call when email and password fields are empty.
                    Toast.makeText(this@MainActivity, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
                } else {
                    // Save email and password to shared preferences
                    saveCredentials(emailEdt.text.toString(), passwordEdt.text.toString())

                    // starting new activity.
                    val i = Intent(this@MainActivity, DashboardActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }
        }
    private fun saveCredentials(email: String, password: String){
        // TODO Implement logic for saving credentials to shared preferences
        val editor = sharedpreferences.edit()
        editor.putString(EMAIL_KEY,email )
        editor.putString(PASSWORD_KEY, password)
        editor.apply()

    }
    private fun retrieveCredentials(){
        // TODO Implement logic for retrieving credentials from shared preferences
        val saveEmail = sharedpreferences.getString(EMAIL_KEY, "")
        val savedPassword = sharedpreferences.getString(PASSWORD_KEY, "")

    }
    }
