package com.lince23.f1info.features.drivers.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val tvDriverLastName: TextView
        val vLineColor: View

        init {
            tvDriverName = view.findViewById(R.id.tvDriverName)
            tvDriverLastName = view.findViewById(R.id.tvDriverLastName)
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
        viewHolder.tvDriverName.text = driversList[position].givenName
        viewHolder.tvDriverLastName.text = driversList[position].familyName
    }

    override fun getItemCount() = driversList.size

}