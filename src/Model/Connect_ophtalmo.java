
package Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect_ophtalmo {
    
    Connecter c=new Connecter();
    public Statement st;
    public ResultSet rs;
    
    public Connect_ophtalmo(){
        
        try {
            
            st=c.connectbdd().createStatement();
            
            rs=st.executeQuery("select mdp from secretaire where id_user = 1");
            
        } catch (SQLException ex) {
            Logger.getLogger(Connect_ophtalmo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }
}
