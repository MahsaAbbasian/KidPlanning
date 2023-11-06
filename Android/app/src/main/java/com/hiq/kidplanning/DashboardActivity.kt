package com.hiq.kidplanning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    private lateinit var dashboardList: RecyclerView
    private lateinit var dashboardAdapter: DashboardAdapter
    private lateinit var tasksList: ArrayList<DashboardDataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        dashboardList = findViewById(R.id.dashboardRecyclerList)
        tasksList = ArrayList()
        addTasks()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        dashboardList.layoutManager = layoutManager
        dashboardAdapter = DashboardAdapter(tasksList)
        dashboardList.adapter = dashboardAdapter

        dashboardAdapter.setOnItemClickListener(object : DashboardAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@DashboardActivity, "Task \"${tasksList[position].taskTodo}\" clicked", Toast.LENGTH_SHORT).show()
            }
        })
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