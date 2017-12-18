/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.model;

/**
 *
 * @author BegalPapua
 */
public class Restock {
    private Barang[] daftarbarang = new Barang[20];
    private String tanggal;
    private int jumlahRestock;
    private int numBarang;
    private int idRestock;

    public Restock(Barang b, String tanggal, int idRestock, int jumlah) {
        this.tanggal = tanggal;
        this.jumlahRestock = jumlah;
        this.idRestock++;
    }   

    public Restock() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Barang tambahJumlahBarang(int idBarang){
        for(int i=0 ; i < numBarang; i++){
            if(idBarang == daftarbarang[i].getId_barang()){
                daftarbarang[i].setJumlah_barang(jumlahRestock + daftarbarang[i].getJumlah_barang());
                return daftarbarang[i];
            }
        }
        return null;
    }
    
    public String getTanggal() {
        return tanggal;
    }

    public int getIdRestock() {
        return idRestock;
    }

    public int getJumlahRestock() {
        return jumlahRestock;
    }
    

}
