package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class addTransaction extends AppCompatActivity {

    private EditText name, type, mont;
    String nom, typeTrans, montTrans;
    private Button val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        this.name = findViewById(R.id.name_champs);
        this.type = findViewById(R.id.type_champs);
        this.mont = findViewById(R.id.mont_champs);

        this.val = findViewById(R.id.button2);

        val.setOnClickListener(v -> {
            if (TextUtils.isEmpty(name.getText())) {
                name.setError("Un nom est requis !");
            } else if (TextUtils.isEmpty(type.getText())) {
                type.setError("Un type est requis !");
            }
            else if (TextUtils.isEmpty(mont.getText())) {
                mont.setError("Un montant est requis !");
            } else {
                nom = name.getText().toString();
                typeTrans = type.getText().toString();
                montTrans = mont.getText().toString();
                Intent retour = new Intent(getApplicationContext(), transac.class);
                retour.putExtra("name", nom);
                retour.putExtra("type", typeTrans);
                retour.putExtra("mont", montTrans);
                startActivity(retour);
                finish();
            }
        });
    }
}