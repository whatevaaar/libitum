package interfaz;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class consolita extends javax.swing.JFrame {

    public consolita() {
        
        initComponents();
        JB1.setOpaque(false);
JB1.setContentAreaFilled(false);
JB1.setBorderPainted(false);

        jButton1.setOpaque(false);
jButton1.setContentAreaFilled(false);
jButton1.setBorderPainted(false);

        JBminimizar.setOpaque(false);
JBminimizar.setContentAreaFilled(false);
JBminimizar.setBorderPainted(false);

        this.setLocationRelativeTo(null);
        com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.9f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        JB1 = new javax.swing.JButton();
        JBminimizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        botonOk = new javax.swing.JButton();
        jlabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        jTextField1.setFont(new java.awt.Font("Exo 2 Medium", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 0, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 950, 90));

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Exo 2 Medium", 1, 18)); // NOI18N
        txtArea.setForeground(new java.awt.Color(153, 0, 51));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 950, 210));

        JB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Imagen3.png"))); // NOI18N
        JB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB1ActionPerformed(evt);
            }
        });
        getContentPane().add(JB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 40, 40));

        JBminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/minimizar.png"))); // NOI18N
        JBminimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBminimizarActionPerformed(evt);
            }
        });
        getContentPane().add(JBminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 40, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/maximizar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 40, 40));

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setForeground(new java.awt.Color(153, 0, 51));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 40));

        botonOk.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        botonOk.setText("Ok");
        botonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOkActionPerformed(evt);
            }
        });
        getContentPane().add(botonOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 180, 120, 50));

        jlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/img037-001 (1).jpg"))); // NOI18N
        getContentPane().add(jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 690));

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void JB1ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        System.exit(0);
    }                                   

    private void JBminimizarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        setExtendedState(JFrame.CROSSHAIR_CURSOR); 
    }                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       setExtendedState(JFrame.MAXIMIZED_BOTH);
    }                                        

    private void botonOkActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(consolita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consolita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consolita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consolita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consolita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton JB1;
    private javax.swing.JButton JBminimizar;
    private javax.swing.JButton botonOk;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration                   
}
