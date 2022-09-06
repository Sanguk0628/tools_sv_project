package com.example.aaaaaaa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList id, order, sub, name, price;

    CustomAdapter(Activity activity, Context context, ArrayList id, ArrayList order, ArrayList sub, ArrayList name, ArrayList price){
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.order = order;
        this.sub = sub;
        this.name = name;
        this.price = price;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.chc_id.setText(String.valueOf(id.get(position)));
        holder.chc_order.setText(String.valueOf(order.get(position)));
        holder.chc_sub.setText(String.valueOf(sub.get(position)));
        holder.chc_name.setText(String.valueOf(name.get(position)));
        holder.chc_price.setText(String.valueOf(price.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("ord", String.valueOf(order.get(position)));
                intent.putExtra("sub", String.valueOf(sub.get(position)));
                intent.putExtra("nam", String.valueOf(name.get(position)));
                intent.putExtra("num", String.valueOf(price.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView  chc_id, chc_order, chc_sub, chc_name, chc_price;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            chc_id = itemView.findViewById(R.id.item_id);
            chc_order = itemView.findViewById(R.id.item_order);
            chc_sub = itemView.findViewById(R.id.item_sub);
            chc_name = itemView.findViewById(R.id.item_name);
            chc_price = itemView.findViewById(R.id.item_price);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);

        }
    }
}
