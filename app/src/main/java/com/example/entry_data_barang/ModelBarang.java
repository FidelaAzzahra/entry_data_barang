package com.example.entry_data_barang;


public class ModelBarang {
    String kode;
    String nama_barang;
    String satuan;
    String harga;
    String kota;

    public ModelBarang(String kode, String nama_barang, String satuan, String harga, String kota) {
        this.kode = kode;
        this.nama_barang = nama_barang;
        this.satuan = satuan;
        this.harga = harga;
        this.kota = kota;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

}
