package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.OfferSimple

class OfferSimpleAdapter(private val offersList: List<OfferSimple>) :
    RecyclerView.Adapter<OfferSimpleAdapter.OfferViewHolder>() {

    class OfferViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val discount: TextView = view.findViewById(R.id.discount)
        val description: TextView = view.findViewById(R.id.description)
        val creditCard: ImageView = view.findViewById(R.id.credit_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offers_simp, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = offersList[position]
        holder.discount.text = offer.discountText
        holder.description.text = offer.descriptionText
        holder.creditCard.setImageResource(offer.imageResId)
    }

    override fun getItemCount() = offersList.size
}
