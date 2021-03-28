package com.example.projetmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.time.LocalDate;


public class DataBase extends SQLiteOpenHelper {

    //Initialize all the fields needed for database
    public static final String DATABASE_NAME = "Ecole.db";
    public static final String TABLE_NAME1 = "actualiter";
    public static final String TABLE_NAME2 = "cour";
    public static final String TABLE_NAME3 = "vdc";
    public static final String TABLE_NAME4 = "budget";
    public static final String TABLE_NAME5 = "utilisateur";
    public static final String ID = "ID";
    public static final String Etat = "Etat";
    public static final String Date = "Date";
    public static final String Admin = "Admin";
    public static final String COL_2 = "Text";
    public static final String Module = "Module";
    public static final String Salle = "Salle";
    public static final String Professeur_nom = "ProfNom";
    public static final String Identifiant = "Identifiant";
    public static final String Password = "Password";
    public static final String Horraire = "Horraire";
    public static final String Devoir = "Devoir";
    public static final String Info = "Info";
    public static final String Montant = "Montant";
    public static final String Note = "Note";
    public static final String LBR = "(";
    public static final String RBR = ")";
    public static final String COM = ",";

    //Just pass context of the app to make it simpler
    public DataBase(Context context) {
        super( context, DATABASE_NAME, null, 2 );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating table

        //actualiter
        db.execSQL( "create table " + TABLE_NAME1 + LBR + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COM + COL_2 + " TEXT" +RBR );
        /* db.execSQL( "create table actualiter (ID INTEGER PRIMARY KEY AUTOINCREMENT, text TEXT)" );*/

        //cour
        db.execSQL( "create table " + TABLE_NAME2 + LBR + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COM +
                Module + " TEXT" + COM + Salle + " TEXT" + COM + Professeur_nom + " TEXT" + COM + Horraire + " TEXT"+ COM + Date + " TEXT" +RBR );
        /* db.execSQL( "create table cour (ID INTEGER PRIMARY KEY AUTOINCREMENT, Module TEXT, Salle TEXT, ProfNom TEXT, Horraire TEXT, Date TEXT)" );*/

        //vie de class (vdc)
        db.execSQL( "create table " + TABLE_NAME3 + LBR + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COM +
                Devoir + " TEXT" + COM + Note + " TEXT" +RBR );
        /* db.execSQL( "create table vdc (ID INTEGER PRIMARY KEY AUTOINCREMENT, Devoir TEXT, Note TEXT)" );*/

        //budget
        db.execSQL( "create table " + TABLE_NAME4 + LBR + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COM +
                Info + " TEXT" + COM + Montant + " TEXT"+COM+Etat+" TEXT"+RBR );
        /* db.execSQL( "create table budget (ID INTEGER PRIMARY KEY AUTOINCREMENT, Info TEXT, Montant TEXT, Etat TEXT )" );*/

        db.execSQL( "create table " + TABLE_NAME5 + LBR + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COM +
                Identifiant + " TEXT" + COM + Password + " TEXT" +COM+Admin+" TEXT"+RBR );
        /* db.execSQL( "create table utilisateur (ID INTEGER PRIMARY KEY AUTOINCREMENT, Identifiant TEXT, Password TEXT, Admin TEXT)" );*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //Dropping old table
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME5);
        onCreate( db );
    }

    public void init(){
        instertDataActualiter("En ce jour ,1er Mai 2021, Fete du travail, restez chez vous et ne faite rien.");
        instertDataActualiter("Cette semaine venez tous en pyjama pour faire une sieste en classe afin de pouvoir évaluer votre sommeil et votre capacité a pouvoir dormir partout.");
        instertDataActualiter("Vendredi 27 Mai, compétition de beach volley, il ne peut y avoir que 50 inscription donc dépéchez-vous afin de pouvoir gagner un Iphone 10 pour tout les vainqueurs !!");

        instertDataUtilisateur("lucas","123","oui");
        instertDataUtilisateur("quentin","123","non");
        instertDataUtilisateur("maxime","123","non");
        instertDataUtilisateur("vivien","123","non");
        instertDataUtilisateur("yoann","123","non");

        instertDataCour("Mathématique","110","M.HAMZAOUI","8h00-9h30","2021:03:24");
        instertDataCour("Francais","101","M.JECPAS","11h00-12h30","2021:03:24");
        instertDataCour("géographie","110","M.JESAISPA","8h00-9h30","2021:03:25");
        instertDataCour("sport","105","M.JEUCESTPA","11h00-12h30","2021:03:25");
        instertDataCour("anglais","107","M.JECAIPAS","8h00-9h30","2021:03:26");

        instertDataVdc("Anglais : Apprendre le vocabulaire page 140","Anglais : 12/20");
        instertDataVdc("Mathématique : Rendre le devoire maison pour le 30/04","Mathématique : 18/20");
        instertDataVdc("Géographie : Apprendre la totalité des pays pour le 30/04","Géographie : 18/20");

        instertDataBudget("Cantine mars","175€","en attente");
        instertDataBudget("Sortie scolaire","50€","payée");
        instertDataBudget("Cantine février","175€","en attente");
        instertDataBudget("Abonnement bus annuel","335.99€","payée");
    }

    //Insert data in database
    public void instertDataActualiter(String info){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COL_2, info );
        db.insert( TABLE_NAME1, null, contentValues );
    }
    //Insert data in database
    public void instertDataCour(String module,String salle,String profnom, String horraire, String date){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( Module, module);
        contentValues.put( Salle, salle);
        contentValues.put( Professeur_nom, profnom);
        contentValues.put( Horraire, horraire);
        contentValues.put( Date, date);
        db.insert( TABLE_NAME2, null, contentValues );
    }
    public void instertDataVdc(String devoir, String note){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( Devoir, devoir );
        contentValues.put( Note, note );
        db.insert( TABLE_NAME3, null, contentValues );
    }
    public void instertDataBudget(String info, String montant, String etat){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( Info, info );
        contentValues.put( Montant, montant );
        contentValues.put( Etat, etat);
        db.insert( TABLE_NAME4, null, contentValues );
    }
    public void instertDataUtilisateur(String identifiant, String password, String admin){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( Identifiant, identifiant );
        contentValues.put( Password, password );
        contentValues.put( Admin, admin );
        db.insert( TABLE_NAME5, null, contentValues );
    }



    public Cursor getDataActualiter(){
        //Get the data from database
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery( "select * from " + TABLE_NAME1, null );
    }
    public Cursor getDataCour(){
        //Get the data from database
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery( "select * from " + TABLE_NAME2, null );
    }
    public Cursor getDataVDC(){
        //Get the data from database
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery( "select * from " + TABLE_NAME3, null );
    }
    public Cursor getDataBudget(){
        //Get the data from database
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery( "select * from " + TABLE_NAME4, null );
    }
    public Cursor getDataUtilisateur(){
        //Get the data from database
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery( "select * from " + TABLE_NAME5, null );
    }
}