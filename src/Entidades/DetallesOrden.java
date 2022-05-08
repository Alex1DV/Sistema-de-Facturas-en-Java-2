/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Telyman
 */
public class DetallesOrden {

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

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DetallesOrden(int numero_orden, int numero_producto, String nombre_producto, int cantidad) {
        this.numero_orden = numero_orden;
        this.numero_producto = numero_producto;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
    }
       public DetallesOrden() {
        
    }
    private int numero_orden;
    private int numero_producto;
    private String nombre_producto;
    private int cantidad;
    
}
