package com.adindas.coding.texttospeechdso_d270;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btn_convert, btn_clear;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.et_input);
        btn_convert = findViewById(R.id.btn_convert);
        btn_clear = findViewById(R.id.btn_clear);

        textToSpeech = new TextToSpeech(getApplicationContext()
                , new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if ( i == TextToSpeech.SUCCESS ) {
                    /// pilih bahasa
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // bisa edit tulisan
                String s = etInput.getText().toString();

                // text convert untuk bicara
                int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clear edit text
                etInput.setText("");
            }
        });
    }
}