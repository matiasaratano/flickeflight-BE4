package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.adapters.FlightAdapter
import com.manadigital.recyclerview1.entities.Flight
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

        fetchFlights()

        return view
    }

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
}
