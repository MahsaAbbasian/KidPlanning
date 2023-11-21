package com.hiq.kidplanning.parentDashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hiq.kidplanning.R

class DashboardActivity : AppCompatActivity() {

    private lateinit var dashboardList: RecyclerView
    private lateinit var dashboardAdapter: DashboardAdapter
    private lateinit var tasksList: ArrayList<DashboardDataModel>
    private lateinit var kidList: ArrayList<DashboardKid>

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
                    Toast.makeText(this@DashboardActivity, "Dashboard clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.dashboard_bottom_menu_chores -> {
                    // Chores
                    Toast.makeText(this@DashboardActivity, "Chores clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.dashboard_bottom_menu_profile -> {
                    // Profile
                    Toast.makeText(this@DashboardActivity, "My Profile clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.inflateMenu(R.menu.dashboard_bottom_navigation_menu)

        dashboardList = findViewById(R.id.dashboardRecyclerList)
        tasksList = ArrayList()
        addTasks()
        kidList = ArrayList()
        addKids()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        dashboardList.layoutManager = layoutManager
        dashboardAdapter = DashboardAdapter(kidList)
        dashboardList.adapter = dashboardAdapter

        dashboardAdapter.setOnItemClickListener(object : DashboardAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@DashboardActivity, "Kid \"${kidList[position].name}\" clicked", Toast.LENGTH_SHORT).show()
            }
        })
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

    private fun addTasks(){
        tasksList.add(DashboardDataModel("Homework", "Finish your homework", false, 10, 1))
        tasksList.add(DashboardDataModel("Cleaning", "Clean your room", false, 20, 2))
        tasksList.add(DashboardDataModel("Bed", "Make your bed", true, 5, 3))
        tasksList.add(DashboardDataModel("Teeth", "Brush your teeth", false, 5, 4))
        tasksList.add(DashboardDataModel("Default Text", "Default Comment", false, 5, 0))
        tasksList.add(DashboardDataModel("Default Text", "Default Comment", true, 5, 0))
        tasksList.add(DashboardDataModel("Default Text", "Default Comment", false, 5, 0))
        tasksList.add(DashboardDataModel("Default Text", "Default Comment", false, 5, 0))
        tasksList.add(DashboardDataModel("Default Text", "Default Comment", false, 5, 0))
        tasksList.add(DashboardDataModel("Default Text", "Default Comment", false, 5, 0))
    }

    private fun addKids(){
        kidList.add(DashboardKid("David", 1337, 999, "The person who is writing this bio is actually still a kid."))
        kidList.add(DashboardKid("Annie", 144, 888, "Annie likes pancakes, broccoli and unicorns."))
        kidList.add(DashboardKid("Richard", 144, 888, "Richard is young but wants to prove himself."))
    }
}