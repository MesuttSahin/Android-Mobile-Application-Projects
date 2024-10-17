package com.example.readifyy;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KitaplarDao
{
    public ArrayList<Kitaplar> tumKitaplar(Veritabani vt)
    {
        ArrayList<Kitaplar> kitaplar = new ArrayList<>();
        SQLiteDatabase db = vt.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kitaplar", null);

        while (c.moveToNext())
        {
            Kitaplar kitap = new Kitaplar(c.getInt(c.getColumnIndexOrThrow("kitapId")),
                    c.getString(c.getColumnIndexOrThrow("kitapAdi")),
                    c.getString(c.getColumnIndexOrThrow("kitapIcerik"))
            );
            kitaplar.add(kitap);
        }
        db.close();
        c.close();
        return kitaplar;
    }

    public void kitapEkle(Veritabani vt, int kitapId,String kitapAdi, String kitapIcerik)
    {
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kitapId", kitapId);
        values.put("kitapAdi", kitapAdi);
        values.put("kitapIcerik", kitapIcerik);
        db.insertOrThrow("kitaplar", null, values);
        db.close();
    }

    public void kitapSil(Veritabani vt, int kitapId)
    {
        SQLiteDatabase db = vt.getWritableDatabase();
        db.delete("kitaplar", "kitapId=?", new String[]{String.valueOf(kitapId)});
        db.close();
    }
}
