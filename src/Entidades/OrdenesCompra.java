/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Telyman
 */
public class OrdenesCompra {
    
    //Atributos
    private int numero_orden;
    private int numero_producto;
    private int num_proveedor;
    private String nombre_producto;
    private Date fecha_orden_pedido;
    private Date fecha_recibida_pedido;
    private int cantidad;
    private Float precio_x_unidad;
    private Float impuesto;
    private Float total_a_pagar;
    private int id_trabajador;
    private boolean  existe;
    
    //Constructores
        public OrdenesCompra(int numero_orden, int numero_producto, int num_proveedor, String nombre_producto, Date fecha_orden_pedido, int cantidad ,Float precio_x_unidad, Float impuesto, Float total_a_pagar, int id_trabajador) {
        this.numero_orden = numero_orden;
        this.numero_producto = numero_producto;
        this.num_proveedor = num_proveedor;
        this.nombre_producto = nombre_producto;
        this.fecha_orden_pedido = fecha_orden_pedido;
        this.cantidad = cantidad;
        this.precio_x_unidad = precio_x_unidad;
        this.impuesto = impuesto;
        this.total_a_pagar = total_a_pagar;
        this.id_trabajador = id_trabajador;
        this.existe = true;
    }

        public OrdenesCompra() {
        
    }    
    
    //Gets y Sets
    public int getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public int getNumero_producto() {
        return numero_producto;
    }

    public void setNumero_producto(int numero_producto) {
        this.numero_producto = numero_producto;
    }

    public int getNum_proveedor() {
        return num_proveedor;
    }

    public void setNum_proveedor(int num_proveedor) {
        this.num_proveedor = num_proveedor;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Date getFecha_orden_pedido() {
        return fecha_orden_pedido;
    }

    public void setFecha_orden_pedido(Date fecha_orden_pedido) {
        this.fecha_orden_pedido = fecha_orden_pedido;
    }

    public Date getFecha_recibida_pedido() {
        return fecha_recibida_pedido;
    }

    public void setFecha_recibida_pedido(Date fecha_recibida_pedido) {
        this.fecha_recibida_pedido = fecha_recibida_pedido;
    }

    public Float getPrecio_x_unidad() {
        return precio_x_unidad;
    }

    public void setPrecio_x_unidad(Float precio_x_unidad) {
        this.precio_x_unidad = precio_x_unidad;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    public Float getTotal_a_pagar() {
        return total_a_pagar;
    }

    public void setTotal_a_pagar(Float total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
  
}
