/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clavedicotomica;

import javax.swing.JOptionPane;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;
//import org.graphstream.ui.layout.util.LayoutOrientation;

/**
 *
 * @author adcd_
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    private ArbolBinario AB;
    public Inicio(ArbolBinario AB) {
        this.AB = AB;
        initComponents();
        setLocationRelativeTo(null); //CEntrar ventana
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MostrarArbol = new javax.swing.JButton();
        DeterminarEspecie = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        InputBuscar = new javax.swing.JTextField();
        BusquedaHash = new javax.swing.JRadioButton();
        BusquedaArbol = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Clave Dicotomica");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Inicio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        MostrarArbol.setText(" Mostrar como árbol");
        MostrarArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarArbolActionPerformed(evt);
            }
        });
        jPanel1.add(MostrarArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        DeterminarEspecie.setText("Determinar especie");
        DeterminarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeterminarEspecieActionPerformed(evt);
            }
        });
        jPanel1.add(DeterminarEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));
        jPanel1.add(InputBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 150, -1));

        buttonGroup1.add(BusquedaHash);
        BusquedaHash.setText("Por Hash");
        BusquedaHash.setToolTipText("");
        jPanel1.add(BusquedaHash, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        buttonGroup1.add(BusquedaArbol);
        BusquedaArbol.setSelected(true);
        BusquedaArbol.setText("Por Arbol");
        BusquedaArbol.setToolTipText("");
        jPanel1.add(BusquedaArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        jLabel3.setText("Metodo de busqueda:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String valorPorBuscar = InputBuscar.getText();
        if (valorPorBuscar.isEmpty() || valorPorBuscar.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Texto inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            InputBuscar.setText("");
            Nodo respuesta = null;
            if (BusquedaArbol.isSelected()) {
                //Busqueda por Arbol
                respuesta = AB.buscar(AB.getRaiz(),valorPorBuscar);
            } else if (BusquedaHash.isSelected()) {
                //Busqueda por Hash
            }

            Resultados r = new Resultados(respuesta);
            r.setVisible(true);
        }
        
    }//GEN-LAST:event_BuscarActionPerformed

    private void MostrarArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarArbolActionPerformed
        // Configurar GraphStream
        System.setProperty("org.graphstream.ui", "swing");
        Graph grafo = new SingleGraph("Clave Dicotómica");
        
        // Estilos avanzados
        grafo.setAttribute("ui.stylesheet", 
            "node {"
            + "   fill-color: #B3C9C0;"
            + "   size: 40px;"
            + "   text-size: 14px;"
            + "   text-alignment: center;"
            + "   stroke-mode: plain;"
            + "   stroke-color: #3A6351;"
            + "}"
            + "edge {"
            + "   fill-color: #3A6351;"
            + "   size: 2px;"
            + "}");
        
        // Construir el gráfico
        AB.construirGrafo(AB.getRaiz(), grafo, "0");
        
        // Mostrar con diseño jerárquico
        Viewer viewer = grafo.display();
        HierarchicalLayout layout = new HierarchicalLayout();
        //layout.setOrientation(LayoutOrientation.TOP_TO_BOTTOM); // Raíz arriba
        //viewer.enableAutoLayout(layout);
    }//GEN-LAST:event_MostrarArbolActionPerformed

    private void DeterminarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeterminarEspecieActionPerformed
        String historial = "";
        AB.preguntar(this, AB.getRaiz(), historial);
    }//GEN-LAST:event_DeterminarEspecieActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArbolBinario AB = new ArbolBinario();
                new Inicio(AB).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JRadioButton BusquedaArbol;
    private javax.swing.JRadioButton BusquedaHash;
    private javax.swing.JButton DeterminarEspecie;
    private javax.swing.JTextField InputBuscar;
    private javax.swing.JButton MostrarArbol;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
