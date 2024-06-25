/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.controller.PresensiController;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import app.model.Presensi;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Satria Yuda
 */
public class PresensiView extends javax.swing.JFrame {
    /**
     */
    private final PresensiController controller;
    public String nim_baru = "0";
    public PresensiView(String nim, String tingkat, String prodi, String akses) {
        //D-III Statistika
        //D-IV Statistika
        //D-IV Komputasi Statistika
        
        nim_baru = nim;
        initComponents();
        if(akses == null){
            JOptionPane.showMessageDialog(null, "Login Terlebih Dahulu");
            System.exit(0);
        }
        if (tingkat.equals("1") && prodi.equals("D-III Statistika")) {
        String[] mapel = {
            "PPKn",
            "Statistika Matematika I",
            "Bahasa Inggris",
            "Pengantar Official Statistics",
            "Eksplorasi dan Visualisasi Data",
            "Pengantar Teknologi Informasi"
        };
        cmb_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(mapel));
    } else if (tingkat.equals("1") && prodi.equals("D-IV Statistika")) {
        String[] mapel = {
            "Bahasa Indonesia",
            "Statistika Matematika I",
            "Bahasa Inggris II",
            "Pengantar Official Statistics",
            "Eksplorasi dan Visualisasi Data",
            "Pengantar Ekonomi",
            "Algoritma dan Pemrograman"
        };
        cmb_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(mapel));
    } else if (tingkat.equals("1") && prodi.equals("D-IV Komputasi Statistik")) {
        String[] mapel = {
            "Bahasa Indonesia",
            "Statistika Matematika I",
            "Bahasa Inggris II",
            "Analisis Data Eksploratif",
            "Matematika Diskrit",
            "Pengantar Ekonomi",
            "Algoritma dan Pemrograman"
        };
        cmb_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(mapel));
    } else if (tingkat.equals("2") && prodi.equals("D-III Statistika")) {
        String[] mapel = {
            "Analisis Data Kategorik",
            "Official Statistics Lanjutan",
            "Pengendalian Kualitas Statistik",
            "Laboratorium Survei",
            "Analisis Regresi",
            "Manajemen Survei",
            "Teknik Penulisan Karya Ilmiah",
            "Komputasi Statistik"
        };
        cmb_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(mapel));
    } else if (tingkat.equals("2") && prodi.equals("D-IV Statistika")) {
        String[] mapel = {
            "Manajemen SDM dan Perkantoran",
            "Official Statistics Lanjutan",
            "Sistem Informasi Geografis",
            "Analisis Regresi",
            "Metode Penarikan Sampel Lanjutan",
            "Pengantar Sains Data",
            "Basis Data"
        };
        cmb_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(mapel));
    } else if (tingkat.equals("2") && prodi.equals("D-IV Komputasi Statistik")) {
        String[] mapel = {
            "Metode Numerik",
            "Pengantar Official Statistics",
            "Analisis Regresi",
            "Metode Survei",
            "Pemrograman Berorientasi Objek",
            "Pemrograman Berbasis Web",
            "Komputasi Statistik"
        };
        cmb_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(mapel));
    }
        if(nim.equals("0")){
            txt_nim.setEnabled(false);
            cmb_keterangan.setEnabled(false);
            jDateChooser1.setEnabled(false);
            btn_tambah.setEnabled(false);
            cmb_matkul.setEnabled(false);
        }else{
            btn_mahasiswa.setEnabled(false);
            btn_rekap.setEnabled(false);
        }
        txt_nim.setText(nim);
        controller = new PresensiController();
        showDataAbsensi();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_absensi = new javax.swing.JTable();
        cmb_keterangan = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        btn_rekap = new javax.swing.JButton();
        btn_mahasiswa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmb_matkul = new javax.swing.JComboBox<>();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Presensi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 120, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("NIM");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 40, 20));

        txt_nim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nim.setEnabled(false);
        jPanel1.add(txt_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tanggal");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        btn_tambah.setBackground(new java.awt.Color(0, 0, 204));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 100, 40));

        tbl_absensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIM", "Keterangan", "Tanggal", "Mata Kuliah"
            }
        ));
        tbl_absensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_absensiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_absensi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 380, 350));

        cmb_keterangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_keterangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hadir", "Izin", "Sakit", "Alpha" }));
        jPanel1.add(cmb_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 230, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 230, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Keterangan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        btn_logout.setBackground(new java.awt.Color(0, 0, 204));
        btn_logout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel1.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 80, 30));

        btn_rekap.setBackground(new java.awt.Color(102, 204, 255));
        btn_rekap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_rekap.setForeground(new java.awt.Color(255, 255, 255));
        btn_rekap.setText("Rekap Presensi");
        btn_rekap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rekapActionPerformed(evt);
            }
        });
        jPanel1.add(btn_rekap, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 130, 30));

        btn_mahasiswa.setBackground(new java.awt.Color(102, 204, 255));
        btn_mahasiswa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_mahasiswa.setForeground(new java.awt.Color(255, 255, 255));
        btn_mahasiswa.setText("Data Mahasiswa");
        btn_mahasiswa.setBorder(null);
        btn_mahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mahasiswaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mahasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Matkul");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cmb_matkul.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(cmb_matkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 230, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg.jpg"))); // NOI18N
        bg.setText("jLabel1");
        bg.setPreferredSize(new java.awt.Dimension(626, 438));
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String nim = txt_nim.getText();
        String keterangan = (String) cmb_keterangan.getSelectedItem();
        String matkul = (String) cmb_matkul.getSelectedItem();
        Date tanggal = jDateChooser1.getDate();
        
        if (nim.isEmpty() || tanggal == null) {
            JOptionPane.showMessageDialog(this, "NIM dan Tanggal harus diisi!");
            return;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalString = sdf.format(tanggal);
        
        Presensi absensi = new Presensi(nim, tanggalString, keterangan, matkul);
        
//        controller.addAbsensi(absensi);
        String ada_data = controller.checkAbsensi(absensi);
        if(ada_data.equals("Data ada")){
            JOptionPane.showMessageDialog(this, "Kamu telah melakukan absensi!");
        }else{
            controller.addAbsensi(absensi);
        }
        showDataAbsensi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tbl_absensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_absensiMouseClicked
    
    }//GEN-LAST:event_tbl_absensiMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed
