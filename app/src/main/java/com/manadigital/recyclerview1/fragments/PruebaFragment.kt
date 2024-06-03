package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.manadigital.recyclerview1.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.manadigital.recyclerview1.adapters.OfferListAdapter
import com.manadigital.recyclerview1.entities.Offers
import com.manadigital.recyclerview1.holders.OfferHolder
import com.manadigital.recyclerview1.listener.OnItemClickedListener


class PruebaFragment : Fragment() {
    lateinit var  vista : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_explore, container, false)


        return vista
    }
    override fun onStart() {
        super.onStart()

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener la referencia a la toolbar en el MainActivity
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)

        // Obtener las referencias a los elementos dentro de la toolbar
        val toolbarTitle = toolbar?.findViewById<TextView>(R.id.toolbar_title)
        val imagenLogo = toolbar?.findViewById<ImageView>(R.id.imagen_logo)

        // Establecer la visibilidad según sea necesario
        toolbarTitle?.visibility = View.GONE
        imagenLogo?.visibility = View.VISIBLE
    }
    override fun onDestroyView() {
        super.onDestroyView()

        // Restaurar la visibilidad de los elementos cuando el fragmento ya no esté visible
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        val toolbarTitle = toolbar?.findViewById<TextView>(R.id.toolbar_title)
        val imagenLogo = toolbar?.findViewById<ImageView>(R.id.imagen_logo)

        toolbarTitle?.visibility = View.VISIBLE
        imagenLogo?.visibility = View.GONE
    }

    companion object {
        fun newInstance() = PruebaFragment

    }
}