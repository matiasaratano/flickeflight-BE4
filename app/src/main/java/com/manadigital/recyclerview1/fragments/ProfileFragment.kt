package com.manadigital.recyclerview1.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.manadigital.recyclerview1.R

class ProfileFragment : Fragment() {
    private lateinit var searchButton : LinearLayout
    private lateinit var vista : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        }
    }
