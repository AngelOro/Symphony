/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.TipoOperacion;
import Utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Angelica
 */
public class DAOTipoOperacion {
    private  Connection conexion;

    public DAOTipoOperacion() {
        conexion = DBUtil.getConexion();
    }

    public List<TipoOperacion> obtenerTipoOperacion() throws SQLException {
        List<TipoOperacion> listaTipoOperacion = new LinkedList<>();

        try (Statement stmt = conexion.createStatement()) {
            String sql = "SELECT ID_TIPO_OPERACION, DESCRIPCION FROM TBL_TIPO_OPERACION";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int idTipoOperacion = rs.getInt("ID_TIPO_OPERACION");
                String descripcion = rs.getString("DESCRIPCION");
                
                TipoOperacion TO = new TipoOperacion(idTipoOperacion, descripcion);
                listaTipoOperacion.add(TO);
            }
        }
        return listaTipoOperacion;
    }
    
    public String idTipoOperacion(int idTipoOperacion) throws SQLException {
        
        String sql = "SELECT ID_TIPO_OPERACION, DESCRIPCION FROM TBL_TIPO_OPERACION WHERE ID_TIPO_OPERACION = ?";
        
        
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, idTipoOperacion);

        ResultSet rs = ps.executeQuery();

        String descripcion = null;
        if (rs.next()) {
             descripcion = rs.getString("DESCRIPCION");
        }
        return descripcion;
    }
}
