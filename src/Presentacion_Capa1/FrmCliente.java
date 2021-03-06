package Presentacion_Capa1;

import Entidades.Cliente;
import javax.swing.table.DefaultTableModel;

import Entidades.Cliente;
import LogicaNegocio_Capa2.LNCliente;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author Telyman
 */
public class FrmCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCliente
     */
    
      
    private Cliente GenerarEntidad(){
        //PONER AQUI SI FALTAN DATOSSSSSSSS
       
        Cliente cliente = new Cliente();
      
        cliente.setId_cliente(Integer.parseInt( TxtIDCliente.getText()));
        cliente.setNombre(TxtNombre.getText());
        cliente.setApellidos(TxtApellidos.getText());
        cliente.setTelefono(TxtTelefono.getText());
        cliente.setResidencia(TxtResidencia.getText());
      
       
        return cliente;
    }
    
       //VARIABLE GLOBAL
    DefaultTableModel modelo;
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblCliente.setModel(modelo);
        modelo.addColumn("ID Cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Residencia");
   
    }
    
      //Metodo para cargar los CLIENTES EN LA TABLA
    private void CargarDatos(String condicion) throws  Exception{
        try {
            LNCliente logica = new LNCliente();
            List<Cliente> lista;
            LimpiarTabla();
            Object[] fila = new Object[5];
            lista = logica.ListarRegistros(condicion);
            for(Cliente cliente:lista){
                fila[0] = cliente.getId_cliente();
                fila[1] = cliente.getNombre();
                fila[2] = cliente.getApellidos();
                fila[3] = cliente.getTelefono();
                fila[4] = cliente.getResidencia();
                modelo.addRow(fila);
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void Limpiar(){
        TxtIDCliente.setText("");
        TxtNombre.setText("");
        TxtApellidos.setText("");
        TxtTelefono.setText("");
        TxtResidencia.setText("");
    }
    
    
    
    public FrmCliente() {
        initComponents();
        
         try {
            CargarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtIDCliente = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtResidencia = new javax.swing.JTextField();
        TxtApellidos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblCliente = new javax.swing.JTable();
        BtnLimpiar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnIngresar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("Buscar un Cliente");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setText("Telefono");

        TxtIDCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIDClienteKeyTyped(evt);
            }
        });

        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel1.setText("Identificacion");

        TxtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidosKeyTyped(evt);
            }
        });

        jLabel7.setText("Apellidos");

        jLabel3.setText("Residencia");

        TxtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelefonoKeyTyped(evt);
            }
        });

        TblCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        TblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblCliente);

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Mantenimiento de Clientes");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnIngresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(11, 11, 11))))
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLimpiar)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnModificar)
                    .addComponent(BtnIngresar)
                    .addComponent(BtnBuscar)
                    .addComponent(jButton1))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        // TODO add your handling code here:
        if (TxtIDCliente.getText().equals("") || TxtNombre.getText().equals("") || TxtApellidos.getText().equals("") || TxtTelefono.getText().equals("") || TxtResidencia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar datos");
        } else {
            LNCliente logica = new LNCliente();
            Cliente cliente = GenerarEntidad();
            try {
               if((logica.VerificarInsert(cliente))==1){
                   JOptionPane.showMessageDialog(this, logica.getMensaje());
               }else{
                   logica.Insertar(cliente);
                   //JOptionPane.showMessageDialog(this, logica.getMensaje());
               }
                
                Limpiar();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            try {
                CargarDatos("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

         
    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void TblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblClienteMouseClicked
        // TODO add your handling code here:
        try {
            LNCliente logica = new LNCliente();
            Cliente cliente;
            String condicion;
            
            if(evt.getClickCount() == 2){
                int fila = TblCliente.rowAtPoint(evt.getPoint());
                TxtIDCliente.setText(TblCliente.getValueAt(fila, 0).toString());
                condicion = String.format("id_cliente = %s", TxtIDCliente.getText());
                cliente = logica.ObtenerRegistro(condicion);
                
                TxtIDCliente.setText(String.valueOf(cliente.getId_cliente()));
                TxtNombre.setText(cliente.getNombre());
                TxtApellidos.setText(cliente.getApellidos());
                TxtTelefono.setText(cliente.getTelefono());
                TxtResidencia.setText(cliente.getResidencia());
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_TblClienteMouseClicked

    private void TxtIDClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIDClienteKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0' || c > '9') evt.consume();
    }//GEN-LAST:event_TxtIDClienteKeyTyped

    private void TxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyTyped
        // TODO add your handling code here:
        SoloLetras(evt);
    }//GEN-LAST:event_TxtNombreKeyTyped

    private void TxtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidosKeyTyped
        // TODO add your handling code here:
        SoloLetras(evt);
    }//GEN-LAST:event_TxtApellidosKeyTyped

    private void TxtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0' || c > '9') evt.consume();
    }//GEN-LAST:event_TxtTelefonoKeyTyped

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
           // TODO add your handling code here:
          
        if (TxtIDCliente.getText().equals("") || TxtNombre.getText().equals("") || TxtApellidos.getText().equals("") || TxtTelefono.getText().equals("") || TxtResidencia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificarlo");
        } else {
            LNCliente logica = new LNCliente();
            Cliente cliente = GenerarEntidad();
            try {
                if((logica.VerificarMod(cliente))==1 || (logica.VerificarExiste(cliente))==1){
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                }else{
                   logica.Modificar(cliente);

                JOptionPane.showMessageDialog(this, logica.getMensaje());
                Limpiar();
                }
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            try {
                CargarDatos("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        if (TxtIDCliente.getText().equals("") || TxtNombre.getText().equals("") || TxtApellidos.getText().equals("") || TxtTelefono.getText().equals("") || TxtResidencia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para eliminarlo");
        } else {
            LNCliente logica = new LNCliente();

            Cliente cliente = GenerarEntidad();

             try {
                if((logica.VerificarEliminar(cliente))==1 || (logica.VerificarExiste(cliente))==1){
                     JOptionPane.showMessageDialog(this, logica.getMensaje());
                }else{
                      logica.Eliminar(cliente);
                 JOptionPane.showMessageDialog(this, logica.getMensaje());
               
                }
              
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            try {
                CargarDatos("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
        FrmBuscarCliente buscar = new FrmBuscarCliente(null, true);
        buscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = buscar.ObtenerId();
                    String condicion = "";
                    LNCliente logica = new LNCliente();
                    Cliente cliente;
                    if (id > -1) {
                        condicion = String.format("id_cliente = %d", id); //d es para enteros
                        cliente = logica.ObtenerRegistro(condicion);
                        TxtIDCliente.setText(String.valueOf(cliente.getId_cliente()));
                        TxtNombre.setText(cliente.getNombre());
                        TxtApellidos.setText(cliente.getApellidos());
                        TxtTelefono.setText(cliente.getTelefono());
                        TxtResidencia.setText(cliente.getResidencia());
                    } else {
                        Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
       buscar.setVisible(true);

    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }
    
    public void SoloLetras(KeyEvent evt){
        char s;
        s= evt.getKeyChar();
        if(!Character.isLetter(s) && s != KeyEvent.VK_SPACE ){
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JTable TblCliente;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtIDCliente;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtResidencia;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
