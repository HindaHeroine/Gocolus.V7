package Vue;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import Model.Connecter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

public class Fiche_Personnelle extends javax.swing.JFrame {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Connecter cont = new Connecter();
    Statement stat;
    ButtonGroup bg = new ButtonGroup();
    Date date = new Date();
    ResultSet resu;
    DefaultTableModel modelAccueil = new DefaultTableModel();
    DefaultTableModel modelAgenda = new DefaultTableModel();
    String civ = "";
    int X, Y;

    public Fiche_Personnelle() {
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
        if (Interface_ophtalmo.modifierpatient == true) {
            afficherDeAgendaOphta(Interface_ophtalmo.tabAgendaOphta.getSelectedRow());
        }
        if (Interface_Secretaire.modifierpatient == true) {
            afficherDeAgendaSecretaire(Interface_Secretaire.tabAgendaSec.getSelectedRow());
        }

        bg.add(mr);
        bg.add(mme);
        bg.add(mlle);
        setLocationRelativeTo(this);
    }

    //**************************************************
    public void reinitialiserlafichepersonnelle() {
        nom.setText(null);
        prenom.setText(null);
        profession.setText(null);
        adresse.setText(null);
        num.setText(null);
        dateN.setDate(null);
        dateRDV.setDate(null);
        heureRDV.setSelectedIndex(0);
        minuteRDV.setSelectedIndex(0);
        JOptionPane.showMessageDialog(null,"reinitialisation ");
    }

