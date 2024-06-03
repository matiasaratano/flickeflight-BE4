package com.manadigital.recyclerview1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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
    Button searchButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        rv = view.findViewById(R.id.offers_horizontalRV);
        searchButton = view.findViewById(R.id.button_search);


        dataSource = new ArrayList<>();
        dataSource.add(new OfferSimple("20% de descuento para usuarios de Mastercard", R.drawable.mastercard));
        dataSource.add(new OfferSimple("25% de descuento con tus tarjetas Visa", R.drawable.visa));

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new OfferSimpleAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_bottom_bar_search_to_flightFragment);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener la referencia a la toolbar en el MainActivity
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        // Obtener las referencias a los elementos dentro de la toolbar
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        ImageView puntitos = toolbar.findViewById(R.id.more_vert);

        // Establecer la visibilidad según sea necesario

        toolbarTitle.setText("Search Flight");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Restaurar la visibilidad de los elementos cuando el fragmento ya no esté visible
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        ImageView puntitos = toolbar.findViewById(R.id.more_vert);

    }
}