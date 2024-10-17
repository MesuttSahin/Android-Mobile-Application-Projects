package com.example.readifyy;

import java.io.Serializable;

public class Kitaplar implements Serializable
{
    private int kitap_id;
    private String kitap_adi;
    private String kitap_icerik;

    public Kitaplar(int kitap_id, String kitap_adi, String kitap_icerik) {
        this.kitap_id = kitap_id;
        this.kitap_adi = kitap_adi;
        this.kitap_icerik = kitap_icerik;
    }

    public int getKitap_id() {
        return kitap_id;
    }

    public void setKitap_id(int kitap_id) {
        this.kitap_id = kitap_id;
    }

    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

    public String getKitap_icerik() {
        return kitap_icerik;
    }

    public void setKitap_icerik(String kitap_icerik) {
        this.kitap_icerik = kitap_icerik;
    }
}
