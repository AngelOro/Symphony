/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empresa;
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
public class DAOEmpresa {

    private Connection conexion;

    public DAOEmpresa() throws Exception {
        conexion = DBUtil.getConexion();
    }

    public List<Empresa> listarEmpresas() throws SQLException {
        List<Empresa> listaEmpresa = new LinkedList<>();

        try (Statement stmt = conexion.createStatement()) {
            String sql = "SELECT TBL_EMPRESA.ID_EMPRESA , TBL_EMPRESA.NOMBRE_EMPRESA, TBL_EMPRESA.NIT,\n"
                    + "TBL_EMPRESA.TELEFONO, TBL_EMPRESA.VALOR_OPERACION, TBL_EMPRESA.TIPO_OPERACION, TBL_TIPO_OPERACION.DESCRIPCION\n"
                    + "FROM TBL_EMPRESA INNER JOIN TBL_TIPO_OPERACION\n"
                    + "ON TBL_EMPRESA.TIPO_OPERACION = TBL_TIPO_OPERACION.ID_TIPO_OPERACION";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idEmpresa = rs.getInt("ID_EMPRESA");
                String nombreEmpresa = rs.getString("NOMBRE_EMPRESA");
                String nit = rs.getString("NIT");
                String telefono = rs.getString("TELEFONO");
                double valorOperacion = rs.getDouble("VALOR_OPERACION");
                int idTipoOperacion = rs.getInt("TIPO_OPERACION");
                String tipoOperacion = rs.getString("DESCRIPCION");

                Empresa e = new Empresa(idEmpresa, nombreEmpresa, nit, telefono, valorOperacion, idTipoOperacion, tipoOperacion);
                listaEmpresa.add(e);
            }
        }
        return listaEmpresa;
    }

    public void guardar(Empresa e) throws SQLException {
        String sql = "INSERT INTO TBL_EMPRESA (NOMBRE_EMPRESA, NIT, TELEFONO, VALOR_OPERACION, TIPO_OPERACION)"
                + "VALUES(?,?,?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, e.getNombreEmpresa());
        ps.setString(2, e.getNit());
        ps.setString(3, e.getTelefono());
        ps.setDouble(4, e.getValorOperacion());
        ps.setInt(5, e.getIdTipoOperacion());

        ps.executeUpdate();
    }

    public String obtenerNombreEmpresa(int idEmpresa) throws SQLException {

        String sql = "SELECT ID_EMPRESA, NOMBRE_EMPRESA FROM TBL_EMPRESA WHERE ID_EMPRESA = ?";

        // La clase PreparedStatement se usa cuando la instrucción de SQL tiene parámetros
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idEmpresa);

        ResultSet rs = ps.executeQuery();

        String nombreEmp = null;
        if (rs.next()) {
            nombreEmp = rs.getString("NOMBRE_EMPRESA");
        }
        return nombreEmp;
    }

    public Empresa empresaPorId(int idEmpresa) throws SQLException {
        String sql = "SELECT TBL_EMPRESA.ID_EMPRESA , TBL_EMPRESA.NOMBRE_EMPRESA, TBL_EMPRESA.NIT,\n"
                + "TBL_EMPRESA.TELEFONO, TBL_EMPRESA.VALOR_OPERACION, TBL_EMPRESA.TIPO_OPERACION, TBL_TIPO_OPERACION.DESCRIPCION\n"
                + "FROM TBL_EMPRESA INNER JOIN TBL_TIPO_OPERACION\n"
                + "ON TBL_EMPRESA.TIPO_OPERACION = TBL_TIPO_OPERACION.ID_TIPO_OPERACION WHERE TBL_EMPRESA.ID_EMPRESA=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idEmpresa);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            idEmpresa = rs.getInt("ID_EMPRESA");
            String nombreEmpresa = rs.getString("NOMBRE_EMPRESA");
            String nit = rs.getString("NIT");
            String telefono = rs.getString("TELEFONO");
            double valorOperacion = rs.getDouble("VALOR_OPERACION");
            int idTipoOperacion = rs.getInt("TIPO_OPERACION");
            String tipoOperacion = rs.getString("DESCRIPCION");

            Empresa e = new Empresa(idEmpresa, nombreEmpresa, nit, telefono, valorOperacion, idTipoOperacion, tipoOperacion);
            return e;
        }

        return null;
    }
    public void editar(Empresa e) throws SQLException {
        String sql = "UPDATE TBL_EMPRESA SET NOMBRE_EMPRESA= ?, "
                + "NIT=?, TELEFONO= ?, VALOR_OPERACION= ?,"
                + " TIPO_OPERACION= ? WHERE ID_EMPRESA=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, e.getNombreEmpresa());
        ps.setString(2, e.getNit());
        ps.setString(3, e.getTelefono());
        ps.setDouble(4, e.getValorOperacion());
        ps.setInt(5, e.getIdTipoOperacion());
        ps.setInt(6, e.getIdEmpresa());
       

        ps.executeUpdate();
       
    }

}
