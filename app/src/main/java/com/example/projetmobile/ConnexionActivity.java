package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        Button btnRetour = (Button) findViewById(R.id.back);
        Button btnValider = (Button) findViewById(R.id.valider);

        TextView identifiant = (TextView) findViewById(R.id.identifiant);
        TextView mdp = (TextView) findViewById(R.id.mdp);


        DataBase myDB = new DataBase(this);
        Cursor res = myDB.getDataUtilisateur();
        ArrayList<Utilisateur> listUtilisateur = new ArrayList<>();
        while (res.moveToNext()) {
            listUtilisateur.add(new Utilisateur(res.getString(1),res.getString(2),res.getString(3)));
        }

        btnRetour.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AccueilActivity.class);
            startActivity(i);
            finish();
        });

        btnValider.setOnClickListener(view -> {
            for(Utilisateur u: listUtilisateur){
                if(u.getNom().equals(identifiant.getText().toString()) && u.getMdp().equals(mdp.getText().toString())){
                    if(u.getAdmin().equals("oui")){
                        Intent i = new Intent(getApplicationContext(), ActivityAdminActualiter.class);
                        startActivity(i);
                        finish();
                    }else{
                        Intent i = new Intent(getApplicationContext(), AccueilCoActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });
    }
}