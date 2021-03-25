package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EDTActivity extends AppCompatActivity {
    private LocalDate currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.currentDate = java.time.LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        currentDate = LocalDate.now();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_d_t);

        ArrayList<Cour> listCour = new ArrayList<>();

        DataBase myDB = new DataBase( this );

        Cursor res = myDB.getDataCour();
        while (res.moveToNext()) {
            String[] date = res.getString(5).split(":");
            listCour.add(new Cour(res.getString(3),res.getString(1),res.getString(2),res.getString(4),LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]))));
        }

        Button Buttondate = (Button) findViewById(R.id.Button_Date);
        Button Buttonapres = (Button) findViewById(R.id.Button_left);
        Button Buttonavant = (Button) findViewById(R.id.Button_right);

        Buttondate.setText(dtf.format(currentDate));
        setListView(listCour);
        Buttonavant.setOnClickListener(view -> {
            this.currentDate = currentDate.plusDays(1);
            Buttondate.setText(dtf.format(currentDate));
            setListView(listCour);
        });
        Buttonapres.setOnClickListener(view -> {
            this.currentDate = currentDate.minusDays(1);
            Buttondate.setText(dtf.format(currentDate));
            setListView(listCour);
        });

        Button btnBudget = (Button) findViewById(R.id.budget);
        Button btnAccueil = (Button) findViewById(R.id.accueil);
        Button btnVdc = (Button) findViewById(R.id.vdc);
        Button btnDeconnexion = (Button) findViewById(R.id.deconnexion);


        btnBudget.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), BudgetActivity.class);
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

    private void setListView(ArrayList<Cour> listCour){
        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayList<Cour> listofDay = new ArrayList<>();
        for(Cour c : listCour){
            if(c.getDate().equals(currentDate)){
                listofDay.add(c);
            }
        }
        listView.setAdapter(new CustomListEDTAdapter(this, listofDay));
    }
}