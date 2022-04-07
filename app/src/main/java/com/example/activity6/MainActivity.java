package com.example.activity6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.activity6.adapter.mhsAdapter;
import com.example.activity6.database.Mahasiswa;
import com.example.activity6.database.dbController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private mhsAdapter adapter;
    private ArrayList<Mahasiswa> mhsArrayList;
    dbController controller = new dbController(this);
    String nim, nm, tlp;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingButton);
        bacaData();
        adapter = new mhsAdapter(mhsArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mahasiswa2.class);
                startActivity(intent);
            }
        });
    }

    public void bacaData(){
        ArrayList<HashMap<String,String>> daftarMhs = controller.getAllMahasiswa();
        mhsArrayList = new ArrayList<>();

        //memindah dari hasil query kedalam Mahasiswa
        for(int i=0;i<daftarMhs.size();i++){
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(daftarMhs.get(i).get("nim").toString());
            mhs.setNama(daftarMhs.get(i).get("nama").toString());
            mhs.setTelepon(daftarMhs.get(i).get("telepon").toString());

            //pindahkan query Mahasiswa kedalam ArrayList mhs di adapter
            mhsArrayList.add(mhs);
        }
    }
}