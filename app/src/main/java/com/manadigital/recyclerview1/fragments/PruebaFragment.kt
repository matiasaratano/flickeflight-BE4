package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.manadigital.recyclerview1.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.manadigital.recyclerview1.adapters.OfferListAdapter
import com.manadigital.recyclerview1.entities.Offers
import com.manadigital.recyclerview1.holders.OfferHolder
import com.manadigital.recyclerview1.listener.OnItemClickedListener


class PruebaFragment : Fragment() {
    lateinit var  vista : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.layoutprueba, container, false)


        return vista
    }
    override fun onStart() {
        super.onStart()

    }

    companion object {
        fun newInstance() = PruebaFragment

    }
}