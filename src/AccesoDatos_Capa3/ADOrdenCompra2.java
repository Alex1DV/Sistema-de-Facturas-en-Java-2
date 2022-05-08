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
import Entidades.OrdenesCompra2;
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


public class ADOrdenCompra2 {
     //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    
    public String getMensaje() {
        return _mensaje;
    }
    
    public ADOrdenCompra2() throws Exception {
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int Insertar(OrdenesCompra2 ordenescompra) throws Exception{
        int id_orden_c = 1;
        String sentencia = "INSERT INTO ORDENES_DE_COMPRA2(NUMERO_ORDEN,NUM_PROVEEDOR,FECHA_ORDEN_PEDIDO,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR) values(?,?,?,?,?,?)";
       
        
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, ordenescompra.getNumero_orden());
            ps.setInt(2, ordenescompra.getNum_proveedor());
            ps.setDate(3,ordenescompra.getFecha_orden_pedido()); 
            ps.setFloat(4,ordenescompra.getImpuesto());
            ps.setFloat(5,ordenescompra.getTotal_a_pagar());
            ps.setInt(6,ordenescompra.getId_trabajador());
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
            String sentencia = "SELECT NUMERO_ORDEN,NUM_PROVEEDOR,FECHA_ORDEN_PEDIDO,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR from ordenes_de_compra2";
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
    public List<OrdenesCompra2> ListarRegistros(String condicion) throws SQLException{
        ResultSet rs = null;
        List<OrdenesCompra2> lista = new ArrayList();
        try {
            Statement stm= _cnn.createStatement();
            String sentencia = "SELECT NUMERO_ORDEN,NUM_PROVEEDOR,FECHA_ORDEN_PEDIDO,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR from ordenes_de_compra";
            if(!condicion.equals("")){
                sentencia=String.format("%s where %s" , sentencia,condicion);
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new OrdenesCompra2(rs.getInt("numero_orden"), rs.getInt("num_proveedor"), /*AQUIII*/ rs.getDate("fecha_orden_pedido"),rs.getFloat("impuesto"), rs.getFloat("total_a_pagar"), rs.getInt("id_trabajador")));
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
    public OrdenesCompra2 ObtenerRegistro(String condicion) throws SQLException{
        OrdenesCompra2 ordenescompra = new OrdenesCompra2();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT NUMERO_ORDEN,NUM_PROVEEDOR,FECHA_ORDEN_PEDIDO,IMPUESTO,TOTAL_A_PAGAR,ID_TRABAJADOR from ordenes_de_compra2";
            
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if(rs.next()){
                ordenescompra.setNumero_orden(rs.getInt(1));
                ordenescompra.setNum_proveedor(rs.getInt(2));
                ordenescompra.setFecha_orden_pedido(rs.getDate(3));
                ordenescompra.setImpuesto(rs.getFloat(4));
                ordenescompra.setTotal_a_pagar(rs.getFloat(5));
                ordenescompra.setId_trabajador(rs.getInt(6));
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
    public int Modificar (OrdenesCompra2 ordenescompra) throws Exception{
        int resultado = 0;
        String sentencia = "update ORDENES_DE_COMPRA2 SET NUM_PROVEEDOR=?,FECHA_ORDEN_PEDIDO=?,IMPUESTO=?,TOTAL_A_PAGAR=?,ID_TRABAJADOR=? where NUMERO_ORDEN =?";
        try{
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            
           
            ps.setInt(1, ordenescompra.getNum_proveedor());
            ps.setDate(2,ordenescompra.getFecha_orden_pedido());
            ps.setFloat(3,ordenescompra.getImpuesto());
            ps.setFloat(4,ordenescompra.getTotal_a_pagar());
            ps.setInt(5,ordenescompra.getId_trabajador());
            ps.setInt(6, ordenescompra.getNumero_orden());
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
    public int Eliminar(OrdenesCompra2 ordenescompra) throws Exception{
        int resultado =0;
        String sentencia = "delete ordenes_de_compra2 where numero_orden=?";
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
         public int Verificar_Antes_Insert(OrdenesCompra2 orden) throws Exception{
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
        public int Verificar_Antes_Mod(OrdenesCompra2 ordenescompra) throws Exception{
        int resultado = 0;
        //String sentencia = "update cliente SET nombre=?,apellidos=?,telefono=?,residencia=? where id_cliente =?";
        
        try{
            CallableStatement CS;
            CS = _cnn.prepareCall("{?= call VERIFICAR_MODIFICACION_ORDEN(?,?,?,?,?,?,?)}");
            CS.registerOutParameter(1, java.sql.Types.INTEGER);
            CS.setInt(2, ordenescompra.getNumero_orden());
            CS.setInt(3, ordenescompra.getNum_proveedor());
            CS.setDate(4,ordenescompra.getFecha_orden_pedido()); 
            CS.setFloat(5,ordenescompra.getImpuesto());
            CS.setFloat(6,ordenescompra.getTotal_a_pagar());
            CS.setInt(7,ordenescompra.getId_trabajador());
            
            
            
            
            CS.setString(8, _mensaje);
            CS.registerOutParameter(8,Types.VARCHAR);
            CS.executeUpdate();
            resultado = CS.getInt(1);
            _mensaje = CS.getString(8);
            
            
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
