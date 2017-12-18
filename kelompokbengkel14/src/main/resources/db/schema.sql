CREATE DATABASE IF NOT EXISTS kelompokbengkel;

ALTER DATABASE kelompokbengkel
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON kelompokbengkel.* TO pc@localhost IDENTIFIED BY 'pc';

USE kelompokbengkel;

CREATE TABLE IF NOT EXISTS barang (
  id_barang INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nama_barang VARCHAR(30),
  jumlah_barang INT(3),
  status VARCHAR(30),
  harga_barang INT(10)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS DataAdmin (
  id_admin VARCHAR(10) PRIMARY KEY,
  nama_admin VARCHAR(80)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS pemesanan (
  id_pemesanan INT(4)  UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  jumlahOrder INT(5),
  tanggal_pemesanan DATE
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS restock (
  id_restock INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tanggal_restock DATE,
  jumlah_restock INT(3)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS relasi_pemesanan_barang_admin (
  id_pemesanan INT(4)  UNSIGNED NOT NULL,
  id_barang INT(4) UNSIGNED NOT NULL,
  id_admin VARCHAR(10),
  total_harga INT(10) UNSIGNED NOT NULL,
  FOREIGN KEY (id_pemesanan) REFERENCES pemesanan(id_pemesanan),
  FOREIGN KEY (id_barang) REFERENCES barang(id_barang),
  FOREIGN KEY (id_admin) REFERENCES DataAdmin(id_admin)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS relasi_restock_barang (
  id_restock INT(4)  UNSIGNED NOT NULL,
  id_barang INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (id_restock) REFERENCES restock(id_restock),
  FOREIGN KEY (id_barang) REFERENCES barang(id_barang)
) engine=InnoDB;