private void printTable(JTable table, String title) {
    try {
        boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(title), null);
        if (complete) {
            JOptionPane.showMessageDialog(null, "Printing Complete", "Printing Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Printing Cancelled", "Printing Result", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (PrinterException pe) {
        JOptionPane.showMessageDialog(null, "Printing Failed: " + pe.getMessage(), "Printing Result", JOptionPane.ERROR_MESSAGE);
    }
}
    private void btn_rekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rekapActionPerformed
        printTable(tbl_absensi, "Data Absensi");
    }//GEN-LAST:event_btn_rekapActionPerformed

    private void btn_mahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mahasiswaActionPerformed
        new MahasiswaView("1").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_mahasiswaActionPerformed
    public void showDataAbsensi() {
        List<Presensi> listAbsensi = null;
        if(nim_baru.equals("0")){
            listAbsensi = controller.getAllAbsensi();
        }else{
            listAbsensi = controller.getAbsensiByNIM(nim_baru);
        }
        DefaultTableModel model = (DefaultTableModel) tbl_absensi.getModel();
        model.setRowCount(0); // Clear table
        
        for (Presensi absensi : listAbsensi) {
            Object[] row = {absensi.getNim(), absensi.getKeterangan(), absensi.getTglAbsensi(),absensi.getMatkul()};
            model.addRow(row);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PresensiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresensiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresensiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresensiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresensiView("0", "0","0", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_mahasiswa;
    private javax.swing.JButton btn_rekap;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cmb_keterangan;
    private javax.swing.JComboBox<String> cmb_matkul;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_absensi;
    private javax.swing.JTextField txt_nim;
    // End of variables declaration//GEN-END:variables
}