/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Artista;
import Modelo.Empresa;
import Utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Angelica
 */
public class DAOArtista {

    private Connection conexion;

    public DAOArtista() throws Exception {
        conexion = DBUtil.getConexion();
    }

    public List<Artista> listarArtistas() throws SQLException {
        List<Artista> listaArtista = new LinkedList<>();

        try (Statement stmt = conexion.createStatement()) {
            String sql = "SELECT TBL_ARTISTA.ID_ARTISTA ,\n"
                    + "  TBL_ARTISTA.NOMBRE_ARTISTA,\n"
                    + "  TBL_ARTISTA.EMPRESA,\n"
                    + "  TBL_EMPRESA.NOMBRE_EMPRESA,\n"
                    + "  TBL_ARTISTA.CORREO,\n"
                    + "  TBL_ARTISTA.TELEFONO_CONTACTO,\n"
                    + "  TBL_ARTISTA.ESTADO\n"
                    + "FROM TBL_ARTISTA\n"
                    + "INNER JOIN TBL_EMPRESA\n"
                    + "ON TBL_ARTISTA.EMPRESA = TBL_EMPRESA.ID_EMPRESA";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idArtista = rs.getInt("ID_ARTISTA");
                String nombreArtista = rs.getString("NOMBRE_ARTISTA");
                int idEmpresa = rs.getInt("EMPRESA");
                String nombreEmp = rs.getString("NOMBRE_EMPRESA");
                String correo = rs.getString("CORREO");
                String telefono = rs.getString("TELEFONO_CONTACTO");
                String estado = rs.getString("ESTADO");

                Artista a = new Artista(idArtista, nombreArtista, idEmpresa, nombreEmp, correo, telefono, estado);
                listaArtista.add(a);
            }
        }
        return listaArtista;
    }

    public void guardar(Artista a) throws SQLException {
        String sql = "INSERT INTO TBL_ARTISTA (NOMBRE_ARTISTA, EMPRESA, CORREO, TELEFONO_CONTACTO, ESTADO)"
                + "VALUES(?,?,?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, a.getNombreArtista());
        ps.setInt(2, a.getIdEmpresa());
        ps.setString(3, a.getCorreo());
        ps.setString(4, a.getTelefono());
        ps.setString(5, a.getEstado());

        ps.executeUpdate();
    }

    public String obtenerNombreArtista(int idArtista) throws SQLException {

        String sql = "SELECT ID_ARTISTA, NOMBRE_ARTISTA FROM TBL_ARTISTA WHERE ID_ARTISTA = ?";

        // La clase PreparedStatement se usa cuando la instrucción de SQL tiene parámetros
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idArtista);

        ResultSet rs = ps.executeQuery();

        String nombreArt = null;
        if (rs.next()) {
            nombreArt = rs.getString("NOMBRE_ARTISTA");
        }
        return nombreArt;
    }

    public Artista artistaPorId(int idArtista) throws SQLException {
        String sql = "SELECT TBL_ARTISTA.ID_ARTISTA ,\n"
                + "  TBL_ARTISTA.NOMBRE_ARTISTA,\n"
                + "  TBL_ARTISTA.EMPRESA,\n"
                + "  TBL_EMPRESA.NOMBRE_EMPRESA,\n"
                + "  TBL_ARTISTA.CORREO,\n"
                + "  TBL_ARTISTA.TELEFONO_CONTACTO,\n"
                + "  TBL_ARTISTA.ESTADO\n"
                + "FROM TBL_ARTISTA\n"
                + "INNER JOIN TBL_EMPRESA\n"
                + "ON TBL_ARTISTA.EMPRESA = TBL_EMPRESA.ID_EMPRESA"
                + " WHERE TBL_ARTISTA.ID_ARTISTA=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtista);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            idArtista = rs.getInt("ID_ARTISTA");
            String nombreArtista = rs.getString("NOMBRE_ARTISTA");
            int idEmpresa = rs.getInt("EMPRESA");
            String empresa = rs.getString("NOMBRE_EMPRESA");
            String correo = rs.getString("CORREO");
            String telefono = rs.getString("TELEFONO_CONTACTO");
            String estado = rs.getString("ESTADO");

            Artista a = new Artista(idArtista, nombreArtista, idEmpresa, empresa, correo, telefono, estado);
            return a;
        }

        return null;
    }

    public void editar(Artista a) throws SQLException {
        String sql = "UPDATE TBL_ARTISTA SET NOMBRE_ARTISTA= ?, "
                + "EMPRESA=?, CORREO= ?, TELEFONO_CONTACTO= ?,"
                + " ESTADO= ? WHERE ID_ARTISTA=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, a.getNombreArtista());
        ps.setInt(2, a.getIdEmpresa());
        ps.setString(3, a.getCorreo());
        ps.setString(4, a.getTelefono());
        ps.setString(5, a.getEstado());
        ps.setInt(6, a.getIdArtista());

        ps.executeUpdate();

    }

}
