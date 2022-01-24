package Vue;

import Model.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Authentifier_Ophtalmo extends javax.swing.JFrame {

    int X, Y;

    public Authentifier_Ophtalmo() {
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
        this.setLocationRelativeTo(null);

    }

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pan_tout = new javax.swing.JPanel();
        panQuitterAuthOphta = new javax.swing.JPanel();
        lQuitterAuthOphta = new javax.swing.JLabel();
        pan_haut_mini = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pan_centre = new javax.swing.JPanel();
        pan_centre1 = new javax.swing.JPanel();
        mdpophtalmologue = new javax.swing.JPasswordField();
        bConnexionOphta1 = new javax.swing.JButton();
        lopht_sec1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_tout.setBackground(new java.awt.Color(255, 255, 255));
        pan_tout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panQuitterAuthOphta.setBackground(new java.awt.Color(0, 102, 153));
        panQuitterAuthOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lQuitterAuthOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/x.png"))); // NOI18N
        lQuitterAuthOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lQuitterAuthOphtaMouseMoved(evt);
            }
        });
        lQuitterAuthOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lQuitterAuthOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lQuitterAuthOphtaMouseExited(evt);
            }
        });
        panQuitterAuthOphta.add(lQuitterAuthOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 20, 30));

        pan_tout.add(panQuitterAuthOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 40, 100));

        pan_haut_mini.setBackground(new java.awt.Color(0, 0, 51));
        pan_haut_mini.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/logonegh_1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        pan_haut_mini.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pan_tout.add(pan_haut_mini, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));

        pan_centre.setBackground(new java.awt.Color(0, 0, 51));
        pan_centre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pan_centre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_centre1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pan_centre1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mdpophtalmologue.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mdpophtalmologue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdpophtalmologueActionPerformed(evt);
            }
        });
        mdpophtalmologue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mdpophtalmologueKeyPressed(evt);
            }
        });
        pan_centre1.add(mdpophtalmologue, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 240, 30));

        bConnexionOphta1.setText("Connexion");
        bConnexionOphta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConnexionOphta1ActionPerformed(evt);
            }
        });
        bConnexionOphta1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bConnexionOphta1KeyPressed(evt);
            }
        });
        pan_centre1.add(bConnexionOphta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 100, -1));

        lopht_sec1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lopht_sec1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/ophtalmologue.png"))); // NOI18N
        pan_centre1.add(lopht_sec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 290));

        pan_centre.add(pan_centre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 390));

        pan_tout.add(pan_centre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 390, 410));

        jPanel3.add(pan_tout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 490));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lQuitterAuthOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterAuthOphtaMouseClicked
        dispose();
        new Authentification().setVisible(true);
    }//GEN-LAST:event_lQuitterAuthOphtaMouseClicked

    private void mdpophtalmologueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdpophtalmologueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mdpophtalmologueActionPerformed

    private void bConnexionOphta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConnexionOphta1ActionPerformed
        connecter();
    }//GEN-LAST:event_bConnexionOphta1ActionPerformed

    private void bConnexionOphta1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bConnexionOphta1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bConnexionOphta1KeyPressed

    private void lQuitterAuthOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterAuthOphtaMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lQuitterAuthOphtaMouseMoved

    private void lQuitterAuthOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterAuthOphtaMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lQuitterAuthOphtaMouseExited

    private void mdpophtalmologueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mdpophtalmologueKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            connecter();
        }
    }//GEN-LAST:event_mdpophtalmologueKeyPressed

    public void connecter() {
        Connect_ophtalmo cophta = new Connect_ophtalmo();
        boolean trouve = false;
        try {
            while (cophta.rs.next()) {
                if (mdpophtalmologue.getText().equals(cophta.rs.getObject("mdp"))) {
                    trouve = true;
                    break;
                }
            }
            if (trouve) {

                new Interface_ophtalmo().setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Mot de passe incorrect.");
                mdpophtalmologue.setText(null);
                mdpophtalmologue.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Authentifier_Ophtalmo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentifier_Ophtalmo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConnexionOphta1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lQuitterAuthOphta;
    private static javax.swing.JLabel lopht_sec1;
    private javax.swing.JPasswordField mdpophtalmologue;
    private javax.swing.JPanel panQuitterAuthOphta;
    private javax.swing.JPanel pan_centre;
    private javax.swing.JPanel pan_centre1;
    private javax.swing.JPanel pan_haut_mini;
    private javax.swing.JPanel pan_tout;
    // End of variables declaration//GEN-END:variables
}
