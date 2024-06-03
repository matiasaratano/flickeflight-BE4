package com.manadigital.recyclerview1.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Flight
import com.squareup.picasso.Picasso

class FlightAdapter(private var flights: List<Flight> = listOf()) :
    RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    class FlightViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flight_item, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flights[position]
        val flightDetails = flight.flights[0]

        holder.view.findViewById<TextView>(R.id.departure_airport).text = flightDetails.departureAirport.name
        holder.view.findViewById<TextView>(R.id.arrival_airport).text = flightDetails.arrivalAirport.name
        holder.view.findViewById<TextView>(R.id.airline).text = flightDetails.airline
        holder.view.findViewById<TextView>(R.id.duration).text = flightDetails.duration.toString()
        holder.view.findViewById<TextView>(R.id.travel_class).text = flightDetails.travelClass
        holder.view.findViewById<TextView>(R.id.price).text = flight.price.toString()
        holder.view.findViewById<TextView>(R.id.departure_airport_id).text = flightDetails.departureAirport.id
        holder.view.findViewById<TextView>(R.id.arrival_airport_id).text = flightDetails.arrivalAirport.id

        val imageView = holder.view.findViewById<ImageView>(R.id.airline_logo)
        Picasso.get().load(flightDetails.airlineLogo).into(imageView)
    }

    override fun getItemCount() = flights.size

    fun updateData(newFlights: List<Flight>) {
        flights = newFlights
        notifyDataSetChanged()
    }
}
