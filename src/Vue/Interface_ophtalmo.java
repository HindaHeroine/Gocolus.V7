package Vue;

import Model.Connecter;
import static Vue.Interface_Secretaire.*;

import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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

public class Interface_ophtalmo extends javax.swing.JFrame {

    public static boolean ajouterpatient = false;
    public static boolean modifierpatient = false;
    Connecter cont = new Connecter();//faire la connexion avec la bdd
    Statement stat;//il permet de faire des rqts sql
    ResultSet resu;//permet de recuperer un elt a partir de la bdd 
    DefaultTableModel modelAccueil = new DefaultTableModel();//une table vertuel pour acceuil
    DefaultTableModel modelAgenda = new DefaultTableModel();
    DefaultTableModel modelPatient = new DefaultTableModel();//une table vertuel pour agenda

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    int X, Y;

    public Interface_ophtalmo() {
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
        lSelectionAgendaOphta.setVisible(false);
        panSelectionPatientOphta.setVisible(false);
        panPatientOphta.setVisible(false);
        panAgendaOphta.setVisible(false);
        try {
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
            tableRDVTodayOphta.setModel(modelAccueil);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            tabAgendaOphta.setModel(modelAgenda);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stat = cont.connectbdd().createStatement();
            resu = stat.executeQuery("Select * from patient");
            modelPatient.addColumn("ID");
            modelPatient.addColumn("Nom");
            modelPatient.addColumn("Prénom");
            modelPatient.addColumn("Civ");
            modelPatient.addColumn("Date Naissance");
            modelPatient.addColumn("Profession");
            modelPatient.addColumn("Numéro");
            modelPatient.addColumn("Adresse");
            modelPatient.addColumn("Date RDV");
            modelPatient.addColumn("Heure RDV");
             modelPatient.addColumn("Etat consultation");
            while (resu.next()) {
                modelPatient.addRow(new Object[]{resu.getObject("id_pat"), resu.getObject("nom_p"), resu.getObject("prenom_p"), resu.getObject("civ"), resu.getObject("dateN"), resu.getObject("profession"),
                    resu.getObject("num_tel"), resu.getObject("adresse"), resu.getObject("dateRDV"), resu.getObject("heureRDV"),resu.getObject("etatConsult")});
            }
            tabPatientOphta.setModel(modelPatient);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panOphtalmologue = new javax.swing.JPanel();
        panQuitterOphta = new javax.swing.JPanel();
        lQuitterOphta = new javax.swing.JLabel();
        panSuperieurOphta = new javax.swing.JPanel();
        tfRechercheOphta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lIconeOphta = new javax.swing.JLabel();
        lActualiserOphta = new javax.swing.JLabel();
        lRechercheOphta = new javax.swing.JLabel();
        panReduireOphta = new javax.swing.JPanel();
        panCentreOphta = new javax.swing.JPanel();
        panPatientOphta = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabPatientOphta = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panMajFicheMed = new javax.swing.JPanel();
        lAjouterFicheMed = new javax.swing.JLabel();
        lModifierFicheMed = new javax.swing.JLabel();
        lSuppFicheMed = new javax.swing.JLabel();
        lConsulterFicheMed = new javax.swing.JLabel();
        lReglementOphta = new javax.swing.JLabel();
        panAgendaOphta = new javax.swing.JPanel();
        panTabAgendaOphta = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabAgendaOphta = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lModifierrdvOphta = new javax.swing.JLabel();
        lSuppRdvOphta = new javax.swing.JLabel();
        lAjouterRdvOphta = new javax.swing.JLabel();
        panAccueilOphta = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRDVTodayOphta = new javax.swing.JTable();
        panCommunicationOphta = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lEnvoyerOphta = new javax.swing.JLabel();
        MsgPredefiniOphta1 = new javax.swing.JCheckBox();
        MsgPredefiniOphta2 = new javax.swing.JCheckBox();
        MsgPredefiniOphta3 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        panMsgOphta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMsgOphta = new javax.swing.JTextArea();
        lAccueilOphta = new javax.swing.JLabel();
        lAgendaOphta = new javax.swing.JLabel();
        lPatientOphta = new javax.swing.JLabel();
        panSelectionAcuueilOphta = new javax.swing.JPanel();
        panSelectionPatientOphta = new javax.swing.JPanel();
        lSelectionAgendaOphta = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panOphtalmologue.setBackground(new java.awt.Color(255, 255, 255));
        panOphtalmologue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panQuitterOphta.setBackground(new java.awt.Color(0, 102, 153));
        panQuitterOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lQuitterOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/exit.PNG"))); // NOI18N
        lQuitterOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lQuitterOphtaMouseMoved(evt);
            }
        });
        lQuitterOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lQuitterOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lQuitterOphtaMouseExited(evt);
            }
        });
        panQuitterOphta.add(lQuitterOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 40, 40));

        panOphtalmologue.add(panQuitterOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 40, 90));

        panSuperieurOphta.setBackground(new java.awt.Color(0, 0, 51));
        panSuperieurOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfRechercheOphta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRechercheOphtaActionPerformed(evt);
            }
        });
        panSuperieurOphta.add(tfRechercheOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 500, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/logo.png"))); // NOI18N
        panSuperieurOphta.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, -1));

        lIconeOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/ophtalmo_mini.png"))); // NOI18N
        panSuperieurOphta.add(lIconeOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, -1, 70));

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
        panSuperieurOphta.add(lActualiserOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 30, 30));

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
        panSuperieurOphta.add(lRechercheOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 30, 30));

        panReduireOphta.setBackground(new java.awt.Color(255, 255, 255));
        panReduireOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panReduireOphtaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panReduireOphtaLayout = new javax.swing.GroupLayout(panReduireOphta);
        panReduireOphta.setLayout(panReduireOphtaLayout);
        panReduireOphtaLayout.setHorizontalGroup(
            panReduireOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        panReduireOphtaLayout.setVerticalGroup(
            panReduireOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panSuperieurOphta.add(panReduireOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 30, 10));

        panOphtalmologue.add(panSuperieurOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 70));

        panCentreOphta.setBackground(new java.awt.Color(204, 204, 204));
        panCentreOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panPatientOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabPatientOphta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabPatientOphta);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 860, 510));

        jLabel15.setBackground(new java.awt.Color(0, 0, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 51));
        jLabel15.setText("Liste des patients :");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 40));
        jPanel8.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 700, 10));

        panPatientOphta.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 880, 530));

        panMajFicheMed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mise à jour des fiches médicales:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        panMajFicheMed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lAjouterFicheMed.setBackground(new java.awt.Color(0, 0, 51));
        lAjouterFicheMed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lAjouterFicheMed.setForeground(new java.awt.Color(0, 0, 51));
        lAjouterFicheMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/ajouter_pat.png"))); // NOI18N
        lAjouterFicheMed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lAjouterFicheMedMouseMoved(evt);
            }
        });
        lAjouterFicheMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAjouterFicheMedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAjouterFicheMedMouseExited(evt);
            }
        });
        panMajFicheMed.add(lAjouterFicheMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 70, 80));

        lModifierFicheMed.setBackground(new java.awt.Color(0, 0, 51));
        lModifierFicheMed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lModifierFicheMed.setForeground(new java.awt.Color(0, 0, 51));
        lModifierFicheMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/modifier_pat.png"))); // NOI18N
        lModifierFicheMed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lModifierFicheMedMouseMoved(evt);
            }
        });
        lModifierFicheMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lModifierFicheMedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lModifierFicheMedMouseExited(evt);
            }
        });
        panMajFicheMed.add(lModifierFicheMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 70, 80));

        lSuppFicheMed.setBackground(new java.awt.Color(0, 0, 51));
        lSuppFicheMed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lSuppFicheMed.setForeground(new java.awt.Color(0, 0, 51));
        lSuppFicheMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/supprimer_pat.png"))); // NOI18N
        lSuppFicheMed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lSuppFicheMedMouseMoved(evt);
            }
        });
        lSuppFicheMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lSuppFicheMedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lSuppFicheMedMouseExited(evt);
            }
        });
        panMajFicheMed.add(lSuppFicheMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 70, 80));

        lConsulterFicheMed.setBackground(new java.awt.Color(0, 0, 51));
        lConsulterFicheMed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lConsulterFicheMed.setForeground(new java.awt.Color(0, 0, 51));
        lConsulterFicheMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/consulter_pat.png"))); // NOI18N
        lConsulterFicheMed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lConsulterFicheMedMouseMoved(evt);
            }
        });
        lConsulterFicheMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lConsulterFicheMedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lConsulterFicheMedMouseExited(evt);
            }
        });
        panMajFicheMed.add(lConsulterFicheMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 70, 80));

        lReglementOphta.setBackground(new java.awt.Color(0, 0, 51));
        lReglementOphta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lReglementOphta.setForeground(new java.awt.Color(0, 0, 51));
        lReglementOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/reglement.final.final.png"))); // NOI18N
        lReglementOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lReglementOphtaMouseMoved(evt);
            }
        });
        lReglementOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lReglementOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lReglementOphtaMouseExited(evt);
            }
        });
        panMajFicheMed.add(lReglementOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 90, 80));

        panPatientOphta.add(panMajFicheMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 130));

        panCentreOphta.add(panPatientOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 660));

        panAgendaOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTabAgendaOphta.setBackground(new java.awt.Color(153, 153, 153));
        panTabAgendaOphta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        panTabAgendaOphta.setOpaque(false);
        panTabAgendaOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabAgendaOphta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabAgendaOphta);

        panTabAgendaOphta.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 860, 510));

        panAgendaOphta.add(panTabAgendaOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 880, 530));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mise à jour :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lModifierrdvOphta.setBackground(new java.awt.Color(0, 0, 51));
        lModifierrdvOphta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lModifierrdvOphta.setForeground(new java.awt.Color(0, 0, 51));
        lModifierrdvOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/rdv_modifier_final_f.png"))); // NOI18N
        lModifierrdvOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lModifierrdvOphtaMouseMoved(evt);
            }
        });
        lModifierrdvOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lModifierrdvOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lModifierrdvOphtaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lModifierrdvOphtaMousePressed(evt);
            }
        });
        jPanel3.add(lModifierrdvOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 70, 70));

        lSuppRdvOphta.setBackground(new java.awt.Color(0, 0, 51));
        lSuppRdvOphta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lSuppRdvOphta.setForeground(new java.awt.Color(0, 0, 51));
        lSuppRdvOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/rdv_supprimer_final_final_final.png"))); // NOI18N
        lSuppRdvOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lSuppRdvOphtaMouseMoved(evt);
            }
        });
        lSuppRdvOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lSuppRdvOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lSuppRdvOphtaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lSuppRdvOphtaMousePressed(evt);
            }
        });
        jPanel3.add(lSuppRdvOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 70, 70));

        lAjouterRdvOphta.setBackground(new java.awt.Color(0, 0, 51));
        lAjouterRdvOphta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lAjouterRdvOphta.setForeground(new java.awt.Color(0, 0, 51));
        lAjouterRdvOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/rdv_ajouter_final.f.png"))); // NOI18N
        lAjouterRdvOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lAjouterRdvOphtaMouseMoved(evt);
            }
        });
        lAjouterRdvOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAjouterRdvOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAjouterRdvOphtaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lAjouterRdvOphtaMousePressed(evt);
            }
        });
        jPanel3.add(lAjouterRdvOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 70, 70));

        panAgendaOphta.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 130));

        panCentreOphta.add(panAgendaOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 670));

        panAccueilOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rendez-vous du jour :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableRDVTodayOphta.setModel(new javax.swing.table.DefaultTableModel(
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
        tableRDVTodayOphta.setEnabled(false);
        jScrollPane1.setViewportView(tableRDVTodayOphta);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 29, 850, 620));

        panAccueilOphta.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 660));

        panCentreOphta.add(panAccueilOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 670));

        panCommunicationOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Communication :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lEnvoyerOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/communication_final.png"))); // NOI18N
        lEnvoyerOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lEnvoyerOphtaMouseMoved(evt);
            }
        });
        lEnvoyerOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEnvoyerOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lEnvoyerOphtaMouseExited(evt);
            }
        });
        jPanel5.add(lEnvoyerOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 60, 70));

        MsgPredefiniOphta1.setText("Faites entrer le patient suivant.");
        jPanel5.add(MsgPredefiniOphta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        MsgPredefiniOphta2.setText("Reportez le prochain rendez-vous.");
        MsgPredefiniOphta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsgPredefiniOphta2ActionPerformed(evt);
            }
        });
        jPanel5.add(MsgPredefiniOphta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        MsgPredefiniOphta3.setText("Je serai occupé(e) pendant 15mn.");
        MsgPredefiniOphta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsgPredefiniOphta3ActionPerformed(evt);
            }
        });
        jPanel5.add(MsgPredefiniOphta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 220, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("  Envoyer");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 60, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 290, -1));

        panCommunicationOphta.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 310, 130));

        panMsgOphta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panMsgOphta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taMsgOphta.setColumns(20);
        taMsgOphta.setRows(5);
        taMsgOphta.setToolTipText("");
        jScrollPane2.setViewportView(taMsgOphta);

        panMsgOphta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 500));

        panCommunicationOphta.add(panMsgOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 146, 310, 520));

        panCentreOphta.add(panCommunicationOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 320, 670));

        panOphtalmologue.add(panCentreOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 78, 1200, 670));

        lAccueilOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/accueil_text.PNG"))); // NOI18N
        lAccueilOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lAccueilOphtaMouseMoved(evt);
            }
        });
        lAccueilOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAccueilOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAccueilOphtaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lAccueilOphtaMousePressed(evt);
            }
        });
        lAccueilOphta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lAccueilOphtaKeyPressed(evt);
            }
        });
        panOphtalmologue.add(lAccueilOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, -1));

        lAgendaOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/agenda_text.PNG"))); // NOI18N
        lAgendaOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lAgendaOphtaMouseMoved(evt);
            }
        });
        lAgendaOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAgendaOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAgendaOphtaMouseExited(evt);
            }
        });
        panOphtalmologue.add(lAgendaOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 316, 100, 160));

        lPatientOphta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/patient_text.PNG"))); // NOI18N
        lPatientOphta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lPatientOphtaMouseMoved(evt);
            }
        });
        lPatientOphta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPatientOphtaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lPatientOphtaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lPatientOphtaMousePressed(evt);
            }
        });
        panOphtalmologue.add(lPatientOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 550, 120, 150));

        javax.swing.GroupLayout panSelectionAcuueilOphtaLayout = new javax.swing.GroupLayout(panSelectionAcuueilOphta);
        panSelectionAcuueilOphta.setLayout(panSelectionAcuueilOphtaLayout);
        panSelectionAcuueilOphtaLayout.setHorizontalGroup(
            panSelectionAcuueilOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        panSelectionAcuueilOphtaLayout.setVerticalGroup(
            panSelectionAcuueilOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        panOphtalmologue.add(panSelectionAcuueilOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 10, 190));

        javax.swing.GroupLayout panSelectionPatientOphtaLayout = new javax.swing.GroupLayout(panSelectionPatientOphta);
        panSelectionPatientOphta.setLayout(panSelectionPatientOphtaLayout);
        panSelectionPatientOphtaLayout.setHorizontalGroup(
            panSelectionPatientOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        panSelectionPatientOphtaLayout.setVerticalGroup(
            panSelectionPatientOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        panOphtalmologue.add(panSelectionPatientOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 10, 190));

        javax.swing.GroupLayout lSelectionAgendaOphtaLayout = new javax.swing.GroupLayout(lSelectionAgendaOphta);
        lSelectionAgendaOphta.setLayout(lSelectionAgendaOphtaLayout);
        lSelectionAgendaOphtaLayout.setHorizontalGroup(
            lSelectionAgendaOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        lSelectionAgendaOphtaLayout.setVerticalGroup(
            lSelectionAgendaOphtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        panOphtalmologue.add(lSelectionAgendaOphta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panOphtalmologue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panOphtalmologue, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lQuitterOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterOphtaMouseClicked
        int quitter = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment vous déconnecter?", "Confirmation ", JOptionPane.YES_NO_OPTION);
        if (quitter == 0) {
            dispose();
            new Authentification().setVisible(true);
        }
    }//GEN-LAST:event_lQuitterOphtaMouseClicked

    private void lPatientOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPatientOphtaMouseClicked

    }//GEN-LAST:event_lPatientOphtaMouseClicked

    private void lAccueilOphtaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilOphtaMousePressed
        panSelectionAcuueilOphta.setVisible(true);
        panAccueilOphta.setVisible(true);
        panPatientOphta.setVisible(false);
        panAgendaOphta.setVisible(false);
        panSelectionPatientOphta.setVisible(false);
        lSelectionAgendaOphta.setVisible(false);


    }//GEN-LAST:event_lAccueilOphtaMousePressed

    private void lAgendaOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAgendaOphtaMouseClicked
        panSelectionAcuueilOphta.setVisible(false);
        panAccueilOphta.setVisible(false);
        panPatientOphta.setVisible(false);
        panAgendaOphta.setVisible(true);
        panSelectionPatientOphta.setVisible(false);
        lSelectionAgendaOphta.setVisible(true);
    }//GEN-LAST:event_lAgendaOphtaMouseClicked

    private void lAccueilOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilOphtaMouseMoved
        setCursor(HAND_CURSOR);        // TODO add your handling code here:
    }//GEN-LAST:event_lAccueilOphtaMouseMoved

    private void tfRechercheOphtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRechercheOphtaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRechercheOphtaActionPerformed

    private void MsgPredefiniOphta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsgPredefiniOphta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MsgPredefiniOphta3ActionPerformed

    private void MsgPredefiniOphta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsgPredefiniOphta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MsgPredefiniOphta2ActionPerformed

    private void lAccueilOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilOphtaMouseExited
        setCursor(DEFAULT_CURSOR);        // TODO add your handling code here:
    }//GEN-LAST:event_lAccueilOphtaMouseExited

    private void lAgendaOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAgendaOphtaMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lAgendaOphtaMouseMoved

    private void lPatientOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPatientOphtaMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lPatientOphtaMouseMoved

    private void lQuitterOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterOphtaMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lQuitterOphtaMouseMoved

    private void lEnvoyerOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEnvoyerOphtaMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lEnvoyerOphtaMouseMoved

    private void lActualiserOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lActualiserOphtaMouseMoved
        setCursor(HAND_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lActualiserOphtaMouseMoved

    private void lAgendaOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAgendaOphtaMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lAgendaOphtaMouseExited

    private void lPatientOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPatientOphtaMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lPatientOphtaMouseExited

    private void lEnvoyerOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEnvoyerOphtaMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lEnvoyerOphtaMouseExited

    private void lQuitterOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterOphtaMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lQuitterOphtaMouseExited

    private void lActualiserOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lActualiserOphtaMouseExited
        setCursor(DEFAULT_CURSOR);          // TODO add your handling code here:
    }//GEN-LAST:event_lActualiserOphtaMouseExited

    private void lEnvoyerOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEnvoyerOphtaMouseClicked
        int confirmation = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment envoyez le message !", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == 0) {
            if (MsgPredefiniOphta1.isSelected()) {
                taMsgOphta.setText(taMsgOphta.getText() + MsgPredefiniOphta1.getText() + "\n");
                MsgPredefiniOphta1.setSelected(false);
            }
            if (MsgPredefiniOphta2.isSelected()) {
                taMsgOphta.setText(taMsgOphta.getText() + MsgPredefiniOphta2.getText() + "\n");
                MsgPredefiniOphta2.setSelected(false);
            }
            if (MsgPredefiniOphta3.isSelected()) {
                taMsgOphta.setText(taMsgOphta.getText() + MsgPredefiniOphta3.getText() + "\n");
                MsgPredefiniOphta3.setSelected(false);
            }

        }
    }//GEN-LAST:event_lEnvoyerOphtaMouseClicked

    private void lAccueilOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAccueilOphtaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lAccueilOphtaMouseClicked

    private void lRechercheOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRechercheOphtaMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lRechercheOphtaMouseMoved

    private void lRechercheOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRechercheOphtaMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lRechercheOphtaMouseExited

    private void lAjouterFicheMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterFicheMedMouseClicked
        new Fiche_Medicale().setVisible(true);
    }//GEN-LAST:event_lAjouterFicheMedMouseClicked

    private void lConsulterFicheMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lConsulterFicheMedMouseClicked
        Fiche_Medicale fiche = new Fiche_Medicale();
        fiche.setVisible(true);
    }//GEN-LAST:event_lConsulterFicheMedMouseClicked

    private void lModifierFicheMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierFicheMedMouseClicked
        Fiche_Medicale fiche = new Fiche_Medicale();
        fiche.setVisible(true);
    }//GEN-LAST:event_lModifierFicheMedMouseClicked

    private void lRechercheOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRechercheOphtaMouseClicked

    }//GEN-LAST:event_lRechercheOphtaMouseClicked

    private void lPatientOphtaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPatientOphtaMousePressed
        panSelectionAcuueilOphta.setVisible(false);
        panAccueilOphta.setVisible(false);
        panPatientOphta.setVisible(true);
        panAgendaOphta.setVisible(false);
        panSelectionPatientOphta.setVisible(true);
        lSelectionAgendaOphta.setVisible(false);
    }//GEN-LAST:event_lPatientOphtaMousePressed

    private void lAccueilOphtaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lAccueilOphtaKeyPressed


    }//GEN-LAST:event_lAccueilOphtaKeyPressed

    private void lAjouterRdvOphtaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvOphtaMousePressed


    }//GEN-LAST:event_lAjouterRdvOphtaMousePressed

    private void lModifierrdvOphtaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierrdvOphtaMousePressed


    }//GEN-LAST:event_lModifierrdvOphtaMousePressed

    private void lSuppRdvOphtaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSuppRdvOphtaMousePressed

    }//GEN-LAST:event_lSuppRdvOphtaMousePressed

    private void lActualiserOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lActualiserOphtaMouseClicked
        tfRechercheOphta.setText(null);
    }//GEN-LAST:event_lActualiserOphtaMouseClicked

    private void lSuppRdvOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSuppRdvOphtaMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lSuppRdvOphtaMouseMoved

    private void lSuppRdvOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSuppRdvOphtaMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lSuppRdvOphtaMouseExited

    private void lAjouterRdvOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvOphtaMouseMoved
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lAjouterRdvOphtaMouseMoved

    private void lAjouterRdvOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvOphtaMouseExited
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lAjouterRdvOphtaMouseExited

    private void lModifierrdvOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierrdvOphtaMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lModifierrdvOphtaMouseMoved

    private void lModifierrdvOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierrdvOphtaMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lModifierrdvOphtaMouseExited

    private void lSuppRdvOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSuppRdvOphtaMouseClicked
        if (tabAgendaOphta.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner une ligne ");
        } else {
            int conf = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer ce patient !", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (conf == 0) {
                try {
                    stat = cont.connectbdd().createStatement();
                    stat.executeUpdate("Delete from patient where id_pat='" + tabAgendaOphta.getValueAt(tabAgendaOphta.getSelectedRow(), 0) + "'");
                    Fiche_Personnelle f_p = new Fiche_Personnelle();
                    f_p.actualiserAgendaOphta();
                    f_p.actuliseraccueilOphta();
                    JOptionPane.showMessageDialog(this, "suppression confirmé");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_lSuppRdvOphtaMouseClicked

    private void lReglementOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lReglementOphtaMouseClicked
        new Reglement().setVisible(true);
    }//GEN-LAST:event_lReglementOphtaMouseClicked

    private void lAjouterFicheMedMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterFicheMedMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lAjouterFicheMedMouseMoved

    private void lConsulterFicheMedMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lConsulterFicheMedMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lConsulterFicheMedMouseMoved

    private void lModifierFicheMedMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierFicheMedMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lModifierFicheMedMouseMoved

    private void lSuppFicheMedMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSuppFicheMedMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lSuppFicheMedMouseMoved

    private void lReglementOphtaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lReglementOphtaMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lReglementOphtaMouseMoved

    private void lAjouterFicheMedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterFicheMedMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lAjouterFicheMedMouseExited

    private void lConsulterFicheMedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lConsulterFicheMedMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lConsulterFicheMedMouseExited

    private void lModifierFicheMedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierFicheMedMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lModifierFicheMedMouseExited

    private void lSuppFicheMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSuppFicheMedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lSuppFicheMedMouseClicked

    private void lSuppFicheMedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSuppFicheMedMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lSuppFicheMedMouseExited

    private void lReglementOphtaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lReglementOphtaMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lReglementOphtaMouseExited

    private void panReduireOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panReduireOphtaMouseClicked
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_panReduireOphtaMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void lAjouterRdvOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAjouterRdvOphtaMouseClicked
        ajouterpatient = true;
        new Fiche_Personnelle().setVisible(true);
        Fiche_Personnelle.mr.setSelected(true);
    }//GEN-LAST:event_lAjouterRdvOphtaMouseClicked

    private void lModifierrdvOphtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierrdvOphtaMouseClicked
        if (Interface_ophtalmo.tabAgendaOphta.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner une ligne ");
        } else {
            int conf = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment effectuer des modification sur ce patient !", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
            if (conf == 0) {

                modifierpatient = true;
                new Fiche_Personnelle().setVisible(true);

            }
        }
    }//GEN-LAST:event_lModifierrdvOphtaMouseClicked
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface_ophtalmo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox MsgPredefiniOphta1;
    private javax.swing.JCheckBox MsgPredefiniOphta2;
    private javax.swing.JCheckBox MsgPredefiniOphta3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lAccueilOphta;
    private javax.swing.JLabel lActualiserOphta;
    private javax.swing.JLabel lAgendaOphta;
    private javax.swing.JLabel lAjouterFicheMed;
    private javax.swing.JLabel lAjouterRdvOphta;
    private javax.swing.JLabel lConsulterFicheMed;
    private javax.swing.JLabel lEnvoyerOphta;
    private javax.swing.JLabel lIconeOphta;
    private javax.swing.JLabel lModifierFicheMed;
    private javax.swing.JLabel lModifierrdvOphta;
    private javax.swing.JLabel lPatientOphta;
    private javax.swing.JLabel lQuitterOphta;
    private javax.swing.JLabel lRechercheOphta;
    private javax.swing.JLabel lReglementOphta;
    private javax.swing.JPanel lSelectionAgendaOphta;
    private javax.swing.JLabel lSuppFicheMed;
    private javax.swing.JLabel lSuppRdvOphta;
    private javax.swing.JPanel panAccueilOphta;
    private javax.swing.JPanel panAgendaOphta;
    private javax.swing.JPanel panCentreOphta;
    private javax.swing.JPanel panCommunicationOphta;
    private javax.swing.JPanel panMajFicheMed;
    private javax.swing.JPanel panMsgOphta;
    private javax.swing.JPanel panOphtalmologue;
    private javax.swing.JPanel panPatientOphta;
    private javax.swing.JPanel panQuitterOphta;
    private javax.swing.JPanel panReduireOphta;
    private javax.swing.JPanel panSelectionAcuueilOphta;
    private javax.swing.JPanel panSelectionPatientOphta;
    private javax.swing.JPanel panSuperieurOphta;
    private javax.swing.JPanel panTabAgendaOphta;
    private javax.swing.JTextArea taMsgOphta;
    public static javax.swing.JTable tabAgendaOphta;
    public static javax.swing.JTable tabPatientOphta;
    public static javax.swing.JTable tableRDVTodayOphta;
    private javax.swing.JTextField tfRechercheOphta;
    // End of variables declaration//GEN-END:variables
}
