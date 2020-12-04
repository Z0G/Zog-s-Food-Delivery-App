package com.example.foodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.FoodDetails;
import com.example.foodapp.R;
import com.example.foodapp.model.Allmenu;

import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> {

    Context context;
    List<Allmenu> allmenuList;

    public AllMenuAdapter(Context context, List<Allmenu> allmenuList) {
        this.context = context;
        this.allmenuList = allmenuList;
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);

        return new AllMenuAdapter.AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, int position) {

        holder.popularName.setText(allmenuList.get(position).getName());
        holder.popularPrice.setText(allmenuList.get(position).getPrice());
        holder.popularTime.setText(allmenuList.get(position).getDeliveryCharges());
        holder.popularRating.setText(allmenuList.get(position).getRating());
        holder.popularCharges.setText(allmenuList.get(position).getDeliveryCharges());
        holder.popularNote.setText(allmenuList.get(position).getNote());

        Glide.with(context).load(allmenuList.get(position).getImageUrl()).into(holder.popularImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, FoodDetails.class);
                i.putExtra("name", allmenuList.get(position).getName());
                i.putExtra("price", allmenuList.get(position).getPrice());
                i.putExtra("rating", allmenuList.get(position).getRating());
                i.putExtra("image", allmenuList.get(position).getImageUrl());

                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {

        return allmenuList.size();
    }

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder{

        ImageView popularImage;
        TextView popularName, popularNote, popularRating, popularTime, popularCharges, popularPrice;

        public AllMenuViewHolder(@NonNull View itemView) {

            super(itemView);

            popularName = itemView.findViewById(R.id.all_menu_name);
            popularNote = itemView.findViewById(R.id.all_menu_note);
            popularRating = itemView.findViewById(R.id.all_menu_rating);
            popularTime = itemView.findViewById(R.id.all_menu_deliverytime);
            popularCharges = itemView.findViewById(R.id.all_menu_delivery_charge);
            popularPrice = itemView.findViewById(R.id.all_menu_price);
            popularImage = itemView.findViewById(R.id.all_menu_image);
        }
    }
}
