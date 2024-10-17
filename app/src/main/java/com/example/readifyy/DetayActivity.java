package com.example.readifyy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.readifyy.databinding.ActivityDetayBinding;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DetayActivity extends AppCompatActivity {

    private ActivityDetayBinding binding;
    private DetayPagerAdapter adapter;
    private List<Sayfa> sayfaListesi;
    private Sayfalar sayfalar = new Sayfalar();
    private SayfaMetin sayfaMetin = new SayfaMetin();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDetayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sayfaListesi = new ArrayList<>();

        sayfalar.listVeriEkle(sayfaListesi, sayfaMetin.getMetin());



        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DetayPagerAdapter(sayfaListesi);
        binding.rv.setAdapter(adapter);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}