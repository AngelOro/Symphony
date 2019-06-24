/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Angelica
 */
public class Empresa {
    
    private int idEmpresa;
    private String nombreEmpresa;
    private String nit;
    private String telefono;
    private double valorOperacion;
    private int idTipoOperacion;
    private String tipoOperacion;

    public Empresa(int idEmpresa, String nombreEmpresa, String nit, String telefono, double valorOperacion, int idTipoOperacion, String tipoOperacion) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.telefono = telefono;
        this.valorOperacion = valorOperacion;
        this.idTipoOperacion = idTipoOperacion;
        this.tipoOperacion = tipoOperacion;
    }
    
    
   
    public double getValorOperacion() {
        return valorOperacion;
    }

    public void setValorOperacion(double valorOperacion) {
        this.valorOperacion = valorOperacion;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(int idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
    
    
    
}
