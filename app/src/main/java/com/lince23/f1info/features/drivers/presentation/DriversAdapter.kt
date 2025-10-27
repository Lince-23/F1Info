package com.lince23.f1info.features.drivers.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lince23.f1info.R
import com.lince23.f1info.features.drivers.domain.Driver

class DriversAdapter(private val driversList: List<Driver>) :
    RecyclerView.Adapter<DriversAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDriverName: TextView
        val tvDriverLastName: TextView
        val vLineColor: View

        val tvDriverNumber: TextView

        init {
            tvDriverName = view.findViewById(R.id.tvDriverName)
            tvDriverLastName = view.findViewById(R.id.tvDriverLastName)
            vLineColor = view.findViewById(R.id.vLineColor)
            tvDriverNumber = view.findViewById(R.id.tvDriverNumber)
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
        viewHolder.tvDriverNumber.text = driversList[position].permanentNumber
    }

    override fun getItemCount() = driversList.size

}