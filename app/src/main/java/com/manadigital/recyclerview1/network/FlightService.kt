package com.manadigital.recyclerview1.network

import com.manadigital.recyclerview1.entities.Flight
import com.manadigital.recyclerview1.entities.PaginateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightService {
    @GET("search")
    fun searchFlights(
        @Query("engine") engine: String,
        @Query("api_key") apiKey: String,
        @Query("departure_id") departureId: String,
        @Query("departure_id2") departureId2: String,
        @Query("arrival_id") arrivalId: String,
        @Query("arrival_id2") arrivalId2: String,
        @Query("outbound_date") outboundDate: String,
        @Query("return_date") returnDate: String
    ): Call<PaginateResponse<Flight>>
}
