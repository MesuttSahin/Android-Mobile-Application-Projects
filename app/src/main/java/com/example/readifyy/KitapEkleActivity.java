package com.example.readifyy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.readifyy.databinding.ActivityKitapEkleBinding;

import java.util.ArrayList;

public class KitapEkleActivity extends AppCompatActivity {
    private ActivityKitapEkleBinding binding;
    private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityKitapEkleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vt = new Veritabani(this);
        binding.button.setOnClickListener(view -> {
            int kitapId = Integer.parseInt(binding.editTextText.getText().toString());
            String kitapAdi = binding.editTextText2.getText().toString();
            String kitapIcerik = binding.editTextText3.getText().toString();

            if (TextUtils.isEmpty(String.valueOf(kitapId)) || TextUtils.isEmpty(kitapAdi) || TextUtils.isEmpty(kitapIcerik))
            {
                startActivity(new Intent(this, MainActivity.class));
            }
            else
            {
                new KitaplarDao().kitapEkle(vt, kitapId, kitapAdi, kitapIcerik);
                startActivity(new Intent(this, MainActivity.class));
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}