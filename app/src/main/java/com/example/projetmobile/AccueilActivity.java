package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AccueilActivity extends AppCompatActivity {

    private static final int Request_Code = 0;
    private Button btnConnexion;
    private Button btnContact;
    DataBase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        btnConnexion = (Button) findViewById(R.id.connexion);
        btnContact = (Button) findViewById(R.id.contact);

        myDB = new DataBase( this );
        Cursor test = myDB.getDataActualiter();

        int cpt=0;
        while (test.moveToNext()) {
            cpt++;
        }

        if(cpt == 0){
            myDB.init();
        }

        ArrayList<Actualiter> listActualiter = new ArrayList<>();
        Cursor res = myDB.getDataActualiter();
        while (res.moveToNext()) {
            listActualiter.add(new Actualiter(res.getString(1)));
        }

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CustomListActualiterAdapter(this, listActualiter));

        btnConnexion.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), ConnexionActivity.class);
            startActivity(i);
            finish();
        });

        btnContact.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), ContactActivity.class);
            startActivity(i);
            finish();
        });


    }


}