/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.model;

/**
 *
 * @author BegalPapua
 */
public class Barang {
    private int id_barang;
    private String nama_barang;
    private int jumlah_barang;
    private String status;
    private int harga_barang;

    public Barang(int id, String nama_barang, int jumlah_barang, String status, int harga_barang) {
        this.nama_barang = nama_barang;
        this.jumlah_barang = jumlah_barang;
        this.status = status;
        this.harga_barang = harga_barang;
        this.id_barang = id++;
    }

    public Barang() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setJumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public int getId_barang() {
        return id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public int getJumlah_barang() {
        return jumlah_barang;
    }

    public String getStatus() {
        if(jumlah_barang > 10) return "Available";
        else return "Restock";
    }

    public int getHarga_barang() {
        return harga_barang;
    }
    
}
