package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActivityAdminEDT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_e_d_t);

        DataBase myDB = new DataBase( this );

        Button btnadd = (Button) findViewById(R.id.AdminbtnEDTAdd);

        TextView nom = (TextView) findViewById(R.id.TextFieldProfesseur);
        TextView horraire = (TextView) findViewById(R.id.TextFieldHorraire);
        TextView salle = (TextView) findViewById(R.id.TextFieldSalle);
        TextView module = (TextView) findViewById(R.id.TextFieldModule);
        TextView date = (TextView) findViewById(R.id.TextFieldDate);

        btnadd.setOnClickListener(view -> {
            myDB.instertDataCour(module.getText().toString(),salle.getText().toString(),nom.getText().toString(),horraire.getText().toString(),date.getText().toString());
            Intent i = new Intent(getApplicationContext(), ActivityAdminEDT.class);
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