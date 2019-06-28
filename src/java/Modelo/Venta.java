/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;



/**
 *
 * @author Angelica
 */
public class Venta {
    private int idVenta;
    private int idArtista;
    private String nombreArtista;
    private String empresa;
    private double valorOperacion;
    private int cantidad;
    private double total;
    private Date fechaVenta;

    public Venta(int idVenta, int idArtista, String nombreArtista, String empresa, double valorOperacion, int cantidad, double total, Date fechaVenta) {
        this.idVenta = idVenta;
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.empresa = empresa;
        this.valorOperacion = valorOperacion;
        this.cantidad = cantidad;
        this.total = total;
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getValorOperacion() {
        return valorOperacion;
    }

    public void setValorOperacion(double valorOperacion) {
        this.valorOperacion = valorOperacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
}
