package com.manadigital.recyclerview1.network

import com.manadigital.recyclerview1.entities.Flight
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightService {
    @GET("search")
    fun searchFlights(
        @Query("engine") engine: String,
        @Query("api_key") apiKey: String,
        @Query("departure_id") departureId: String,
        @Query("departure_id2") departureId2: String, //lo agregue para que no este repetido en el layout
        @Query("arrival_id") arrivalId: String,
        @Query("arrival_id2") arrivalId2: String, //lo agregue para que no este repetido en el layout
        @Query("outbound_date") outboundDate: String,
        @Query("return_date") returnDate: String
    ): Call<List<Flight>>

    //agregue esta fun pero solo para qeu buildee, hayq ue ver como manejar este error.
    abstract fun searchFlights(engine: String, apiKey: String, departureId: String, departureId2: String, arrivalId: String, arrivalId2: String): Call<List<Flight>>
}
