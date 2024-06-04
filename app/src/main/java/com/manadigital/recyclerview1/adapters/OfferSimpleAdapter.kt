package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.OfferSimple
import com.manadigital.recyclerview1.listener.OnItemNavClickedListener

class OfferSimpleAdapter(private val offersList: List<OfferSimple>,  private val onItemClickListener : OnItemNavClickedListener ) :
    RecyclerView.Adapter<OfferSimpleAdapter.OfferViewHolder>() {

    class OfferViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val discount: TextView = view.findViewById(R.id.discount)
        val description: TextView = view.findViewById(R.id.description)
        val creditCard: ImageView = view.findViewById(R.id.credit_card)
        val card : CardView = view.findViewById(R.id.card_package_item_offers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offers_simp, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = offersList[position]
        holder.discount.text = offer.discountText
        holder.creditCard.setImageResource(offer.imageResId)
        holder.card.setOnClickListener{
            onItemClickListener.navOnClick()
        }


    }

    override fun getItemCount() = offersList.size
}
