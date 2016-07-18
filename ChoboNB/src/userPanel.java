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
        agregarRegistro = new javax.swing.JButton();
        eliminarRegistro = new javax.swing.JButton();

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

        clienteButton.setText("Cliente");
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

        agregarRegistro.setText("Agregar");

        eliminarRegistro.setText("Eliminar");
        eliminarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(productosButton)
                        .addGap(28, 28, 28)
                        .addComponent(clienteButton)
                        .addGap(32, 32, 32)
                        .addComponent(agregarRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(productosButton)
                                .addComponent(clienteButton))
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarRegistro)
                            .addComponent(eliminarRegistro))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void eliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarRegistroActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRow;
        if ((selectedRow = jTable2.getSelectedRow()) != -1) {
            Map<String, String> objectsKeysToRemove = new HashMap<String, String>();
            for (Map.Entry entry : bs.model.getKeyIndexFrom(actualDBTable).entrySet()) {
                objectsKeysToRemove.put(entry.getValue().toString(), 
                    "'" + model.getValueAt(selectedRow, (Integer)entry.getKey()).toString() + "'");
            }
            bs.model.removeRow(actualDBTable, objectsKeysToRemove);
            model.removeRow(selectedRow);
            // System.out.println("Succesfully removed from database");
        }
    }//GEN-LAST:event_eliminarRegistroActionPerformed
    
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
    private javax.swing.JButton agregarRegistro;
    private javax.swing.JButton clienteButton;
    private javax.swing.JButton eliminarRegistro;
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton productosButton;
    // End of variables declaration//GEN-END:variables

}
