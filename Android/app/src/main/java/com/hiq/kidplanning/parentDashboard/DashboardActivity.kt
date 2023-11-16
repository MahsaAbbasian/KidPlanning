package com.hiq.kidplanning.parentDashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiq.kidplanning.R

class DashboardActivity : AppCompatActivity() {

    private lateinit var dashboardList: RecyclerView
    private lateinit var dashboardAdapter: DashboardAdapter
    private lateinit var tasksList: ArrayList<DashboardDataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val toolbar: Toolbar = findViewById(R.id.parent_dashboard_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = null

        dashboardList = findViewById(R.id.dashboardRecyclerList)
        tasksList = ArrayList()
        addTasks()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        dashboardList.layoutManager = layoutManager
        dashboardAdapter = DashboardAdapter(tasksList)
        dashboardList.adapter = dashboardAdapter

        dashboardAdapter.setOnItemClickListener(object : DashboardAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@DashboardActivity, "Task \"${tasksList[position].taskTodo}\" clicked", Toast.LENGTH_SHORT).show()
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
}