package com.manadigital.recyclerview1.entities

data class FlightX(
    val airline: String,
    val airline_logo: String,
    val airplane: String,
    val arrival_airport: ArrivalAirport,
    val departure_airport: DepartureAirport,
    val duration: Int,
    val flight_number: String,
    val travel_class: String
)