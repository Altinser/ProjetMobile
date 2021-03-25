package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class VDCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_d_c);

        Button btnEdt = (Button) findViewById(R.id.edt);
        Button btnAccueil = (Button) findViewById(R.id.accueil);
        Button btnBudget = (Button) findViewById(R.id.budget);
        Button btnDeconnexion = (Button) findViewById(R.id.deconnexion);

        ListView listView = (ListView) findViewById(R.id.listview);
        ListView listView2 = (ListView) findViewById(R.id.listview2);


        DataBase myDB = new DataBase( this );
        Cursor res = myDB.getDataVDC();



        ArrayList<Devoir> listDevoir = new ArrayList<>();
        ArrayList<Note> listNote = new ArrayList<>();
        while (res.moveToNext()) {
            listDevoir.add(new Devoir(res.getString(1)));
            listNote.add(new Note(res.getString(2)));
        }

        listView.setAdapter(new CustomListDevoirAdapter(this, listDevoir));
        listView2.setAdapter(new CustomListNoteAdapter(this, listNote));



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