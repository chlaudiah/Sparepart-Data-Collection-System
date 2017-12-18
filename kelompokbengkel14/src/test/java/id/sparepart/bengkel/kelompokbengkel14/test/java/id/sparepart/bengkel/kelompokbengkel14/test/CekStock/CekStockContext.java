/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.sparepart.bengkel.kelompokbengkel14.test.CekStock;

import cucumber.api.java.bm.Maka;
import cucumber.api.java.id.Dengan;
import cucumber.api.java.id.Ketika;

/**
 *
 * @author MSI
 */
public class CekStockContext {
    @Dengan("^admin menginputkan \"([^\"]*)\" dan dilakukan pengecekan \"([^\"]*)\" tersebut pada \"([^\"]*)\" di sistem$")
    public void admin_menginputkan_dan_dilakukan_pengecekan_tersebut_pada_di_sistem(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        int expected = App.Aplikasi.getIdBarang(b.getId_barang());
        int result = App.Aplikasi.getIdBarang(b.getId_barang());
        Assert.assertEquals(expected,result);
    }

    @Ketika("^\"([^\"]*)\" ada maka akan ditampilkan \"([^\"]*)\" yang memuat \"([^\"]*)\", \"([^\"]*)\" dan \"([^\"]*)\" sparepart yang tersedia$")
    public void ada_maka_akan_ditampilkan_yang_memuat_dan_sparepart_yang_tersedia(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        respon = App.Aplikasi.DataBarang(b.getId_barang());
    }

    @Maka("^respon sukses dengan menampilkan data \"([^\"]*)\" yang dicari$")
    public void respon_sukses_dengan_menampilkan_data_yang_dicari(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Assert.assertEquals(respon, "Data tersedia");
    }

    @Ketika("^\"([^\"]*)\" yang dicari tidak ada$")
    public void yang_dicari_tidak_ada(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        respon = App.Aplikasi.DataBarang(0);
    }

    @Maka("^respon gagal dengan menampilkan pesan \"([^\"]*)\"$")
    public void respon_gagal_dengan_menampilkan_pesan(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Assert.assertEquals(respon, "Data tidak tersedia");
      }
}
