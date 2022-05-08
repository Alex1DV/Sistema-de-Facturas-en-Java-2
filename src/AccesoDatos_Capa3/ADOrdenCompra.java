/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos_Capa3;

/**
 *
 * @author Telyman
 */

import Config.Config;
import Entidades.Cliente;
import Entidades.OrdenesCompra;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Trabajador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;


public class ADOrdenCompra {
     //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    
    public String getMensaje() {
        return _mensaje;
    }
    
    public ADOrdenCompra() throws Exception {
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int Insertar(OrdenesCompra ordenescompra) throws Exception{
        int id_orden_c = 1;
        String sentencia = "INSERT INTO ORDENES_DE_COMPRA(NUMERO_ORDEN,NUMERO_PRODUCTO,NUM_PROVEEDOR,NOMBRE_PRODUCTO,FECHA_ORDEN_PEDIDO,CANTIDAD,PRECIO_X_UNIDAD,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR) values(?,?,?,?,?,?,?,?,?,?)";
        Calendar fecha = new GregorianCalendar();
        
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, ordenescompra.getNumero_orden());
            ps.setInt(2,ordenescompra.getNumero_producto());
            ps.setInt(3, ordenescompra.getNum_proveedor());
            ps.setString(4,ordenescompra.getNombre_producto());
            ps.setDate(5,ordenescompra.getFecha_orden_pedido()); //AQUIIIIIIIIIII
            //ps.setDate(6,ordenescompra.getFecha_recibida_pedido());
            ps.setInt(6, ordenescompra.getCantidad());
            ps.setFloat(7,ordenescompra.getPrecio_x_unidad());
            ps.setFloat(8,ordenescompra.getImpuesto());
            ps.setFloat(9,ordenescompra.getTotal_a_pagar());
            ps.setInt(10,ordenescompra.getId_trabajador());
            ps.execute();
            //ResultSet rs = ps.getGeneratedKeys(); //El result set es como una tabla con un registro
            //if(rs!=null && rs.next()){ //SI SE GENERÓ EL RESULTSET Y HAY OTRO REGISTRO
                //id_orden_c=rs.getInt(1);
                _mensaje = "Orden de compra ingresada con exito";
            //}
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return id_orden_c;
    }//Fin Insertar
    
