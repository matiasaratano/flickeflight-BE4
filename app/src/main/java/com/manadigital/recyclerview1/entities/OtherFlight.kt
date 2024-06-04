package com.manadigital.recyclerview1.entities

data class OtherFlight(
    val airline_logo: String,
    val departure_token: String,
    val flights: List<FlightX>,
    val price: Int,
    val total_duration: Int,
    val type: String
)