package com.manadigital.recyclerview1.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manadigital.recyclerview1.R;
import com.manadigital.recyclerview1.adapters.OfferSimpleAdapter;
import com.manadigital.recyclerview1.entities.OfferSimple;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    RecyclerView rv;
    ArrayList<OfferSimple> dataSource;
    LinearLayoutManager linearLayoutManager;
    OfferSimpleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        rv = view.findViewById(R.id.offers_horizontalRV);

        dataSource = new ArrayList<>();
        dataSource.add(new OfferSimple("20% de descuento para usuarios de Mastercard", R.drawable.mastercard));
        dataSource.add(new OfferSimple("25% de descuento con tus tarjetas Visa", R.drawable.visa));

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new OfferSimpleAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        return view;
    }
}

