/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clavedicotomica;

/**
 *
 * @author Freya Blanca, Jesús Schneider, Marcelo Pineiro
 */
public class Resultados extends javax.swing.JFrame {

    /**
     * Creates new form Resultados
     */
    String respuesta;
    public Resultados(String respuesta, long tiempoTranscurrido) {
        initComponents();
        setLocationRelativeTo(null);
        
        String textoAMostrar = "No se encontraron resultados";
        
        if (respuesta != null && !respuesta.isEmpty()) {
            textoAMostrar = respuesta;
        }
        
        // Convertir tiempo a segundos con formato
        double segundos = tiempoTranscurrido / 1_000_000_000.0;
        String tiempoTexto = String.format("Tiempo: %.6f segundos", segundos);
        
        // Actualizar componentes
        tiempo.setText(tiempoTexto);
        TextoResultado.setText(textoAMostrar);
        TextoResultado.setEditable(false);
        TextoResultado.setLineWrap(true);
        TextoResultado.setWrapStyleWord(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        tiempo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Resultados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 40));

        Close.setBackground(new java.awt.Color(255, 0, 0));
        Close.setText("X");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jPanel1.add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        tiempo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tiempo.setText("Tipo de busqueda: ");
        jPanel1.add(tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, -1));

        TextoResultado.setColumns(20);
        TextoResultado.setRows(5);
        TextoResultado.setText("No se encontraron resultados");
        jScrollPane1.setViewportView(TextoResultado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 360, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

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
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String respuesta = "";
                long inicio = System.nanoTime();
                long fin = System.nanoTime();
                long tiempoTranscurrido = fin - inicio;
                new Resultados(respuesta, tiempoTranscurrido).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JTextArea TextoResultado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables
}
