package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class AccueilCoActivity extends AppCompatActivity {

    DataBase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueilco);

        myDB = new DataBase( this );
        //myDB.init();

        Button btnEdt = (Button) findViewById(R.id.edt);
        Button btnVdc = (Button) findViewById(R.id.vdc);
        Button btnBudget = (Button) findViewById(R.id.budget);
        Button btnDeconnexion = (Button) findViewById(R.id.deconnexion);


        ArrayList<Actualiter> listActualiter = new ArrayList<>();
        Cursor res = myDB.getDataActualiter();
        while (res.moveToNext()) {
            listActualiter.add(new Actualiter(res.getString(1)));
        }

        Collections.reverse(listActualiter);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CustomListActualiterAdapter(this, listActualiter));

        btnEdt.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), EDTActivity.class);
            startActivity(i);
            finish();
        });
        btnVdc.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), VDCActivity.class);
            startActivity(i);
            finish();
        });
        btnBudget.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), BudgetActivity.class);
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