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
import Entidades.DevolucionesVentas;
import Entidades.EncabezadoFactura;
import Entidades.OrdenesCompra;
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
import java.util.HashSet;
import java.util.List;


public class ADEncabezadoFactura {
     //Atributos
    private Connection _cnn;
    private String _mensaje;
    
    
    public String getMensaje() {
        return _mensaje;
    }
    
    public ADEncabezadoFactura() throws Exception {
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int Insertar(EncabezadoFactura encabezado) throws Exception{
        int id_encabezado = 1;
        String sentencia = "insert into ENCABEZADO_FACTURA(NUMERO_FACTURA,ID_TRABAJADOR,FECHA,IMPUESTO,MONTO_A_PAGAR,ID_CLIENTE) values(?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, encabezado.getNumero_factura());
            ps.setInt(2,encabezado.getId_trabajador());
            ps.setDate(3, encabezado.getFecha());
            ps.setFloat(4,encabezado.getImpuesto());
            ps.setFloat(5,encabezado.getMonto_a_pagar());
            ps.setInt(6, encabezado.getId_cliente());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys(); //El result set es como una tabla con un registro
            if(rs!=null && rs.next()){ //SI SE GENERÓ EL RESULTSET Y HAY OTRO REGISTRO
                id_encabezado=rs.getInt(1);
                _mensaje = "Factura ingresada con exito";
            }
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            _cnn=null;
        }
        return id_encabezado;
    }//Fin Insertar
    
    public ResultSet ListarRegistros(String condicion , String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT NUMERO_FACTURA,ID_TRABAJADOR,FECHA,IMPUESTO,MONTO_A_PAGAR,ID_CLIENTE from ENCABEZADO_FACTURA ";
            if(!condicion.equals("")){
                sentencia=String.format("%s where %s", sentencia,condicion);
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
    public List<EncabezadoFactura> ListarRegistros(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EncabezadoFactura> lista = new ArrayList();
        try {
            Statement stm= _cnn.createStatement();
            String sentencia = "SELECT NUMERO_FACTURA,ID_TRABAJADOR,FECHA,IMPUESTO,MONTO_A_PAGAR,ID_CLIENTE from ENCABEZADO_FACTURA ";
            if(!condicion.equals("")){
                sentencia=String.format("%s where %s" , sentencia,condicion);
            }
            rs= stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EncabezadoFactura(rs.getInt("numero_factura"), rs.getInt("id_trabajador"),rs.getDate("fecha"), rs.getFloat("impuesto"), rs.getFloat("monto_a_pagar"),rs.getInt("id_cliente")));
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
    public EncabezadoFactura ObtenerRegistro(String condicion) throws SQLException{
        EncabezadoFactura encabezado = new EncabezadoFactura();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT NUMERO_FACTURA,ID_TRABAJADOR,FECHA,IMPUESTO,MONTO_A_PAGAR,ID_CLIENTE from ENCABEZADO_FACTURA";
            
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if(rs.next()){
                encabezado.setNumero_factura(rs.getInt(1));
                encabezado.setId_trabajador(rs.getInt(2));
                encabezado.setFecha(rs.getDate(3));
                encabezado.setImpuesto(rs.getFloat(4));
                encabezado.setMonto_a_pagar(rs.getFloat(5));
                encabezado.setId_cliente(rs.getInt(6));
                encabezado.setExiste(true);
            }
        } catch (Exception e) {
            throw  e;
        } finally {
            _cnn = null;
        }
        return encabezado;
    }
    
    //FIN OBTENER
    
        public int Modificar (EncabezadoFactura encabezado) throws Exception{
        int resultado = 0;
        String sentencia = "update ENCABEZADO_FACTURA SET ID_TRABAJADOR=?,IMPUESTO=?,MONTO_A_PAGAR=?,ID_CLIENTE=? where NUMERO_FACTURA =?";
        try{
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            
           
         
            ps.setInt(1,encabezado.getId_trabajador());
            ps.setFloat(2,encabezado.getImpuesto());
            ps.setFloat(3,encabezado.getMonto_a_pagar());
            ps.setInt(4,encabezado.getId_cliente());
            ps.setInt(5, encabezado.getNumero_factura());
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
            
    
     //ELIMINAR UNA DEVOLUCION
    public int Eliminar(EncabezadoFactura encabezado) throws Exception{
        int resultado =0;
        String sentencia = "delete ENCABEZADO_FACTURA where NUMERO_FACTURA=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, encabezado.getNumero_factura());
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
    
     public int Verificar_Antes_Insert(EncabezadoFactura encabezado) throws Exception{
        int resultado = 0;
        //String sentencia = "update cliente SET nombre=?,apellidos=?,telefono=?,residencia=? where id_cliente =?";
        
        try{
            CallableStatement CS;
            CS = _cnn.prepareCall("{?= call VERIFICAR_ANTES_DE_INSERTSAR__ENC_F(?,?)}");
            CS.registerOutParameter(1, java.sql.Types.INTEGER);
            CS.setInt(2, encabezado.getNumero_factura());
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
              public int Verificar_Antes_Mod(EncabezadoFactura encabezado) throws Exception{
        int resultado = 0;
        //String sentencia = "update cliente SET nombre=?,apellidos=?,telefono=?,residencia=? where id_cliente =?";
        
        try{
            CallableStatement CS;
            CS = _cnn.prepareCall("{?= call VERIFICAR_MODIFICACION_ENCAB(?,?,?,?,?,?)}");
            CS.registerOutParameter(1, java.sql.Types.INTEGER);
            CS.setInt(2, encabezado.getNumero_factura());
            CS.setInt(3,encabezado.getId_trabajador());
            CS.setFloat(4,encabezado.getImpuesto());
            CS.setFloat(5,encabezado.getMonto_a_pagar());
            CS.setInt(6,encabezado.getId_cliente());
            
            
            CS.setString(7, _mensaje);
            CS.registerOutParameter(7,Types.VARCHAR);
            CS.executeUpdate();
            resultado = CS.getInt(1);
            _mensaje = CS.getString(7);
            
            
//            if(resultado > 0){
//                _mensaje = "Registro modificado de manera exitosa";
//            }
        }catch (Exception e){
            throw e;
        }
        return resultado;
    }
       public int Verificar_Antes_Eliminar(EncabezadoFactura encabezado) throws Exception{
        int resultado = 0;
        //String sentencia = "update cliente SET nombre=?,apellidos=?,telefono=?,residencia=? where id_cliente =?";
        
        try{
            CallableStatement CS;
            CS = _cnn.prepareCall("{?= call SP_ELIMINAR_ENCABEZADO_FACTURA(?,?)}");
            CS.registerOutParameter(1, java.sql.Types.INTEGER);
            CS.setInt(2, encabezado.getNumero_factura());
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
       
     public String Ventas(int month, String id) throws SQLException{
         ResultSet rs = null;
         String res = "";
         try {
             Statement statement = _cnn.createStatement();
             String select = "Select Total=COUNT(NUMERO_FACTURA) from encabezado_factura where MONTH(FECHA)=" + month + " and "
                     + "id_trabajador= '" + id + "'"; 
             rs = statement.executeQuery(select);
             if(rs.next()){
                 res = rs.getString("Total");
             }
         } catch (Exception e) {
             throw e;
         }finally{
             _cnn = null;
         }
         return res;
     }
    
}
