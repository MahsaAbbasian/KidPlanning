package com.hiq.kidplanning.parentDashboard

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.hiq.kidplanning.R
import java.lang.StringBuilder

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
        //val childName = firstName(dashboardKid.name)

        holder.kidName.text = firstName(dashboardKid.name)
        holder.kidHiddenName.text = dashboardKid.name

        holder.kidName.setTextColor(holder.itemView.context.getColor(R.color.white))
        holder.kidHiddenName.setTextColor(holder.itemView.context.getColor(R.color.white))
        holder.kidPercentage.setTextColor(holder.itemView.context.getColor(R.color.white))

        holder.itemView.setOnClickListener {
            mListener.onItemClick(it, position)
        }

        holder.layout.background = colorChoice(dashboardKid.colorChoice)

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

    private fun colorChoice(choice: Int): GradientDrawable {
        val gradientDrawable = GradientDrawable()
        val startColor: Int
        val endColor: Int

        when (choice) {
            1 -> {
                startColor = Color.parseColor("#f569e0")
                endColor = Color.parseColor("#f79eea")
            }
            2 -> {
                startColor = Color.parseColor("#7569f5")
                endColor = Color.parseColor("#aba4f5")
            }
            3 -> {
                startColor = Color.parseColor("#f54545")
                endColor = Color.parseColor("#f77e7e")
            }
            else -> {
                startColor = Color.parseColor("#4af545")
                endColor = Color.parseColor("#99fa96")
            }
        }

        gradientDrawable.orientation = GradientDrawable.Orientation.LEFT_RIGHT
        gradientDrawable.colors = intArrayOf(startColor, endColor)
        return  gradientDrawable
    }

    private fun firstName(name: String): String {
        val firstNameString = StringBuilder(name.trim().split(" ")[0])
        if(firstNameString.length > 10){
            firstNameString.setLength(9)
            firstNameString.append(".")
        }
        return firstNameString.toString()
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

        val layout: ConstraintLayout = itemView.findViewById(R.id.dashboard_viewcard_layout)

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