package com.manadigital.recyclerview1.entities

data class Flight(
    val departureAirport: Airport,
    val arrivalAirport: Airport,
    val duration: Int,
    val airline: String,
    val airlineLogo: String,
    val travelClass: String,
    val price: Double,
    val id: String
)

data class Airport(
    val name: String,
    val id: String,
    val time: String
)
