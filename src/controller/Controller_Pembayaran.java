package controller;

import view.FormUtama;
import dao.DAO_Pembayaran;
import dao.DAO_PembayaranImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PembayaranSPP;

public class Controller_Pembayaran {
    private final FormUtama frame; // Variabel ini bernama 'frame'
    private final DAO_Pembayaran dao;
    private List<PembayaranSPP> listSpp;

    public Controller_Pembayaran(FormUtama frame) {
        this.frame = frame;
        this.dao = new DAO_PembayaranImpl();
    }

    
    
    public void ubah() {
        if (frame.getTxtId().getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Pilih data yang ingin diubah pada tabel terlebih dahulu!");
            return;
    }
        try {
            PembayaranSPP spp = new PembayaranSPP();
            spp.setNis(frame.getTxtNis().getText());
            spp.setNama(frame.getTxtNama().getText());
            spp.setKelas(frame.getTxtKelas().getText());
            spp.setBulan(frame.getCmbBulan().getSelectedItem().toString());
            spp.setJumlahBayar(Integer.parseInt(frame.getTxtJumlah().getText()));
            spp.setTanggalBayar(frame.getTxtTanggal().getText());
            spp.setStatus(frame.getCmbStatus().getSelectedItem().toString());

            dao.insert(spp);
            JOptionPane.showMessageDialog(frame, "Data berhasil disimpan!");
            reset();
            tampilData();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Jumlah Bayar harus angka!");
        }
    }
    
    
    public void reset() {
        frame.getTxtId().setText("");
        frame.getTxtNis().setText("");
        frame.getTxtNama().setText("");
        frame.getTxtKelas().setText("");
        frame.getCmbBulan().setSelectedIndex(0);
        frame.getTxtJumlah().setText("");
        frame.getTxtTanggal().setText(java.time.LocalDate.now().toString());
        frame.getCmbStatus().setSelectedIndex(0);
        frame.getTblData().clearSelection();
    }

    public void tampilData() {
        listSpp = dao.getAll();
        String[] header = {"ID", "NIS", "Nama", "Kelas", "Bulan", "Jumlah Bayar", "Tanggal", "Status"};
        DefaultTableModel model = new DefaultTableModel(null, header) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        for (PembayaranSPP spp : listSpp) {
            Object[] o = new Object[8];
            o[0] = spp.getIdPembayaran();
            o[1] = spp.getNis();
            o[2] = spp.getNama();
            o[3] = spp.getKelas();
            o[4] = spp.getBulan();
            o[5] = spp.getJumlahBayar();
            o[6] = spp.getTanggalBayar();
            o[7] = spp.getStatus();
            model.addRow(o);
        }
        frame.getTblData().setModel(model); // Ganti view jadi frame
    }

    public void simpan() {
        // Ganti semua 'view' jadi 'frame'
        if (frame.getTxtNis().getText().trim().isEmpty() || 
            frame.getTxtNama().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Data wajib diisi!");
            return;
        }

        try {
            PembayaranSPP spp = new PembayaranSPP();
            spp.setNis(frame.getTxtNis().getText());
            spp.setNama(frame.getTxtNama().getText());
            spp.setKelas(frame.getTxtKelas().getText());
            spp.setBulan(frame.getCmbBulan().getSelectedItem().toString());
            spp.setJumlahBayar(Integer.parseInt(frame.getTxtJumlah().getText()));
            spp.setTanggalBayar(frame.getTxtTanggal().getText());
            spp.setStatus(frame.getCmbStatus().getSelectedItem().toString());

            dao.insert(spp);
            JOptionPane.showMessageDialog(frame, "Data berhasil disimpan!");
            reset();
            tampilData();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Jumlah Bayar harus angka!");
        }
    }

    // Lakukan hal yang sama (ganti view -> frame) untuk method ubah, hapus, cari, dan pilihTabel
    // Sisa method lainnya ikuti pola perubahan di atas.
    
    public void pilihTabel() {
        int row = frame.getTblData().getSelectedRow();
        if (row != -1) {
            frame.getTxtId().setText(frame.getTblData().getValueAt(row, 0).toString());
            frame.getTxtNis().setText(frame.getTblData().getValueAt(row, 1).toString());
            // ... dst ...
        }
    }
    
     public void hapus() {
         if (frame.getTxtId().getText().isEmpty()) {
             JOptionPane.showMessageDialog(frame, "Pilih data yang ingin dihapus pada tabel terlebih dahulu!");
            return;
            }
         int konfirmasi = JOptionPane.showConfirmDialog(frame, "Yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(frame.getTxtId().getText());
                dao.delete(id); // Memanggil fungsi delete di DAO
                JOptionPane.showMessageDialog(frame, "Data berhasil dihapus!");
                reset(); // Kembali bersihkan form
                tampilData(); // Refresh isi tabel
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
         }
     }
     public void cari() {
         String keyword = frame.getTxtCari().getText().trim();
        if (!keyword.isEmpty()) {
            listSpp = dao.getCari(keyword); // Memanggil fungsi pencarian di DAO
            String[] header = {"ID", "NIS", "Nama", "Kelas", "Bulan", "Jumlah Bayar", "Tanggal", "Status"};
            DefaultTableModel model = new DefaultTableModel(null, header) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            for (PembayaranSPP spp : listSpp) {
                Object[] o = new Object[8];
                o[0] = spp.getIdPembayaran();
                o[1] = spp.getNis();
                o[2] = spp.getNama();
                o[3] = spp.getKelas();
                o[4] = spp.getBulan();
                o[5] = spp.getJumlahBayar();
                o[6] = spp.getTanggalBayar();
                o[7] = spp.getStatus();
                model.addRow(o);
            }
            frame.getTblData().setModel(model);
        } else {
            tampilData();
        }
     }
     public void cetakLaporan() {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Simpan Laporan Pembayaran SPP");
        
        // Mengatur nama file default
        fileChooser.setSelectedFile(new java.io.File("Laporan_Pembayaran_SPP.xls"));
        
        int userSelection = fileChooser.showSaveDialog(frame);
        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            
            try {
                java.io.FileWriter fw = new java.io.FileWriter(fileToSave);
                java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
                
                // 1. Cetak Header Tabel
                for (int i = 0; i < frame.getTblData().getColumnCount(); i++) {
                    bw.write(frame.getTblData().getColumnName(i) + "\t");
                }
                bw.newLine();
                
                // 2. Cetak Isi Data Tabel
                for (int i = 0; i < frame.getTblData().getRowCount(); i++) {
                    for (int j = 0; j < frame.getTblData().getColumnCount(); j++) {
                        // Menghindari nilai null agar tidak error
                        Object value = frame.getTblData().getValueAt(i, j);
                        bw.write((value != null ? value.toString() : "") + "\t");
                    }
                    bw.newLine();
                }
                
                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(frame, "Laporan berhasil dicetak ke:\n" + fileToSave.getAbsolutePath(), "Selesai", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (java.io.IOException ex) {
                JOptionPane.showMessageDialog(frame, "Gagal mencetak laporan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
     }
}