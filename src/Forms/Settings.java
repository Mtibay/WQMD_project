/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author t-bye-
 */
public class Settings extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
        changelocationpanel.setVisible(false);
        conn=MyConnection.ConnectDB();
        getLoc();
        verifyloc();
    }
    
    public void UpdateLogin(){
            String pass = txtConfirmpass.getText();
        try{
            java.sql.Statement st = conn.createStatement();
            conn=MyConnection.ConnectDB();
            st = conn.createStatement();
            String SQL = "UPDATE login SET passcode = '"+pass+"' WHERE id = 1";
            String ver = "SELECT * FROM login";
            rs = st.executeQuery(ver);
            while(rs.next()){
                String passco = rs.getString("passcode");
                    if (txtOldpass.getText() .equals(passco)){
                        if (txtNewpass.getText().equals(txtConfirmpass.getText())){
                            pst = conn.prepareStatement(SQL);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "passcode updated!");
                            dispose();
                        }
                        else{
                            txtOldpass.setText("");
                            txtNewpass.setText("");
                            txtConfirmpass.setText("");
                            JOptionPane.showMessageDialog(null, "New password and confirm password did not match!","error", JOptionPane.WARNING_MESSAGE);        
                        }
                    }
                    else {
                        txtOldpass.setText("");
                        txtNewpass.setText("");
                        txtConfirmpass.setText("");
                        JOptionPane.showMessageDialog(null, "Current Password did not match!","error", JOptionPane.WARNING_MESSAGE);
                    }
                        
            }
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Catch!");
        }
    }
    public void getLoc(){
        String locname = txtLocation.getText();
        try{
            java.sql.Statement st = conn.createStatement();
            conn=MyConnection.ConnectDB();
            st = conn.createStatement();
            String loc = "SELECT * FROM location";
            rs = st.executeQuery(loc);
            while(rs.next()) {
                String locc = rs.getString("loc_name");
                txtLocation.setText(locc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void UpdateLoc(){
        String locname = txtLocation.getText();
        try {
            java.sql.Statement st = conn.createStatement();
            conn=MyConnection.ConnectDB();
            st = conn.createStatement();
            String sql1 = "SELECT loc_id FROM location WHERE loc_id = 1";
            rs = st.executeQuery(sql1);
            if(rs != null && rs.next()){
                btninsert.setVisible(false);
                String sql = "Update location SET loc_name = '"+locname+"' Where loc_id = 1";
                if(txtLocation.getText().length() > 1){
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Location Updated!");
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please specify the location text","", JOptionPane.WARNING_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No default location yet, please insert default location first","",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void InsertLoc(){
        String locname = txtLocation.getText();
        try {
            java.sql.Statement st = conn.createStatement();
            conn=MyConnection.ConnectDB();
            st = conn.createStatement();
            String sql1 = "SELECT loc_id FROM location WHERE loc_id = 1";
            rs = st.executeQuery(sql1);
            if(rs != null && rs.next()){
             JOptionPane.showMessageDialog(null, "No default location yet, please insert default location first","",JOptionPane.WARNING_MESSAGE);   
            }
            else
            {
                String sql = "INSERT INTO location (loc_id, loc_name) VALUES(?,?)";
                if(txtLocation.getText().length() > 1){
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, "1");
                    pst.setString(2, txtLocation.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Location added!");
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please specify the location text","", JOptionPane.WARNING_MESSAGE);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void verifyloc(){
        String locname = txtLocation.getText();
        try {
            java.sql.Statement st = conn.createStatement();
            conn=MyConnection.ConnectDB();
            st = conn.createStatement();
            String sql1 = "SELECT loc_id FROM location WHERE loc_id = 1";
            rs = st.executeQuery(sql1);
            if(rs != null && rs.next()){
                btninsert.setVisible(false);
                btnupdate.setVisible(true);
            }
            else
            {
                btninsert.setVisible(true);
                btnupdate.setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changepass = new javax.swing.JLabel();
        changeloc = new javax.swing.JLabel();
        changepasspanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtConfirmpass = new javax.swing.JPasswordField();
        txtNewpass = new javax.swing.JPasswordField();
        txtOldpass = new javax.swing.JPasswordField();
        changelocationpanel = new javax.swing.JPanel();
        btninsert = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtLocation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        changepass.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        changepass.setForeground(new java.awt.Color(0, 0, 204));
        changepass.setText("Change Location");
        changepass.setToolTipText("");
        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changepassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changepassMouseReleased(evt);
            }
        });
        getContentPane().add(changepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 120, 20));

        changeloc.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        changeloc.setForeground(new java.awt.Color(0, 0, 204));
        changeloc.setText("Change Password");
        changeloc.setToolTipText("");
        changeloc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changelocMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changelocMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changelocMouseReleased(evt);
            }
        });
        getContentPane().add(changeloc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, 20));

        changepasspanel.setBackground(new java.awt.Color(0, 0, 102));
        changepasspanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        changepasspanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 70, -1));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        changepasspanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Password:");
        changepasspanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Current password:");
        changepasspanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("New Password:");
        changepasspanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        changepasspanel.add(txtConfirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 140, -1));

        txtNewpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewpassActionPerformed(evt);
            }
        });
        changepasspanel.add(txtNewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        txtOldpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOldpassActionPerformed(evt);
            }
        });
        changepasspanel.add(txtOldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 140, -1));

        getContentPane().add(changepasspanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 30, 340, 200));

        changelocationpanel.setBackground(new java.awt.Color(0, 0, 102));
        changelocationpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninsert.setText("Insert Location ");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });
        changelocationpanel.add(btninsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 150, -1));

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        changelocationpanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        txtLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationActionPerformed(evt);
            }
        });
        changelocationpanel.add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Current Location");
        changelocationpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        btnupdate.setText("Update Location Value");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        changelocationpanel.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 150, -1));

        getContentPane().add(changelocationpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 310, 200));

        setSize(new java.awt.Dimension(329, 269));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseClicked
        changelocationpanel.setVisible(true);
        changepasspanel.setVisible(false);
    }//GEN-LAST:event_changepassMouseClicked

    private void changepassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMousePressed

    }//GEN-LAST:event_changepassMousePressed

    private void changepassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseReleased

    }//GEN-LAST:event_changepassMouseReleased

    private void changelocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changelocMouseClicked
    changepasspanel.setVisible(true);
    changelocationpanel.setVisible(false);
    }//GEN-LAST:event_changelocMouseClicked

    private void changelocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changelocMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_changelocMousePressed

    private void changelocMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changelocMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_changelocMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UpdateLogin();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
    InsertLoc();
    }//GEN-LAST:event_btninsertActionPerformed

    private void txtLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationActionPerformed

    private void txtNewpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewpassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
    UpdateLoc();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtOldpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOldpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOldpassActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel changeloc;
    private javax.swing.JPanel changelocationpanel;
    private javax.swing.JLabel changepass;
    private javax.swing.JPanel changepasspanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtConfirmpass;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JPasswordField txtNewpass;
    private javax.swing.JPasswordField txtOldpass;
    // End of variables declaration//GEN-END:variables
}
