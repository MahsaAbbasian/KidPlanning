package com.hiq.kidplanning.parentDashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiq.kidplanning.R

class DashboardFragmentDashboard : Fragment() {

    private lateinit var dashboardList: RecyclerView
    private lateinit var dashboardAdapter: DashboardAdapter
    private lateinit var kidList: ArrayList<DashboardKid>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        kidList = ArrayList()
        addKids()
        dashboardList = requireView().findViewById(R.id.dashboard_fragment_dashboard_list)
        dashboardList.layoutManager = layoutManager
        dashboardAdapter = DashboardAdapter(kidList)
        dashboardList.adapter = dashboardAdapter

        dashboardAdapter.setOnItemClickListener(object : DashboardAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(requireContext(), "Kid \"${kidList[position].name}\" clicked", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun addKids(){
        kidList.add(DashboardKid("David", 1337, 999, "The person who is writing this bio is actually still a kid."))
        kidList.add(DashboardKid("Annie", 144, 888, "Annie likes pancakes, broccoli and unicorns."))
        kidList.add(DashboardKid("Richard", 144, 888, "Richard is young but wants to prove himself."))
    }
}