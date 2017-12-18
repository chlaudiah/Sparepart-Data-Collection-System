/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.model;

/**
 *
 * @author BegalPapua
 */
public class Pemesanan {
    private int id_pemesanan;
    private Barang[] daftarOrder = new Barang[20];
    private Barang barang;
    private String tanggal;
    private int totalOrder;
    private int jumlahBarang;
    private int totalHarga = 0;
    private int numOrder;

    public Pemesanan(Barang barang, int idPemesanan, String tanggal, int totalOrder) {
        this.tanggal = tanggal;
        this.totalOrder = totalOrder;
        this.id_pemesanan++;
    }

    public Pemesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void tambahOrder(Barang barang, int jumlahOrder){
        if(numOrder < daftarOrder.length && jumlahOrder <= barang.getJumlah_barang()){
            daftarOrder[numOrder] = barang;
            this.jumlahBarang = jumlahOrder;
            numOrder++;
        } else if(jumlahOrder > barang.getJumlah_barang()){
            System.out.println("Jumlah barang tidak cukup");
        } else{
            System.out.println("Daftar Order Penuh");
        }
    }
    
    public Barang lihatOrder(int id){
        System.out.println("DAFTAR BARANG: ");
        for(int i=0; i<numOrder;i++){
            return daftarOrder[i];
        }
        return null;
    }
    
    public int HitungSisaBarang(int idPemesanan, int idBarang){
        for(int i=0; i < numOrder; i++){
            if(idBarang == daftarOrder[i].getId_barang()){
                barang.setJumlah_barang(barang.getJumlah_barang()-daftarOrder[i].getJumlah_barang());
            }
        }
        return barang.getJumlah_barang();
    }
    
    
    public int HitungTotal(int id){
        for(int i = 0; i < numOrder; i++){
            totalHarga = totalHarga + daftarOrder[i].getHarga_barang();
        }
        return totalHarga;
    }
    
    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public int getJumlah() {
        return jumlahBarang;
    }
    
    
    
}
