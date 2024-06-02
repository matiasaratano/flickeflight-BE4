package com.manadigital.recyclerview1.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manadigital.recyclerview1.R;
import com.manadigital.recyclerview1.entities.OfferSimple;

import java.util.ArrayList;

public class ActivityHorizontalRv extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<OfferSimple> dataSource;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);

        rv = findViewById(R.id.offers_horizontalRV);

        dataSource = new ArrayList<>();
        dataSource.add(new OfferSimple("20% discount for mastercard users", R.drawable.mastercard));
        dataSource.add(new OfferSimple("25% discount with your Visa credit cards", R.drawable.visa));

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new MyRvAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {
        ArrayList<OfferSimple> data;

        public MyRvAdapter(ArrayList<OfferSimple> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ActivityHorizontalRv.this).inflate(R.layout.item_offers_simp, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            OfferSimple offer = data.get(position);
            holder.discount.setText(offer.getDiscountText());
            holder.creditCard.setImageResource(offer.getImageResId());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView discount;
            ImageView creditCard;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                discount = itemView.findViewById(R.id.discount);
                creditCard = itemView.findViewById(R.id.credit_card);
            }
        }
    }
}
