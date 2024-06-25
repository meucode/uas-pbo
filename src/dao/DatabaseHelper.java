/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:"+ System.getProperty("user.dir")+ "\\absensi.db";
    
    public static Connection connect() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Berhasil konek");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println(con);
        return con;
    }
}
