package app.model;

import java.util.Date;

public class Presensi {

    private int idAbsensi;
    private String nim;
    private String tglAbsensi;
    private String keterangan;
    private String matkul;

    public Presensi() {
    }

    public Presensi(String nim, String tglAbsensi, String keterangan, String matkul) {
        this.nim = nim;
        this.tglAbsensi = tglAbsensi;
        this.keterangan = keterangan;
        this.matkul = matkul;
    }

    public int getIdAbsensi() {
        return idAbsensi;
    }

    public void setIdAbsensi(int idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTglAbsensi() {
        return tglAbsensi;
    }

    public void setTglAbsensi(String tglAbsensi) {
        this.tglAbsensi = tglAbsensi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    @Override
    public String toString() {
        return "Absensi{" +
                "idAbsensi=" + idAbsensi +
                ", nim='" + nim + '\'' +
                ", tglAbsensi=" + tglAbsensi +
                ", keterangan='" + keterangan + '\'' +
                ", matkul=" + matkul +
                '}';
    }
}
