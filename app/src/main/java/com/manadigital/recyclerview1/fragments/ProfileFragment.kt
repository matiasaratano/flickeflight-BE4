package com.manadigital.recyclerview1.fragments

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.activities.MainActivity
import androidx.core.content.ContextCompat

class ProfileFragment : Fragment() {
    private lateinit var searchButton : LinearLayout
    private lateinit var vista : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_profile, container, false)
        searchButton = vista.findViewById(R.id.settingsButton)
        searchButton.setOnClickListener(View.OnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_bottom_bar_profile_to_drawer_settings)
        })
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onResume() {
        super.onResume()

        // Cambiar el fondo de la barra de herramientas
        (activity as MainActivity).changeToolbarBackground(R.drawable.prueba_de_fondo)

        // Personalizar la flecha de retroceso
        val backButton = LayerDrawable(arrayOf(
            ContextCompat.getDrawable(requireContext(), R.drawable.back_button),
            ContextCompat.getDrawable(requireContext(), R.drawable.baseline_arrow_back_24)
        ))
        (activity as MainActivity).supportActionBar?.setHomeAsUpIndicator(backButton)

        (activity as MainActivity).addToolbarButton()

        val mainActivity = activity as MainActivity

        // Obtener una referencia a la Toolbar
        val toolbar: Toolbar = mainActivity.findViewById(R.id.toolbar)

        // Obtener una referencia al TextView del título de la Toolbar
        val toolbarTitle: TextView = toolbar.findViewById(R.id.toolbar_title)

        // Cambiar el texto del título de la Toolbar
        toolbarTitle.text = ""

        val toolbarDotsIcon: ImageView = toolbar.findViewById(R.id.more_vert)
        toolbarDotsIcon.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()

        // Cambiar el fondo de la barra de herramientas
        (activity as MainActivity).changeToolbarBackground(R.color.white)

        // Restablecer la flecha de retroceso a su apariencia predeterminada
        (activity as MainActivity).supportActionBar?.setHomeAsUpIndicator(null)

        (activity as MainActivity).removeToolbarButton()
    }
}