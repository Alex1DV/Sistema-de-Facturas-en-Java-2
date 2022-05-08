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
public class OrdenesCompra2 {

    public int getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public int getNum_proveedor() {
        return num_proveedor;
    }

    public void setNum_proveedor(int num_proveedor) {
        this.num_proveedor = num_proveedor;
    }

    public Date getFecha_orden_pedido() {
        return fecha_orden_pedido;
    }

    public void setFecha_orden_pedido(Date fecha_orden_pedido) {
        this.fecha_orden_pedido = fecha_orden_pedido;
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

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public OrdenesCompra2(int numero_orden, int num_proveedor, Date fecha_orden_pedido, Float impuesto, Float total_a_pagar, int id_trabajador) {
        this.numero_orden = numero_orden;
        this.num_proveedor = num_proveedor;
        this.fecha_orden_pedido = fecha_orden_pedido;
        this.impuesto = impuesto;
        this.total_a_pagar = total_a_pagar;
        this.id_trabajador = id_trabajador;
        this.existe = true;
    }
        public OrdenesCompra2() {
       
    }
    private int numero_orden;
    private int num_proveedor;
    private Date fecha_orden_pedido;
    private Float impuesto;
    private Float total_a_pagar;
    private int id_trabajador;
    private boolean  existe;
}
