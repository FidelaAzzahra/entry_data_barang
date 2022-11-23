package com.example.entry_data_barang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateBarang extends AppCompatActivity implements View.OnClickListener {
    Button tombolupdate, tomboldelete, tombolview;
    EditText ekode, enama, esatuan, eharga, ekota;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_barang);
        ekode = findViewById(R.id.xkodebrg);
        enama = findViewById(R.id.xnamabrg);
        esatuan = findViewById(R.id.xsatuan);
        eharga = findViewById(R.id.xharga);
        ekota = findViewById(R.id.xkota);

        tombolupdate = findViewById(R.id.btnupdate);
        tomboldelete = findViewById(R.id.btndelete);
        tombolview = findViewById(R.id.btnview);

        tombolupdate.setOnClickListener(this);
        tomboldelete.setOnClickListener(this);
        tombolview.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        ekode.setText(bundle.getString("kodene"));
        enama.setText(bundle.getString("namane"));
        esatuan.setText(bundle.getString("satuane"));
        eharga.setText(bundle.getString("hargane"));
        ekota.setText(bundle.getString("kotane"));

        dbh = new DatabaseHelper(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnupdate)
        {
            //update
            String xkode=ekode.getText().toString();
            String xnama=enama.getText().toString();
            String xsatuan=esatuan.getText().toString();
            String xharga=eharga.getText().toString();
            String xkota=ekota.getText().toString();

            boolean oke= dbh.update_data(xkode, xnama, xsatuan, xharga, xkota);
            if(oke)
            {
                Toast.makeText(UpdateBarang.this,"Update data berhasil", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(UpdateBarang.this,Baca_Sqlite.class);
                startActivity(intent);
            } else {
                Toast.makeText(UpdateBarang.this, "Update data gagal", Toast.LENGTH_LONG).show();
            }
            Intent intent=new Intent(UpdateBarang.this, Baca_Sqlite.class);
            startActivity(intent);

            //delete
        } else if (view.getId() == R.id.btndelete) {
            String xkode=ekode.getText().toString();
            dbh.hapus_databarang(xkode);
            Intent intent=new Intent(UpdateBarang.this, Baca_Sqlite.class);
            startActivity(intent);

        } else {
            Intent intent=new Intent(UpdateBarang.this, Baca_Sqlite.class);
            startActivity(intent);
        }

    }
}