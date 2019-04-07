package com.example.android_lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DodajWpis extends AppCompatActivity {

    private int modyfi_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);
        ArrayAdapter<String> gatunki = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] { "Pies", "Kot", "Rybki" });
        Spinner gatunek = findViewById(R.id.gatunek);
        gatunek.setAdapter(gatunki);

        Bundle extras = getIntent().getExtras();
        try {
            if(extras.getSerializable("element")!= null){
                Animal zwierz = (Animal) extras.getSerializable("element");

                EditText kolor = findViewById(R.id.editText2);
                EditText wielkosc = findViewById(R.id.editText3);
                EditText opis = findViewById(R.id.editText4);

                kolor.setText(zwierz.getKolor());
                wielkosc.setText(Float.toString(zwierz.getWielkosc()));
                opis.setText(zwierz.getOpis());

                modyfi_id = zwierz.getId();
            }
        }catch (Exception ex){
            this.modyfi_id=0;
        }
    }

    public void wyslij(View view){
        /*EditText kontrolka = findViewById(R.id.editText);
        String pole = kontrolka.getText().toString();
        Intent intencja = new Intent();
        intencja.putExtra("wpis", pole);
        setResult(RESULT_OK, intencja);
        finish();*/
        Spinner gatunek = findViewById(R.id.gatunek);
        EditText kolor = findViewById(R.id.editText2);
        EditText wielkosc = findViewById(R.id.editText3);
        EditText opis = findViewById(R.id.editText4);

        Animal zwierze = new Animal(gatunek.getSelectedItem().toString(),
                kolor.getText().toString(),
                Float.valueOf(wielkosc.getText().toString()),
                opis.getText().toString());
        zwierze.setId(modyfi_id);
        Intent intencja = new Intent();
        intencja.putExtra("wpis", zwierze);
        setResult(RESULT_OK, intencja);
        finish();
    }
}
