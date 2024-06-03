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
import com.manadigital.recyclerview1.entities.PaginateResponse
import com.manadigital.recyclerview1.network.FlightService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConstants {
    const val BASE_URL = "https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/"
    const val ENGINE = "google_flights"
    const val API_KEY = "123"
    const val DEPARTURE_ID = "EZE"
    const val ARRIVAL_ID = "MIA"
    const val OUTBOUND_DATE = "2024-05-31"
    const val RETURN_DATE = "2024-06-10"
}

class FlightFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: FlightAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FlightFragment", "onCreateView called")
        val view = inflater.inflate(R.layout.flight_fragment, container, false)
        viewManager = LinearLayoutManager(context)
        viewAdapter = FlightAdapter()

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
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(FlightService::class.java)

        val call = service.searchFlights(
            engine = ApiConstants.ENGINE,
            apiKey = ApiConstants.API_KEY,
            departureId = ApiConstants.DEPARTURE_ID,
            departureId2 = ApiConstants.DEPARTURE_ID,
            arrivalId = ApiConstants.ARRIVAL_ID,
            arrivalId2 = ApiConstants.ARRIVAL_ID,
            outboundDate = ApiConstants.OUTBOUND_DATE,
            returnDate = ApiConstants.RETURN_DATE
        )

        call.enqueue(object : Callback<PaginateResponse<Flight>> {
            override fun onResponse(
                call: Call<PaginateResponse<Flight>>,
                response: Response<PaginateResponse<Flight>>
            ) {
                if (response.isSuccessful) {
                    val flights = response.body()?.bestFlights ?: emptyList()
                    viewAdapter.updateData(flights)
                    Log.e("FlightFragment", "Flights fetched successfully")
                    val responseBody = response.body()
                    Log.d("FlightFragment", "Response body: ${responseBody}")
                }


            }

            override fun onFailure(call: Call<PaginateResponse<Flight>>, t: Throwable) {
                Log.e("FlightFragment", "Error fetching flights", t)
            }
        })  }
}

