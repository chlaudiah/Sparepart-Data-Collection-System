# languange: id

Fitur : Menerima Data pemesanan customer
            Admin menginputkan pemesanan customer sesuai dengan data yang diminta, lalu mengecek pada stock sparepart

        
        @Normal
        Skenario: Memasukkan data pemesanan
                  Dengan memasukkan data pemesanan dan data pemesanan tidak tersedia dalam data yang telah ada di sistem
                  Ketika memasukkan "data customer" dan "id barang" sistem akan melakukan "cek stock" terhadap "id barang" sesuai dengan data barang yang ada di sistem 
                  Dan mengurangi "jumlah sparepart" pada data barang
                  Maka memasukkan "data pemesanan" ke dalam data pemesanan yang ada di sistem dan respon sukses dengan menampilkan "data pemesanan"

        @WrongIdBarang
        