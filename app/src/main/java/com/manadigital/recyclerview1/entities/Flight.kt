package com.manadigital.recyclerview1.entities
import com.manadigital.recyclerview1.entities.FlightDetails


data class Flight(
    val flights: List<FlightDetails>,

    val totalDuration: Int,
    val price: Int,
    val type: String,
    val airlineLogo: String,
    val departureToken: String
)

data class Airport(
    val name: String,
    val id: String,
    val time: String
)