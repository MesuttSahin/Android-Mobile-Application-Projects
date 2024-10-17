package com.example.readifyy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.readifyy.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private KitaplarAdapter adapter;
    private ArrayList<Kitaplar> kitaplar;
    private Veritabani vt;
    private boolean silmeModu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vt = new Veritabani(this);
        binding.toolbar.setTitle("Kitaplar");
        setSupportActionBar(binding.toolbar);

        binding.rv.setHasFixedSize(true);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));

        binding.floatingActionButton2.setOnClickListener(view -> {
            showPopUpMenu(view);
        });



        kitaplar = new KitaplarDao().tumKitaplar(vt);
        adapter = new KitaplarAdapter(this, kitaplar);
        binding.rv.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showPopUpMenu(View view)
    {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId()==R.id.action_ekle)
            {
                startActivity(new Intent(this,KitapEkleActivity.class));
                return true;
            }
            else if (item.getItemId()==R.id.action_sil)
            {
                silmeModu = true;
                return true;
            }
            else
            {
                return false;
            }
        });


        popupMenu.show();

    }

    public void silmeKapat()
    {
        silmeModu = false;
    }

    public void onCardViewClicked(int position)
    {
        if (silmeModu)
        {
            Snackbar.make(binding.rv, "Kitap silinsin mi?", Snackbar.LENGTH_LONG).setAction("Evet", view -> {
                new KitaplarDao().kitapSil(vt, kitaplar.get(position).getKitap_id());

                kitaplar.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, kitaplar.size());
                silmeKapat();
            }).show();


        }
        else {
            Kitaplar kitap = kitaplar.get(position);
            Intent intent = new Intent(this, DetayActivity.class);
            intent.putExtra("nesne", kitap);
        }
    }
}