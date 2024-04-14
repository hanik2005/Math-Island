package backend;

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;

public class RegistrationForm extends javax.swing.JFrame implements KeyListener{

    public RegistrationForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.nameTxtField.addKeyListener(this);
        this.pwdTxtField.addKeyListener(this);
        this.recoveryCodeTxtField.addKeyListener(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameTxtField = new javax.swing.JTextField();
        pwdTxtField = new javax.swing.JPasswordField();
        registerBttn = new javax.swing.JButton();
        loginBttn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        recoveryCodeTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        nameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtFieldActionPerformed(evt);
            }
        });

        registerBttn.setText("Register");
        registerBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBttnActionPerformed(evt);
            }
        });

        loginBttn.setText("Login");
        loginBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBttnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Register");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Recovery Code");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pwdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)))
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(registerBttn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loginBttn))
                            .addComponent(recoveryCodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recoveryCodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBttn)
                    .addComponent(loginBttn))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 330, 290));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/BackgroundRegister.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 0, 890, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtFieldActionPerformed

    private void registerBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBttnActionPerformed
        // TODO add your handling code here:
        String url = "jdbc:mysql://localhost:3306/math_island_database";
          
        String username = "root";
        String password = "";
        String name = nameTxtField.getText().trim();
        String pwd = pwdTxtField.getText().trim();
        String recoveryCode = recoveryCodeTxtField.getText();
        String defaultCategory = "User";
        if (!nameTxtField.getText().equals("") && !pwdTxtField.getText().equals("")) {
            try {
               Connection connection = DriverManager.getConnection(url, username, password);
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE Name = ? ");
               preparedStatement.setString(1, name);
               ResultSet rs = preparedStatement.executeQuery();

               if (rs.next()) {
                   JOptionPane.showMessageDialog(null, "This username is already registered");
                   recoveryCodeTxtField.setText("");
                   nameTxtField.setText("");
                   pwdTxtField.setText("");
               } else {
                   if (recoveryCodeTxtField.getText().equals("")) {
                       int choice = JOptionPane.showConfirmDialog(null, "Are you sure you don't want to have a recovery code?, it would then be harder to change your password when you forgot it");
                     if (choice == 0) {
                        PreparedStatement preparedStatementInsert = connection.prepareStatement("INSERT INTO accounts (Name, Password, Category) VALUES (?, ?, ?)");
                        preparedStatementInsert.setString(1, name);
                        preparedStatementInsert.setString(2, pwd);
                        preparedStatementInsert.setString(3, defaultCategory);

                        int rows = preparedStatementInsert.executeUpdate();
                        nameTxtField.setText("");
                        pwdTxtField.setText("");
                        recoveryCodeTxtField.setText("");
                        JOptionPane.showMessageDialog(null, "You have successfully registered your account, please refer to the login page by clicking the login button below");
                        } else {
                         choice = 5;
                       }
                   } else {
                       PreparedStatement preparedStatementInsert = connection.prepareStatement("INSERT INTO accounts (Name, Password, Category, RecoveryCode) VALUES (?, ?, ?, ?)");
                        preparedStatementInsert.setString(1, name);
                        preparedStatementInsert.setString(2, pwd);
                        preparedStatementInsert.setString(3, defaultCategory);
                        preparedStatementInsert.setString(4, recoveryCode);

                        int rows = preparedStatementInsert.executeUpdate();
                        nameTxtField.setText("");
                        pwdTxtField.setText("");
                        recoveryCodeTxtField.setText("");
                        JOptionPane.showMessageDialog(null, "You have successfully registered your account, please refer to the login page by clicking the login button below");
                       
                   }
                                  }
               rs.close();
               preparedStatement.close();
               connection.close();
               System.out.println("Connection closed.");
           } catch (SQLException e) {
               e.printStackTrace();
           }
        } else {
            JOptionPane.showMessageDialog(null, "You have to input both fields to proceed");
            nameTxtField.setText("");
            pwdTxtField.setText("");
        }
     
    }//GEN-LAST:event_registerBttnActionPerformed

    private void loginBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBttnActionPerformed
        // TODO add your handling code here:
        Form loginPage = new Form();
        loginPage.setVisible(true);
        loginPage.setLocationRelativeTo(null);
        this.hide();
    }//GEN-LAST:event_loginBttnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBttn;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JPasswordField pwdTxtField;
    private javax.swing.JTextField recoveryCodeTxtField;
    private javax.swing.JButton registerBttn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            registerBttnActionPerformed(null);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
