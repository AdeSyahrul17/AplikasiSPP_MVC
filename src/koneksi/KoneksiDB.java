package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        // Jika koneksi masih kosong, maka buat koneksi baru
        if (koneksi == null) {
            try {
                // Sesuaikan nama database sesuai yang dibuat di phpMyAdmin
                String url = "jdbc:mysql://localhost:3306/db_sekolah_231011401374";
                String user = "root"; // username default XAMPP
                String password = ""; // password default XAMPP (dikosongkan)
                
                // Mendaftarkan Driver MySQL
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
                
                // Melakukan koneksi
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Database Berhasil");
                
            } catch (SQLException e) {
                System.out.println("Error Membuat Koneksi");
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
}