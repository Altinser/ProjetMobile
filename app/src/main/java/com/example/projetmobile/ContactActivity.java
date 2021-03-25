package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button btnConnexion = (Button) findViewById(R.id.connexion);
        Button btnRetour = (Button) findViewById(R.id.retour);

        btnConnexion.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), ConnexionActivity.class);
            startActivity(i);
            finish();
        });

        btnRetour.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AccueilActivity.class);
            startActivity(i);
            finish();
        });

    }
}