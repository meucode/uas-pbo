package app.controller;

import app.model.Presensi;
import dao.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PresensiController {

    public void addAbsensi(Presensi absensi) {
        String sql = "INSERT INTO tb_absensi(NIM, Tgl_absensi, Keterangan, matkul) VALUES(?, ?, ?,?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, absensi.getNim());
            pstmt.setString(2, absensi.getTglAbsensi());
            pstmt.setString(3, absensi.getKeterangan());
            pstmt.setString(4, absensi.getMatkul());
            int affectedRows = pstmt.executeUpdate();
        
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil melakukan presensi!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String checkAbsensi(Presensi absensi) {
    String sql = "SELECT * FROM tb_absensi WHERE NIM = ? AND Tgl_absensi = ? AND Matkul = ?";

    try (Connection conn = DatabaseHelper.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, absensi.getNim());
        pstmt.setString(2, absensi.getTglAbsensi());
        pstmt.setString(3, absensi.getMatkul());

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return "Data ada";
            } else {
                return "Data tidak ada";
            }
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return "Error: " + e.getMessage();
    }
}


    public List<Presensi> getAllAbsensi() {
        List<Presensi> absensiList = new ArrayList<>();
        String sql = "SELECT * FROM tb_absensi";

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Presensi absensi = new Presensi();
                absensi.setIdAbsensi(rs.getInt("ID_absensi"));
                absensi.setNim(rs.getString("NIM"));
                absensi.setTglAbsensi(rs.getString("Tgl_absensi"));
                absensi.setKeterangan(rs.getString("Keterangan"));
                absensi.setMatkul(rs.getString("matkul"));

                absensiList.add(absensi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return absensiList;
    }
public List<Presensi> getAbsensiByNIM(String nim) {
        List<Presensi> absensiList = new ArrayList<>();
        String sql = "SELECT * FROM tb_absensi WHERE NIM = "+nim;

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Presensi absensi = new Presensi();
                absensi.setIdAbsensi(rs.getInt("ID_absensi"));
                absensi.setNim(rs.getString("NIM"));
                absensi.setTglAbsensi(rs.getString("Tgl_absensi"));
                absensi.setKeterangan(rs.getString("Keterangan"));
                absensi.setMatkul(rs.getString("Matkul"));

                absensiList.add(absensi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return absensiList;
    }
    public void deleteAbsensi(int idAbsensi) {
        String sql = "DELETE FROM tb_absensi WHERE ID_absensi = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAbsensi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
