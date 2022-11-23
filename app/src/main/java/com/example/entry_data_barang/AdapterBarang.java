package com.example.entry_data_barang;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.myViewHolder> {
    Context context;
    ArrayList<ModelBarang> barangArrayList;

    public AdapterBarang(Context context, ArrayList<ModelBarang> barangArrayList) {
        this.context = context;
        this.barangArrayList = barangArrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_tampilan_barang,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.ckode.setText(barangArrayList.get(position).kode);
        holder.cnama.setText(barangArrayList.get(position).nama_barang);
        holder.csatuan.setText(barangArrayList.get(position).satuan);
        holder.charga.setText(barangArrayList.get(position).harga);
        holder.ckota.setText(barangArrayList.get(position).kota);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,UpdateBarang.class);
                intent.putExtra("kodene",barangArrayList.get(position).kode);
                intent.putExtra("namane",barangArrayList.get(position).nama_barang);
                intent.putExtra("satuane",barangArrayList.get(position).satuan);
                intent.putExtra("hargane",barangArrayList.get(position).harga);
                intent.putExtra("kotane",barangArrayList.get(position).kota);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return barangArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView ckode,cnama,csatuan,charga,ckota;
        RelativeLayout relativeLayout;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ckode=itemView.findViewById(R.id.kodebrg);
            cnama=itemView.findViewById(R.id.namabrg);
            csatuan=itemView.findViewById(R.id.satuanbrg);
            charga=itemView.findViewById(R.id.hargabrg);
            ckota=itemView.findViewById(R.id.kotabrg);
            relativeLayout=itemView.findViewById(R.id.rela01);

        }
    }
}
