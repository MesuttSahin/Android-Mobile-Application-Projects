package com.example.readifyy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper
{
    public Veritabani(@Nullable Context context) {
        super(context, "kitaplar.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE kitaplar(kitapId INTEGER PRIMARY KEY AUTOINCREMENT, kitapAdi TEXT, kitapIcerik TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS kitaplar");
    }
}
