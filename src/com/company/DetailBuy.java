package com.company;

public class DetailBuy {
    private String customerID;
    private String namaProduct;
    private String kendaraanID;
    private String tanggalPolis;
    private String noTertanggung;

    public String getNoTertanggung() {
        return noTertanggung;
    }

    public void setNoTertanggung(String noTertanggung) {
        this.noTertanggung = noTertanggung;
    }


    public String getTanggalPolis() {
        return tanggalPolis;
    }

    public void setTanggalPolis(String tanggalPolis) {
        this.tanggalPolis = tanggalPolis;
    }



    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.namaProduct = namaProduct;
    }

    public String getKendaraanID() {
        return kendaraanID;
    }

    public void setKendaraanID(String kendaraanID) {
        this.kendaraanID = kendaraanID;
    }
}
