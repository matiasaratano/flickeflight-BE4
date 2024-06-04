package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.adapters.FlightAdapter
import com.manadigital.recyclerview1.entities.Flight
import com.manadigital.recyclerview1.entities.FlightsModels
import com.manadigital.recyclerview1.network.ActivityServiceApiBuilder
import com.manadigital.recyclerview1.network.FlightService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlightFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: FlightAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.flight_fragment, container, false)
        viewManager = LinearLayoutManager(context)
        viewAdapter = FlightAdapter(emptyList())

        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter


        }

        loadFlights()

        return view
    }

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
    }
}
