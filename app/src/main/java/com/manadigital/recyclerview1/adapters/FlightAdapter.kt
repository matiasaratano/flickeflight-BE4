package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Flight
import com.squareup.picasso.Picasso

class FlightAdapter(private var flightList: List<Flight>) :
    RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    private val airportNameMap = mapOf(
        "EZE" to "Ezeiza Ar",
        "MIA" to "Miami Fl",
        "IAH" to "Houston Tx",
        "JFK" to "Nueva York",
        "VVI" to "Viru Viru",
        "MEX" to "Mexico",
        "GIG" to "Río de Janeiro",
        "BOG" to "El Dorado"
    )

    class FlightViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flight_item, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flightList[position]
        val departureAirportName = airportNameMap[flight.departure_airport.id] ?: flight.departure_airport.name
        val arrivalAirportName = airportNameMap[flight.arrival_airport.id] ?: flight.arrival_airport.name

        holder.view.findViewById<TextView>(R.id.departure_airport).text = departureAirportName
        holder.view.findViewById<TextView>(R.id.departure_airport_id2).text = flight.departure_airport.id
        holder.view.findViewById<TextView>(R.id.arrival_airport).text = arrivalAirportName
        holder.view.findViewById<TextView>(R.id.arrival_airport_id2).text = flight.arrival_airport.id
        holder.view.findViewById<TextView>(R.id.airline).text = flight.airline
        holder.view.findViewById<TextView>(R.id.duration).text = formatDuration(flight.duration)
        holder.view.findViewById<TextView>(R.id.travel_class).text = flight.travel_class
        holder.view.findViewById<TextView>(R.id.price).text = flight.price.toString()
        holder.view.findViewById<TextView>(R.id.departure_airport_id).text = flight.departure_airport.id
        holder.view.findViewById<TextView>(R.id.arrival_airport_id).text = flight.arrival_airport.id

        val imageView = holder.view.findViewById<ImageView>(R.id.airline_logo)
        Picasso.get().load(flight.airline_logo).into(imageView)
    }

    override fun getItemCount() = flightList.size

    fun updateData(newFlightList: List<Flight>) {
        flightList = newFlightList
        notifyDataSetChanged()
    }

    fun formatDuration(duration: Int): String {
        val hours = duration / 60
        val minutes = duration % 60
        return String.format("%02d hr %02dmin", hours, minutes)
    }
}
