
package Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect_secretaire {
    
    Connecter co=new Connecter();
    public Statement st;
    public ResultSet rs;
    
    public Connect_secretaire(){
        try {
            st=co.connectbdd().createStatement();
            
            rs=st.executeQuery("select mdp from secretaire where id_user = 2");
        } catch (SQLException ex) {
            Logger.getLogger(Connect_secretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
}