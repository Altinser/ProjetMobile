package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class BudgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        Button btnEdt = (Button) findViewById(R.id.edt);
        Button btnAccueil = (Button) findViewById(R.id.accueil);
        Button btnVdc = (Button) findViewById(R.id.vdc);
        Button btnDeconnexion = (Button) findViewById(R.id.deconnexion);



        btnEdt.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), EDTActivity.class);
            startActivity(i);
            finish();
        });
        btnAccueil.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AccueilCoActivity.class);
            startActivity(i);
            finish();
        });
        btnVdc.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), VDCActivity.class);
            startActivity(i);
            finish();
        });
        btnDeconnexion.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AccueilActivity.class);
            startActivity(i);
            finish();
        });

    }
}