package com.manadigital.recyclerview1.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.entities.Destination
import com.manadigital.recyclerview1.R

class ExploreHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView: ImageView = view.findViewById(R.id.imageViewDestination)
    private val textViewName1: TextView = view.findViewById(R.id.textViewDestination)
    private val textViewName2: TextView = view.findViewById(R.id.textViewDestination2)
    private val textViewCountry: TextView = view.findViewById(R.id.textViewDestination)

    fun bind(destination: Destination) {
        imageView.setImageResource(destination.imageResId)
        textViewName1.text = destination.name.substring(0, minOf(destination.name.length, 45))
        textViewName2.text = destination.name.substring(45, minOf(destination.name.length, 94))
        textViewCountry.text = destination.country.substring(0, minOf(destination.country.length, 45))
    }
}