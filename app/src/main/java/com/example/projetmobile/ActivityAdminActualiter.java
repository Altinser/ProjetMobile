package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityAdminActualiter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_actualiter);

        DataBase myDB = new DataBase( this );

        Button btnadd = (Button) findViewById(R.id.AdminbtnAdd);

        TextView actu = (TextView) findViewById(R.id.AdminTextFieldActualiter);

        ArrayList<Actualiter> listActualiter = new ArrayList<>();
        Cursor res = myDB.getDataActualiter();
        while (res.moveToNext()) {
            listActualiter.add(new Actualiter(res.getString(1)));
        }

        ListView listView = (ListView) findViewById(R.id.listviewAdmin);
        listView.setAdapter(new CustomListActualiterAdapter(this, listActualiter));

        btnadd.setOnClickListener(view -> {
            myDB.instertDataActualiter(actu.getText().toString());
            Intent i = new Intent(getApplicationContext(), ActivityAdminActualiter.class);
            startActivity(i);
            finish();
        });

        Button btnDeconexion = (Button) findViewById(R.id.AdminDeconnexion);
        Button btnEDT = (Button) findViewById(R.id.AdminEDT);
        Button btnActualiter = (Button) findViewById(R.id.AdminActualiter);

        btnDeconexion.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AccueilActivity.class);
            startActivity(i);
            finish();
        });
        btnEDT.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), ActivityAdminEDT.class);
            startActivity(i);
            finish();
        });
        btnActualiter.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), ActivityAdminActualiter.class);
            startActivity(i);
            finish();
        });

    }
}