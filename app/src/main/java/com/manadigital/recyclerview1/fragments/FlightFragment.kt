package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.adapters.FlightAdapter
import com.manadigital.recyclerview1.entities.Flight
import com.manadigital.recyclerview1.entities.OfferSimple
import com.manadigital.recyclerview1.listener.SearchResultOnClick
import com.manadigital.recyclerview1.network.FlightService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlightFragment : Fragment() , SearchResultOnClick {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: FlightAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.flight_fragment, container, false)
        viewManager = LinearLayoutManager(context)
        viewAdapter = FlightAdapter(emptyList(), this)

        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter


        }

        loadFlights()

        return view
    }

<<<<<<< HEAD
    private fun loadFlights() {
        val service = ActivityServiceApiBuilder.create()

        service.searchFlights().enqueue(object : Callback<FlightsModels> {
            override fun onResponse(call: Call<FlightsModels>, response: Response<FlightsModels>) {
                if (response.isSuccessful) {
                    val flightsResponse = response.body()
                    // Actualiza el adaptador con los vuelos obtenidos de la respuesta
                    viewAdapter.updateData(flightsResponse?.best_flights?.flatMap { it.flights } ?: emptyList())
                } else {
                    Log.e(
                        "FlightFragment",
                        "Response not successful: ${response.errorBody()?.string()}"
                    )
                }
            }

            override fun onFailure(call: Call<FlightsModels>, t: Throwable) {
                Log.e("FlightFragment", "Error: ${t.message}", t)
            }
        })
=======
    private fun fetchFlights() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(FlightService::class.java)

        val call = service.searchFlights("google_flights", "123", "EZE", "MIA", "2024-05-31", "2024-06-10")
        call.enqueue(object : Callback<List<Flight>> {
            override fun onResponse(call: Call<List<Flight>>, response: Response<List<Flight>>) {
                if (response.isSuccessful) {
                    viewAdapter.updateData(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Flight>>, t: Throwable) {
                // Manejar error
            }
        })
    }

    override fun navOnClick() {
        Navigation.findNavController(view).navigate(R.id.action_bottom_bar_search_to_bottom_bar_offers)
>>>>>>> 71d8f934f59d784abe2888a509981d42a1784923
    }
}
