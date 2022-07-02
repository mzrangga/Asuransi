package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static ArrayList<Kendaraan> dataKendaraan = new ArrayList<Kendaraan>();
    static ArrayList<Prospek> dataPros = new ArrayList<Prospek>();
    static ArrayList<Customer> dataCustomer = new ArrayList<Customer>();
    static ArrayList<Produk> dataProduct = new ArrayList<Produk>();
    static ArrayList<DetailBuy> dataDetail = new ArrayList<DetailBuy>();
    static Scanner sc = new Scanner(System.in);

    static Prospek dP = new Prospek();
    static Customer dC = new Customer();
    static int idProspect = 1;
    static String nProduct = "";
    static String idCusBaru = "";
    public static void main(String[] args) {
        //add product
        addProduct();
        //run menu
        mainMenu();
    }

    static void addProduct(){
        Produk product1 = new Produk("Sehat Bersama","Kesehatan","Bulanan","Untuk yang umur di","Claim perawatan kelas 1. ","Bisa menanggung keluarga atau diri sendiri dari data nasabah.");
        Produk product2 = new Produk("Sehat Extra","Kesehatan","Bulanan","Untuk yang umur di","Claim perawatan kelas VIP.","Hanya bisa");
        Produk product3 = new Produk("Life Keluarga","Jiwa","Bulanan","Untuk yang umur di","Mendapatkan 500.000.000","Bisa menanggung");
        Produk product4 = new Produk("Life Special","Jiwa","Tahunan","Untuk yang umur di","Mendapatkan 800.000.000","Hanya bisa");
        Produk product5 = new Produk("Protection","Kendaraan","Tahunan","Untuk yang umur di","Mendapat ganti rugi sampai","Hanya bisa");
        Produk product6 = new Produk("Protection Plus","Kendaraan","Tahunan","Untuk yang umur di","Mendapat ganti rugi sampai","Hanya bisa");

        dataProduct.add(product1);
        dataProduct.add(product2);
        dataProduct.add(product3);
        dataProduct.add(product4);
        dataProduct.add(product5);
        dataProduct.add(product6);
    }

    static void mainMenu(){
        //show choice menu
        int pilih;
        System.out.println("------------------------------------");
        System.out.println("Pilih Salah Satu Menu di bawah ini :");
        System.out.println("1.  Menu Prospect");
        System.out.println("2.  Menu Customer");
        System.out.println("3.  Exit Application");
        System.out.print("Jawab : ");
        pilih = sc.nextInt();
        switch(pilih) {
            case 1 :
                menuProspect();
                break;
            case 2 :
                menuCustomer();
                break;
            default :
                exitApplication();
                break;
        }
    }

    // menu prospek
    static void menuProspect(){
        showProspect();
        int pilih;
        System.out.println("------------------------------------");
        System.out.println("Pilih Salah Satu Menu di bawah ini :");
        System.out.println("1.  Add Prospect");
        System.out.println("2.  Prospect to Customer");
        System.out.println("3.  Main Menu");
        System.out.println("4.  Exit Application");
        System.out.print("Jawab : ");
        pilih = sc.nextInt();
        switch(pilih) {
            case 1 :
                addProspect();
                break;
            case 2 :
                prospectToCustomer();
                break;
            case 3 :
                mainMenu();
                break;
            default :
                exitApplication();
                break;
        }
    }

    static void showProspect(){
        if (dataPros.size() > 0){
            for (Prospek dP : dataPros){
                System.out.println("No :" + dP.getId() + ", "+ dP.getNamaDepan()+" "+ dP.getNamaBelakang()+", "
                        +(dP.getJenisKelamin().equals("P") ? "Perempuan": "Laki-Laki")+", "
                        +dP.getTanggalLahir()+"("+dP.getTempatLahir()+"), "+dP.getPekerjaan()+", "+dP.getStatus());
            }
        }
    }

    static void addProspect(){
        dP = new Prospek();
        String namaBelakang, namaDepan, tanggalLahir, tempatLahir, jenisKelamin, pekerjaan;
        //show input data
        System.out.println("-----------------------------------");
        System.out.println("Masukan data prospek satu persatu :");
        System.out.print("Nama Depan : ");
        namaDepan = sc.next();
        System.out.print("Nama Belakang : ");
        namaBelakang = sc.next();

        System.out.print("Tanggal Lahir (dd/mm/yyyy) : ");
        tanggalLahir = sc.next();

        System.out.print("Tempat Lahir : ");
        tempatLahir = sc.next();

        System.out.print("Jenis Kelamin (P/L) : ");
        jenisKelamin = sc.next();

        System.out.print("Pekerjaan : ");
        pekerjaan = sc.next();

        System.out.println();
        System.out.println("... Menambahkan Prospect Baru");
        //import class
        //add field to class
        dP.setId(idProspect);
        dP.setNamaDepan(namaDepan);
        dP.setNamaBelakang(namaBelakang);
        dP.setTanggalLahir(tanggalLahir);
        dP.setTempatLahir(tempatLahir);
        dP.setJenisKelamin(jenisKelamin);
        dP.setPekerjaan(pekerjaan);
        dP.setStatus("Prospect");
        //add to arrayList with object
        dataPros.add(dP);
        idProspect += 1;
        //back to menu
        menuProspect();
        System.out.println(idProspect);
    }

    static void prospectToCustomer(){
        System.out.print("Ketik nomor prospect yang ingin dijadikan nasabah : ");
        int idprospectVal = sc.nextInt();
        int cari = -1, i=0;
        Iterator ltr = dataPros.iterator();
        while(ltr.hasNext()){
            Prospek prospect = (Prospek) ltr.next();
            if(prospect.getId() == idprospectVal){
                dP = new Prospek();
                dP.setId(idprospectVal);
                dP.setNamaDepan(prospect.getNamaDepan());
                dP.setNamaBelakang(prospect.getNamaBelakang());
                dP.setTanggalLahir(prospect.getTanggalLahir());
                dP.setTempatLahir(prospect.getTempatLahir());
                dP.setJenisKelamin(prospect.getJenisKelamin());
                dP.setPekerjaan(prospect.getPekerjaan());
                dP.setStatus("Nasabah");
                dataPros.remove(i);
                inputToCustomer();
                cari=i;
                break;
            }
            i++;
        }
    }

    static void inputToCustomer(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.print("Nomor KTP : ");
        String ktp = sc.next();
        System.out.print("Status KK : ");
        String status = sc.next();
        System.out.print("Payment Method(CC/AC/VP) : ");
        String method = sc.next();
        dC = new Customer();
        dC.setIdCustomer(formattedDate+"/"+dP.getId());
        dC.setDataProspect(dP);
        dC.setNikKtp(ktp);
        dC.setStatusKK(status);
        dC.setMethod(method);
        dataPros.add(dP);
        dataCustomer.add(dC);
        menuProspect();
    }

    static void showCustomer(){

        if (dataCustomer.size() > 0){
            for (Customer dC : dataCustomer){
                System.out.println("No :" + dC.getIdCustomer()+ ", "
                        + dC.getDataProspect().getNamaDepan()+" "
                        + dC.getDataProspect().getNamaBelakang()+", "
                        +(dC.getDataProspect().getJenisKelamin().equals("P") ? "Perempuan": "Laki-Laki")+", "
                        +dC.getDataProspect().getTanggalLahir()+"("+dC.getDataProspect().getTempatLahir()+"), "
                        +dC.getDataProspect().getPekerjaan());
                System.out.println("KTP :"+ dC.getNikKtp()+",Status di KK : "+dC.getStatusKK()+", Payment Method : "+dC.getMethod());
                System.out.println("============================================================================");
            }
        }
    }

    static void showProduct(){
        if(dataProduct.size() > 0){
            System.out.println("||-------------------------------||");
            for(Produk dp : dataProduct){
                System.out.println("|| Nama Product => " + dp.getNamaProduct());
            }
            System.out.println("||-------------------------------||");
        }
    }
    static void menuCustomer(){
        showCustomer();
        int pilih;
        System.out.println("-------------------------------");
        System.out.println("Pilih Menu yang ingin dipilih :");
        System.out.println("1.  Buy Product");
        System.out.println("2.  Detail policy");
        System.out.println("3.  Main Menu");
        System.out.println("4.  Exit Application");
        System.out.print("Jawab : ");
        pilih = sc.nextInt();
        switch(pilih) {
            case 1 :
                buyProduct();
                break;
            case 2 :
                detailPolicy();
                break;
            case 3 :
                mainMenu();
                break;
            default :
                exitApplication();
                break;
        }
    }

    static void buyProduct(){
        System.out.print("Pilih Nomor Customer : ");
        String idCus = sc.next();
        idCusBaru = idCus;
        int cari = -1, i=0;
        Iterator ltr = dataCustomer.iterator();
        while(ltr.hasNext()){
            Customer cus = (Customer) ltr.next();
            if(cus.getIdCustomer().equals(idCus)){
                inputToProduct();
                cari=i;
                break;
            }
            i++;
        }
    }

    static void inputToProduct(){
        showProduct();
        sc = new Scanner(System.in);
        System.out.print("Pilih Nama Product : ");
        nProduct =sc.nextLine();
        //cek nama product
        if(nProduct.equalsIgnoreCase("Protection") || nProduct.equalsIgnoreCase("Protection Plus")){
            inputKendaraan();
        }else if(nProduct.equalsIgnoreCase("Sehat Bersama") || nProduct.equalsIgnoreCase("Sehat Extra ")){
            inputKesehatanJiwa();
        }else {
            inputKesehatanJiwa();
        }
        menuCustomer();
    }

    static void inputKesehatanJiwa(){
        System.out.print("Pilih Nomor Customer Tertanggung : ");
        String noTertanggung = sc.next();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        //add to detail
        DetailBuy db = new DetailBuy();
        db.setCustomerID(idCusBaru);
        db.setNamaProduct(nProduct);
        db.setTanggalPolis(formattedDate);
        db.setNoTertanggung(noTertanggung);
        dataDetail.add(db);
    }
    static void inputKendaraan(){
        //show input
        UUID uuid = UUID.randomUUID();
        System.out.println("Input data kendaraan");
        System.out.print("Jenis Kendaraan : ");
        String jenisK = sc.next();
        System.out.print("Nomor Polisi : ");
        String nomorPK = sc.next();
        System.out.print("Nomor STNK : ");
        String nomorSTNK = sc.next();
        System.out.print("Merek Kendaraan : ");
        String merekK = sc.next();
        System.out.print("Model Kendaraan : ");
        String modelK = sc.next();
        System.out.print("Warna Kendaraan : ");
        String warnaK = sc.next();

        //set to kendaraan
        Kendaraan dk = new Kendaraan();
        dk.setKendaraanID(uuid.toString());
        dk.setJenisKendaraan(jenisK);
        dk.setMerekKendaraan(merekK);
        dk.setModelKendaraan(modelK);
        dk.setNomorPolisi(nomorPK);
        dk.setNomorSTNK(nomorSTNK);
        dk.setWarnaKendaraan(warnaK);

        //add to array kendaraan.
        dataKendaraan.add(dk);

        //import date
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        //add to detail
        DetailBuy db = new DetailBuy();
        db.setCustomerID(idCusBaru);
        db.setKendaraanID(uuid.toString());
        db.setNamaProduct(nProduct);
        db.setTanggalPolis(formattedDate);
        dataDetail.add(db);

    }
    static void detailPolicy(){
        for(DetailBuy dd : dataDetail){
            System.out.println("Detail => "+ dd.getCustomerID());
        }
        sc = new Scanner(System.in);
        System.out.print("Pilih Nomor Customer : ");
        String noCus =sc.nextLine();
        if (dataDetail.size() > 0) {
            for(DetailBuy dd : dataDetail){
                System.out.println(dd.getCustomerID().equalsIgnoreCase(noCus));
                System.out.println("dd = " +dd.getCustomerID());
                System.out.println("nocus" +noCus);
                if(dd.getCustomerID().equalsIgnoreCase(noCus)){
                    //for customer info
                    System.out.println("===============================Customer Info==============================");
                    if (dataCustomer.size() > 0){
                        for (Customer dC : dataCustomer){
                            if (dC.getIdCustomer().equalsIgnoreCase(noCus)){
                                System.out.println("No :" + dC.getIdCustomer()+ ", "
                                        + dC.getDataProspect().getNamaDepan()+" "
                                        + dC.getDataProspect().getNamaBelakang()+", "
                                        +(dC.getDataProspect().getJenisKelamin().equals("P") ? "Perempuan": "Laki-Laki")+", "
                                        +dC.getDataProspect().getTanggalLahir()+"("+dC.getDataProspect().getTempatLahir()+"), "
                                        +dC.getDataProspect().getPekerjaan());
                                System.out.println("KTP :"+ dC.getNikKtp()+",Status di KK : "+dC.getStatusKK()+", Payment Method : "+dC.getMethod());
                                System.out.println("============================================================================");
                            }
                        }
                    }
                    System.out.println("=================================Policy Info================================");
                    //product
                    if(dd.getNamaProduct().equalsIgnoreCase("Protection") || dd.getNamaProduct().equalsIgnoreCase("Protection Plus")){
                        System.out.println("Product : " + dd.getNamaProduct());
                        System.out.println("Tanggal Mulai Dijalankan : " + dd.getTanggalPolis());
                        //kendaraan
                        if (dataKendaraan.size()>0){
                            for(Kendaraan dk : dataKendaraan){
                                if (dk.getKendaraanID().equalsIgnoreCase(dd.getKendaraanID())){
                                    System.out.println("Jenis Kendaraan : " + dk.getJenisKendaraan());
                                    System.out.println("Nomor Polisi : " + dk.getNomorPolisi());
                                    System.out.println("Nomor STNK : " + dk.getNomorSTNK());
                                    System.out.println("Merek Kendaraan : " + dk.getMerekKendaraan());
                                    System.out.println("Model Kendaraan : " + dk.getModelKendaraan());
                                    System.out.println("Warna Kendaraan : " + dk.getWarnaKendaraan());
                                    System.out.println("============================================================================");
                                }
                            }
                        }
                    }else{
                        if (dataCustomer.size() > 0){
                            for (Customer dC : dataCustomer){
                                if (dC.getIdCustomer().equalsIgnoreCase(dd.getNoTertanggung())){
                                    System.out.println("Tertanggung : " + dC.getDataProspect().getNamaDepan()+" "+dC.getDataProspect().getNamaBelakang());
                                }
                            }
                        }
                        System.out.println("Product : " + dd.getNamaProduct());
                        System.out.println("Tanggal Mulai Dijalankan : " + dd.getTanggalPolis());
                        if (dataProduct.size() > 0){
                            for(Produk dPP : dataProduct){
                                if(dPP.getNamaProduct().equalsIgnoreCase(nProduct)){
                                    System.out.println("Manfaat : " + dPP.getManfaat());
                                }
                            }
                        }
                    }

                }
                //payment
                System.out.println("====================================Payment==================================");
                if (dd.getNamaProduct().equalsIgnoreCase("Protection") || dd.getNamaProduct().equalsIgnoreCase("Protection Plus")){
                    String masterTanggal = dd.getTanggalPolis();
                    int tahun=Integer.parseInt(masterTanggal.substring(6,10));
                    int bulan=Integer.parseInt(masterTanggal.substring(3,5));
                    int tahun1 = tahun + 1;
                    String sTahun = Integer.toString(tahun1);
                    int tahun2 = tahun + 2;
                    String sTahun1 = Integer.toString(tahun2);
                    if (dd.getNamaProduct().equalsIgnoreCase("Protection")){
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+tahun +", Rp2.000.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+sTahun +", Rp2.000.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+sTahun1 +", Rp2.000.000,00");
                    }else{
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+tahun +", Rp2.500.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+sTahun +", Rp2.500.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+sTahun1 +", Rp2.500.000,00");
                    }
                }else{
                    String masterTanggal = dd.getTanggalPolis();
                    int bulan=Integer.parseInt(masterTanggal.substring(3,5));
                    int bulan1 = bulan + 1;
                    String sBulan = Integer.toString(bulan1);
                    int bulan2 = bulan + 2;
                    String sBulan1 = Integer.toString(bulan2);
                    int tahun=Integer.parseInt(masterTanggal.substring(6,10));
                    int tahun1 = tahun + 1;
                    String sTahun = Integer.toString(tahun1);
                    int tahun2 = tahun + 2;
                    String sTahun1 = Integer.toString(tahun2);
                    if(dd.getNamaProduct().equalsIgnoreCase("Sehat Bersama")){
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+tahun +", Rp.400.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(Integer.parseInt(sBulan))+"-"+tahun +", Rp.400.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(Integer.parseInt(sBulan1))+"-"+tahun +", Rp.400.000,00");
                    }else if(dd.getNamaProduct().equalsIgnoreCase("Sehat Extra")){
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+tahun +", Rp.500.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(Integer.parseInt(sBulan))+"-"+tahun +", Rp.500.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(Integer.parseInt(sBulan1))+"-"+tahun +", Rp.500.000,00");
                    }else if(dd.getNamaProduct().equalsIgnoreCase("Life Keluarga")){
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+tahun +", Rp.450.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(Integer.parseInt(sBulan))+"-"+tahun +", Rp.450.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(Integer.parseInt(sBulan1))+"-"+tahun +", Rp.450.000,00");
                    }else if(dd.getNamaProduct().equalsIgnoreCase("Life Special")){
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+tahun +", Rp.4.800.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+sTahun +", Rp.4.800.000,00");
                        System.out.println(dd.getTanggalPolis().subSequence(0,2)+"-"+generateBulan(bulan)+"-"+sTahun1 +", Rp.4.800.000,00");
                    }
                }
                System.out.println("============================================================================");
            }
        }
        mainMenu();
    }


    static String generateBulan(int val){
        String namaBulan = "";
        switch(val){
            case 1:
                namaBulan = "Januari";
                break;
            case 2:
                namaBulan = "Februari";
                break;
            case 3:
                namaBulan = "Maret";
                break;
            case 4:
                namaBulan = "April";
                break;
            case 5:
                namaBulan = "Mei";
                break;
            case 6:
                namaBulan = "Juni";
                break;
            case 7:
                namaBulan = "Juli";
                break;
            case 8:
                namaBulan = "Agustus";
                break;
            case 9:
                namaBulan = "September";
                break;
            case 10:
                namaBulan = "Oktober";
                break;
            case 11:
                namaBulan = "November";
                break;
            case 12:
                namaBulan = "Desember";
                break;
            default:
                namaBulan = "";
                break;
        }
        return namaBulan;
    }

    static void showDetail(){
        showCustomer();
        detailPolicy();
    }
    static void exitApplication(){
        System.exit(0);
    }
}
