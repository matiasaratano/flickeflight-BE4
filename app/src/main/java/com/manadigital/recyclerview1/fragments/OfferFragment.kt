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
import com.manadigital.recyclerview1.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.manadigital.recyclerview1.adapters.OfferListAdapter
import com.manadigital.recyclerview1.entities.Offers
import com.manadigital.recyclerview1.listener.OnItemClickedListener


class OfferFragment : Fragment(), OnItemClickedListener{

    lateinit var vista : View
    lateinit var recOffers : RecyclerView

    var offers : MutableList<Offers> = ArrayList()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var offerListAdapter: OfferListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        offers =  ArrayList();
        offers.add(Offers("Get 20% discount with your Master credit cards","Use your mastercard with any transaction and get 20% discount instantly!" ,R.drawable.mastercard))
        offers.add(Offers("Get 25% discount with your VISA credit or debit cards","Use your VISA credit or debit card with any transaction and get 25% discount instantly!" ,R.drawable.visa))
        vista = inflater.inflate(R.layout.fragment_offer, container, false)
        recOffers = vista.findViewById(R.id.rec_offers)

        return vista
    }
    override fun onStart() {
        super.onStart()
        Log.d("ListFragment", "onResume")
        //Creo la Lista Dinamica Ofertas



        linearLayoutManager = LinearLayoutManager(context)
        recOffers.layoutManager = linearLayoutManager

        offerListAdapter = OfferListAdapter(offers, this)
        recOffers.adapter = offerListAdapter
    }

    companion object {
        fun newInstance() = OfferFragment

    }
    override fun onHeartClick(position: Int) {
        // Handle the heart selector click event
        val clickedOffer = offers[position]
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener la referencia a la toolbar en el MainActivity
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)

        // Obtener las referencias a los elementos dentro de la toolbar
        val toolbarTitle = toolbar?.findViewById<TextView>(R.id.toolbar_title)
        val puntitos = toolbar?.findViewById<ImageView>(R.id.more_vert)

        // Establecer la visibilidad según sea necesario
        puntitos?.visibility =  View.GONE
        toolbarTitle?.text = "Offers"

    }
    override fun onDestroyView() {
        super.onDestroyView()

        // Restaurar la visibilidad de los elementos cuando el fragmento ya no esté visible
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        val toolbarTitle = toolbar?.findViewById<TextView>(R.id.toolbar_title)
        val puntitos = toolbar?.findViewById<ImageView>(R.id.more_vert)

        puntitos?.visibility =  View.VISIBLE

    }
}