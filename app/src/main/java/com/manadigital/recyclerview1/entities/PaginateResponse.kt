package com.manadigital.recyclerview1.entities
import com.manadigital.recyclerview1.entities.Flight



data class PaginateResponse<T>(
    val searchMetadata: SearchMetadata,
    val searchParameters: SearchParameters,
    val bestFlights: List<Flight>,
    val otherFlights: List<Flight>
)

data class SearchMetadata(
    val id: String,
    val status: String,
    val jsonEndpoint: String,
    val createdAt: String,
    val processedAt: String,
    val googleFlightsUrl: String,
    val rawHtmlFile: String,
    val prettifyHtmlFile: String,
    val totalTimeTaken: Double
)

data class SearchParameters(
    val engine: String,
    val hl: String,
    val gl: String,
    val departureId: String,
    val arrivalId: String,
    val outboundDate: String,
    val returnDate: String
)
