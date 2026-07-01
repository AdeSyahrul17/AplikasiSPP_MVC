package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.KoneksiDB;
import model.PembayaranSPP;

public class DAO_PembayaranImpl implements DAO_Pembayaran {
    
    // Memanggil koneksi database
    Connection connection = KoneksiDB.getKoneksi();

    // Query SQL menggunakan tanda tanya (?) untuk PreparedStatement (Mencegah SQL Injection)
    final String insert = "INSERT INTO pembayaran_spp (nis, nama, kelas, bulan, jumlah_bayar, tanggal_bayar, status) VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE pembayaran_spp SET nis=?, nama=?, kelas=?, bulan=?, jumlah_bayar=?, tanggal_bayar=?, status=? WHERE id_pembayaran=?;";
    final String delete = "DELETE FROM pembayaran_spp WHERE id_pembayaran=?;";
    final String select = "SELECT * FROM pembayaran_spp ORDER BY id_pembayaran DESC;";
    final String search = "SELECT * FROM pembayaran_spp WHERE nama LIKE ? OR nis LIKE ?;";

    @Override
    public void insert(PembayaranSPP spp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, spp.getNis());
            statement.setString(2, spp.getNama());
            statement.setString(3, spp.getKelas());
            statement.setString(4, spp.getBulan());
            statement.setInt(5, spp.getJumlahBayar());
            statement.setString(6, spp.getTanggalBayar()); // Format YYYY-MM-DD
            statement.setString(7, spp.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Input Data: " + e.getMessage());
        } finally {
            try { if(statement != null) statement.close(); } catch (SQLException e) {}
        }
    }

    @Override
    public void update(PembayaranSPP spp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, spp.getNis());
            statement.setString(2, spp.getNama());
            statement.setString(3, spp.getKelas());
            statement.setString(4, spp.getBulan());
            statement.setInt(5, spp.getJumlahBayar());
            statement.setString(6, spp.getTanggalBayar());
            statement.setString(7, spp.getStatus());
            statement.setInt(8, spp.getIdPembayaran());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Ubah Data: " + e.getMessage());
        } finally {
            try { if(statement != null) statement.close(); } catch (SQLException e) {}
        }
    }

    @Override
    public void delete(int idPembayaran) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, idPembayaran);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus Data: " + e.getMessage());
        } finally {
            try { if(statement != null) statement.close(); } catch (SQLException e) {}
        }
    }

    @Override
    public List<PembayaranSPP> getAll() {
        List<PembayaranSPP> listSpp = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(select);
            while (rs.next()) {
                PembayaranSPP spp = new PembayaranSPP();
                spp.setIdPembayaran(rs.getInt("id_pembayaran"));
                spp.setNis(rs.getString("nis"));
                spp.setNama(rs.getString("nama"));
                spp.setKelas(rs.getString("kelas"));
                spp.setBulan(rs.getString("bulan"));
                spp.setJumlahBayar(rs.getInt("jumlah_bayar"));
                spp.setTanggalBayar(rs.getString("tanggal_bayar"));
                spp.setStatus(rs.getString("status"));
                listSpp.add(spp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil Data: " + e.getMessage());
        }
        return listSpp;
    }

    @Override
    public List<PembayaranSPP> getCari(String keyword) {
        List<PembayaranSPP> listSpp = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(search);
            // Menambahkan % agar bisa mencari kata yang mengandung keyword tersebut
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PembayaranSPP spp = new PembayaranSPP();
                spp.setIdPembayaran(rs.getInt("id_pembayaran"));
                spp.setNis(rs.getString("nis"));
                spp.setNama(rs.getString("nama"));
                spp.setKelas(rs.getString("kelas"));
                spp.setBulan(rs.getString("bulan"));
                spp.setJumlahBayar(rs.getInt("jumlah_bayar"));
                spp.setTanggalBayar(rs.getString("tanggal_bayar"));
                spp.setStatus(rs.getString("status"));
                listSpp.add(spp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Cari Data: " + e.getMessage());
        }
        return listSpp;
    }
}