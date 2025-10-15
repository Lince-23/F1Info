package com.lince23.f1info.features.drivers.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.lince23.f1info.R
import com.lince23.f1info.features.drivers.domain.Driver
import androidx.core.graphics.toColorInt

class DriversAdapter(private val driversList: List<Driver>) :
    RecyclerView.Adapter<DriversAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDriverName: TextView
        val tvDriverTeam: TextView
        val ivDriver: ImageView
        val vLineColor: View

        init {
            tvDriverName = view.findViewById(R.id.tvDriverName)
            tvDriverTeam = view.findViewById(R.id.tvDriverTeam)
            ivDriver = view.findViewById(R.id.ivDriver)
            vLineColor = view.findViewById(R.id.vLineColor)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.drivers_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvDriverName.text = driversList[position].fullName
        viewHolder.tvDriverTeam.text = driversList[position].team
        viewHolder.ivDriver.load(driversList[position].image)
        val color = driversList[position].teamColor
        viewHolder.vLineColor.setBackgroundColor("#$color".toColorInt())
    }

    override fun getItemCount() = driversList.size

}