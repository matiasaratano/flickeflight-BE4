package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.entities.Offers
import com.manadigital.recyclerview1.holders.OfferHolder
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.listener.OnItemClickedListener

class OfferListAdapter (
    private val offersList: MutableList<Offers>,
    private val listener: OnItemClickedListener
) : RecyclerView.Adapter<OfferHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_offers,parent,false)
        return (OfferHolder(view, listener))
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

    override fun onBindViewHolder(holder: OfferHolder, position: Int) {
        val offer = offersList[position]
        holder.setTitulo(offer.titulo)
        holder.setDescripcion(offer.descripcion)
        holder.setImagen(offer.imagen)
        }
    }
