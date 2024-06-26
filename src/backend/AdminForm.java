/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package backend;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


/**
 *
 * @author Admin
 */
public class AdminForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     */
    public AdminForm() {
        initComponents();
        this.setSize(new Dimension(491, 363));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
        nameTxtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        banBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        nameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTxtField);
        nameTxtField.setBounds(160, 140, 140, 30);

        jLabel1.setText("Admin Form");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 90, 110, 40);

        banBttn.setText("BAN");
        banBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banBttnActionPerformed(evt);
            }
        });
        jPanel1.add(banBttn);
        banBttn.setBounds(190, 190, 76, 27);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 490, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtFieldActionPerformed

    private void banBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_banBttnActionPerformed
        // TODO add your handling code here:
        String url = "jdbc:mysql://localhost:3306/math_island_database";
        String username = "root";
        String password = "";
        String user = nameTxtField.getText();
        String sqlDeletionQuery = "DELETE FROM accounts WHERE Name = ?";
        String sqlSelectionQuery = "SELECT * FROM accounts WHERE Name = ?";
        
        if (!nameTxtField.getText().equals("")) {
            try {
                Connection conn = DriverManager.getConnection(url,username,password);
                PreparedStatement selectionStmt = conn.prepareStatement(sqlSelectionQuery);
                PreparedStatement deletionStmt = conn.prepareStatement(sqlDeletionQuery);

                selectionStmt.setString(1, user);
                ResultSet rs = selectionStmt.executeQuery();

                if(rs.next()) {
                    deletionStmt.setString(1, user);
                    int rowsDeleted = deletionStmt.executeUpdate();
                    nameTxtField.setText("");
                    JOptionPane.showMessageDialog(null, "You have successfully deleted this user in the database");
                } else {
                    nameTxtField.setText("");
                    JOptionPane.showMessageDialog(null, "Sorry, but that user doesn't exist in the database");
                }

                conn.close();
                selectionStmt.close();
                deletionStmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "You have to enter something");
            nameTxtField.setText("");
        }
     
    }//GEN-LAST:event_banBttnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton banBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTxtField;
    // End of variables declaration//GEN-END:variables
}
