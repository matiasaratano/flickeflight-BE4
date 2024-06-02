package com.manadigital.recyclerview1.adapters

import CustomTypefaceSpan
import android.graphics.Typeface
import android.os.Build
import android.text.SpannableString
import android.text.Spanned
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
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

        // metodo para que cambie de tipo de fuente la primer parte del texto
        val spannableString = SpannableString(offer.titulo)
        val discounts = listOf("25% discount", "Get 20% discount")

        for (discount in discounts) {
            val start = offer.titulo?.indexOf(discount, ignoreCase = true)
            if (start != -1 && start != null) { // Verificamos que start no sea nulo
                val end = start + discount.length
                val customTypeface: Typeface? = ResourcesCompat.getFont(holder.itemView.context, R.font.roboto_medium)
                customTypeface?.let {
                    spannableString.setSpan(CustomTypefaceSpan(it), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
        }

        holder.setTitulo(spannableString.toString())
        holder.setDescripcion(offer.descripcion)
        holder.setImagen(offer.imagen)
    }
}
