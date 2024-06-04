package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.adapters.ExploreAdapter
import com.manadigital.recyclerview1.adapters.OfferSimpleAdapter
import com.manadigital.recyclerview1.entities.Destination
import com.manadigital.recyclerview1.entities.OfferSimple

class ExploreFragment : Fragment() {
    private lateinit var viewRoot: View
    private lateinit var trendingDestinationsRecyclerView: RecyclerView
    private lateinit var offersRecyclerView: RecyclerView
    private lateinit var destinations: List<Destination>
    private lateinit var offers: List<OfferSimple>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewRoot = inflater.inflate(R.layout.fragment_explore, container, false)
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Trending Destinations RecyclerView
        trendingDestinationsRecyclerView = viewRoot.findViewById(R.id.recyclerViewTrendingDestinations)
        destinations = listOf(
            Destination(R.drawable.d_boracay, "Boracay", "Philippines", R.drawable.diasboracay),
            Destination(R.drawable.d_baros, "Baros", "Maldives", R.drawable.diasboracay),
            Destination(R.drawable.d_bali, "Bali", "Indonesia", R.drawable.diasboracay),
            Destination(R.drawable.d_palawan, "Palawan", "Philippines", R.drawable.diasboracay)
        )
        val trendingDestinationsAdapter = ExploreAdapter(destinations)
        trendingDestinationsRecyclerView.adapter = trendingDestinationsAdapter
        trendingDestinationsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Setup Offers RecyclerView
        offersRecyclerView = viewRoot.findViewById(R.id.offers_horizontalRV)
        offers = listOf(
            OfferSimple("20% de descuento para usuarios de Mastercard", R.drawable.mastercard),
            OfferSimple("25% de descuento con tus tarjetas Visa", R.drawable.visa)
        )
        val offersAdapter = OfferSimpleAdapter(offers)
        offersRecyclerView.adapter = offersAdapter
        offersRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}
