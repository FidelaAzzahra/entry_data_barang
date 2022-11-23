package com.example.entry_data_barang;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Baca_Sqlite extends AppCompatActivity {
    Button btnmasuk;
    RecyclerView recyclerView_barang;
    ArrayList<ModelBarang> barangArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_sqlite);
        btnmasuk=findViewById(R.id.tombolmasuk);
        recyclerView_barang=findViewById(R.id.recyclerviewbrg);
        com.example.entry_data_barang.DatabaseHelper dbh= new com.example.entry_data_barang.DatabaseHelper(this);

        Cursor cursor=dbh.baca_data();

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            barangArrayList.add(new ModelBarang(cursor.getString(0),
                                                cursor.getString(1),
                                                cursor.getString(2),
                                                cursor.getString(3),
                                                cursor.getString(4)));
        }
        AdapterBarang adapterBarang=new AdapterBarang(this,barangArrayList);
        recyclerView_barang.setAdapter(adapterBarang);
        recyclerView_barang.setLayoutManager(new LinearLayoutManager(this));

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Baca_Sqlite.this,Entry_data_barang.class);
                startActivity(intent);
            }
        });
    }
}