package com.example.javamadeeasy.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javamadeeasy.LessonsActivity;
import com.example.javamadeeasy.ProgramsActivity;
import com.example.javamadeeasy.R;
import com.example.javamadeeasy.models.Menu;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    List<Menu> menus;
    Context context;
    LayoutInflater inflater;

    public  MenuAdapter(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
        this.inflater = LayoutInflater.from(context);
    }


    public  class ViewHolder extends  RecyclerView.ViewHolder {

        private TextView textViewMenuName;
        private ImageView imageViewMenuImage;
        private CardView cardViewMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMenuName = itemView.findViewById(R.id.tvMenuName);
            imageViewMenuImage = itemView.findViewById(R.id.imgMenuImage);
            cardViewMenu = itemView.findViewById(R.id.cardViewMenu);
        }
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        holder.textViewMenuName.setText(menus.get(position).getName());
        holder.imageViewMenuImage.setImageResource(menus.get(position).getImage());
        holder.cardViewMenu.setCardBackgroundColor(menus.get(position).getColor());

        holder.cardViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedMenuName = menus.get(position).getName();

                switch (selectedMenuName) {
                    case "Lessons":
                        Intent intentLessons = new Intent(context, LessonsActivity.class);
                        context.startActivity(intentLessons);
                        break;
                    case  "Programs":
                        Intent intentPrograms = new Intent(context, ProgramsActivity.class);
                        context.startActivity(intentPrograms);
                    default:
                        return;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
}
