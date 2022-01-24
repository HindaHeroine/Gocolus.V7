package Vue;


import java.util.logging.Level;
import java.util.logging.Logger;



public class Splash_Screen extends javax.swing.JFrame {
    
    public Splash_Screen() {
        initComponents();
        setLocationRelativeTo(this);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Splash_Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                dispose();
             //  new Interface_Secretaire().setVisible(true);
              Authentification auth=new Authentification();
                auth.setVisible(true);//Lancer l'interface_principale
                
            }
        }).start();
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lSplashScreen = new javax.swing.JLabel();
        panSplashScreen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lSplashScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/show/ihm/splash_screen.png"))); // NOI18N
        getContentPane().add(lSplashScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        javax.swing.GroupLayout panSplashScreenLayout = new javax.swing.GroupLayout(panSplashScreen);
        panSplashScreen.setLayout(panSplashScreenLayout);
        panSplashScreenLayout.setHorizontalGroup(
            panSplashScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panSplashScreenLayout.setVerticalGroup(
            panSplashScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(panSplashScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lSplashScreen;
    private javax.swing.JPanel panSplashScreen;
    // End of variables declaration//GEN-END:variables
}
