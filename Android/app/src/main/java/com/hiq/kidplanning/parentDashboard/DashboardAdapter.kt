package com.hiq.kidplanning.parentDashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hiq.kidplanning.R

class DashboardAdapter(
    //private val mList: List<DashboardDataModel>
    private val mList: List<DashboardKid>
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int) : ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard_kid_view_card, parent, false)

        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dashboardKid = mList[position]

        holder.kidName.text = dashboardKid.name
        holder.kidHiddenName.text = dashboardKid.name
        if(dashboardKid.name == "Annie"){
            holder.kidPercentage.text = holder.itemView.context.getString(R.string.percentage64)
        }

        holder.itemView.setOnClickListener {
            // Kalla på onItemClick-metoden i lyssnaren
            mListener?.onItemClick(it, position)
        }
        /*
        if(dashboardDataModel.pictureID != 0){
            holder.task.text = dashboardDataModel.taskTodo
            holder.comment.text = dashboardDataModel.comment
            holder.points.text = dashboardDataModel.points.toString()
        }
        if(dashboardDataModel.isComplete){
            holder.task.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.comment.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }*/

        //holder.points.text = Resources.getSystem().getString(R.string.points) // This is how to use values from strings.xml
        //holder.points.text = holder.itemView.context.getString(R.string.percentage64)
    }

    private var lastClickedPosition: Int = RecyclerView.NO_POSITION

    fun resetLastClickedSize() {
        if (lastClickedPosition != RecyclerView.NO_POSITION) {
            notifyItemChanged(lastClickedPosition)
            lastClickedPosition = RecyclerView.NO_POSITION
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(listener : OnItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        /*val task: TextView = itemView.findViewById(R.id.recycler_cardview_id_1)
        val comment: TextView = itemView.findViewById(R.id.recycler_cardview_comment)
        val points: TextView = itemView.findViewById(R.id.recycler_cardview_points_value)*/

        val kidName: TextView = itemView.findViewById(R.id.dashboard_kid_name)
        val kidHiddenName: TextView = itemView.findViewById(R.id.dashboard_kid_hidden_name)
        val kidPercentage: TextView = itemView.findViewById(R.id.dashboard_kid_vc_percentage)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(it, adapterPosition)
            }
        }
    }
}