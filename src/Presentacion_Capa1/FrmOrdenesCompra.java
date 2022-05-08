package Presentacion_Capa1;

import Entidades.OrdenesCompra;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Trabajador;
import LogicaNegocio_Capa2.LNOrdenesCompra;
import LogicaNegocio_Capa2.LNProducto;
import LogicaNegocio_Capa2.LNProovedor;
import LogicaNegocio_Capa2.LNTrabajador;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author Telyman
 */
public class FrmOrdenesCompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmOrdenesCompra
     */
    
    
      private OrdenesCompra GenerarEntidad(){
        //PONER AQUI SI FALTAN DATOSSSSSSSS
        OrdenesCompra ordenes = new OrdenesCompra();
        
        Date fecha = new Date();
        //Date fecha2 = new Date();
        fecha = DCFechaOrdenP.getDate();
        //fecha2 = DCFechaLlegadaP.getDate();
      
        
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        //java.sql.Date sqlDate2 = new java.sql.Date(fecha2.getTime());
                
        try {
              
              if (!TxtNumOrden.getText().equals("")) {
                  ordenes.setExiste(true);
                  ordenes.setNumero_orden(Integer.parseInt(TxtNumOrden.getText()));
              }
              ordenes.setNumero_orden(Integer.parseInt(TxtNumOrden.getText()));
              ordenes.setNumero_producto(Integer.parseInt(TxtNumProducto.getText()));
              ordenes.setNum_proveedor(Integer.parseInt(TxtNumProv.getText()));
              ordenes.setNombre_producto( TxtNombProduc.getText());
              ordenes.setFecha_orden_pedido(sqlDate);
              //ordenes.setFecha_recibida_pedido(sqlDate2);
              ordenes.setCantidad(Integer.parseInt(TxtCant.getValue().toString())); 
              ordenes.setPrecio_x_unidad(Float.parseFloat((TxtPrecioU.getText())));
              ordenes.setImpuesto(Float.parseFloat((TxtImpuesto.getText())));
              ordenes.setTotal_a_pagar(Float.parseFloat((TxtTotalPagar.getText())));
              ordenes.setId_trabajador(Integer.parseInt(TxtIdTrabaj.getText()));
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this, e.getMessage());
          }

          return ordenes;
      
       
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
        TblOrdenCompra.setModel(modelo);
        modelo.addColumn("Orden N°");
        modelo.addColumn("Producto N°");
        modelo.addColumn("Proveedor N°");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Fecha Orden");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio X Unidad");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Total a pagar");
        modelo.addColumn("ID Trabajador");
    
   
    }
     //Metodo para cargar los CLIENTES EN LA TABLA
    private void CargarDatos(String condicion) throws  Exception{
        try {
            LNOrdenesCompra logica = new LNOrdenesCompra();
            List<OrdenesCompra> lista;
            LimpiarTabla();
            Object[] fila = new Object[10];
            lista = logica.ListarRegistros(condicion);
            for(OrdenesCompra orden:lista){
                fila[0] = orden.getNumero_orden();
                fila[1] = orden.getNumero_producto();
                fila[2] = orden.getNum_proveedor();
                fila[3] = orden.getNombre_producto();
                fila[4] = orden.getFecha_orden_pedido();
                fila[5] = orden.getCantidad();
                fila[6] = orden.getPrecio_x_unidad();
                fila[7] = orden.getImpuesto();
                fila[8] = orden.getTotal_a_pagar();
                fila[9] = orden.getId_trabajador();
                
                
                modelo.addRow(fila);
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void Limpiar(){
        TxtNumOrden.setText("");
        TxtNumProducto.setText("");
        TxtNumProv.setText("");
        TxtNombProduc.setText("");
        TxtPrecioU.setText("");
        //TxtImpuesto.setText("");
        TxtTotalPagar.setText("");
        TxtIdTrabaj.setText("");
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public FrmOrdenesCompra() {
        initComponents();
        float imp=13;
            try {
            CargarDatos("");
            TxtImpuesto.setText(""+imp);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TxtPrecioU = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtTotalPagar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtImpuesto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtNumOrden = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtIdTrabaj = new javax.swing.JTextField();
        TxtNumProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNombProduc = new javax.swing.JTextField();
        BtnBuscarP = new javax.swing.JButton();
        DCFechaOrdenP = new com.toedter.calendar.JDateChooser();
        BtnBuscarTrabajador = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblOrdenCompra = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        TxtNumProv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        TxtCant = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TxtPrecioU.setEditable(false);
        TxtPrecioU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TxtPrecioUMouseEntered(evt);
            }
        });
        TxtPrecioU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPrecioUKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioUKeyTyped(evt);
            }
        });

        jLabel1.setText("N° Orden");

        TxtTotalPagar.setEditable(false);
        TxtTotalPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTotalPagarKeyTyped(evt);
            }
        });

        jLabel7.setText("Precio Por Unidad");

        TxtImpuesto.setEditable(false);
        TxtImpuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtImpuestoKeyTyped(evt);
            }
        });

        jLabel8.setText("Impuesto");

        jLabel9.setText("Total a Pagar");

        TxtNumOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNumOrdenKeyTyped(evt);
            }
        });

        jLabel11.setText("Id Trabajador ");

        jLabel2.setText("N° Producto");

        TxtIdTrabaj.setEditable(false);
        TxtIdTrabaj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIdTrabajKeyTyped(evt);
            }
        });

        TxtNumProducto.setEditable(false);
        TxtNumProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNumProductoKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre Producto");

        TxtNombProduc.setEditable(false);
        TxtNombProduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombProducKeyTyped(evt);
            }
        });

        BtnBuscarP.setText("Buscar Producto");
        BtnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarPActionPerformed(evt);
            }
        });

        BtnBuscarTrabajador.setText("Buscar Trabajador");
        BtnBuscarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarTrabajadorActionPerformed(evt);
            }
        });

        TblOrdenCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        TblOrdenCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblOrdenCompraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblOrdenCompra);

        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Ingresar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        TxtNumProv.setEditable(false);
        TxtNumProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNumProvKeyTyped(evt);
            }
        });

        jLabel5.setText("N° Proveedor");

        jLabel10.setText("Fecha Orden Pedido");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Mantenimiento de Ordenes de Compra");

        jLabel4.setText("Cantidad a Comprar");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNumOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNumProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(TxtNombProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(DCFechaOrdenP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(174, 174, 174))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(363, 363, 363))
            .addComponent(jSeparator1)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtCant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(TxtPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(TxtIdTrabaj, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnBuscarTrabajador)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(BtnBuscarP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtNumOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtNumProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtNombProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DCFechaOrdenP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(BtnBuscarP)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIdTrabaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBuscarTrabajador)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        if (TxtNumProducto.getText().equals("") || TxtNumOrden.getText().equals("") || TxtNombProduc.getText().equals("") || TxtNumProv.getText().equals("") || TxtPrecioU.getText().equals("") || TxtImpuesto.getText().equals("") || TxtIdTrabaj.getText().equals("") || TxtTotalPagar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe insertar datos");
        } else {
            LNOrdenesCompra logica = new LNOrdenesCompra();
            OrdenesCompra ordenes = GenerarEntidad();
            try {
                if((logica.VerificarIns(ordenes))==1){
                   
                JOptionPane.showMessageDialog(this, logica.getMensaje());
                }else{
                    logica.Insertar(ordenes);
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


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TblOrdenCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblOrdenCompraMouseClicked
        // TODO add your handling code here:
         try {
             LNOrdenesCompra logica = new LNOrdenesCompra();
                OrdenesCompra orden;
                String condicion;
            
            if(evt.getClickCount() == 2){
                int fila = TblOrdenCompra.rowAtPoint(evt.getPoint());
                TxtNumOrden.setText(TblOrdenCompra.getValueAt(fila, 0).toString());
                condicion = String.format("numero_orden = %s", TxtNumOrden.getText());
                orden = logica.ObtenerRegistro(condicion);
                
                TxtNumOrden.setText(String.valueOf(orden.getNumero_orden()));
                TxtNumProducto.setText(String.valueOf(orden.getNumero_producto()));
                TxtNumProv.setText(String.valueOf(orden.getNum_proveedor()));
                TxtNombProduc.setText(orden.getNombre_producto());
                DCFechaOrdenP.setDate(java.sql.Date.valueOf(orden.getFecha_orden_pedido().toString()));
               // DCFechaLlegadaP.setDate(java.sql.Date.valueOf(orden.getFecha_recibida_pedido().toString()));
                TxtCant.setValue(orden.getCantidad());
                TxtPrecioU.setText(String.valueOf(orden.getPrecio_x_unidad()));
                TxtImpuesto.setText(String.valueOf( orden.getImpuesto())); 
                TxtTotalPagar.setText(String.valueOf( orden.getTotal_a_pagar()));
                TxtIdTrabaj.setText(String.valueOf( orden.getId_trabajador()));
            } 
            
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_TblOrdenCompraMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
                if (TxtNumProducto.getText().equals("") || TxtNumOrden.getText().equals("") || TxtNombProduc.getText().equals("") || TxtNumProv.getText().equals("") || TxtPrecioU.getText().equals("") || TxtImpuesto.getText().equals("") /*|| TxtPrecioC.getText().equals("")*/ || TxtTotalPagar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una orden de compra para modificarla");
        } else {
            LNOrdenesCompra logica = new LNOrdenesCompra();
            OrdenesCompra ordenes = GenerarEntidad();
            try {
                if((logica.VerificarMod(ordenes))==1 || (logica.VerificarExiste(ordenes))==1){
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                }else{
                    logica.Modificar(ordenes);
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

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                if (TxtNumProducto.getText().equals("") || TxtNumOrden.getText().equals("") || TxtNombProduc.getText().equals("") || TxtNumProv.getText().equals("") || TxtPrecioU.getText().equals("") || TxtImpuesto.getText().equals("") /*|| TxtPrecioC.getText().equals("")*/ || TxtTotalPagar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una orden de compra para eliminarla");
        } else {
            LNOrdenesCompra logica = new LNOrdenesCompra();
            OrdenesCompra ordenes = GenerarEntidad();
            try {
                if((logica.VerificarExiste(ordenes))==1){
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                }else{
                    logica.Eliminar(ordenes);
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

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        FrmBuscarOrdenCompra buscar = new FrmBuscarOrdenCompra(null, true);
        buscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = buscar.ObtenerId();
                    String condicion = "";
                    LNOrdenesCompra logica = new LNOrdenesCompra();
                    OrdenesCompra orden;
                    if (id > -1) {
                        condicion = String.format("numero_orden = %s", id);
                        orden = logica.ObtenerRegistro(condicion);

                        TxtNumOrden.setText(String.valueOf(orden.getNumero_orden()));
                        TxtNumProducto.setText(String.valueOf(orden.getNumero_producto()));
                        TxtNumProv.setText(String.valueOf(orden.getNum_proveedor()));
                        TxtNombProduc.setText(orden.getNombre_producto());
                        DCFechaOrdenP.setDate(java.sql.Date.valueOf(orden.getFecha_orden_pedido().toString()));
                        //DCFechaLlegadaP.setDate(java.sql.Date.valueOf(orden.getFecha_recibida_pedido().toString()));
                        TxtCant.setValue(orden.getCantidad());
                        TxtPrecioU.setText(String.valueOf(orden.getPrecio_x_unidad()));
                        TxtImpuesto.setText(String.valueOf(orden.getImpuesto()));
                        TxtTotalPagar.setText(String.valueOf(orden.getTotal_a_pagar()));
                        TxtIdTrabaj.setText(String.valueOf(orden.getId_trabajador()));
                    } else {
                        Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
       buscar.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void TxtNumOrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNumOrdenKeyTyped
        // TODO add your handling code here:
             char c = evt.getKeyChar();
            if( c<'0' || c > '9') evt.consume();
    }//GEN-LAST:event_TxtNumOrdenKeyTyped

    private void TxtNumProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNumProductoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
            if( c<'0' || c > '9') evt.consume();
    }//GEN-LAST:event_TxtNumProductoKeyTyped

    private void TxtNombProducKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombProducKeyTyped
        // TODO add your handling code here:
        SoloLetras(evt);
    }//GEN-LAST:event_TxtNombProducKeyTyped

    private void TxtNumProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNumProvKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
            if( c<'0' || c > '9') evt.consume();
    }//GEN-LAST:event_TxtNumProvKeyTyped

    private void TxtPrecioUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioUKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_TxtPrecioUKeyTyped

    private void TxtImpuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtImpuestoKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_TxtImpuestoKeyTyped

    private void TxtTotalPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTotalPagarKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_TxtTotalPagarKeyTyped

    private void TxtIdTrabajKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdTrabajKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
            if( c<'0' || c > '9') evt.consume();
    }//GEN-LAST:event_TxtIdTrabajKeyTyped

    private void BtnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarPActionPerformed
        // TODO add your handling code here:
        FrmBuscarProducto buscar = new FrmBuscarProducto(null, true);
        buscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = buscar.ObtenerId();
                    String condicion = "";
                    LNProducto logica = new LNProducto();
                    Producto producto;
                    if (id > -1) {
                        condicion = String.format("numero_producto = %s", id);
                        producto = logica.ObtenerRegistro(condicion);
                        
                        TxtNumProducto.setText(Integer.toString(producto.getNumero_producto()));
                        TxtNombProduc.setText(producto.getNombre_producto());
                        TxtNumProv.setText(Integer.toString(producto.getNum_proveedor()));
                        TxtPrecioU.setText(Float.toString(producto.getPrecio_compra()));
                        
                    } else {
                        Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
       buscar.setVisible(true);
    }//GEN-LAST:event_BtnBuscarPActionPerformed

    private void BtnBuscarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarTrabajadorActionPerformed
        // TODO add your handling code here:
         FrmBuscarTrabajador buscar = new FrmBuscarTrabajador(null, true);
        buscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = buscar.ObtenerId();
                    String condicion = "";
                    LNTrabajador logica = new LNTrabajador();
                    Trabajador trabajador;
                    if (id > -1) {
                        condicion = String.format("id_trabajador = %s", id);
                        trabajador = logica.ObtenerRegistro(condicion);
                        
                        TxtIdTrabaj.setText(Integer.toString(trabajador.getId_trabajador()));
                    } else {
                        Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
       buscar.setVisible(true);
    }//GEN-LAST:event_BtnBuscarTrabajadorActionPerformed

    private void TxtPrecioUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioUKeyReleased
        // TODO add your handling code here:
         try {
//            Float precioV = Float.parseFloat(TxtPrecioV.getText());
//            float descuento1 = 2;
//            float descuento2 = 3;
//            float descuento3 = 5;
//            float descuentoNull = 0;
//            if (precioV >= 10000 && precioV <= 19999) {
//
//                TxtDesc.setText("" + descuento1);
//            } else if (precioV >= 20000 && precioV <= 39999) {
//                TxtDesc.setText("" + descuento2);
//            } else if (precioV >= 40000) {
//                TxtDesc.setText("" + descuento3);
//            } else {
//                TxtDesc.setText("" + descuentoNull);
//            }
            
            //calcularPrecioTotal();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe llenar este campo");
        }
    }//GEN-LAST:event_TxtPrecioUKeyReleased

    private void TxtPrecioUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtPrecioUMouseEntered
        // TODO add your handling code here:
        calcularPrecioTotal();
    }//GEN-LAST:event_TxtPrecioUMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

      void calcularPrecioTotal(){
        float prec= Float.parseFloat(TxtPrecioU.getText());
        float cant = Integer.parseInt(TxtCant.getValue().toString());
        float imp = Float.parseFloat(TxtImpuesto.getText());
        float total =0;
        float subt =0;
        float mImp =0;
        
        subt = (prec*cant); 
        mImp= (subt*imp)/100;
        total = subt +mImp;
        TxtTotalPagar.setText("" + total);
       
        
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
            java.util.logging.Logger.getLogger(FrmOrdenesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenesCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOrdenesCompra().setVisible(true);
            }
        });
    }

    
//     char c = evt.getKeyChar();
//     if( c<'0' || c > '9') evt.consume();
//    
//    char c = evt.getKeyChar();
//    if( (c<'0' || c > '9') && (c!='.') ) evt.consume();
//    
         public void SoloLetras(KeyEvent evt){
        char s;
        s= evt.getKeyChar();
        if(!Character.isLetter(s) && s != KeyEvent.VK_SPACE ){
            evt.consume();
        }
    }
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarP;
    private javax.swing.JButton BtnBuscarTrabajador;
    private com.toedter.calendar.JDateChooser DCFechaOrdenP;
    private javax.swing.JTable TblOrdenCompra;
    private javax.swing.JSpinner TxtCant;
    private javax.swing.JTextField TxtIdTrabaj;
    private javax.swing.JTextField TxtImpuesto;
    private javax.swing.JTextField TxtNombProduc;
    private javax.swing.JTextField TxtNumOrden;
    private javax.swing.JTextField TxtNumProducto;
    private javax.swing.JTextField TxtNumProv;
    private javax.swing.JTextField TxtPrecioU;
    private javax.swing.JTextField TxtTotalPagar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
