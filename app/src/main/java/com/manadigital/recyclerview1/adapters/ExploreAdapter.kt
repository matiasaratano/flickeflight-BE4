package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Destination
import com.manadigital.recyclerview1.holders.ExploreHolder
import com.manadigital.recyclerview1.listener.SearchResultOnClick
import com.manadigital.recyclerview1.listener.TrendingDestinationNav

class ExploreAdapter(private val destinations: List<Destination>, private val onItemClickListener : TrendingDestinationNav) :
    RecyclerView.Adapter<ExploreHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trending_destination, parent, false)
        return ExploreHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreHolder, position: Int) {
        val destination = destinations[position]
        holder.bind(destination)
        holder.getCardLayout().setOnClickListener{
            onItemClickListener.navOnClickTrending("5D4N")
        }
    }

    override fun getItemCount(): Int {
        return destinations.size
    }
}