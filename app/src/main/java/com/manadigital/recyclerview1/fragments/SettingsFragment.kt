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


class SettingsFragment : Fragment() {
    lateinit var  vista : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_settings, container, false)


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
        val imagenProfile = toolbar?.findViewById<ImageView>(R.id.toolbar_profile_image)
        val puntitos = toolbar?.findViewById<ImageView>(R.id.more_vert)

        // Establecer la visibilidad según sea necesario
        toolbarTitle?.visibility = View.GONE
        imagenLogo?.visibility = View.VISIBLE
        imagenProfile?.visibility = View.VISIBLE
        puntitos?.visibility = View.GONE
    }
    override fun onDestroyView() {
        super.onDestroyView()

        // Restaurar la visibilidad de los elementos cuando el fragmento ya no esté visible
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        val toolbarTitle = toolbar?.findViewById<TextView>(R.id.toolbar_title)
        val imagenLogo = toolbar?.findViewById<ImageView>(R.id.imagen_logo)
        val imagenProfile = toolbar?.findViewById<ImageView>(R.id.toolbar_profile_image)
        val puntitos = toolbar?.findViewById<ImageView>(R.id.more_vert)


        toolbarTitle?.visibility = View.VISIBLE
        imagenLogo?.visibility = View.GONE
        imagenProfile?.visibility = View.GONE
        puntitos?.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance() = PruebaFragment

    }
}