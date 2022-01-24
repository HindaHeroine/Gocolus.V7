
package Model;

import javax.swing.JOptionPane;
import java.sql.*;

public class Connecter {
    
    Connection c;
    
    public Connecter(){
        
        //Connexion vers le serveur de BDD
        try {
            Class.forName("com.mysql.jdbc.Driver");
           //JOptionPane.showMessageDialog(null, "Connexion au serveur réussie1.");
        } catch (Exception e) {
           //JOptionPane.showMessageDialog(null, "Echec de connexion au serveur1."+e.getMessage());
        }
        
       
        try {
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/goculus","root",""); 
//Pour obtenir la connexion vers la BDD (.getconnection("@ de la bdd qui se trouve dans service","nom d'utilisateur","mdp"))
         // JOptionPane.showMessageDialog(null, "Connexion à la BDD réussie.1");
        } catch (Exception e) {
           //JOptionPane.showMessageDialog(null, "Echec de connexion à la BDD1"+e.getMessage());
        }
    }
    
    //Méthode pour se co à la BDD:
    public Connection connectbdd(){
        return c;
    }
}
