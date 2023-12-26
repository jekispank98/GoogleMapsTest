package com.example.googlemapstest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.LocationModel
import com.example.googlemapstest.R

class ListOfPointAdapter(private val context: Context): RecyclerView.Adapter<ListOfPointAdapter.ListOfPointHolder>() {

    private var listOfPoint = emptyList<LocationModel>()
    class ListOfPointHolder(pointView: View): RecyclerView.ViewHolder(pointView) {

        val name = pointView.findViewById<TextView>(R.id.name_of_point)
        val latitude = pointView.findViewById<TextView>(R.id.latitude_value)
        val longitude = pointView.findViewById<TextView>(R.id.longitude_value)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfPointHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.point_layout, parent, false)
        return ListOfPointHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfPoint.size
    }

    override fun onBindViewHolder(holder: ListOfPointHolder, position: Int) {
        val location = listOfPoint[position]
        holder.apply {
            name.text = context.getString(R.string.POINT) + " " + (position + 1).toString()
            latitude.text = context.getString(R.string.DEGREE_LABEL, location.latitude.toString().take(7))
            longitude.text = context.getString(R.string.DEGREE_LABEL, location.longitude.toString().take(7))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatePoints(list:List<LocationModel>) {
        listOfPoint = list
        notifyDataSetChanged()
    }
}