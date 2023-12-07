package com.hiq.kidplanning.parentDashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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
            override fun onItemClick(view: View, position: Int) {
                //Toast.makeText(requireContext(), "Kid \"${kidList[position].name}\" clicked", Toast.LENGTH_SHORT).show()
                //dashboardAdapter.resetLastClickedSize()
                val topButton: Button? = view.findViewById(R.id.dashboard_kid_vc_top_button)
                val bottomButton: Button? = view.findViewById(R.id.dashboard_kid_vc_bottom_button)
                val kidHiddenName: TextView? = view.findViewById(R.id.dashboard_kid_hidden_name)
                val kidPercentage: TextView? = view.findViewById(R.id.dashboard_kid_vc_percentage)
                val kidName: TextView? = view.findViewById(R.id.dashboard_kid_name)
                if (topButton != null && bottomButton != null && kidHiddenName != null && kidPercentage != null && kidName != null && topButton.visibility == View.VISIBLE) {
                    topButton.visibility = View.GONE
                    bottomButton.visibility = View.GONE
                    kidHiddenName.visibility = View.GONE
                    kidPercentage.visibility = View.VISIBLE
                    kidName.visibility = View.VISIBLE
                }else if(topButton != null && bottomButton != null && kidHiddenName != null && kidPercentage != null && kidName != null && topButton.visibility == View.GONE){
                    topButton.visibility = View.VISIBLE
                    bottomButton.visibility = View.VISIBLE
                    kidHiddenName.visibility = View.VISIBLE
                    kidPercentage.visibility = View.GONE
                    kidName.visibility = View.GONE
                }
            }
        })
    }

    private fun addKids(){
        kidList.add(DashboardKid("David", 1337, 999, "The person who is writing this bio is actually still a kid."))
        kidList.add(DashboardKid("Annie", 144, 888, "Annie likes pancakes, broccoli and unicorns."))
        kidList.add(DashboardKid("Richard", 144, 888, "Richard is young but wants to prove himself."))
    }
}