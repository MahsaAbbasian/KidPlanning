package com.hiq.kidplanning.parentDashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiq.kidplanning.R

class DashboardFragmentKidChores : Fragment() {

    private var dataImport: String? = null
    private lateinit var listOfChores: ArrayList<Chore>

    companion object {
        private const val arg_dataImport = "newData"
        fun newInstance(data: String): DashboardFragmentKidChores {
            return DashboardFragmentKidChores().apply {
                arguments = Bundle().apply {
                    putString(arg_dataImport, data)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            dataImport = it.getString(arg_dataImport)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_kid_chores_parent_view , container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOfChores = ArrayList()
        addChores()

        val kidPicture: ImageView = view.findViewById(R.id.dashboard_fragment_kid_chores_pv_pic)
        val kidName: TextView? = view.findViewById(R.id.dashboard_fragment_kid_chores_pv_kid_name)

        if (kidName != null) {
            kidName.text = dataImport
        }
        if(dataImport == "Annie Bergenstrale"){
            kidPicture.setImageResource(android.R.drawable.ic_menu_myplaces)
        }else if(dataImport == "Christopher Lee"){
            kidPicture.setImageResource(android.R.drawable.btn_star_big_on)
        }

        val choreRecycleList: RecyclerView = requireView().findViewById(R.id.dashboard_fragment_kid_chores_pv_list)
        choreRecycleList.layoutManager = GridLayoutManager(requireContext(), 3)
        val choresAdapter: FragmentKidChoresAdapter = FragmentKidChoresAdapter(listOfChores)
        choreRecycleList.adapter = choresAdapter

        choresAdapter.setOnItemClickListener(object : FragmentKidChoresAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(requireContext(), "Item $position in list", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun addChores(){
        listOfChores.add(Chore("Make Bed", "Make your bed", 1, 2))
        listOfChores.add(Chore("Get Dressed", "Pick out some clothes or ask mommy", 3, 4, true))
        listOfChores.add(Chore("Brush Teeth", "Brush ALL your teeth", 5, 6, true))
        listOfChores.add(Chore("Brush Hair", "Make sure you look respectable", 7, 8))
        listOfChores.add(Chore("Feed Pet", "Fido won't feed himself", 9, 10))
        listOfChores.add(Chore(task ="Finish Homework", pictureID = 11, points = 12))
        listOfChores.add(Chore(task = "Set table", pictureID = 13, points = 14))
        listOfChores.add(Chore(task = "Empty Dishwasher", pictureID = 15, points = 16))
        listOfChores.add(Chore(task = "Fix Car", description = "Change the spark plugs on daddy's car", pictureID = 17, points = 18, complete = true))
        listOfChores.add(Chore(task = "Hamper", description = "Put dirty clothes into the hamper", pictureID = 19, points = 20))
        listOfChores.add(Chore(task = "The Sink", description = "The the dirty dishes into the sink", pictureID = 21, points = 22))
        listOfChores.add(Chore(task = "Add your own?"))
    }
}