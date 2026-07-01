package model;

public class PembayaranSPP {
    private Integer idPembayaran;
    private String nis;
    private String nama;
    private String kelas;
    private String bulan;
    private Integer jumlahBayar;
    private String tanggalBayar;
    private String status;

    // --- GETTER ---
    public Integer getIdPembayaran() { return idPembayaran; }
    public String getNis() { return nis; }
    public String getNama() { return nama; }
    public String getKelas() { return kelas; }
    public String getBulan() { return bulan; }
    public Integer getJumlahBayar() { return jumlahBayar; }
    public String getTanggalBayar() { return tanggalBayar; }
    public String getStatus() { return status; }

    // --- SETTER ---
    public void setIdPembayaran(Integer idPembayaran) { this.idPembayaran = idPembayaran; }
    public void setNis(String nis) { this.nis = nis; }
    public void setNama(String nama) { this.nama = nama; }
    public void setKelas(String kelas) { this.kelas = kelas; }
    public void setBulan(String bulan) { this.bulan = bulan; }
    public void setJumlahBayar(Integer jumlahBayar) { this.jumlahBayar = jumlahBayar; }
    public void setTanggalBayar(String tanggalBayar) { this.tanggalBayar = tanggalBayar; }
    public void setStatus(String status) { this.status = status; }
}