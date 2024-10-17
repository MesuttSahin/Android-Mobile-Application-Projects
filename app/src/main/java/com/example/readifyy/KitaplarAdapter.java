package com.example.readifyy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KitaplarAdapter extends RecyclerView.Adapter<KitaplarAdapter.CardViewHolder>
{
    private Context context;
    private ArrayList<Kitaplar> kitaplar;

    public KitaplarAdapter(Context context, ArrayList<Kitaplar> kitaplar) {
        this.context = context;
        this.kitaplar = kitaplar;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder
    {
        private CardView card;
        private TextView textViewKitapAdi;
        private ImageView imageView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            textViewKitapAdi = itemView.findViewById(R.id.textViewKitapAdi);
            imageView = itemView.findViewById(R.id.imageView3);
        }


    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_tasarrim, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Kitaplar kitap = kitaplar.get(position);
        holder.textViewKitapAdi.setText(kitap.getKitap_adi());

        holder.card.setOnClickListener(view -> {
            ((MainActivity) context).onCardViewClicked(position);
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetayActivity.class);
                intent.putExtra("nesne", kitap);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return kitaplar.size();
    }


}
