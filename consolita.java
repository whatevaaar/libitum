package libitum;

import libitum.Robot;
import libitum.Accion;
import libitum.Demo;
import javax.swing.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.util.Scanner;
import java.awt.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class consolita extends javax.swing.JFrame {

    boolean flag = true;
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

                
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
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
        
        //Salida de texto
        salida.setFont(new java.awt.Font("Exo 2 Medium", 1, 15)); // NOI18N
        salida.setForeground(new java.awt.Color(102, 102, 51));
        salida.setColumns(20);
        salida.setEditable(false);
        getContentPane().add(salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 850, 250));

        //Entrada de texto
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Exo 2 Medium", 1, 18)); // NOI18N
        txtArea.setForeground(new java.awt.Color(153, 0, 51));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 850, 100));
         
        //Botón cerrar
        JB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("cerrar.png"))); // NOI18N
        JB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB1ActionPerformed(evt);
            }
        });
       getContentPane().add(JB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 40));

        //Botón minimizar
        JBminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("minimizar.png"))); // NOI18N
        JBminimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBminimizarActionPerformed(evt);
            }
        });
        getContentPane().add(JBminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 40, 40));

        //Botón maximizar
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("maximizar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 0, 40, 40));
        
        //Banner
        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setForeground(new java.awt.Color(153, 0, 51));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 40));
        
        //Botón ok
        botonOk.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        botonOk.setText("Ok");
        botonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOkActionPerformed(evt);
            }
        });
        getContentPane().add(botonOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600,100,70));

        jlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("fondo.jpg"))); // NOI18N
        getContentPane().add(jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960,680 ));

        pack();
    }// </editor-fold>                                                            

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
        flag = false;
    }                                       
    
    public JTextArea getField(){
        return salida;
    }
    
    public void imprimir(String s){
        salida.setText(s);
        salida.validate();
    }
    
    public String entrada(){
        
        while (flag){
            try {
            Thread.sleep(200);
        }   catch(InterruptedException e) {}
        }
        flag = true;
        String temp = txtArea.getText();
        txtArea.setText("");
        return temp;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String arg[])
    {
	consolita consola = new consolita();
        consola.setPreferredSize(new Dimension(400,800));
	consola.setVisible(true);
        Demo juegoPrueba = new Demo(consola);
        Robot personajePrincipal = new Robot();
        for (;;){
            String entradaT = consola.entrada();
            Accion accionPrueba = new Accion(entradaT,personajePrincipal,consola);
        }
    }
   
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton JB1;
    private javax.swing.JButton JBminimizar;
    private javax.swing.JButton botonOk;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea salida;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JTextArea txtArea;

    // End of variables declaration                   
}
