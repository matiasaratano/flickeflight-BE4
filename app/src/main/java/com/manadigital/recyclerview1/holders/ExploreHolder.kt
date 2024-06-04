package com.manadigital.recyclerview1.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.entities.Destination
import com.manadigital.recyclerview1.R

class ExploreHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView: AppCompatImageView = view.findViewById(R.id.imageViewDestination)
    private val textViewName1: TextView = view.findViewById(R.id.textViewDestination)
    private val textViewName2: TextView = view.findViewById(R.id.textViewDestination2)
    private val imageViewId: AppCompatImageView = view.findViewById(R.id.imageView5)

    fun bind(destination: Destination) {
        imageView.setImageResource(destination.imageResId)
        textViewName1.text = destination.name
        textViewName2.text = destination.country
        imageViewId.setImageResource(destination.imageId)
    }
}