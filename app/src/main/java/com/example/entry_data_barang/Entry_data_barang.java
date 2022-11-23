package com.example.entry_data_barang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Entry_data_barang extends AppCompatActivity {
    EditText ckode,cnama,csatuan,charga, ckota;
    Button btnsave,btnview;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_barang);

        ckode=findViewById(R.id.xkodebrg);
        cnama=findViewById(R.id.xnamabrg);
        csatuan=findViewById(R.id.xsatuan);
        charga=findViewById(R.id.xharga);
        ckota=findViewById(R.id.xkota);

        btnsave=findViewById(R.id.btnsave);
        dbh=new DatabaseHelper(this);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xkode=ckode.getText().toString();
                String xnama=cnama.getText().toString();
                String xsatuan=csatuan.getText().toString();
                String xharga=charga.getText().toString();
                String xkota=ckota.getText().toString();

               boolean hasil= dbh.input_data(xkode,xnama,xsatuan,xharga,xkota);
               if (hasil)
               {
                   Toast.makeText(Entry_data_barang.this, "Data Tersimpan",
                           Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}