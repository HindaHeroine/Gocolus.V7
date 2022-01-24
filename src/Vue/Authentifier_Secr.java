/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Model.Connect_ophtalmo;
import Model.Connect_secretaire;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC MC
 */
public class Authentifier_Secr extends javax.swing.JFrame {

    int X, Y;

    public Authentifier_Secr() {
        initComponents();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                X = e.getX();
                Y = e.getY();
            }

        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                int depX = e.getX() - X;
                int depY = e.getY() - Y;
                setLocation(getX() + depX, getY() + depY);
            }
        });
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        panQuitterAuthSec = new javax.swing.JPanel();
        lQuitterAuthSec = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        mdpsecretaire = new javax.swing.JPasswordField();
        bConnexionSec = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panQuitterAuthSec.setBackground(new java.awt.Color(0, 102, 153));
        panQuitterAuthSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lQuitterAuthSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/x.png"))); // NOI18N
        lQuitterAuthSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lQuitterAuthSecMouseMoved(evt);
            }
        });
        lQuitterAuthSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lQuitterAuthSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lQuitterAuthSecMouseExited(evt);
            }
        });
        panQuitterAuthSec.add(lQuitterAuthSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, 30));

        jPanel7.add(panQuitterAuthSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 40, 100));

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mdpsecretaire.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mdpsecretaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdpsecretaireActionPerformed(evt);
            }
        });
        mdpsecretaire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mdpsecretaireKeyPressed(evt);
            }
        });
        jPanel4.add(mdpsecretaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 240, 30));

        bConnexionSec.setText("Connexion");
        bConnexionSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConnexionSecActionPerformed(evt);
            }
        });
        jPanel4.add(bConnexionSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 100, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/secretaire.PNG"))); // NOI18N
        jPanel6.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 290));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 390));

        jPanel7.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 390, 410));

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/logonegh_1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 490));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lQuitterAuthSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterAuthSecMouseClicked
        new Authentification().setVisible(true);
        dispose();
    }//GEN-LAST:event_lQuitterAuthSecMouseClicked

    private void bConnexionSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConnexionSecActionPerformed
        connecter();
    }//GEN-LAST:event_bConnexionSecActionPerformed

    private void mdpsecretaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdpsecretaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mdpsecretaireActionPerformed

    private void lQuitterAuthSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterAuthSecMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lQuitterAuthSecMouseMoved

    private void lQuitterAuthSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterAuthSecMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lQuitterAuthSecMouseExited

    private void mdpsecretaireKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mdpsecretaireKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            connecter();
        }
    }//GEN-LAST:event_mdpsecretaireKeyPressed
    public void connecter() {
        Connect_secretaire csecr = new Connect_secretaire();
        boolean trouve = false;
        try {
            while (csecr.rs.next()) {
                if (mdpsecretaire.getText().equals(csecr.rs.getObject("mdp"))) {
                    trouve = true;
                    break;
                }
            }
            if (trouve) {
                new Interface_Secretaire().setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Mot de passe incorrect.");
                mdpsecretaire.setText(null);
                mdpsecretaire.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Authentifier_Ophtalmo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentifier_Secr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConnexionSec;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lQuitterAuthSec;
    private javax.swing.JPasswordField mdpsecretaire;
    private javax.swing.JPanel panQuitterAuthSec;
    // End of variables declaration//GEN-END:variables
}
