package com.example.projetmobile;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BudgetActivity extends AppCompatActivity {

    private Button pay;
    List<Transaction> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        Intent intent = getIntent();

        String nom = intent.getStringExtra("name");
        String typeTrans = intent.getStringExtra("type");
        String montTrans = intent.getStringExtra("mont");


        DataBase myDB = new DataBase( this );

        Cursor res = myDB.getDataBudget();
        while (res.moveToNext()) {
            list.add(new Transaction(res.getString(1),res.getString(3),res.getString(2)));
        }


        final ListView listView = findViewById(R.id.myLV);
        listView.setAdapter(new CustomListBudgetAdapter(this, list));
        this.pay = findViewById(R.id.butPay);

        Button add = findViewById(R.id.btnadd);
        add.setOnClickListener(popupView -> {
            Intent addTransac = new Intent(getApplicationContext(), ActivityAddTransaction.class);
            startActivity(addTransac);
            finish();
        });

        listView.setOnItemClickListener((a, v, position, id) -> {
            LayoutInflater inflater = (LayoutInflater) BudgetActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popupactivity, null, false);
            final PopupWindow pw = new PopupWindow(popupView,1000,600, true);
            pw.showAtLocation(this.findViewById(R.id.myLV), Gravity.CENTER, 0, 0);
            Button close = popupView.findViewById(R.id.butPay);
            close.setOnClickListener(popupView1 -> {
                pw.dismiss();
                //TextView textView = findViewById(R.id.type_transac);
                //textView.setText("payée");
            });
        });

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