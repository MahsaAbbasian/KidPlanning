package com.hiq.kidplanning.parentDashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hiq.kidplanning.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val toolbar: Toolbar = findViewById(R.id.parent_dashboard_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Dashboard Parent"

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.dashboard_bottom_menu)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.dashboard_bottom_menu_dashboard-> {
                    // Dashboard
                    //Toast.makeText(this@DashboardActivity, "Dashboard clicked", Toast.LENGTH_SHORT).show()
                    changeFragment(DashboardFragmentDashboard())
                    true
                }
                R.id.dashboard_bottom_menu_chores -> {
                    // Chores
                    //Toast.makeText(this@DashboardActivity, "Chores clicked", Toast.LENGTH_SHORT).show()
                    changeFragment(DashboardFragmentChores())
                    true
                }
                R.id.dashboard_bottom_menu_profile -> {
                    // Profile
                    //Toast.makeText(this@DashboardActivity, "My Profile clicked", Toast.LENGTH_SHORT).show()
                    changeFragment(DashboardFragmentProfile())
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.inflateMenu(R.menu.dashboard_bottom_navigation_menu)
    }

    fun changeFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.dashboardFragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.parent_dashboard_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_settings -> {
                Toast.makeText(this@DashboardActivity, "Position \"Settings\" clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_add_kid -> {
                Toast.makeText(this@DashboardActivity, "Position \"Add Kid\" clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_logout -> {
                Toast.makeText(this@DashboardActivity, "Position \"Logout\" clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_about -> {
                Toast.makeText(this@DashboardActivity, "Position \"About\" clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}