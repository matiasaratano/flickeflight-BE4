package com.manadigital.recyclerview1.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Flight
import com.manadigital.recyclerview1.listener.OnItemNavClickedListener
import com.manadigital.recyclerview1.listener.SearchResultOnClick
import com.squareup.picasso.Picasso

class FlightAdapter(private var flightList: List<Flight>,  private val onItemClickListener : SearchResultOnClick) :
    RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    class FlightViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flight_item, parent, false) as View
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flightList[position]
        holder.view.findViewById<TextView>(R.id.departure_airport).text = flight.departureAirport.name
        holder.view.findViewById<TextView>(R.id.departure_airport_id2).text = flight.departureAirport.name
        holder.view.findViewById<TextView>(R.id.arrival_airport).text = flight.arrivalAirport.name
        holder.view.findViewById<TextView>(R.id.arrival_airport_id2).text = flight.arrivalAirport.name
        holder.view.findViewById<TextView>(R.id.airline).text = flight.airline
        holder.view.findViewById<TextView>(R.id.duration).text = flight.duration.toString()
        holder.view.findViewById<TextView>(R.id.travel_class).text = flight.travelClass
        holder.view.findViewById<TextView>(R.id.price).text = flight.price.toString()
        holder.view.findViewById<TextView>(R.id.departure_airport_id).text = flight.departureAirport.id
        holder.view.findViewById<TextView>(R.id.arrival_airport_id).text = flight.arrivalAirport.id
        holder.view.findViewById<Button>(R.id.book_button).setOnClickListener{
            onItemClickListener.navOnClick()
        }

        val imageView = holder.view.findViewById<ImageView>(R.id.airline_logo)
        Picasso.get().load(flight.airlineLogo).into(imageView)
    }

    override fun getItemCount() = flightList.size

    fun updateData(newFlightList: List<Flight>) {
        flightList = newFlightList
        notifyDataSetChanged()
    }
}
