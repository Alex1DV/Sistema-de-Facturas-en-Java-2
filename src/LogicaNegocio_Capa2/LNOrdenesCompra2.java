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
import AccesoDatos_Capa3.ADOrdenCompra;
import AccesoDatos_Capa3.ADOrdenCompra2;
import AccesoDatos_Capa3.ADProducto;
import AccesoDatos_Capa3.ADProveedor;
import Entidades.Cliente;
import Entidades.OrdenesCompra;
import Entidades.OrdenesCompra2;
import Entidades.Producto;
import Entidades.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LNOrdenesCompra2 {
    //Atributo
     private String _mensaje;
    
    public String getMensaje() {
        return _mensaje;
    }
   
    //Llamar a Acceso a Datos
    public int Insertar(OrdenesCompra2 ordenescompra) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADOrdenCompra2 adordencompra;
        try {
            adordencompra = new ADOrdenCompra2();
            id = adordencompra.Insertar(ordenescompra);
            _mensaje = adordencompra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
    
    //Listar proveedores con RESULT SET
    public ResultSet ListarRegistros(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADOrdenCompra2 adordencompra;
        try {
            adordencompra = new ADOrdenCompra2();
            resultado= adordencompra.ListarRegistros(condicion, orden);
        } catch (Exception e) {
            throw  e;
        }
        return resultado;
    }
    //FIN Listar proveedor con RESULT SET
    
    //Listar clientes con la LISTA
    public List<OrdenesCompra2> ListarRegistros(String condicion) throws Exception{
        List<OrdenesCompra2> resultado = new ArrayList();
        ADOrdenCompra2 adordencompra;
          try {
            adordencompra = new ADOrdenCompra2();
            resultado= adordencompra.ListarRegistros(condicion);
        } catch (Exception e) {
            throw  e;
        }
        return resultado;
        
    }
    //FINListar producto con la LISTA
    
    //Obtener un registro
      public OrdenesCompra2 ObtenerRegistro(String condicion) throws Exception{
        OrdenesCompra2 resultado;
        ADOrdenCompra2 adordencompra;
        try{
            adordencompra= new ADOrdenCompra2();
            resultado = adordencompra.ObtenerRegistro(condicion);
            if(resultado.isExiste()){
                _mensaje = "Orden de compra recuperada exitosamente";
                
            }else{
                _mensaje = "La orden de compra no existe";
            }
        }catch(Exception e){
            throw e;
        }
        return resultado;
    }
    
    
    //Obtener registro FIN
      
          public int Modificar(OrdenesCompra2 ordenescompra) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADOrdenCompra2 adordencompra;
        try {
            adordencompra = new ADOrdenCompra2();
            id = adordencompra.Modificar(ordenescompra);
            _mensaje = adordencompra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
    
         public int Eliminar(OrdenesCompra2 ordenescompra) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADOrdenCompra2 adordencompra;
        try {
            adordencompra = new ADOrdenCompra2();
            id = adordencompra.Eliminar(ordenescompra);
            _mensaje = adordencompra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
    //------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------
         public int VerificarIns(OrdenesCompra ordenescompra) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADOrdenCompra adordencompra;
        try {
            adordencompra = new ADOrdenCompra();
            id = adordencompra.Verificar_Antes_Insert(ordenescompra);
            _mensaje = adordencompra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
          public int VerificarMod(OrdenesCompra ordenescompra) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADOrdenCompra adordencompra;
        try {
            adordencompra = new ADOrdenCompra();
            id = adordencompra.Verificar_Antes_Mod(ordenescompra);
            _mensaje = adordencompra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
                public int VerificarExiste(OrdenesCompra ordenescompra) throws Exception{
        int id = -1; //-1 SI NO LOGRÓ NADA O SINO DEVUELVE EL ID DEL CLIENTE
        ADOrdenCompra adordencompra;
        try {
            adordencompra = new ADOrdenCompra();
            id = adordencompra.Verificar_Existe(ordenescompra);
            _mensaje = adordencompra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    } 
}
