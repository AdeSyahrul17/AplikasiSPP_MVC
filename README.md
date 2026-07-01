# Aplikasi Pembayaran SPP Berbasis Java Desktop (MVC)

Tugas Akhir ini merupakan aplikasi manajemen pembayaran SPP sekolah yang dirancang menggunakan bahasa pemrograman Java dengan arsitektur **Model-View-Controller (MVC)** untuk menghasilkan struktur kode yang bersih, rapi, dan mudah dikembangkan.

## 👤 Informasi Mahasiswa
* Nama: Ade Syahrul Ramadhani
* NIM: 231011401374
* Mata Kuliah: Pemrograman 2 / Tugas Akhir

---

## 🔒 Hak Akses Login (Autentikasi)
Untuk menguji fungsionalitas penuh sistem, gunakan akun administrator berikut pada halaman Form Login:
* **Username:** `admin`
* **Password:** `admin123`

---

## 🏛️ Objek / Domain & Arsitektur Aplikasi
Aplikasi ini berfokus pada manajemen administrasi keuangan sekolah (SPP). Proyek ini diimplementasikan menggunakan pola arsitektur **MVC**:
1. **Model:** Mengatur struktur data dan logika bisnis (interaksi langsung dengan database MySQL).
2. **View:** Mengatur tampilan antarmuka pengguna (GUI) menggunakan framework Swing (seperti `FormLogin` dan `FormUtama`).
3. **Controller:** Menjadi jembatan penghubung yang memproses aksi dari *View* untuk memanipulasi data pada *Model*.

---

## 🚀 Fitur Utama Aplikasi & Cara Mengeceknya

Dosen penguji dapat melakukan validasi sistem melalui fitur-fitur utama berikut:

### 1. Sistem Autentikasi Keamanan (Login & Logout)
* **Deskripsi:** Membatasi hak akses aplikasi hanya untuk user/admin yang terdaftar demi keamanan data.
* **Cara Cek:** Jalankan aplikasi, masukkan Username `admin` dan Password `admin123`. Jika benar, sistem akan mengarahkan ke halaman `FormUtama`. Jika salah, sistem akan menampilkan pesan peringatan.

### 2. Manajemen Data Master (CRUD)
* **Deskripsi:** Modul untuk mengelola data mentah sistem (Data Siswa, Data Petugas/Admin, dan Data Kelas/Tarif SPP).
* **Cara Cek:** Masuk ke menu Master data, coba lakukan operasi **Create** (tambah data baru), **Read** (melihat data tampil di tabel), **Update** (mengubah data yang dipilih), dan **Delete** (menghapus data).

### 3. Transaksi Pembayaran SPP
* **Deskripsi:** Fitur inti untuk melakukan pencatatan pembayaran SPP bulanan siswa secara real-time.
* **Cara Cek:** Buka menu Transaksi, cari siswa berdasarkan NISN/Nama, pilih bulan yang ingin dibayarkan, masukkan nominal uang, lalu simpan transaksi. Status pembayaran siswa tersebut otomatis akan diperbarui.

### 4. Laporan Keuangan (Reporting)
* **Deskripsi:** Menyediakan rekapitulasi data cetak transaksi pembayaran untuk kebutuhan arsip sekolah.
* **Cara Cek:** Masuk ke menu Laporan, pilih periode atau cetak langsung untuk melihat hasil *generate* laporan keuangan dalam bentuk cetak/preview.

---

## 🛠️ Cara Menjalankan Project di Laptop

ScreenShot Aplikasi :
sebelum di run
<img width="2880" height="1874" alt="image" src="https://github.com/user-attachments/assets/8a6a1486-3bb2-4e36-8ef2-b9c9371ccaed" />

sesudah di run 
<img width="2880" height="1920" alt="image" src="https://github.com/user-attachments/assets/f39cb78a-55e1-4a65-b966-a2fce18bd000" />


1. **Clone / Unduh Repositori:**
   ```bash
   git clone [https://github.com/AdeSyahrul17/AplikasiSPP_MVC.git](https://github.com/AdeSyahrul17/AplikasiSPP_MVC.git)
