package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.adapters.BoracayImageAdapter
import com.manadigital.recyclerview1.entities.BoracayImage

class BoracayFragment : Fragment() {

    private lateinit var vista: View
    private lateinit var imageCarousel: RecyclerView
    private lateinit var images: List<BoracayImage>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_boracay, container, false)
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val heartImageView: ImageView = vista.findViewById(R.id.heartImageView)
        heartImageView.setOnClickListener {
            heartImageView.isSelected = !heartImageView.isSelected
        }

        imageCarousel = vista.findViewById(R.id.image_carousel)

        images = listOf(
            BoracayImage(R.drawable.photo_boracay6),
            BoracayImage(R.drawable.photo_boracay5),
            BoracayImage(R.drawable.photo_boracay4),
            BoracayImage(R.drawable.photo_boracay3),
            BoracayImage(R.drawable.photo_boracay2),
            BoracayImage(R.drawable.photo_boracay1)
        )

        val adapter = BoracayImageAdapter(images)

        imageCarousel.adapter = adapter
        imageCarousel.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }
}