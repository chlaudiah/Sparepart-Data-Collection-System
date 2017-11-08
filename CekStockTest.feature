# language: id

Fitur : Melakukan Cek Stock
        Melakukan Cek Stok Admin

    @Normal
    Skenario : Melakukan Cek Stok Admin
                Dengan admin menginputkan id barang dan dilakukan pengecekan id barang tersebut pada data barang di sistem 
                ketika id barang ada maka akan ditampilkan data barang yang memuat nama barang, harga barang dan status sparepart yang tersedia
                maka respon sukses dengan menampilkan data stock barang yang dicari

    @WrongUsername
    Skenario : Melakukan Cek Stok Admin
                Dengan admin menginputkan id barang dan dilakukan pengecekan id barang tersebut pada data barang di sistem 
                ketika id barang tidak ada maka akan ditampilkan data barang yang memuat nama barang, harga barang dan status sparepart yang tersedia
                maka respon gagal dengan menampilkan pesan "Barang tidak ada"
    
