package com.hiq.kidplanning.parentDashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

        holder.chorePicture.setImageResource(getPictureIcon(chore.pictureID))

        holder.choreTask.text = chore.task
    }

    private fun getPictureIcon(choice: Int): Int {

        when (choice) {
            1 -> {
                return android.R.drawable.btn_star
            }3 -> {
                return android.R.drawable.btn_star_big_off
            }5 -> {
                return android.R.drawable.checkbox_on_background
            }7 -> {
                return android.R.drawable.ic_delete
            }9 -> {
                return android.R.drawable.ic_menu_agenda
            }11 -> {
                return android.R.drawable.ic_dialog_email
            }13 -> {
                return android.R.drawable.ic_menu_delete
            }15 -> {
                return android.R.drawable.ic_menu_help
            }17 -> {
                return android.R.drawable.ic_menu_manage
            }19 -> {
                return android.R.drawable.ic_dialog_map
            }
            else -> {
                return android.R.drawable.ic_input_add
            }
        }
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
        val chorePicture: ImageView = itemView.findViewById(R.id.dashboard_fragment_chores_picture)
        val choreTask: TextView = itemView.findViewById(R.id.dashboard_fragment_kid_chores_pv_chore_text)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(it, adapterPosition)
            }
        }
    }
}