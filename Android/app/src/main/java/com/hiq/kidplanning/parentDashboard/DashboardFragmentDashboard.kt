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
                val choresButton: Button? = view.findViewById(R.id.dashboard_kid_vc_top_button)
                val bottomButton: Button? = view.findViewById(R.id.dashboard_kid_vc_bottom_button)
                val kidHiddenName: TextView? = view.findViewById(R.id.dashboard_kid_hidden_name)
                val kidPercentage: TextView? = view.findViewById(R.id.dashboard_kid_vc_percentage)
                val kidNameTextView: TextView? = view.findViewById(R.id.dashboard_kid_name)
                var kidName: String = "invalid";
                if (choresButton != null && bottomButton != null && kidHiddenName != null && kidPercentage != null && kidNameTextView != null && choresButton.visibility == View.VISIBLE) {
                    choresButton.visibility = View.GONE
                    bottomButton.visibility = View.GONE
                    kidHiddenName.visibility = View.INVISIBLE
                    kidPercentage.visibility = View.VISIBLE
                    kidNameTextView.visibility = View.VISIBLE

                    kidName = "invalid"
                }else if(choresButton != null && bottomButton != null && kidHiddenName != null && kidPercentage != null && kidNameTextView != null && choresButton.visibility == View.GONE){
                    choresButton.visibility = View.VISIBLE
                    bottomButton.visibility = View.VISIBLE
                    kidHiddenName.visibility = View.VISIBLE
                    kidPercentage.visibility = View.GONE
                    kidNameTextView.visibility = View.GONE

                    kidName = kidList[position].name
                }

                choresButton?.setOnClickListener{
                    if(kidName != "invalid"){
                        val dashboardFragmentKidChores = DashboardFragmentKidChores.newInstance(kidName)
                        (activity as DashboardActivity).changeFragment(dashboardFragmentKidChores)
                    }else{
                        Toast.makeText(requireContext(), "No individual were chosen", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun addKids(){
        kidList.add(DashboardKid("David", 1337, 999, "The person who is writing this bio is actually still a kid.", 1))
        kidList.add(DashboardKid("Annie Bergenstrale", 144, 888, "Annie likes pancakes, broccoli and unicorns.", 2))
        kidList.add(DashboardKid("Christopher Lee", 144, 888, "Christopher is young but wants to prove himself.", 3))
    }
}