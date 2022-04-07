package com.example.activity6.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class dbController extends SQLiteOpenHelper {
    public dbController(Context context) {
        super(context, "ProdiTI", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Mahasiswa (nim integer primary key, nama text, telepon text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Mahasiswa");
        onCreate(db);
    }

    public void insertData(HashMap<String,String> queryValues){
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama",queryValues.get("nama"));
        nilai.put("telepon",queryValues.get("telepon"));

        basisdata.insert("Mahasiswa",null,nilai);
        basisdata.close();
    }

    public ArrayList<HashMap<String,String>> getAllMahasiswa() {
        ArrayList<HashMap<String,String>> daftarMhs;
        daftarMhs = new ArrayList<HashMap<String,String>>();
        String selectQuery = "Select * From Mahasiswa";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("nim", cursor.getString(0));
                map.put("nama", cursor.getString(1));
                map.put("telepon", cursor.getString(2));
                daftarMhs.add(map);
            }while (cursor.moveToNext());
        }
        db.close();
        return daftarMhs;
    }


}
