package com.manadigital.recyclerview1.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.listener.OnItemClickedListener


class OfferHolder(v: View, private val listener: OnItemClickedListener) : RecyclerView.ViewHolder(v) {

    private var view: View = v
    private var heartSelector: ImageView = view.findViewById(R.id.selector)

    init {
        heartSelector.setOnClickListener {
            heartSelector.isSelected = !heartSelector.isSelected
            listener.onHeartClick(adapterPosition)
        }
    }

    fun setTitulo(titulo: CharSequence?) {
        val txt: TextView = view.findViewById(R.id.discount)
        txt.text = titulo
    }
    fun setDescripcion(descripcion: String?){
        val txt: TextView = view.findViewById(R.id.description)
        txt.text = descripcion
    }
    fun setImagen(imagen: Int){
        val img: AppCompatImageView = view.findViewById(R.id.credit_card)
        img.setImageResource(imagen)
    }

}