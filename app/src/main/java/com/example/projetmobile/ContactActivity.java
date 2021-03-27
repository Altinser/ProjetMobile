package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button btnConnexion = (Button) findViewById(R.id.connexion);
        Button btnRetour = (Button) findViewById(R.id.retour);
        Button btnMap = (Button) findViewById(R.id.map);

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

        btnMap.setOnClickListener(View -> {
            String map = "http://maps.google.com/maps?daddr=50.2770376,3.9757033";
            Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(map));
            startActivity(i);
            finish();
        });

    }
}