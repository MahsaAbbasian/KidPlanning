package com.hiq.kidplanning.parentDashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hiq.kidplanning.R

class FragmentKidChoresAdapter(
    private val mList: List<Chore>
) : RecyclerView.Adapter<FragmentKidChoresAdapter.ViewHolder>(){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_card_dashboard_kid_chores_pv, parent, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chore = mList[position]

        holder.choreTask.text = chore.task
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(listener : FragmentKidChoresAdapter.OnItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: FragmentKidChoresAdapter.OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        // val chorePicture: imageView?
        val choreTask: TextView = itemView.findViewById(R.id.dashboard_fragment_kid_chores_pv_chore_text)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(it, adapterPosition)
            }
        }
    }
}