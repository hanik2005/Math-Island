package backend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import javax.swing.JOptionPane;
import main.Main;


public class Form extends javax.swing.JFrame implements KeyListener {

    public Form() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.nameTxtField.addKeyListener(this);
        this.pwdTxtField.addKeyListener(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nameTxtField = new javax.swing.JTextField();
        pwdTxtField = new javax.swing.JPasswordField();
        loginBttn = new javax.swing.JButton();
        registerBttn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        playingGuest = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        forgotPwdBttn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);
        jPanel2.add(nameTxtField);
        nameTxtField.setBounds(50, 230, 156, 22);
        jPanel2.add(pwdTxtField);
        pwdTxtField.setBounds(50, 300, 156, 22);

        loginBttn.setText("Login");
        loginBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBttnActionPerformed(evt);
            }
        });
        jPanel2.add(loginBttn);
        loginBttn.setBounds(60, 340, 130, 30);

        registerBttn.setText("Register");
        registerBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBttnActionPerformed(evt);
            }
        });
        jPanel2.add(registerBttn);
        registerBttn.setBounds(60, 380, 130, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(100, 160, 50, 30);

        playingGuest.setText("Playing as Guest");
        playingGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playingGuestActionPerformed(evt);
            }
        });
        jPanel2.add(playingGuest);
        playingGuest.setBounds(60, 460, 130, 30);

        jLabel3.setText("Username");
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(50, 210, 80, 16);

        jLabel4.setText("Game_Password");
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(50, 280, 110, 16);

        forgotPwdBttn1.setText("Forgot Pass ?");
        forgotPwdBttn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPwdBttn1ActionPerformed(evt);
            }
        });
        jPanel2.add(forgotPwdBttn1);
        forgotPwdBttn1.setBounds(60, 420, 130, 30);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 240, 580));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/Background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -270, 1280, 1120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBttnActionPerformed
       // TODO add your handling code here:
        String url = "jdbc:mysql://localhost:3306/math_login";
        String username = "root";
        String password = "";
        String name = nameTxtField.getText();
        String pwd = pwdTxtField.getText();
        int attempts = 0;
        if (!nameTxtField.getText().equals("") && !pwdTxtField.getText().equals("")) {
             try {
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? and Game_Password = ? ");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, pwd);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Enjoy the game!");
                     UserData userData = new UserData(); // Create an instance of UserData
                    userData.setUserName(name);
                    nameTxtField.setText("");
                    pwdTxtField.setText("");
                    Main.runTheProgram();
                    
                    this.hide();
                } else {
                    JOptionPane.showMessageDialog(null, "This user is not registered");
                    nameTxtField.setText("");
                    pwdTxtField.setText("");
                }
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Failed to connect to the database. Please make sure your database server is running.If no server play as a Guest");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have to input something in both fields");
        } 
       
    }//GEN-LAST:event_loginBttnActionPerformed

    private void registerBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBttnActionPerformed
//        // TODO add your handling code here:
//        RegistrationForm regForm = new RegistrationForm();
//        regForm.setVisible(true);
//        regForm.setLocationRelativeTo(null);
//        this.hide();
   try {
        Runtime.getRuntime().exec("cmd /c start chrome http://localhost/Math%20Island%20Website/phpHtml/index.php");
    } catch (java.io.IOException e) {
        System.out.println(e.getMessage());
    }

    }//GEN-LAST:event_registerBttnActionPerformed

    private void playingGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playingGuestActionPerformed
//        // TODO add your handling code here:
//        UpdatePassForm updatePwdForm = new UpdatePassForm();
//        updatePwdForm.setVisible(true);
//        updatePwdForm.setLocationRelativeTo(null);
//        this.dispose();
JOptionPane.showMessageDialog(null, "Enjoy the game!");
Main.runTheProgram();
 this.hide();
  

    }//GEN-LAST:event_playingGuestActionPerformed

    private void forgotPwdBttn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPwdBttn1ActionPerformed
        // TODO add your handling code here:
        try {
        Runtime.getRuntime().exec("cmd /c start chrome http://localhost/Math%20Island%20Website/phpHtml/gamePassword.php");
    } catch (java.io.IOException e) {
        System.out.println(e.getMessage());
        
    }
    }//GEN-LAST:event_forgotPwdBttn1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotPwdBttn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginBttn;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JButton playingGuest;
    private javax.swing.JPasswordField pwdTxtField;
    private javax.swing.JButton registerBttn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            loginBttnActionPerformed(null);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
