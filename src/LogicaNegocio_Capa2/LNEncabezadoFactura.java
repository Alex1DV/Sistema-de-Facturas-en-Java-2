/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio_Capa2;

/**
 *
 * @author Telyman
 */

import AccesoDatos_Capa3.ADCliente;
import AccesoDatos_Capa3.ADDevolucionesVentas;
import AccesoDatos_Capa3.ADEncabezadoFactura;
import Entidades.Cliente;
import Entidades.DevolucionesVentas;
import Entidades.EncabezadoFactura;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LNEncabezadoFactura {
    //Atributo
     private String _mensaje;
    
    public String getMensaje() {
        return _mensaje;
    }
   
    //Llamar a Acceso a Datos
    public int Insertar(EncabezadoFactura encabezado) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIEN
        ADEncabezadoFactura adencabezado;
        try {
            adencabezado= new ADEncabezadoFactura();
            id = adencabezado.Insertar(encabezado);
            _mensaje = adencabezado.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
    
    //Listar clientes con RESULT SET
    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
       ResultSet resultado;
        ADEncabezadoFactura adencabezado;
        try {
            adencabezado = new ADEncabezadoFactura();
            resultado= adencabezado.ListarRegistros(condicion, orden);
        } catch (Exception e) {
            throw  e;
        }
        return resultado;
    }
    //FIN Listar clientes con RESULT SET
    
    //Listar clientes con la LISTA
    public List<EncabezadoFactura> ListarRegistros(String condicion) throws Exception{
        List<EncabezadoFactura> resultado = new ArrayList();
        ADEncabezadoFactura adencabezado;
          try {
            adencabezado = new ADEncabezadoFactura();
            resultado= adencabezado.ListarRegistros(condicion);
        } catch (Exception e) {
            throw  e;
        }
        return resultado;
        
    }
    //FINListar clientes con la LISTA
    
    //Obtener un registro
    public EncabezadoFactura ObtenerRegistro(String condicion) throws Exception{
        EncabezadoFactura resultado;
        ADEncabezadoFactura adencabezado;
        try{
            adencabezado= new ADEncabezadoFactura();
            resultado = adencabezado.ObtenerRegistro(condicion);
            if(resultado.isExiste()){
                _mensaje = "Encabezado de factura recuperado exitosamente";
                
            }else{
                _mensaje = "La factura no existe";
            }
        }catch(Exception e){
            throw e;
        }
        return resultado;
    }
    
    //Obtener registro FIN
       public int Modificar(EncabezadoFactura encabezado) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADEncabezadoFactura adencabezado;
        try {
            adencabezado = new ADEncabezadoFactura();
            id = adencabezado.Modificar(encabezado);
            _mensaje = adencabezado.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
       public int Eliminar(EncabezadoFactura encabezado) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADEncabezadoFactura adencabezado;
        try {
            adencabezado = new ADEncabezadoFactura();
            id = adencabezado.Eliminar(encabezado);
            _mensaje = adencabezado.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
     public int VerificarIns(EncabezadoFactura encabezado) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADEncabezadoFactura adencabezado;
        try {
            adencabezado = new ADEncabezadoFactura();
            id = adencabezado.Verificar_Antes_Insert(encabezado);
            _mensaje = adencabezado.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
      public int VerificarMod(EncabezadoFactura encabezado) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADEncabezadoFactura adencabezado;
        try {
            adencabezado = new ADEncabezadoFactura();
            id = adencabezado.Verificar_Antes_Mod(encabezado);
            _mensaje = adencabezado.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
        public int VerificarEliminar(EncabezadoFactura encabezado) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADEncabezadoFactura adencabezado;
        try {
            adencabezado = new ADEncabezadoFactura();
            id = adencabezado.Verificar_Antes_Eliminar(encabezado);
            _mensaje = adencabezado.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
        
        
    } 
        
        
        
    
}
