package app.controller;

import app.model.Mahasiswa;
import app.view.PresensiView;
import app.view.Login;
import app.view.MahasiswaView;
import dao.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {

    // Metode untuk melakukan autentikasi login mahasiswa
    public String loginMahasiswa(String nim, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String nim_terdaftar = null;
        String tingkat_terdaftar = null;
        String prodi_terdaftar = null;
        try {
            // Mengganti dengan koneksi database Anda
            conn = DatabaseHelper.connect();
            
            // Query SQL untuk mengambil data mahasiswa berdasarkan nim dan password
            String query = "SELECT * FROM tb_mahasiswa WHERE nim = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, nim);
            
            rs = ps.executeQuery();
            
            // Jika data ditemukan, inisialisasi objek Mahasiswa
            if (rs.next()) {
                Login.nim_terdaftar = rs.getString("nim");
                Login.tingkat_terdaftar = rs.getString("tingkat");
                Login.prodi_terdaftar = rs.getString("prodi");
                Login.password_terdaftar = rs.getString("password");
                nim_terdaftar = rs.getString("nim");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            // Menutup koneksi dan statement
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }        
        return nim_terdaftar;
    }
    
}
