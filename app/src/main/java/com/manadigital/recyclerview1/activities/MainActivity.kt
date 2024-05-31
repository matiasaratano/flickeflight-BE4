package com.manadigital.recyclerview1.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.fragments.FlightFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar y configurar el botón de búsqueda de vuelos
        val buttonSearchFlights: Button = findViewById(R.id.button_search_flights)
        buttonSearchFlights.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FlightFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
