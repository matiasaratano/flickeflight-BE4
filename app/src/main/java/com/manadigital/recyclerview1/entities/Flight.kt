package com.manadigital.recyclerview1.entities

data class Flight(
    val departureAirport: Airport,
    val arrivalAirport: Airport,
    val duration: Int,
<<<<<<< HEAD
    val flight_number: String,
    val travel_class: String,
    val price: Int
)
=======
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
>>>>>>> 71d8f934f59d784abe2888a509981d42a1784923
