package app.controller;

import app.model.Mahasiswa;
import dao.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MahasiswaController {

    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        String sql = "INSERT INTO tb_mahasiswa (NIM, Nama, Kelas, Prodi, Tingkat, Password) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, mahasiswa.getNim());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setString(3, mahasiswa.getKelas());
            pstmt.setString(4, mahasiswa.getProdi());
            pstmt.setString(5, mahasiswa.getTingkat());
            pstmt.setString(6, mahasiswa.getPassword());
            int affectedRows = pstmt.executeUpdate();
        
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NIM telah terdaftar");
            System.out.println(e.getMessage());
        }
    }

    public void editMahasiswa(Mahasiswa mahasiswa) {
        String sql = "UPDATE tb_mahasiswa SET Nama = ?, Kelas = ?, Prodi = ?, Tingkat = ?, Password = ? WHERE NIM = ?";
        
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, mahasiswa.getNama());
            pstmt.setString(2, mahasiswa.getKelas());
            pstmt.setString(3, mahasiswa.getProdi());
            pstmt.setString(4, mahasiswa.getTingkat());
            pstmt.setString(5, mahasiswa.getPassword());
            pstmt.setString(6, mahasiswa.getNim());
            int affectedRows = pstmt.executeUpdate();
        
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diedit!");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusMahasiswa(String nim) {
        String sql = "DELETE FROM tb_mahasiswa WHERE NIM = ?";

        int response = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Penghapusan", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.OK_OPTION) {
            try (Connection conn = DatabaseHelper.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, nim);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                } else {
                    JOptionPane.showMessageDialog(null, "Penghapusan gagal: Data tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Penghapusan dibatalkan.", "Dibatalkan", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public List<Mahasiswa> getAllMahasiswa() {
        String sql = "SELECT NIM, Nama, Kelas, Prodi, Tingkat, Password FROM tb_mahasiswa";
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa(
                        rs.getString("NIM"),
                        rs.getString("Nama"),
                        rs.getString("Kelas"),
                        rs.getString("Prodi"),
                        rs.getString("Tingkat"), 
                        rs.getString("Password")
                );
                mahasiswaList.add(mahasiswa);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return mahasiswaList;
    }
}
