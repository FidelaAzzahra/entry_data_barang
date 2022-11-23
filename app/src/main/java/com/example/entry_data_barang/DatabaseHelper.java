package com.example.entry_data_barang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String NAMA_DATABASE="STOK_BARANG";
    public final static String NAMA_TABEL="barang";
    public final static String field01="kode";
    public final static String field02="nama_brg";
    public final static String field03="satuan";
    public final static String field04="harga";
    public final static String field05="kota";

    public DatabaseHelper(Context context) {
        super(context, NAMA_DATABASE,null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+NAMA_TABEL+"(kode primary key,nama_brg text,satuan text,harga text, kota text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+NAMA_TABEL);
        onCreate(db);
    }

    public boolean input_data(String xkode, String xnama, String xsatuan, String xharga, String xkota) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field01,xkode);
        contentValues.put(field02,xnama);
        contentValues.put(field03,xsatuan);
        contentValues.put(field04,xharga);
        contentValues.put(field05,xkota);

        db.insert(NAMA_TABEL,null,contentValues);
        return true;
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from " +NAMA_TABEL,null);
        return cur;
    }

    public boolean update_data(String xkode, String xnama, String xsatuan, String xharga, String xkota) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field01,xkode);
        contentValues.put(field02,xnama);
        contentValues.put(field03,xsatuan);
        contentValues.put(field04,xharga);
        contentValues.put(field05,xkota);

        long jadi = db.update(NAMA_TABEL, contentValues, "kode=?",new String[] {xkode});
        if(jadi>0) {
            return true;
        } else
        {
            return false;
        }

    }

    public void hapus_databarang(String xkode) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(NAMA_TABEL, "kode=?",new String[]{xkode});
    }
}
