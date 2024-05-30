package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.manadigital.recyclerview1.R

class BoracayFragment : Fragment() {

    private lateinit var vista: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val heartImageView: ImageView = vista.findViewById(R.id.heartImageView)
        heartImageView.setOnClickListener {
            heartImageView.isSelected = !heartImageView.isSelected
        }

    }
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_boracay, container, false)
        return vista
    }




}