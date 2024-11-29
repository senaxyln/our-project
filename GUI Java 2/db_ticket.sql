-- Membuat database
CREATE DATABASE db_ticket;

-- Menggunakan database yang baru dibuat
USE db_ticket;

-- Membuat tabel untuk laporan penjualan
CREATE TABLE laporan_penjualan (
    nama_pelanggan VARCHAR(100),
    jenis_kelamin VARCHAR(20),
    kategori_tiket VARCHAR(50),
    harga_tiket MONEY,
    jumlah_tiket INT,
    nama_artis VARCHAR(100),
    total_harga MONEY);

	INSERT INTO laporan_penjualan (nama_pelanggan, jenis_kelamin, kategori_tiket, harga_tiket, jumlah_tiket, nama_artis, total_harga)
	VALUES 
	('Caty', 'Perempuan', 'Ruby', '2000000', '2', 'IVE', '4000000');

	SELECT *FROM laporan_penjualan
	DROP TABLE laporan_penjualan;
);

-- 1. Buat tabel
CREATE TABLE Tiket (
    NamaArtis VARCHAR(255),
    KategoriTiket VARCHAR(255),
    HargaTiket VARCHAR(255)
);

-- 2. Sisipkan data ke dalam tabel
INSERT INTO Tiket (NamaArtis, KategoriTiket, HargaTiket)
VALUES 
    ('Alan Walker', 'Diamond, Ruby, Gold, Silver', '4.000.000, 3.000.000, 2.000.000, 1.250.000'),
    ('Lucas', 'Diamond, Ruby, Gold, Silver', '4.000.000, 3.000.000, 2.000.000, 1.250.000'),
    ('Kim Seonho', 'Diamond, Ruby, Gold, Silver', '4.000.000, 3.000.000, 2.000.000, 1.250.000'),
    ('Doh Kyungsoo', 'Diamond, Ruby, Gold, Silver', '4.000.000, 3.000.000, 2.000.000, 1.250.000'),
    ('IVE', 'Diamond, Ruby, Gold, Silver', '4.000.000, 3.000.000, 2.000.000, 1.250.000');

	select * from Tiket

 CREATE TABLE Jadwal (
	NamaArtis VARCHAR(255),
	TanggalKonser VARCHAR(255),
	TempatKonser VARCHAR(255)
	);

	INSERT INTO Jadwal (NamaArtis, TanggalKonser, TempatKonser)
	VALUES
		('Alan Walker', '08 Juni 2024', 'Banten'),
        ('Lucas', '11 Mei 2024', 'Jakarta'),
        ('Kim Seonho', '27 Juli 2024', 'Jakarta'),
        ('Doh Kyungsoo', '12 Juli 2024', 'Jakarta'),
        ('IVE', '24 Agustus 2024', 'Banten')

		select * from Jadwal