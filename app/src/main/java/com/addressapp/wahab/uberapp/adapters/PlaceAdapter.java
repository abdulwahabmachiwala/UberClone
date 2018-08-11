package com.addressapp.wahab.uberapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.addressapp.wahab.uberapp.listeners.OnItemClickListener;
import com.addressapp.wahab.uberapp.models.Place;
import com.khan.maaz.uberapp.R;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {
    private ArrayList<Place> places;
    private OnItemClickListener listener;

    public PlaceAdapter(ArrayList<Place> places, OnItemClickListener listener) {
        this.places = places;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.bind(places.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;
        private TextView descriptionTextView;

        public MyViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.title_of_list);
            descriptionTextView = view.findViewById(R.id.description_of_list);
        }

        public void bind(final Place place, final OnItemClickListener listener) {
            titleTextView.setText(place.getTitle());
            descriptionTextView.setText(place.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(place);
                }
            });
        }
    }
}