    public void actuliseraccueilSecretaire() {
        modelAccueil.setColumnCount(0);
        modelAccueil.setRowCount(0);
        try {
            stat = cont.connectbdd().createStatement();
            resu = stat.executeQuery("Select * from patient where DateRDV = '" + dateFormat.format(date) + "'");
            modelAccueil.addColumn("Nom");
            modelAccueil.addColumn("Prénom");
            modelAccueil.addColumn("Civilité");
            modelAccueil.addColumn("Date de naissance");
            modelAccueil.addColumn("Profession");
            modelAccueil.addColumn("N° portable");
            modelAccueil.addColumn("Adresse");
            modelAccueil.addColumn("Heure RDV");
            while (resu.next()) {
                modelAccueil.addRow(new Object[]{resu.getObject("nom_p"), resu.getObject("prenom_p"), resu.getObject("civ"), resu.getObject("dateN"), resu.getObject("profession"),
                    resu.getObject("num_tel"), resu.getObject("adresse"), resu.getObject("heureRDV")});
            }
            Interface_Secretaire.tableRDVTodaySec.setModel(modelAccueil);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actuliseraccueilOphta() {

        modelAccueil.setColumnCount(0);
        modelAccueil.setRowCount(0);
        try {
            stat = cont.connectbdd().createStatement();
            resu = stat.executeQuery("Select * from patient where DateRDV = '" + dateFormat.format(date) + "'");
            modelAccueil.addColumn("Nom");
            modelAccueil.addColumn("Prénom");
            modelAccueil.addColumn("Civilité");
            modelAccueil.addColumn("Date de naissance");
            modelAccueil.addColumn("Profession");
            modelAccueil.addColumn("N° portable");
            modelAccueil.addColumn("Adresse");
            modelAccueil.addColumn("Heure RDV");
            while (resu.next()) {
                modelAccueil.addRow(new Object[]{resu.getObject("nom_p"), resu.getObject("prenom_p"), resu.getObject("civ"), resu.getObject("dateN"), resu.getObject("profession"),
                    resu.getObject("num_tel"), resu.getObject("adresse"), resu.getObject("HeureRDV")});
            }
            Interface_ophtalmo.tableRDVTodayOphta.setModel(modelAccueil);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualiserAgendasecretaire() {

        modelAgenda.setColumnCount(0);
        modelAgenda.setRowCount(0);
        try {
            stat = cont.connectbdd().createStatement();
            resu = stat.executeQuery("Select * from patient");
            modelAgenda.addColumn("ID");
            modelAgenda.addColumn("Nom");
            modelAgenda.addColumn("Prénom");
            modelAgenda.addColumn("Civilité");
            modelAgenda.addColumn("Date de naissance");
            modelAgenda.addColumn("Profession");
            modelAgenda.addColumn("N° portable");
            modelAgenda.addColumn("Adresse");
            modelAgenda.addColumn("Date RDV");
            modelAgenda.addColumn("Heure RDV");
            while (resu.next()) {

                modelAgenda.addRow(new Object[]{resu.getObject("id_pat"), resu.getObject("nom_p"), resu.getObject("prenom_p"), resu.getObject("civ"), resu.getObject("dateN"), resu.getObject("profession"),
                    resu.getObject("num_tel"), resu.getObject("adresse"), resu.getObject("dateRDV"), resu.getObject("heureRDV")});
            }
            Interface_Secretaire.tabAgendaSec.setModel(modelAgenda);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void actualiserAgendaOphta() {

        modelAgenda.setColumnCount(0);
        modelAgenda.setRowCount(0);

        try {
            stat = cont.connectbdd().createStatement();
            resu = stat.executeQuery("Select * from patient");
            modelAgenda.addColumn("ID");
            modelAgenda.addColumn("Nom");
            modelAgenda.addColumn("Prénom");
            modelAgenda.addColumn("Civilité");
            modelAgenda.addColumn("Date de naissance");
            modelAgenda.addColumn("Profession");
            modelAgenda.addColumn("N° portable");
            modelAgenda.addColumn("Adresse");
            modelAgenda.addColumn("Date RDV");
            modelAgenda.addColumn("Heure RDV");
            while (resu.next()) {

                modelAgenda.addRow(new Object[]{resu.getObject("id_pat"), resu.getObject("nom_p"), resu.getObject("prenom_p"), resu.getObject("civ"), resu.getObject("dateN"), resu.getObject("profession"),
                    resu.getObject("num_tel"), resu.getObject("adresse"), resu.getObject("DateRDV"), resu.getObject("HeureRDV")});
            }
            Interface_ophtalmo.tabAgendaOphta.setModel(modelAgenda);
        } catch (SQLException ex) {
            Logger.getLogger(Interface_Secretaire.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    public void ajouterSecretaire() {
        javax.swing.JTextField[] tab = {nom, prenom, profession, num};
        if (mr.isSelected()) {
            civ = mr.getText();
        }
        if (mme.isSelected()) {
            civ = mme.getText();
        }
        if (mlle.isSelected()) {
            civ = mlle.getText();
        }
        try {
            boolean vide = false;
            for (javax.swing.JTextField tf : tab) {
                if (tf.getText().trim().isEmpty()) {
                    vide = true;
                    break;
                }
            }
            if (!vide) {
                if (adresse.getText().trim().isEmpty()) {
                    vide = true;
                }
            }
            if (dateRDV.getDate() == null || dateN.getDate() == null) {
                vide = true;
            }
            if (vide) {
                JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vides");
            } else {
                int confirmer = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment ajouter le patient", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmer == 0) {
                    stat = cont.connectbdd().createStatement();
                    stat.executeUpdate("Insert into patient(nom_p,prenom_p,dateN,civ,profession,num_tel,adresse,dateRDV,heureRDV,id_user)Values('" + nom.getText().replace("'", "''")
                            + "','" + prenom.getText().replace("'", "''") + "','" + dateFormat.format(dateN.getDate()) + "','" + civ + "','" + profession.getText().replace("'", "''") + "','" + num.getText().replace("'", "''")
                            + "','" + adresse.getText().replace("'", "''") + "','" + dateFormat.format(dateRDV.getDate()) + "','" + heureRDV.getSelectedItem() + ":" + minuteRDV.getSelectedItem() + "','2')");
                    actuliseraccueilSecretaire();
                    actualiserAgendasecretaire();
                    Interface_Secretaire.ajouterpatient = false;

                    dispose();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Fiche_Personnelle.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ajout echoué. " + ex.getMessage());
        }

    }

    public void ajouterOphta() {
        javax.swing.JTextField[] tab = {nom, prenom, profession, num};
        if (mr.isSelected()) {
            civ = mr.getText();
        }
        if (mme.isSelected()) {
            civ = mme.getText();
        }
        if (mlle.isSelected()) {
            civ = mlle.getText();
        }
        try {
            boolean vide = false;
            for (javax.swing.JTextField tf : tab) {
                if (tf.getText().trim().isEmpty()) {
                    vide = true;
                    break;
                }
            }
            if (!vide) {
                if (adresse.getText().trim().isEmpty()) {
                    vide = true;
                }
            }
            if (dateRDV.getDate() == null || dateN.getDate() == null) {
                vide = true;
            }
            if (vide) {
                JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vides");
            } else {
                int confirmer = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment ajouter le patient", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmer == 0) {
                    stat = cont.connectbdd().createStatement();
                    stat.executeUpdate("Insert into patient(nom_p,prenom_p,dateN,civ,profession,num_tel,adresse,dateRDV,heureRDV,id_user)Values('" + nom.getText().replace("'", "''")
                            + "','" + prenom.getText().replace("'", "''") + "','" + dateFormat.format(dateN.getDate()) + "','" + civ + "','" + profession.getText().replace("'", "''") + "','" + num.getText().replace("'", "''")
                            + "','" + adresse.getText().replace("'", "''") + "','" + dateFormat.format(dateRDV.getDate()) + "','" + heureRDV.getSelectedItem() + ":" + minuteRDV.getSelectedItem() + "','2')");
                    actuliseraccueilOphta();
                    actualiserAgendaOphta();
                    Interface_ophtalmo.ajouterpatient = false;
                    dispose();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Fiche_Personnelle.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ajout echoué. " + ex.getMessage());
        }

    }

    public static void afficherDeAgendaOphta(int ligne) {

        nom.setText(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 1) + "");
        prenom.setText(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 2) + "");
        if (mr.getText().equals(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 3))) {
            mr.setSelected(true);
        }
        if (mme.getText().equals(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 3))) {
            mme.setSelected(true);
        }
        if (mlle.getText().equals(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 3))) {
            mlle.setSelected(true);
        }

        dateN.setDate((Date) Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 4));
        profession.setText(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 5) + "");
        num.setText(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 6) + "");
        adresse.setText(Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 7) + "");
        dateRDV.setDate((Date) Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 8));
        java.sql.Time time = (Time) Interface_ophtalmo.tabAgendaOphta.getValueAt(ligne, 9);
        switch (time.getMinutes()) {
            case 0:
                minuteRDV.setSelectedIndex(0);
                break;
            case 15:
                minuteRDV.setSelectedIndex(1);
                break;
            case 30:
                minuteRDV.setSelectedIndex(2);
                break;
            case 45:
                minuteRDV.setSelectedIndex(3);
                break;
        }
        switch (time.getHours()) {
            case 8:
                heureRDV.setSelectedIndex(0);
                break;
            case 9:
                heureRDV.setSelectedIndex(1);
                break;
            case 10:
                heureRDV.setSelectedIndex(2);
                break;
            case 11:
                heureRDV.setSelectedIndex(3);
                break;
            case 13:
                heureRDV.setSelectedIndex(4);
                break;
            case 14:
                heureRDV.setSelectedIndex(5);
                break;
            case 15:
                heureRDV.setSelectedIndex(6);
                break;
            case 16:
                heureRDV.setSelectedIndex(7);
                break;
        }

    }

    public static void afficherDeAgendaSecretaire(int ligne) {

        nom.setText(Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 1) + "");
        prenom.setText(Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 2) + "");
        if (mr.getText().equals("" + Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 3))) {
            mr.setSelected(true);
        }
        if (mme.getText().equals(Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 3))) {
            mme.setSelected(true);
        }
        if (mlle.getText().equals(Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 3))) {
            mlle.setSelected(true);
        }
        dateN.setDate((Date) Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 4));
        profession.setText(Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 5) + "");
        num.setText(Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 6) + "");
        adresse.setText(Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 7) + "");
        dateRDV.setDate((Date) Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 8));
        java.sql.Time time = (Time) Interface_Secretaire.tabAgendaSec.getValueAt(ligne, 9);
        switch (time.getMinutes()) {
            case 0:
                minuteRDV.setSelectedIndex(0);
                break;
            case 15:
                minuteRDV.setSelectedIndex(1);
                break;
            case 30:
                minuteRDV.setSelectedIndex(2);
                break;
            case 45:
                minuteRDV.setSelectedIndex(3);
                break;
        }
        switch (time.getHours()) {
            case 8:
                heureRDV.setSelectedIndex(0);
                break;
            case 9:
                heureRDV.setSelectedIndex(1);
                break;
            case 10:
                heureRDV.setSelectedIndex(2);
                break;
            case 11:
                heureRDV.setSelectedIndex(3);
                break;
            case 13:
                heureRDV.setSelectedIndex(4);
                break;
            case 14:
                heureRDV.setSelectedIndex(5);
                break;
            case 15:
                heureRDV.setSelectedIndex(6);
                break;
            case 16:
                heureRDV.setSelectedIndex(7);
                break;
        }

    }

    public void modifierOphtalmologue() {

        if (mr.isSelected()) {
            civ = mr.getText();
        }
        if (mme.isSelected()) {
            civ = mme.getText();
        }
        if (mlle.isSelected()) {
            civ = mlle.getText();
        }

        try {
            stat = cont.connectbdd().createStatement();
            stat.executeUpdate("Update patient set nom_p='" + nom.getText().replace("'", "''") + "',prenom_p='"
                    + prenom.getText().replace("'", "''") + "', dateN='" + dateFormat.format(dateN.getDate()) + "',civ='" + civ + "',profession='" + profession.getText().replace("'", "''")
                    + "',num_tel='" + num.getText() + "',adresse='" + adresse.getText().replace("'", "''") + "',dateRDV='" + dateFormat.format(dateRDV.getDate())
                    + "',heureRDV='" + heureRDV.getSelectedItem() + ":" + minuteRDV.getSelectedItem() + "'where id_pat='" + Interface_ophtalmo.tabAgendaOphta.getValueAt(Interface_ophtalmo.tabAgendaOphta.getSelectedRow(), 0) + "'");
            actualiserAgendaOphta();
            actuliseraccueilOphta();

        } catch (SQLException ex) {
            Logger.getLogger(Fiche_Personnelle.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Modification echouée. " + ex.getMessage());
        }

    }

    public void modifierSecretaire() {

        if (mr.isSelected()) {
            civ = mr.getText();
        }
        if (mme.isSelected()) {
            civ = mme.getText();
        }
        if (mlle.isSelected()) {
            civ = mlle.getText();
        }

        try {
            stat = cont.connectbdd().createStatement();
            stat.executeUpdate("Update patient set nom_p='" + nom.getText().replace("'", "''") + "',prenom_p='"
                    + prenom.getText().replace("'", "''") + "', dateN='" + dateFormat.format(dateN.getDate()) + "',civ='" + civ + "',profession='" + profession.getText().replace("'", "''")
                    + "',num_tel='" + num.getText() + "',adresse='" + adresse.getText().replace("'", "''") + "',dateRDV='" + dateFormat.format(dateRDV.getDate())
                    + "',heureRDV='" + heureRDV.getSelectedItem() + ":" + minuteRDV.getSelectedItem()
                    + "'where id_pat='" + Interface_Secretaire.tabAgendaSec.getValueAt(Interface_Secretaire.tabAgendaSec.getSelectedRow(), 0) + "'");
            actualiserAgendasecretaire();
            actuliseraccueilSecretaire();

        } catch (SQLException ex) {
            Logger.getLogger(Fiche_Personnelle.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Modification echouée. " + ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panQuitterFichePerso = new javax.swing.JPanel();
        lQuitterFichePerso = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lReduireFichePerso = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panperso = new javax.swing.JPanel();
        lnom = new javax.swing.JLabel();
        lprenom = new javax.swing.JLabel();
        ldaten = new javax.swing.JLabel();
        ladresse = new javax.swing.JLabel();
        lcivilite = new javax.swing.JLabel();
        lprofession = new javax.swing.JLabel();
        lnump = new javax.swing.JLabel();
        profession = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        mr = new javax.swing.JRadioButton();
        mme = new javax.swing.JRadioButton();
        mlle = new javax.swing.JRadioButton();
        ldaten1 = new javax.swing.JLabel();
        ldaten2 = new javax.swing.JLabel();
        minuteRDV = new javax.swing.JComboBox<>();
        heureRDV = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        adresse = new javax.swing.JTextArea();
        valider = new javax.swing.JButton();
        dateRDV = new com.toedter.calendar.JDateChooser();
        dateN = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panQuitterFichePerso.setBackground(new java.awt.Color(204, 204, 204));
        panQuitterFichePerso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lQuitterFichePerso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/x_bleu.png"))); // NOI18N
        lQuitterFichePerso.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lQuitterFichePersoMouseMoved(evt);
            }
        });
        lQuitterFichePerso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lQuitterFichePersoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lQuitterFichePersoMouseExited(evt);
            }
        });
        panQuitterFichePerso.add(lQuitterFichePerso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 20, 20));

        getContentPane().add(panQuitterFichePerso, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 40, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lReduireFichePerso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/réduire.png"))); // NOI18N
        lReduireFichePerso.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lReduireFichePersoMouseMoved(evt);
            }
        });
        jPanel2.add(lReduireFichePerso, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 20, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 60));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panperso.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panperso.setForeground(new java.awt.Color(0, 0, 51));
        panperso.setMinimumSize(new java.awt.Dimension(970, 409));
        panperso.setPreferredSize(new java.awt.Dimension(970, 409));

        lnom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lnom.setForeground(new java.awt.Color(0, 0, 51));
        lnom.setText("Date RDV:");

        lprenom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lprenom.setForeground(new java.awt.Color(0, 0, 51));
        lprenom.setText("Heure du RDV:");

        ldaten.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ldaten.setForeground(new java.awt.Color(0, 0, 51));
        ldaten.setText("Date de naissance:");

        ladresse.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ladresse.setForeground(new java.awt.Color(0, 0, 51));
        ladresse.setText("Adresse:");

        lcivilite.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lcivilite.setForeground(new java.awt.Color(0, 0, 51));
        lcivilite.setText("Civilité:");

        lprofession.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lprofession.setForeground(new java.awt.Color(0, 0, 51));
        lprofession.setText("Profession:");

        lnump.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lnump.setForeground(new java.awt.Color(0, 0, 51));
        lnump.setText("N° portable:");

        profession.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                professionFocusLost(evt);
            }
        });
        profession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professionActionPerformed(evt);
            }
        });

        num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numKeyTyped(evt);
            }
        });

        mr.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        mr.setForeground(new java.awt.Color(0, 0, 51));
        mr.setText("Mr.");

        mme.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        mme.setForeground(new java.awt.Color(0, 0, 51));
        mme.setText("Mme.");

        mlle.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        mlle.setForeground(new java.awt.Color(0, 0, 51));
        mlle.setText("Mlle.");

        ldaten1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ldaten1.setForeground(new java.awt.Color(0, 0, 51));
        ldaten1.setText("Prénom:");

        ldaten2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ldaten2.setForeground(new java.awt.Color(0, 0, 51));
        ldaten2.setText("Nom:");

        minuteRDV.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        minuteRDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));

        heureRDV.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        heureRDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08", "09", "10", "11", "13", "14", "15", "16" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText(":");

        nom.setToolTipText("nom");
        nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomFocusLost(evt);
            }
        });

        prenom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prenomFocusLost(evt);
            }
        });

        adresse.setColumns(20);
        adresse.setRows(5);
        jScrollPane1.setViewportView(adresse);

        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        dateRDV.setToolTipText("dt");

        javax.swing.GroupLayout panpersoLayout = new javax.swing.GroupLayout(panperso);
        panperso.setLayout(panpersoLayout);
        panpersoLayout.setHorizontalGroup(
            panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panpersoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ldaten2)
                    .addComponent(lnom)
                    .addComponent(ldaten)
                    .addComponent(lprofession)
                    .addComponent(ladresse))
                .addGap(18, 18, 18)
                .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panpersoLayout.createSequentialGroup()
                        .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(nom)
                            .addComponent(dateRDV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profession))
                        .addGap(55, 55, 55)
                        .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panpersoLayout.createSequentialGroup()
                                .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ldaten1)
                                    .addComponent(lprenom))
                                .addGap(13, 13, 13)
                                .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panpersoLayout.createSequentialGroup()
                                        .addComponent(heureRDV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minuteRDV, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panpersoLayout.createSequentialGroup()
                                .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panpersoLayout.createSequentialGroup()
                                        .addComponent(lcivilite)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mr))
                                    .addGroup(panpersoLayout.createSequentialGroup()
                                        .addComponent(lnump)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panpersoLayout.createSequentialGroup()
                                        .addComponent(mme)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mlle))
                                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(336, 336, 336))
            .addGroup(panpersoLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panpersoLayout.setVerticalGroup(
            panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panpersoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panpersoLayout.createSequentialGroup()
                        .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateRDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(heureRDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minuteRDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lprenom)))
                        .addGap(33, 33, 33)
                        .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ldaten1)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mme, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mlle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcivilite))
                        .addGap(50, 50, 50)
                        .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnump)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panpersoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panpersoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panpersoLayout.createSequentialGroup()
                                .addComponent(lnom)
                                .addGap(38, 38, 38)
                                .addComponent(ldaten2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(ldaten)))
                        .addGap(52, 52, 52)
                        .addComponent(lprofession)
                        .addGap(33, 33, 33)
                        .addComponent(ladresse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(valider)
                .addGap(27, 27, 27))
        );

        jPanel1.add(panperso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 690, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lQuitterFichePersoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterFichePersoMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lQuitterFichePersoMouseMoved

    private void lQuitterFichePersoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterFichePersoMouseClicked
        int quitter = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment quitter !", "Confirmation ", JOptionPane.YES_NO_OPTION);
        
        if (quitter == 0) {
           reinitialiserlafichepersonnelle();
            this.setVisible(false);

        }
    }//GEN-LAST:event_lQuitterFichePersoMouseClicked

    private void lQuitterFichePersoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lQuitterFichePersoMouseExited
        setCursor(DEFAULT_CURSOR);
    }//GEN-LAST:event_lQuitterFichePersoMouseExited

    private void lReduireFichePersoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lReduireFichePersoMouseMoved
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_lReduireFichePersoMouseMoved

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed

        if (Interface_Secretaire.ajouterpatient) {
            ajouterSecretaire();
        }

        if (Interface_Secretaire.modifierpatient) {
            Interface_Secretaire.modifierpatient = false;
            modifierSecretaire();
            
            reinitialiserlafichepersonnelle();

            dispose();
        }

        if (Interface_ophtalmo.ajouterpatient) {

            ajouterOphta();

        }

        if (Interface_ophtalmo.modifierpatient == true) {
            Interface_ophtalmo.modifierpatient = false;
            modifierOphtalmologue();
            reinitialiserlafichepersonnelle();
            dispose();
        }
    }//GEN-LAST:event_validerActionPerformed

    private void nomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusLost
        nom.setText(nom.getText().toUpperCase());

    }//GEN-LAST:event_nomFocusLost

    private void professionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_professionActionPerformed

    private void numKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numKeyTyped
        char c = evt.getKeyChar();
        if ((c == KeyEvent.VK_BACK_SPACE) || !Character.isDigit(c) || (c == KeyEvent.VK_DELETE) || (num.getText().length() >= 10)) {
            evt.consume();
        }
    }//GEN-LAST:event_numKeyTyped

    private void prenomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prenomFocusLost
        prenom.setText(prenom.getText().toUpperCase().charAt(0) + prenom.getText().toLowerCase().substring(1));
    }//GEN-LAST:event_prenomFocusLost

    private void professionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_professionFocusLost
        profession.setText(profession.getText().toString().toUpperCase().charAt(0) + profession.getText().toLowerCase().substring(1));
    }//GEN-LAST:event_professionFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fiche_Personnelle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea adresse;
    public static com.toedter.calendar.JDateChooser dateN;
    public static com.toedter.calendar.JDateChooser dateRDV;
    public static javax.swing.JComboBox<String> heureRDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lQuitterFichePerso;
    private javax.swing.JLabel lReduireFichePerso;
    private javax.swing.JLabel ladresse;
    private javax.swing.JLabel lcivilite;
    private javax.swing.JLabel ldaten;
    private javax.swing.JLabel ldaten1;
    private javax.swing.JLabel ldaten2;
    private javax.swing.JLabel lnom;
    private javax.swing.JLabel lnump;
    private javax.swing.JLabel lprenom;
    private javax.swing.JLabel lprofession;
    public static javax.swing.JComboBox<String> minuteRDV;
    public static javax.swing.JRadioButton mlle;
    public static javax.swing.JRadioButton mme;
    public static javax.swing.JRadioButton mr;
    public static javax.swing.JTextField nom;
    public static javax.swing.JTextField num;
    private javax.swing.JPanel panQuitterFichePerso;
    private javax.swing.JPanel panperso;
    public static javax.swing.JTextField prenom;
    public static javax.swing.JTextField profession;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
