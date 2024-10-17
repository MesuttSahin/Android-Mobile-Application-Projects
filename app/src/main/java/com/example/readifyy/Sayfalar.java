package com.example.readifyy;

import java.util.ArrayList;
import java.util.List;

public class Sayfalar {
    // Kitap metnini alıp sayfalara ekleyen metod
    public void listVeriEkle(List<Sayfa> sayfaListesi, String kitapMetni) {
        int maxWords = 200;
        List<String> parcalar = splitText(kitapMetni, maxWords);

        for (String parca : parcalar) {
            sayfaListesi.add(new Sayfa(parca));
        }
    }

    // Metni belirtilen kelime sayısına göre parçalara ayıran metod
    private List<String> splitText(String metin, int maxWords) {
        List<String> parcalar = new ArrayList<>();
        String[] kelimeler = metin.split("\\s+");

        StringBuilder sayfa = new StringBuilder();
        int kelimeSayisi = 0;

        for (String kelime : kelimeler) {
            if (kelimeSayisi < maxWords) {
                sayfa.append(kelime).append(" ");
                kelimeSayisi++;
            } else {
                // Sayfayı kaydet ve yeni sayfayı başlat
                parcalar.add(sayfa.toString().trim());
                sayfa = new StringBuilder(kelime + " ");
                kelimeSayisi = 1;
            }
        }

        // Son sayfayı ekle
        if (sayfa.length() > 0) {
            parcalar.add(sayfa.toString().trim());
        }

        return parcalar;
    }
}