    public ResultSet ListarRegistros(String condicion , String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT NUMERO_ORDEN,NUMERO_PRODUCTO,NUM_PROVEEDOR,NOMBRE_PRODUCTO,FECHA_ORDEN_PEDIDO,CANTIDAD,PRECIO_X_UNIDAD,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR from ordenes_de_compra";
            if(!condicion.equals("")){
                sentencia=String.format("%s where %s" , sentencia,condicion);
            }
            if(!orden.equals("")){
                sentencia = String.format("%s order by %s" , sentencia, orden);
            }
            rs = stm.executeQuery(sentencia);
        } catch (Exception e) {
            throw  e;
        } finally {
            _cnn=null;
        }
        return rs; //devuelve el result set
    }
    
    //OTRA MANERA DE LISTAR
    public List<OrdenesCompra> ListarRegistros(String condicion) throws SQLException{
        ResultSet rs = null;
        List<OrdenesCompra> lista = new ArrayList();
        try {
            Statement stm= _cnn.createStatement();
            String sentencia = "SELECT NUMERO_ORDEN,NUMERO_PRODUCTO,NUM_PROVEEDOR,NOMBRE_PRODUCTO,FECHA_ORDEN_PEDIDO,CANTIDAD,PRECIO_X_UNIDAD,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR from ordenes_de_compra";
            if(!condicion.equals("")){
                sentencia=String.format("%s where %s" , sentencia,condicion);
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new OrdenesCompra(rs.getInt("numero_orden"), rs.getInt("numero_producto"),rs.getInt("num_proveedor"), rs.getString("nombre_producto"),/*AQUIII*/ rs.getDate("fecha_orden_pedido"),  rs.getInt("cantidad"), rs.getFloat("precio_x_unidad"), rs.getFloat("impuesto"), rs.getFloat("total_a_pagar"), rs.getInt("id_trabajador")));
            }
            
            
        } catch (Exception e) {
            throw  e;
        } finally {
            _cnn = null;
        }
        return lista;
    }

    //FIN OTRA MANERA DE LISTAR
    
    //OBTENER UN CLIENTE
    public OrdenesCompra ObtenerRegistro(String condicion) throws SQLException{
        OrdenesCompra ordenescompra = new OrdenesCompra();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT NUMERO_ORDEN,NUMERO_PRODUCTO,NUM_PROVEEDOR,NOMBRE_PRODUCTO,FECHA_ORDEN_PEDIDO,CANTIDAD,PRECIO_X_UNIDAD,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR from ordenes_de_compra";
            
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if(rs.next()){
                ordenescompra.setNumero_orden(rs.getInt(1));
                ordenescompra.setNumero_producto(rs.getInt(2));
                ordenescompra.setNum_proveedor(rs.getInt(3));
                ordenescompra.setNombre_producto(rs.getString(4));
                ordenescompra.setFecha_orden_pedido(rs.getDate(5));
                //ordenescompra.setFecha_recibida_pedido(rs.getDate(6));
                ordenescompra.setCantidad(rs.getInt(6));
                ordenescompra.setPrecio_x_unidad(rs.getFloat(7));
                ordenescompra.setImpuesto(rs.getFloat(8));
                ordenescompra.setTotal_a_pagar(rs.getFloat(9));
                ordenescompra.setId_trabajador(rs.getInt(10));
                ordenescompra.setExiste(true);
            }
        } catch (Exception e) {
            throw  e;
        } finally {
            _cnn = null;
        }
        return ordenescompra;
    }
    
    //FIN OBTENER
    
     //MODIFICAR UN CLIENTE
    public int Modificar (OrdenesCompra ordenescompra) throws Exception{
        int resultado = 0;
        String sentencia = "update ORDENES_DE_COMPRA SET NUMERO_PRODUCTO=?,NUM_PROVEEDOR=?,NOMBRE_PRODUCTO=?,FECHA_ORDEN_PEDIDO=?,CANTIDAD=?,PRECIO_X_UNIDAD=?,IMPUESTO=?,TOTAL_A_PAGAR=?,ID_TRABAJADOR=? where NUMERO_ORDEN =?";
        try{
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            
            ps.setInt(1,ordenescompra.getNumero_producto());
            ps.setInt(2, ordenescompra.getNum_proveedor());
            ps.setString(3,ordenescompra.getNombre_producto());
            ps.setDate(4,ordenescompra.getFecha_orden_pedido()); //AQUIIIIIIIIIII
           // ps.setDate(5,ordenescompra.getFecha_recibida_pedido());
           
            ps.setInt(5, ordenescompra.getCantidad());
            ps.setFloat(6,ordenescompra.getPrecio_x_unidad());
            ps.setFloat(7,ordenescompra.getImpuesto());
            ps.setFloat(8,ordenescompra.getTotal_a_pagar());
            ps.setInt(9,ordenescompra.getId_trabajador());
            ps.setInt(10, ordenescompra.getNumero_orden());
            resultado = ps.executeUpdate();
            
            if(resultado > 0){
                _mensaje = "Registro modificado de manera exitosa";
            }
        }catch (Exception e){
            throw e;
        }finally{
            _cnn = null;
        }
        return resultado;
    }
            
    
     //ELIMINAR UN CLIENTE
    public int Eliminar(OrdenesCompra ordenescompra) throws Exception{
        int resultado =0;
        String sentencia = "delete ordenes_de_compra where numero_orden=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, ordenescompra.getNumero_orden());
            resultado = ps.executeUpdate();
             if(resultado > 0){
                _mensaje = "Registro borrado de manera exitosa";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return resultado;
    }
         public int Verificar_Antes_Insert(OrdenesCompra orden) throws Exception{
        int resultado = 0;
        //String sentencia = "update cliente SET nombre=?,apellidos=?,telefono=?,residencia=? where id_cliente =?";
        
        try{
            CallableStatement CS;
            CS = _cnn.prepareCall("{?= call VERIFICAR_ANTES_DE_INSERTSAR_ODENES_COMPRA(?,?)}");
            CS.registerOutParameter(1, java.sql.Types.INTEGER);
            CS.setInt(2, orden.getNumero_orden());
            CS.setString(3, _mensaje);
            CS.registerOutParameter(3,Types.VARCHAR);
            CS.executeUpdate();
            resultado = CS.getInt(1);
            _mensaje = CS.getString(3);
            
            
//            if(resultado > 0){
//                _mensaje = "Registro modificado de manera exitosa";
//            }
        }catch (Exception e){
            throw e;
        }
        return resultado;
    }
        public int Verificar_Antes_Mod(OrdenesCompra ordenescompra) throws Exception{
        int resultado = 0;
        //String sentencia = "update cliente SET nombre=?,apellidos=?,telefono=?,residencia=? where id_cliente =?";
        
        try{
            CallableStatement CS;
            CS = _cnn.prepareCall("{?= call VERIFICAR_MODIFICACION_ORDEN(?,?,?,?,?,?,?,?,?,?,?,?)}");
            CS.registerOutParameter(1, java.sql.Types.INTEGER);
            CS.setInt(2, ordenescompra.getNumero_orden());
            CS.setInt(3,ordenescompra.getNumero_producto());
            CS.setInt(4, ordenescompra.getNum_proveedor());
            CS.setString(5,ordenescompra.getNombre_producto());
            CS.setDate(6,ordenescompra.getFecha_orden_pedido()); 
            CS.setInt(7, ordenescompra.getNum_proveedor());
            CS.setFloat(8,ordenescompra.getPrecio_x_unidad());
            CS.setFloat(9,ordenescompra.getImpuesto());
            CS.setFloat(10,ordenescompra.getTotal_a_pagar());
            CS.setInt(11, ordenescompra.getCantidad());
            CS.setInt(12,ordenescompra.getId_trabajador());
            
            
            
            
            CS.setString(13, _mensaje);
            CS.registerOutParameter(13,Types.VARCHAR);
            CS.executeUpdate();
            resultado = CS.getInt(1);
            _mensaje = CS.getString(13);
            
            
//            if(resultado > 0){
//                _mensaje = "Registro modificado de manera exitosa";
//            }
        }catch (Exception e){
            throw e;
        }
        return resultado;
    }
             public int Verificar_Existe(OrdenesCompra orden) throws Exception{
        int resultado = 0;
        //String sentencia = "update cliente SET nombre=?,apellidos=?,telefono=?,residencia=? where id_cliente =?";
        
        try{
            CallableStatement CS;
            CS = _cnn.prepareCall("{?= call VERIFICAR_Modificar_Antes_OR(?,?)}");
            CS.registerOutParameter(1, java.sql.Types.INTEGER);
            CS.setInt(2, orden.getNumero_orden());
            CS.setString(3, _mensaje);
            CS.registerOutParameter(3,Types.VARCHAR);
            CS.executeUpdate();
            resultado = CS.getInt(1);
            _mensaje = CS.getString(3);
            
            
//            if(resultado > 0){
//                _mensaje = "Registro modificado de manera exitosa";
//            }
        }catch (Exception e){
            throw e;
        }
        return resultado;
    }
}
