# language: id

Fitur: Menerima Data pemesanan customer
        Menerima Data pemesanan customer

        @Normal
        Skenario: Menerima Data pemesanan customer
                  Dengan memasukkan data pemesanan dan data pemesanan tidak tersedia dalam data yang telah ada di sistem
                  Ketika memasukkan "data customer" dan "id barang" sistem akan melakukan "cek stock" terhadap "id barang" sesuai dengan data barang yang ada di sistem 
                  Dan mengurangi "jumlah sparepart" pada data barang
                  Maka memasukkan "data pemesanan" ke dalam data pemesanan yang ada di sistem dan respon sukses dengan menampilkan "data pemesanan"
        
        @WrongIdBarang
        Skenario: Menerima Data pemesanan customer
                  Dengan memasukkan data pemesanan dan data pemesanan tidak tersedia dalam data yang telah ada di sistem
                  Ketika memasukkan "data customer" dan "id barang" sistem akan melakukan "cek stock" terhadap "id barang" sesuai dengan data barang yang ada di sistem
                  Dan "id barang" tidak ditemukan pada data barang
                  Maka respon gagal dengan pesan "Id barang tidak tersedia" dan "data pemesanan" tidak di masukkan ke dalam data pemesanan yang ada di sistem
                  
        @BarangTidakTersedia
        Skenario: Menerima Data pemesanan customer
                  Dengan memasukkan data pemesanan dan data pemesanan tidak tersedia dalam data yang telah ada di sistem
                  Ketika memasukkan "data customer" dan "id barang" sistem akan melakukan "cek stock" terhadap "id barang" sesuai dengan data barang yang ada di sistem
                  Dan "jumlah sparepart" bernilai "0" pada data barang
                  Maka respon gagal dengan pesan "Barang Habis" dan "data pemesanan" tidak di masukkan ke dalam data pemesanan yang ada di sistem
