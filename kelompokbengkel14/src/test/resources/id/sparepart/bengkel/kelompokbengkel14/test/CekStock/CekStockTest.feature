# language: id

Fitur: Melakukan Cek Stock Admin
        Melakukan Cek Stok Admin

        @Normal
        Skenario: Melakukan Cek Stock Admin
                Dengan admin menginputkan "id barang" dan dilakukan pengecekan "id barang" tersebut pada "daftar barang" di sistem 
                Ketika "id barang" ada maka akan ditampilkan "daftar barang" yang memuat "nama barang", "harga barang" dan "status" sparepart yang tersedia
                Maka respon sukses dengan menampilkan data "daftar barang" yang dicari

        @BarangTidakAda
        Skenario: Melakukan Cek Stock Admin
                Dengan admin menginputkan "id barang" dan dilakukan pengecekan "id barang" tersebut pada "daftar barang" di sistem 
                Ketika "id barang" yang dicari tidak ada
                Maka respon gagal dengan menampilkan pesan "Barang tidak ada"
  
