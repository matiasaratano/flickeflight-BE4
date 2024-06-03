package com.manadigital.recyclerview1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manadigital.recyclerview1.R;
import com.manadigital.recyclerview1.adapters.ExploreAdapter;
import com.manadigital.recyclerview1.entities.Destination;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    private RecyclerView recyclerView;
    private ExploreAdapter adapter;
    private List<Destination> destinations;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTrendingDestinations);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupRecyclerView();
        setToolbarTitle();
    }

    private void setupRecyclerView() {
        destinations = createDestinations(); // Define tus destinos aquí
        adapter = new ExploreAdapter(destinations);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    private List<Destination> createDestinations() {
        // Define tus destinos aquí
        List<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination(R.drawable.d_boracay, "Destino 1", "País 1"));
        destinations.add(new Destination(R.drawable.d_baros, "Destino 2", "País 2"));
        destinations.add(new Destination(R.drawable.d_bali, "Destino 3", "País 3"));
        destinations.add(new Destination(R.drawable.d_palawan, "Destino 4", "País 4"));
        return destinations;
    }

    private void setToolbarTitle() {
        // Get reference to the toolbar in MainActivity
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        // Get references to elements inside the toolbar
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        ImageView puntitos = toolbar.findViewById(R.id.more_vert);

        // Set visibility as needed
        toolbarTitle.setText("Explore Destinations");
    }
}
