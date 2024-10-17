package com.example.readifyy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class DetayPagerAdapter extends RecyclerView.Adapter<DetayPagerAdapter.SayfaViewHolder> {
    private List<Sayfa> sayfalar;

    // Yapıcı metot
    public DetayPagerAdapter(List<Sayfa> sayfalar) {
        this.sayfalar = sayfalar;
    }

    @NonNull
    @Override
    public SayfaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sayfa_item, parent, false);
        return new SayfaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SayfaViewHolder holder, int position) {
        Sayfa sayfa = sayfalar.get(position);
        holder.textView.setText(sayfa.getİçerik());
    }

    @Override
    public int getItemCount() {
        return sayfalar.size();
    }

    static class SayfaViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        SayfaViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.sayfa_text);
        }
    }
}
