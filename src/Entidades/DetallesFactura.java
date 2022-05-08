/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;
/**
 *
 * @author Telyman
 */
public class DetallesFactura {
     //Atributos
    private int numero_factura;
    private int numero_producto;
    private String nombre_producto;
    private int cantidad;
    private float precio;

    private boolean existe;
    
    //Constructores
    public DetallesFactura(int numero_factura, int numero_producto, String nombre_producto, int cantidad, String garantia,float precio) {
        this.numero_factura = numero_factura;
        this.numero_producto = numero_producto;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.garantia = garantia;
        this.precio = precio;
        this.existe = true;
    }
    

    public DetallesFactura() {
        
    }
    
    //Gets y Sets
    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
    }

    public int getNumero_producto() {
        return numero_producto;
    }

    public void setNumero_producto(int numero_producto) {
        this.numero_producto = numero_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
    private String garantia;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}
