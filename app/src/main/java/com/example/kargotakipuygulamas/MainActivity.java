package com.example.kargotakipuygulamas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    Spinner spinnerDurum;
    Button buttonKontrol;
    TextView textSonuc;

    KargoDurumu seciliDurum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDurum = findViewById(R.id.spinnerDurum);
        buttonKontrol = findViewById(R.id.buttonKontrol);
        textSonuc = findViewById(R.id.textSonuc);

        // Enum değerlerini spinner'a yükle
        ArrayAdapter<KargoDurumu> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                KargoDurumu.values()
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDurum.setAdapter(adapter);

        // Butona tıklanınca durumu kontrol et
        buttonKontrol.setOnClickListener(v -> {
            seciliDurum = (KargoDurumu) spinnerDurum.getSelectedItem();

            switch (seciliDurum) {
                case HAZIRLANIYOR:
                    textSonuc.setText("Kargonuz hazırlanıyor. Lütfen bekleyin.");
                    break;
                case YOLA_CIKTI:
                    textSonuc.setText("Kargonuz yola çıktı.");
                    break;
                case DAGITIMDA:
                    textSonuc.setText("Kargonuz dağıtımda, gün içinde size ulaşacak.");
                    break;
                case TESLIM_EDILDI:
                    textSonuc.setText("Kargonuz başarıyla teslim edildi!");
                    break;
            }
        });
    }
}
