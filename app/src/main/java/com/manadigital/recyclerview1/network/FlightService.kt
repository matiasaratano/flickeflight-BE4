package com.manadigital.recyclerview1.network

import com.manadigital.recyclerview1.entities.Flight
import com.manadigital.recyclerview1.entities.FlightsModels
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightService {
    @GET("search?engine=google_flights&api_key=123&departure_id=EZE&arrival_id=MIA&outbound_date=2024-05-31&return_date=2024-06-10")
    fun searchFlights(
    ): Call<FlightsModels>
}
