/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.model;

/**
 *
 * @author BegalPapua
 */
public class Admin {
    private String id_admin;
    private String nama_admin;
    private int numPemesanan, numBarang, numRestock;
    private Restock[] restock = new Restock[20]; 
    private Pemesanan[] daftarPemesanan = new Pemesanan[20];
    private Barang[] daftarBarang = new Barang[20];
    private static int id = 0;

    public Admin(String nama) {
        this.nama_admin = nama;
        this.id_admin = "Admin"+(id + 1);
        this.numPemesanan = 0;
    }

    public String getId_admin() {
        return id_admin;
    }

    public String getNama_admin() {
        return nama_admin;
    }
    
    public void tambahPemesanan(Pemesanan pemesanan){
        if(numPemesanan < daftarPemesanan.length){
            int i = 0;
            while(i < numPemesanan){
                i++;
            }
            if(i == numPemesanan){
                daftarPemesanan[numPemesanan] = pemesanan;
                numPemesanan++;
            }
            else{
                System.out.println("Pemesanan sudah ada");
            }
        }
        else System.out.println("Sudah tidak dapat membuat pemesanan lagi");
    }
    
    public void tambahBarang(Barang barang){
        if(numBarang < daftarBarang.length){
            int i = 0;
            while(i < numBarang && daftarBarang[i].getId_barang()!= barang.getId_barang()){
                i++;
            }
            if(i == numBarang){
                daftarBarang[numBarang] = barang;
                numBarang++;
            }
            else{
                System.out.println("Barang sudah ada");
            }
        }
        else System.out.println("Sudah tidak dapat menambahkan barang lagi");
    }
    
    public void tampilDataPemesanan(int id){
        System.out.println("Nama Admin: "+nama_admin);
        for(int i = 0; i < numPemesanan; i++){
            if(id == daftarPemesanan[i].getId_pemesanan()){
                System.out.println("ID Pemesanan: "+daftarPemesanan[i].getId_pemesanan());
                System.out.println("Tanggal Pemesanan: "+daftarPemesanan[i].getTanggal());
                System.out.println("Total Order: "+daftarPemesanan[i].getTotalOrder());
                System.out.println("DAFTAR BARANG");
                System.out.println("Nama Barang: "+daftarPemesanan[i].lihatOrder(id).getNama_barang());
                System.out.println("Harga Barang: "+daftarPemesanan[i].lihatOrder(id).getHarga_barang());
                System.out.println("Jumlah Order: "+daftarPemesanan[i].getJumlah());
                System.out.println("TOTAL HARGA");
                System.out.println("Total: "+ daftarPemesanan[i].HitungTotal(id));
            }
        }
    }
    
    
    public void tampilDataBarang(int idPemesanan){
        System.out.println("DATA BARANG");
        for(int i = 0; i < numBarang ; i++){
            System.out.println("ID Barang: " + daftarBarang[i].getId_barang());
            System.out.println("Nama Barang: "+ daftarBarang[i].getNama_barang());
            System.out.println("Harga Barang: " + daftarBarang[i].getHarga_barang());
            System.out.println("Status: " + daftarBarang[i].getStatus());
            for(int j = 0; j < numPemesanan; j++){
                if(idPemesanan == daftarPemesanan[j].HitungSisaBarang(idPemesanan,daftarBarang[i].getId_barang())){
                    daftarBarang[i].setJumlah_barang(daftarBarang[i].getJumlah_barang() - daftarPemesanan[j].getJumlah());
                }
            }
            System.out.println("Jumlah Barang: " + daftarBarang[i].getJumlah_barang());
        }
    }
    
    public void tampilDataRestock(int id){
        System.out.println("DATA RESTOCK");
        for(int i = 0; i < numRestock ; i++){
            System.out.println("ID Restock: "+ restock[i].getIdRestock());
            System.out.println("Tanggal Restock: " + restock[i].getTanggal());
            System.out.println("Jumlah restock: "+restock[i].getJumlahRestock());
            System.out.println("ID Barang: " + restock[i].tambahJumlahBarang(id).getId_barang());
            System.out.println("Jumlah Barang: " + restock[i].tambahJumlahBarang(id).getNama_barang());
        }
    }
    
}
