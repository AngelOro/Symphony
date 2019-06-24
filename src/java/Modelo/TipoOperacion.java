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
public class TipoOperacion {
    
    private int idTipoOperacion;
    private String descripcion;

    public TipoOperacion(int idTipoOperacion, String descripcion) {
        this.idTipoOperacion = idTipoOperacion;
        this.descripcion = descripcion;
    }

    public int getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(int idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
