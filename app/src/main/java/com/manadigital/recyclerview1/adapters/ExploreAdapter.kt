package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Destination
import com.manadigital.recyclerview1.holders.ExploreHolder

class ExploreAdapter(private val destinations: List<Destination>) :
    RecyclerView.Adapter<ExploreHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trending_destination, parent, false)
        return ExploreHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreHolder, position: Int) {
        val destination = destinations[position]
        holder.bind(destination)
    }

    override fun getItemCount(): Int {
        return destinations.size
    }
}