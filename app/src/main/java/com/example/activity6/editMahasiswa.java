package com.example.activity6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.activity6.database.dbController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class editMahasiswa extends AppCompatActivity {
    TextInputEditText Nama, Telepon;
    Button Save;
    String nm, tlp, nim;
    dbController controller = new dbController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);

        Nama = findViewById(R.id.edNama);
        Telepon = findViewById(R.id.edTelp);
        Save = findViewById(R.id.simpanBtn);

        nim = getIntent().getStringExtra("nim");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telpon");

        setTitle("Edit Data");
        Nama.setText(nm);
        Telepon.setText(tlp);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (Nama.getText().toString().equals("") || Telepon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon isi data terlebih dahulu.", Toast.LENGTH_LONG).show();
                }else {
                    nm = Nama.getText().toString();
                    tlp = Telepon.getText().toString();
                    HashMap<String, String> values = new HashMap<>();
                    values.put("nim", nim);
                    values.put("nama", nm);
                    values.put("telepon", tlp);
                    controller.UpdateData(values);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(editMahasiswa.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}