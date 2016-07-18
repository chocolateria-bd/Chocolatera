
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class adminPanel extends javax.swing.JPanel {

    private String columnas[] = {"Nombre", "apellido"};
    private String filas[][];
    
    private String columnas2[] = {"Nombre", "Fecha", "data"};
    DefaultTableModel tabla;
    String actualDBTable; 
    
    public static adminPanel instance = null;
    
    public static adminPanel getInstance(){
        return instance;
    }
    
    /**
     * Creates new form adminPanel
     */
    public adminPanel() {
        initComponents();
        instance = this;
        tabla = new DefaultTableModel(filas, columnas);
        jTable1.setModel(tabla);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        productosButton = new javax.swing.JButton();
        clientesButton = new javax.swing.JButton();
        empresaButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(74, 28));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("Agregar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        productosButton.setText("Productos");
        productosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosButtonActionPerformed(evt);
            }
        });

        clientesButton.setText("Clientes");
        clientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesButtonActionPerformed(evt);
            }
        });

        empresaButton.setText("Empresas");
        empresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(productosButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empresaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productosButton)
                    .addComponent(clientesButton)
                    .addComponent(empresaButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRow;
        if ((selectedRow = jTable1.getSelectedRow()) != -1) {
            Map<String, String> objectsKeysToRemove = new HashMap<String, String>();
            for (Map.Entry entry : bs.model.getKeyIndexFrom(actualDBTable).entrySet()) {
                objectsKeysToRemove.put(entry.getValue().toString(), 
                    "'" + model.getValueAt(selectedRow, (Integer)entry.getKey()).toString() + "'");
            }
            bs.model.removeRow(actualDBTable, objectsKeysToRemove);
            model.removeRow(selectedRow);
             System.out.println("Succesfully removed from database");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesButtonActionPerformed
        updateJTableWith("cliente");
        actualDBTable = "cliente";
    }//GEN-LAST:event_clientesButtonActionPerformed

    private void productosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosButtonActionPerformed
        updateJTableWith("producto");
        actualDBTable = "producto";
    }//GEN-LAST:event_productosButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Utils.initNewFrame(actualDBTable);
    }//GEN-LAST:event_addButtonActionPerformed

    private void empresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresaButtonActionPerformed
        updateJTableWith("empresa");
        actualDBTable = "empresa";
    }//GEN-LAST:event_empresaButtonActionPerformed
    
    public void updateDatabase(List<String> values){
        DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
        
        tableModel.addRow(Utils.listToArray(values));
        bs.model.addRow(actualDBTable, values);
    }
    
    public void updateJTableWith(String tableName) {
        setBootstrap();
        Map<String, List<String>> tableNames = bs.model.getTableNames();
        List<String> namesList = tableNames.get(tableName);
        System.out.println("Columnas de " + tableName + ": " + namesList);
        updateTableModel(Utils.listOfListsToArray(bs.model.selectAllFromLoader(tableName), tableName), 
                Utils.listToArray(namesList));
        System.out.println("Actualizacion Correcta con " + tableName);
    }
    
    public Bootstrap bs = null;
    
    public void setBootstrap(){
        if (bs == null){
            bs = Bootstrap.getInstance();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clientesButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton empresaButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton productosButton;
    // End of variables declaration//GEN-END:variables
}
