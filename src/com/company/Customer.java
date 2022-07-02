package com.company;

public class Customer {
    private Prospek dataProspect;
    private String idCustomer;
    private String nikKtp;
    private String statusKK;
    private String method;

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }


    public Prospek getDataProspect() {
        return dataProspect;
    }

    public void setDataProspect(Prospek dataProspect) {
        this.dataProspect = dataProspect;
    }

    public String getNikKtp() {
        return nikKtp;
    }

    public void setNikKtp(String nikKtp) {
        this.nikKtp = nikKtp;
    }

    public String getStatusKK() {
        return statusKK;
    }

    public void setStatusKK(String statusKK) {
        this.statusKK = statusKK;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
