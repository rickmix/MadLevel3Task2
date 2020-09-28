package com.example.madlevel3example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel3task2.Portal
import com.example.madlevel3task2.R
import kotlinx.android.synthetic.main.portal_item.view.*

class PortalAdapter(private val reminders: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.portal_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return reminders.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(reminders[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun dataBind(reminder: Portal) {
            itemView.tvPortal.text = reminder.title
            itemView.tvPortalUrl.text = reminder.url
        }
    }

}