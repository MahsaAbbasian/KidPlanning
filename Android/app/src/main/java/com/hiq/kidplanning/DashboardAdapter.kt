package com.hiq.kidplanning

import android.content.res.Resources
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter(
    private val mList: List<DashboardDataModel>
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int) : ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_card, parent, false)

        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dashboardDataModel = mList[position]
        if(dashboardDataModel.pictureID != 0){
            holder.task.text = dashboardDataModel.taskTodo
            holder.comment.text = dashboardDataModel.comment
            holder.points.text = dashboardDataModel.points.toString()
        }
        // TODO : Implement "task complete" logic
        //holder.points.text = Resources.getSystem().getString(R.string.points) // This is how to use values from strings.xml
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener : OnItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val task: TextView = itemView.findViewById(R.id.recycler_cardview_id_1)
        val comment: TextView = itemView.findViewById(R.id.recycler_cardview_comment)
        val points: TextView = itemView.findViewById(R.id.recycler_cardview_points_value)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}