/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion_Capa1;

import Entidades.EncabezadoFactura;
import LogicaNegocio_Capa2.LNEncabezadoFactura;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Telyman
 */
public class FrmBuscarEncabezado extends javax.swing.JDialog {

    /**
     * Creates new form FrmBuscarEncabezado
     */
    //VARIABLE GLOBAL
    DefaultTableModel modelo;
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblFactura.setModel(modelo);
        modelo.addColumn("Factura N°");
        modelo.addColumn("ID Trabajador");
        modelo.addColumn("Fecha");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Monto Total");
        modelo.addColumn("ID Cliente");
   
    }
        private void CargarDatos(String condicion) throws  Exception{
        try {
            LNEncabezadoFactura logica = new LNEncabezadoFactura();
            List<EncabezadoFactura> lista;
            LimpiarTabla();
            Object[] fila = new Object[6];
            lista = logica.ListarRegistros(condicion);
            for(EncabezadoFactura encabezado:lista){
                fila[0] = encabezado.getNumero_factura();
                fila[1] = encabezado.getId_trabajador();
                fila[2] = encabezado.getFecha();
                fila[3] = encabezado.getImpuesto();
                fila[4] = encabezado.getMonto_a_pagar();
                fila[5] = encabezado.getId_cliente();
                modelo.addRow(fila);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public int ObtenerId() {
        int codigo = -1;
        if (!TxtId.getText().equals("")) {
            codigo = Integer.parseInt(TxtId.getText());
        }
        return codigo;
    }

   
        
    
    
    public FrmBuscarEncabezado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
            this.setTitle("Buscar Encabezado");
        //Centrar el modal
        this.setLocationRelativeTo(null);
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

        BtnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TxtN = new javax.swing.JTextField();
        BtBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblFactura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BtnCancelar.setText("Cancelar");

        jLabel1.setText("Código");

        jLabel2.setText("N° Factura");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("Buscar Encabezado");

        TxtId.setEditable(false);

        TxtN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNKeyTyped(evt);
            }
        });

        BtBuscar.setText("Buscar Factura");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });

        TblFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        TblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblFactura);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BtnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtN, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtBuscar)
                        .addGap(141, 141, 141))))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCancelar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNKeyTyped
        // TODO add your handling code here:
        //SoloLetras(evt);
        char c = evt.getKeyChar();
        if(c<'0' || c > '9') evt.consume();
        
      
    }//GEN-LAST:event_TxtNKeyTyped

    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
        // TODO add your handling code here:
          String condicion = "";
        try {
            if(!TxtN.getText().equals("")){
                condicion = "NUMERO_FACTURA LIKE '%" + TxtN.getText() + "%'";
            }
            CargarDatos(condicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_BtBuscarActionPerformed

    private void TblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblFacturaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            //Saber a cual fila se le dió click
            int fila = TblFactura.rowAtPoint(evt.getPoint());

            TxtId.setText(TblFactura.getValueAt(fila, 0).toString());
            TxtN.setText(TblFactura.getValueAt(fila, 1).toString());

            this.dispose();
        }
    }//GEN-LAST:event_TblFacturaMouseClicked

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
            java.util.logging.Logger.getLogger(FrmBuscarEncabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarEncabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarEncabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarEncabezado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmBuscarEncabezado dialog = new FrmBuscarEncabezado(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JTable TblFactura;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}