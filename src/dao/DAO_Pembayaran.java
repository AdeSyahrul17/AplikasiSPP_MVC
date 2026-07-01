package dao;

import java.util.List;
import model.PembayaranSPP;

public interface DAO_Pembayaran {
    // Fungsi untuk menambah data (Create)
    public void insert(PembayaranSPP spp);
    
    // Fungsi untuk mengubah data (Update)
    public void update(PembayaranSPP spp);
    
    // Fungsi untuk menghapus data (Delete)
    public void delete(int idPembayaran);
    
    // Fungsi untuk menampilkan seluruh data ke tabel (Read)
    public List<PembayaranSPP> getAll();
    
    // Fungsi untuk fitur pencarian data
    public List<PembayaranSPP> getCari(String keyword);
}