package com.company;

public class Produk {
    private String namaProduct;
    private String jenisProduct;
    private String jenis;
    private String frekuensi;
    private String iuran;
    private String manfaat;
    private String ketentuan;

    public Produk(String namaProduct, String jenisProduct,String frekuensi, String iuran, String manfaat, String ketentuan) {
        this.namaProduct = namaProduct;
        this.jenisProduct = jenisProduct;
        this.frekuensi = frekuensi;
        this.iuran = iuran;
        this.manfaat = manfaat;
        this.ketentuan = ketentuan;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.namaProduct = namaProduct;
    }

    public String getJenisProduct() {
        return jenisProduct;
    }

    public void setJenisProduct(String jenisProduct) {
        this.jenisProduct = jenisProduct;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getFrekuensi() {
        return frekuensi;
    }

    public void setFrekuensi(String frekuensi) {
        this.frekuensi = frekuensi;
    }

    public String getIuran() {
        return iuran;
    }

    public void setIuran(String iuran) {
        this.iuran = iuran;
    }

    public String getManfaat() {
        return manfaat;
    }

    public void setManfaat(String manfaat) {
        this.manfaat = manfaat;
    }

    public String getKetentuan() {
        return ketentuan;
    }

    public void setKetentuan(String ketentuan) {
        this.ketentuan = ketentuan;
    }
}
