package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.adapters.ExploreAdapter
import com.manadigital.recyclerview1.adapters.OfferSimpleAdapter
import com.manadigital.recyclerview1.entities.Destination
import com.manadigital.recyclerview1.entities.OfferSimple
import com.manadigital.recyclerview1.listener.OnItemNavClickedListener
import com.manadigital.recyclerview1.listener.TrendingDestinationNav

class ExploreFragment : Fragment(), OnItemNavClickedListener , TrendingDestinationNav{
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
        // Obtener la referencia a la toolbar en el MainActivity
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)

        // Obtener las referencias a los elementos dentro de la toolbar
        val toolbarTitle = toolbar?.findViewById<TextView>(R.id.toolbar_title)
        val imagenLogo = toolbar?.findViewById<ImageView>(R.id.imagen_logo)
        val puntitos = toolbar?.findViewById<ImageView>(R.id.more_vert)
        val profileImage = toolbar?.findViewById<ImageView>(R.id.toolbar_profile_image)
        // Establecer la visibilidad según sea necesario
        toolbarTitle?.visibility = View.GONE
        puntitos?.visibility = View.GONE
        imagenLogo?.visibility = View.VISIBLE
        profileImage?.visibility = View.VISIBLE


        // Setup Trending Destinations RecyclerView
        trendingDestinationsRecyclerView = viewRoot.findViewById(R.id.recyclerViewTrendingDestinations)
        destinations = listOf(
            Destination(R.drawable.d_boracay, "Boracay", "Philippines", R.drawable.diasboracay),
            Destination(R.drawable.d_baros, "Baros", "Maldives", R.drawable.diasboracay),
            Destination(R.drawable.d_bali, "Bali", "Indonesia", R.drawable.diasboracay),
            Destination(R.drawable.d_palawan, "Palawan", "Philippines", R.drawable.diasboracay)
        )
        val trendingDestinationsAdapter = ExploreAdapter(destinations,this)
        trendingDestinationsRecyclerView.adapter = trendingDestinationsAdapter
        trendingDestinationsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Setup Offers RecyclerView
        offersRecyclerView = viewRoot.findViewById(R.id.offers_horizontalRV)
        offers = listOf(
            OfferSimple("20% de descuento para usuarios de Mastercard", R.drawable.mastercard),
            OfferSimple("25% de descuento con tus tarjetas Visa", R.drawable.visa)
        )
        val offersAdapter = OfferSimpleAdapter(offers,this)
        offersRecyclerView.adapter = offersAdapter
        offersRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
    override fun onDestroyView() {
        super.onDestroyView()

        // Restaurar la visibilidad de los elementos cuando el fragmento ya no esté visible
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        val toolbarTitle = toolbar?.findViewById<TextView>(R.id.toolbar_title)
        val imagenLogo = toolbar?.findViewById<ImageView>(R.id.imagen_logo)
        val puntitos = toolbar?.findViewById<ImageView>(R.id.more_vert)
        val profileImage = toolbar?.findViewById<ImageView>(R.id.toolbar_profile_image)

        toolbarTitle?.visibility = View.VISIBLE
        imagenLogo?.visibility = View.GONE
        profileImage?.visibility = View.GONE
        puntitos?.visibility = View.VISIBLE

    }

    override fun navOnClick() {
        Navigation.findNavController(viewRoot).navigate(R.id.action_bottom_bar_explore_to_bottom_bar_offers)
    }

    override fun navOnClickTrending(string : String) {
        viewRoot.findNavController().navigate(ExploreFragmentDirections.actionBottomBarExploreToBoracayFragment(string))
    }
}
