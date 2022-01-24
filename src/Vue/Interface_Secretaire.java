/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Model.Connecter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Interface_Secretaire extends javax.swing.JFrame {

    public static boolean ajouterpatient = false;
    public static boolean modifierpatient = false;
    Connecter cont = new Connecter();//faire la connexion avec la bdd
    Statement stat;//il permet de faire des rqts sql
    ResultSet resu;//permet de recuperer un elt a partir de la bdd 
    DefaultTableModel modelAccueil = new DefaultTableModel();//une table vertuel pour acceuil
    DefaultTableModel modelAgenda = new DefaultTableModel();//une table vertuel pour agenda
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    int X, Y;

    public Interface_Secretaire() {
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
        panSelectionAgendaSec.setVisible(false);
        panAgendaSec.setVisible(false);
        //************************************************************************************************

        try {
            //remplir la jtable 
            stat = cont.connectbdd().createStatement();
            resu = stat.executeQuery("Select * from patient where DateRDV = '" + dateFormat.format(date) + "'");
            modelAccueil.addColumn("Nom");
            modelAccueil.addColumn("Prénom");
            modelAccueil.addColumn("Civilité");
            modelAccueil.addColumn("Date Naissance");
            modelAccueil.addColumn("Profession");
            modelAccueil.addColumn("N° portable");
            modelAccueil.addColumn("Adresse");
            modelAccueil.addColumn("Heure RDV");
            while (resu.next()) {
                modelAccueil.addRow(new Object[]{resu.getObject("nom_p"), resu.getObject("prenom_p"), resu.getObject("civ"), resu.getObject("dateN"), resu.getObject("profession"),
                    resu.getObject("num_tel"), resu.getObject("adresse"), resu.getObject("HeureRDV")});
            }
            tableRDVTodaySec.setModel(modelAccueil);

        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        //************************************************************************************************************
        try {

            stat = cont.connectbdd().createStatement();
            resu = stat.executeQuery("Select * from patient");
            modelAgenda.addColumn("ID");
            modelAgenda.addColumn("Nom");
            modelAgenda.addColumn("Prénom");
            modelAgenda.addColumn("Civilité");
            modelAgenda.addColumn("Date Naissance");
            modelAgenda.addColumn("Profession");
            modelAgenda.addColumn("N° portable");
            modelAgenda.addColumn("Adresse");
            modelAgenda.addColumn("Date RDV");
            modelAgenda.addColumn("Heure RDV");
            while (resu.next()) {
                modelAgenda.addRow(new Object[]{resu.getObject("id_pat"), resu.getObject("nom_p"), resu.getObject("prenom_p"), resu.getObject("civ"), resu.getObject("dateN"), resu.getObject("profession"),
                    resu.getObject("num_tel"), resu.getObject("adresse"), resu.getObject("DateRDV"), resu.getObject("HeureRDV")});
            }

            tabAgendaSec.setModel(modelAgenda);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panSecretaire = new javax.swing.JPanel();
        panDecoSec = new javax.swing.JPanel();
        lDecoSec = new javax.swing.JLabel();
        panSuperieurSec = new javax.swing.JPanel();
        tfRechercheSec = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lIconeSec = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lRechercheOphta = new javax.swing.JLabel();
        lActualiserOphta = new javax.swing.JLabel();
        panCentreSec = new javax.swing.JPanel();
        panAgendaSec = new javax.swing.JPanel();
        panTabAgendaSec = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabAgendaSec = new javax.swing.JTable();
        panMajAgendaSec = new javax.swing.JPanel();
        lModifierRdvSec = new javax.swing.JLabel();
        lSupprimerRdvSec = new javax.swing.JLabel();
        lAjouterRdvSec = new javax.swing.JLabel();
        panAccueilSec = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRDVTodaySec = new javax.swing.JTable();
        panCommunicationSec = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lEnvoyerSec = new javax.swing.JLabel();
        MsgPredefiniSec1 = new javax.swing.JCheckBox();
        MsgPredefiniSec2 = new javax.swing.JCheckBox();
        MsgPredefiniSec3 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMsgSec = new javax.swing.JTextArea();
        lAccueilSec = new javax.swing.JLabel();
        lAgendaSec = new javax.swing.JLabel();
        panSelectionAccueilSec = new javax.swing.JPanel();
        panSelectionAgendaSec = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panSecretaire.setBackground(new java.awt.Color(255, 255, 255));
        panSecretaire.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panDecoSec.setBackground(new java.awt.Color(0, 102, 153));
        panDecoSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDecoSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/exit.PNG"))); // NOI18N
        lDecoSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lDecoSecMouseMoved(evt);
            }
        });
        lDecoSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDecoSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lDecoSecMouseExited(evt);
            }
        });
        panDecoSec.add(lDecoSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 40, 40));

        panSecretaire.add(panDecoSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 40, 90));

        panSuperieurSec.setBackground(new java.awt.Color(0, 0, 51));
        panSuperieurSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfRechercheSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRechercheSecActionPerformed(evt);
            }
        });
        panSuperieurSec.add(tfRechercheSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 500, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/logo.png"))); // NOI18N
        panSuperieurSec.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, -1));

        lIconeSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/secretaire_mini.png"))); // NOI18N
        panSuperieurSec.add(lIconeSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, -1, 70));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panSuperieurSec.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 30, 10));

        lRechercheOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/rechercher.PNG"))); // NOI18N
        lRechercheOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lRechercheOphtaMouseMoved(evt);
            }
        });
        lRechercheOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lRechercheOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lRechercheOphtaMouseExited(evt);
            }
        });
        panSuperieurSec.add(lRechercheOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 30, 30));

        lActualiserOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/actualiser_der.PNG"))); // NOI18N
        lActualiserOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lActualiserOphtaMouseMoved(evt);
            }
        });
        lActualiserOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lActualiserOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lActualiserOphtaMouseExited(evt);
            }
        });
        panSuperieurSec.add(lActualiserOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 30, 30));

        panSecretaire.add(panSuperieurSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 70));

        panCentreSec.setBackground(new java.awt.Color(204, 204, 204));
        panCentreSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panAgendaSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTabAgendaSec.setBackground(new java.awt.Color(153, 153, 153));
        panTabAgendaSec.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        panTabAgendaSec.setOpaque(false);
        panTabAgendaSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabAgendaSec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabAgendaSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabAgendaSecMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tabAgendaSec);

        panTabAgendaSec.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 860, 510));

        panAgendaSec.add(panTabAgendaSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 880, 530));

        panMajAgendaSec.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mise à jour :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        panMajAgendaSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lModifierRdvSec.setBackground(new java.awt.Color(0, 0, 51));
        lModifierRdvSec.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lModifierRdvSec.setForeground(new java.awt.Color(0, 0, 51));
        lModifierRdvSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/rdv_modifier_final_f.png"))); // NOI18N
        lModifierRdvSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lModifierRdvSecMouseMoved(evt);
            }
        });
        lModifierRdvSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lModifierRdvSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lModifierRdvSecMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lModifierRdvSecMousePressed(evt);
            }
        });
        panMajAgendaSec.add(lModifierRdvSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, 70));

        lSupprimerRdvSec.setBackground(new java.awt.Color(0, 0, 51));
        lSupprimerRdvSec.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lSupprimerRdvSec.setForeground(new java.awt.Color(0, 0, 51));
        lSupprimerRdvSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/rdv_supprimer_final_final_final.png"))); // NOI18N
        lSupprimerRdvSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lSupprimerRdvSecMouseMoved(evt);
            }
        });
        lSupprimerRdvSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lSupprimerRdvSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lSupprimerRdvSecMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lSupprimerRdvSecMousePressed(evt);
            }
        });
        panMajAgendaSec.add(lSupprimerRdvSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, 70));

        lAjouterRdvSec.setBackground(new java.awt.Color(0, 0, 51));
        lAjouterRdvSec.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lAjouterRdvSec.setForeground(new java.awt.Color(0, 0, 51));
        lAjouterRdvSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/rdv_ajouter_final.f.png"))); // NOI18N
        lAjouterRdvSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lAjouterRdvSecMouseMoved(evt);
            }
        });
        lAjouterRdvSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAjouterRdvSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAjouterRdvSecMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lAjouterRdvSecMousePressed(evt);
            }
        });
        panMajAgendaSec.add(lAjouterRdvSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 70, 70));

        panAgendaSec.add(panMajAgendaSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 130));

        panCentreSec.add(panAgendaSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 670));

        panAccueilSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rendez-vous du jour :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableRDVTodaySec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRDVTodaySec.setEnabled(false);
        jScrollPane1.setViewportView(tableRDVTodaySec);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 19, 870, 630));

        panAccueilSec.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 660));

        panCentreSec.add(panAccueilSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 670));

        panCommunicationSec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Communication :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("  Envoyer");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 60, 20));

        lEnvoyerSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/communication_final.png"))); // NOI18N
        lEnvoyerSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lEnvoyerSecMouseMoved(evt);
            }
        });
        lEnvoyerSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEnvoyerSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lEnvoyerSecMouseExited(evt);
            }
        });
        jPanel5.add(lEnvoyerSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 60, 70));

        MsgPredefiniSec1.setText("Un appel vous est destiné.");
        jPanel5.add(MsgPredefiniSec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        MsgPredefiniSec2.setText("Un patient demande à vous voir.");
        MsgPredefiniSec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsgPredefiniSec2ActionPerformed(evt);
            }
        });
        jPanel5.add(MsgPredefiniSec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        MsgPredefiniSec3.setText("Message prédifini");
        MsgPredefiniSec3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsgPredefiniSec3ActionPerformed(evt);
            }
        });
        jPanel5.add(MsgPredefiniSec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, -1));

        panCommunicationSec.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 310, 130));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taMsgSec.setColumns(20);
        taMsgSec.setRows(5);
        taMsgSec.setToolTipText("");
        jScrollPane2.setViewportView(taMsgSec);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 500));

        panCommunicationSec.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 146, 310, 530));

        panCentreSec.add(panCommunicationSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 320, 670));

        panSecretaire.add(panCentreSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 78, 1200, 670));

        lAccueilSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/accueil_text.PNG"))); // NOI18N
        lAccueilSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lAccueilSecMouseMoved(evt);
            }
        });
        lAccueilSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAccueilSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAccueilSecMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lAccueilSecMousePressed(evt);
            }
        });
        lAccueilSec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lAccueilSecKeyPressed(evt);
            }
        });
        panSecretaire.add(lAccueilSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 150));

        lAgendaSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/agenda_text.PNG"))); // NOI18N
        lAgendaSec.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lAgendaSecMouseMoved(evt);
            }
        });
        lAgendaSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAgendaSecMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAgendaSecMouseExited(evt);
            }
        });
        panSecretaire.add(lAgendaSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 100, -1));

        javax.swing.GroupLayout panSelectionAccueilSecLayout = new javax.swing.GroupLayout(panSelectionAccueilSec);
        panSelectionAccueilSec.setLayout(panSelectionAccueilSecLayout);
        panSelectionAccueilSecLayout.setHorizontalGroup(
            panSelectionAccueilSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        panSelectionAccueilSecLayout.setVerticalGroup(
            panSelectionAccueilSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        panSecretaire.add(panSelectionAccueilSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 10, 320));

        javax.swing.GroupLayout panSelectionAgendaSecLayout = new javax.swing.GroupLayout(panSelectionAgendaSec);
        panSelectionAgendaSec.setLayout(panSelectionAgendaSecLayout);
        panSelectionAgendaSecLayout.setHorizontalGroup(
            panSelectionAgendaSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        panSelectionAgendaSecLayout.setVerticalGroup(
            panSelectionAgendaSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        panSecretaire.add(panSelectionAgendaSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panSecretaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panSecretaire, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lDecoSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDecoSecMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lDecoSecMouseMoved

    private void lDecoSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDecoSecMouseClicked
        int quitter = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment vous déconnecter?", "Confirmation ", JOptionPane.YES_NO_OPTION);
        if (quitter == 0) {
            dispose();
            new Authentification().setVisible(true);

        }
    }//GEN-LAST:event_lDecoSecMouseClicked

    private void lDecoSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDecoSecMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lDecoSecMouseExited

    private void tfRechercheSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRechercheSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRechercheSecActionPerformed

    private void lEnvoyerSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEnvoyerSecMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lEnvoyerSecMouseMoved

    private void lEnvoyerSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEnvoyerSecMouseClicked
        int confirmation = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment envoyez le message !", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == 0) {
            if (MsgPredefiniSec1.isSelected()) {
                taMsgSec.setText(taMsgSec.getText() + MsgPredefiniSec1.getText() + "\n");
                MsgPredefiniSec1.setSelected(false);
            }
            if (MsgPredefiniSec2.isSelected()) {
                taMsgSec.setText(taMsgSec.getText() + MsgPredefiniSec2.getText() + "\n");
                MsgPredefiniSec2.setSelected(false);
            }

        }
    }//GEN-LAST:event_lEnvoyerSecMouseClicked

    private void lEnvoyerSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEnvoyerSecMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lEnvoyerSecMouseExited

    private void MsgPredefiniSec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsgPredefiniSec2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MsgPredefiniSec2ActionPerformed

    private void MsgPredefiniSec3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsgPredefiniSec3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MsgPredefiniSec3ActionPerformed

    private void lAccueilSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilSecMouseMoved
        setCursor(HAND_CURSOR);        // TODO add your handling code here:
    }//GEN-LAST:event_lAccueilSecMouseMoved

    private void lAccueilSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilSecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lAccueilSecMouseClicked

    private void lAccueilSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilSecMouseExited
        setCursor(DEFAULT_CURSOR);        // TODO add your handling code here:
    }//GEN-LAST:event_lAccueilSecMouseExited

    private void lAccueilSecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilSecMousePressed
        panSelectionAccueilSec.setVisible(true);
        panAccueilSec.setVisible(true);

        panAgendaSec.setVisible(false);

        panSelectionAgendaSec.setVisible(false);

    }//GEN-LAST:event_lAccueilSecMousePressed

    private void lAccueilSecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lAccueilSecKeyPressed


    }//GEN-LAST:event_lAccueilSecKeyPressed

    private void lAgendaSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAgendaSecMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lAgendaSecMouseMoved

    private void lAgendaSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAgendaSecMouseClicked
        panSelectionAccueilSec.setVisible(false);
        panAccueilSec.setVisible(false);

        panAgendaSec.setVisible(true);

        panSelectionAgendaSec.setVisible(true);
    }//GEN-LAST:event_lAgendaSecMouseClicked

    private void lAgendaSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAgendaSecMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lAgendaSecMouseExited

    private void lAjouterRdvSecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvSecMousePressed

    }//GEN-LAST:event_lAjouterRdvSecMousePressed

    private void lModifierRdvSecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierRdvSecMousePressed

    }//GEN-LAST:event_lModifierRdvSecMousePressed

    private void tabAgendaSecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabAgendaSecMousePressed

    }//GEN-LAST:event_tabAgendaSecMousePressed

    private void lSupprimerRdvSecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSupprimerRdvSecMousePressed

    }//GEN-LAST:event_lSupprimerRdvSecMousePressed

    private void lSupprimerRdvSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSupprimerRdvSecMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lSupprimerRdvSecMouseMoved

    private void lSupprimerRdvSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSupprimerRdvSecMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lSupprimerRdvSecMouseExited

    private void lAjouterRdvSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvSecMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lAjouterRdvSecMouseMoved

    private void lAjouterRdvSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvSecMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lAjouterRdvSecMouseExited

    private void lModifierRdvSecMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierRdvSecMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lModifierRdvSecMouseMoved

    private void lModifierRdvSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierRdvSecMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lModifierRdvSecMouseExited

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
       setExtendedState(JFrame.ICONIFIED);
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void lRechercheOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRechercheOphtaMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lRechercheOphtaMouseMoved

    private void lRechercheOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRechercheOphtaMouseClicked

    }//GEN-LAST:event_lRechercheOphtaMouseClicked

    private void lRechercheOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRechercheOphtaMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lRechercheOphtaMouseExited

    private void lActualiserOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lActualiserOphtaMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lActualiserOphtaMouseMoved

    private void lActualiserOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lActualiserOphtaMouseClicked
        tfRechercheSec.setText(null);
    }//GEN-LAST:event_lActualiserOphtaMouseClicked

    private void lActualiserOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lActualiserOphtaMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lActualiserOphtaMouseExited

    private void lAjouterRdvSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvSecMouseClicked
        ajouterpatient = true;
        
        new Fiche_Personnelle().setVisible(true);
        Fiche_Personnelle.mr.setSelected(true);

    }//GEN-LAST:event_lAjouterRdvSecMouseClicked

    private void lModifierRdvSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierRdvSecMouseClicked
        if (Interface_Secretaire.tabAgendaSec.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner une ligne ");

        } else {

            int conf = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment effectuer des modification sur ce patient !", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
            if (conf == 0) {
                modifierpatient = true;
                new Fiche_Personnelle().setVisible(true);

            }
        }
    }//GEN-LAST:event_lModifierRdvSecMouseClicked

    private void lSupprimerRdvSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSupprimerRdvSecMouseClicked
        if (tabAgendaSec.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner une ligne ");
        } else {
            int conf = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer ce patient !", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
            if (conf == 0) {
                try {
                    stat = cont.connectbdd().createStatement();
                    stat.executeUpdate("Delete from patient where id_pat='" + tabAgendaSec.getValueAt(tabAgendaSec.getSelectedRow(), 0) + "'");
                    Fiche_Personnelle f_p = new Fiche_Personnelle();
                    f_p.actualiserAgendasecretaire();
                    f_p.actuliseraccueilSecretaire();
                    JOptionPane.showMessageDialog(this, "suppression confirmé");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }

    }//GEN-LAST:event_lSupprimerRdvSecMouseClicked

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_jPanel1MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface_Secretaire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox MsgPredefiniSec1;
    private javax.swing.JCheckBox MsgPredefiniSec2;
    private javax.swing.JCheckBox MsgPredefiniSec3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lAccueilSec;
    private javax.swing.JLabel lActualiserOphta;
    private javax.swing.JLabel lAgendaSec;
    private javax.swing.JLabel lAjouterRdvSec;
    private javax.swing.JLabel lDecoSec;
    private javax.swing.JLabel lEnvoyerSec;
    private javax.swing.JLabel lIconeSec;
    private javax.swing.JLabel lModifierRdvSec;
    private javax.swing.JLabel lRechercheOphta;
    private javax.swing.JLabel lSupprimerRdvSec;
    private javax.swing.JPanel panAccueilSec;
    private javax.swing.JPanel panAgendaSec;
    private javax.swing.JPanel panCentreSec;
    private javax.swing.JPanel panCommunicationSec;
    private javax.swing.JPanel panDecoSec;
    private javax.swing.JPanel panMajAgendaSec;
    private javax.swing.JPanel panSecretaire;
    private javax.swing.JPanel panSelectionAccueilSec;
    private javax.swing.JPanel panSelectionAgendaSec;
    private javax.swing.JPanel panSuperieurSec;
    private javax.swing.JPanel panTabAgendaSec;
    private javax.swing.JTextArea taMsgSec;
    public static javax.swing.JTable tabAgendaSec;
    public static javax.swing.JTable tableRDVTodaySec;
    private javax.swing.JTextField tfRechercheSec;
    // End of variables declaration//GEN-END:variables
}
