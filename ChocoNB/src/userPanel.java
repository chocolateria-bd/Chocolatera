/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Victor
 */
public class userPanel extends javax.swing.JPanel {
    
    private String columnas[] = {"Nombre", "apellido"};
    private String filas[][];
    
    private String columnas2[] = {"Nombre", "Fecha", "data"};
    DefaultTableModel tabla;
    String actualDBTable;
    
    /**
     * Creates new form userPanel
     */
    public userPanel() {
        initComponents();
        tabla = new DefaultTableModel(filas, columnas);
        jTable2.setModel(tabla);
    }
    
    private void updateTableModel(Object rows[][], String columns[]){
        // tabla = new DefaultTableModel(rows, columns);
        
        tabla.setDataVector(rows, columns);
        tabla.fireTableDataChanged();
        
        // jTable2.setModel(tabla);
        // jScrollPane2.setViewportView(jTable2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        productosButton = new javax.swing.JButton();
        clienteButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        empresasButton = new javax.swing.JButton();
        cursoButton = new javax.swing.JButton();
        facturaButton = new javax.swing.JButton();
        maquinariaButton = new javax.swing.JButton();
        personaButton = new javax.swing.JButton();
        empleadoButton = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"asd", "asd", null, null},
                {null, "asd", null, null},
                {null, null, null, null},
                {null, null, "asd", "123123"}
            },
            new String [] {
                "Productos", "S", "SD", "A4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        productosButton.setText("Productos");
        productosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosButtonActionPerformed(evt);
            }
        });

        clienteButton.setText("Clientes");
        clienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        empresasButton.setText("Empresas");
        empresasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresasButtonActionPerformed(evt);
            }
        });

        cursoButton.setText("Curso");
        cursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoButtonActionPerformed(evt);
            }
        });

        facturaButton.setText("Facturas");
        facturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaButtonActionPerformed(evt);
            }
        });

        maquinariaButton.setText("Maquinaria");
        maquinariaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinariaButtonActionPerformed(evt);
            }
        });

        personaButton.setText("Personas");
        personaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personaButtonActionPerformed(evt);
            }
        });

        empleadoButton.setText("Empleados");
        empleadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maquinariaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clienteButton)
                    .addComponent(personaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(empresasButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cursoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(facturaButton))
                    .addComponent(empleadoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maquinariaButton)
                            .addComponent(personaButton)
                            .addComponent(empleadoButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productosButton)
                            .addComponent(clienteButton)
                            .addComponent(empresasButton)
                            .addComponent(cursoButton)
                            .addComponent(facturaButton)))))
        );
    }// </editor-fold>//GEN-END:initComponents

        // soy un comentario
    private void productosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosButtonActionPerformed
        updateJTableWith("producto");
        actualDBTable = "producto";
    }//GEN-LAST:event_productosButtonActionPerformed

    private void clienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteButtonActionPerformed
        updateJTableWith("cliente");
        actualDBTable = "cliente";
    }//GEN-LAST:event_clienteButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        setBootstrap();
        if (bs.model.closeConnection()) {
            System.out.println("Logged out exitoso");
            bs.view.swapPanel("loginPanel");
        } else {
            System.out.println("Error al cerrar la conexion a la bd");
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void maquinariaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinariaButtonActionPerformed
        updateJTableWith("maquina");
        actualDBTable = "maquina";
    }//GEN-LAST:event_maquinariaButtonActionPerformed

    private void empresasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresasButtonActionPerformed
        updateJTableWith("empresa");
        actualDBTable = "empresa";
    }//GEN-LAST:event_empresasButtonActionPerformed

    private void cursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoButtonActionPerformed
        updateJTableWith("curso");
        actualDBTable = "curso";
    }//GEN-LAST:event_cursoButtonActionPerformed

    private void facturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaButtonActionPerformed
        updateJTableWith("vende");
        actualDBTable = "vende";
    }//GEN-LAST:event_facturaButtonActionPerformed

    private void personaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personaButtonActionPerformed
        updateJTableWith("persona");
        actualDBTable = "persona";
    }//GEN-LAST:event_personaButtonActionPerformed

    private void empleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadoButtonActionPerformed
        updateJTableWith("empleado");
        actualDBTable = "empleado";
    }//GEN-LAST:event_empleadoButtonActionPerformed
    
    public Bootstrap bs = null;
    
    public void setBootstrap(){
        if (bs == null){
            bs = Bootstrap.getInstance();
        }
    }
    
    public void updateJTableWith(String tableName) {
        setBootstrap();
        Map<String, List<String>> tableNames = bs.model.getTableNames();
        List<String> namesList = tableNames.get(tableName);
        System.out.println("Columnas de " + tableName + ": " + namesList);
        updateTableModel(Utils.listOfListsToArray(bs.model.selectAllFromLoader(tableName), tableName), Utils.listToArray(namesList));
        System.out.println("Actualizacion Correcta con " + tableName);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clienteButton;
    private javax.swing.JButton cursoButton;
    private javax.swing.JButton empleadoButton;
    private javax.swing.JButton empresasButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton facturaButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton maquinariaButton;
    private javax.swing.JButton personaButton;
    private javax.swing.JButton productosButton;
    // End of variables declaration//GEN-END:variables

}
