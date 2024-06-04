package com.manadigital.recyclerview1.entities

data class BestFlight(
    val airline_logo: String,
    val flights: List<Flight>,
    val price: Int,
    val total_duration: Int,

)