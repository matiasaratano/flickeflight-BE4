package com.manadigital.recyclerview1.entities

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