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

data class FlightDetails(
    val departureAirport: Airport,
    val arrivalAirport: Airport,
    val duration: Int,
    val airplane: String,
    val airline: String,
    val airlineLogo: String,
    val travelClass: String,
    val flightNumber: String,
    val legroom: String,
    val extensions: List<String>,
    val overnight: Boolean = false,
    val oftenDelayedByOver30Min: Boolean = false
)