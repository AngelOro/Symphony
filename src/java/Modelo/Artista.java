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
public class Artista {
    private int idArtista;
    private String nombreArtista;
    private int idEmpresa;
    private String nombreEmp;
    private String correo;
    private String telefono;
    private String estado;

    public Artista(int idArtista, String nombreArtista, int idEmpresa, String nombreEmp, String correo, String telefono, String estado) {
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.idEmpresa = idEmpresa;
        this.nombreEmp = nombreEmp;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

   
   
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
    
}
