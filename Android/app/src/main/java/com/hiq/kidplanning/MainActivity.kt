package com.hiq.kidplanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hiq.kidplanning.parentDashboard.DashboardActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.dashboardButton)
        button.setOnClickListener{
            val changePage = Intent(this, DashboardActivity::class.java)
            startActivity(changePage)
        }
    }
}