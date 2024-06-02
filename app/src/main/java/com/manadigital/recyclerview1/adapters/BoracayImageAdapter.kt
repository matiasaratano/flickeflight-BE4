package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.BoracayImage
import com.manadigital.recyclerview1.holders.BoracayImageViewHolder

class BoracayImageAdapter(private val images: List<BoracayImage>) : RecyclerView.Adapter<BoracayImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoracayImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.boracay_image, parent, false)
        return BoracayImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoracayImageViewHolder, position: Int) {
        val boracayImage = images[position]
        holder.imageView.setImageResource(boracayImage.image)
    }

    override fun getItemCount() = images.size
}