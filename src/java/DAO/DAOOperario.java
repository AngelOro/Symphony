/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Operario;
import Modelo.TipoOperacion;
import Modelo.Usuario;
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
public class DAOOperario {

    private Connection conexion;

    public DAOOperario() throws Exception {
        conexion = DBUtil.getConexion();
    }

    public List<Operario> listarOperario() throws SQLException {
        List<Operario> listaOperario = new LinkedList<>();

        try (Statement stmt = conexion.createStatement()) {
            String sql = "SELECT TBL_USUARIO.ID_USUARIO ,\n"
                    + "  TBL_USUARIO.PRIMER_NOMBRE,\n"
                    + "  TBL_USUARIO.SEGUNDO_NOMBRE,\n"
                    + "  TBL_USUARIO.PRIMER_APELLIDO,\n"
                    + "  TBL_USUARIO.SEGUNDO_APELLIDO,\n"
                    + "  TBL_USUARIO.NUMERO_DOCUMENTO,\n"
                    + "  TBL_USUARIO.EMAIL,\n"
                    + "  TBL_USUARIO.PERFIL,\n"
                    + "  TBL_TIPO_PERFIL.DESCRIPCION,\n"
                    + "  TBL_USUARIO.TIPO_DOCUMENTO,\n"
                    + "  TBL_TIPO_DOCUMENTO.DESCRIPCION AS DOCUMENTO,\n"
                    + "  TBL_USUARIO.ESTADO,\n"
                    + "  TBL_USUARIO.USUARIO,\n"
                    + "  TBL_USUARIO.CLAVE\n"
                    + "FROM TBL_USUARIO\n"
                    + "INNER JOIN TBL_TIPO_PERFIL\n"
                    + "ON TBL_USUARIO.PERFIL = TBL_TIPO_PERFIL.ID_TIPO_USER\n"
                    + "INNER JOIN TBL_TIPO_DOCUMENTO\n"
                    + "ON TBL_USUARIO.TIPO_DOCUMENTO = TBL_TIPO_DOCUMENTO.ID_DOCUMENTO\n"
                    + "WHERE PERFIL = 2";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idUsuario = rs.getInt("ID_USUARIO");
                String primerNombre = rs.getString("PRIMER_NOMBRE");
                String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
                String primerApellido = rs.getString("PRIMER_APELLIDO");
                String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
                String numDocumento = rs.getString("NUMERO_DOCUMENTO");
                String correo = rs.getString("EMAIL");
                int idPerfil = rs.getInt("PERFIL");
                int idDocumento = rs.getInt("TIPO_DOCUMENTO");
                String tipoDocumento = rs.getString("DOCUMENTO");
                String estado = rs.getString("ESTADO");
                String userName = rs.getString("USUARIO");
                String clave = rs.getString("CLAVE");

                Operario o = new Operario(idUsuario, primerNombre, segundoNombre, primerApellido, segundoApellido, numDocumento, correo, idPerfil, idDocumento, tipoDocumento, estado, userName, clave);
                listaOperario.add(o);
            }
        }
        return listaOperario;
    }

    public void guardar(Operario o) throws SQLException {
        String sql = "INSERT INTO TBL_USUARIO (PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO,\n"
                + "NUMERO_DOCUMENTO, EMAIL, PERFIL, TIPO_DOCUMENTO, ESTADO, USUARIO, CLAVE)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, o.getPrimerNombre());
        ps.setString(2, o.getSegundoNombre());
        ps.setString(3, o.getPrimerApellido());
        ps.setString(4, o.getSegundoApellido());
        ps.setString(5, o.getNumDocumento());
        ps.setString(6, o.getEmail());
        ps.setInt(7, o.getIdPerfil());
        ps.setInt(8, o.getIdTipoDocumento());
        ps.setString(9, o.getEstado());
        ps.setString(10, o.getUserName());
        ps.setString(11, o.getPassword());

        ps.executeUpdate();
    }

    public void guardarUser(Operario u) throws SQLException {
        String sql = "INSERT INTO TBL_LOGIN (NOMBRE_USUARIO, CLAVE, USUARIO)"
                + "VALUES(?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, u.getUserName());
        ps.setString(2, u.getPassword());
        ps.setInt(3, u.getIdUsuario());

        ps.executeUpdate();
    }

    public Operario operarioPorId(int idUsuario) throws SQLException {
        String sql = "SELECT TBL_USUARIO.ID_USUARIO ,\n"
                + "  TBL_USUARIO.PRIMER_NOMBRE,\n"
                + "  TBL_USUARIO.SEGUNDO_NOMBRE,\n"
                + "  TBL_USUARIO.PRIMER_APELLIDO,\n"
                + "  TBL_USUARIO.SEGUNDO_APELLIDO,\n"
                + "  TBL_USUARIO.NUMERO_DOCUMENTO,\n"
                + "  TBL_USUARIO.EMAIL,\n"
                + "  TBL_USUARIO.PERFIL,\n"
                + "  TBL_TIPO_PERFIL.DESCRIPCION,\n"
                + "  TBL_USUARIO.TIPO_DOCUMENTO,\n"
                + "  TBL_TIPO_DOCUMENTO.DESCRIPCION AS DOCUMENTO,\n"
                + "  TBL_USUARIO.ESTADO,\n"
                + "  TBL_USUARIO.USUARIO,\n"
                + "  TBL_USUARIO.CLAVE\n"
                + "FROM TBL_USUARIO\n"
                + "INNER JOIN TBL_TIPO_PERFIL\n"
                + "ON TBL_USUARIO.PERFIL = TBL_TIPO_PERFIL.ID_TIPO_USER\n"
                + "INNER JOIN TBL_TIPO_DOCUMENTO\n"
                + "ON TBL_USUARIO.TIPO_DOCUMENTO = TBL_TIPO_DOCUMENTO.ID_DOCUMENTO\n"
                + "WHERE TBL_USUARIO.ID_USUARIO=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            idUsuario = rs.getInt("ID_USUARIO");
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            String documento = rs.getString("NUMERO_DOCUMENTO");
            String email = rs.getString("EMAIL");
            int idPerfil = rs.getInt("PERFIL");
            int idDocumento = rs.getInt("TIPO_DOCUMENTO");
            String tipoDocumento = rs.getString("DOCUMENTO");
            String estado = rs.getString("ESTADO");
            String userName = rs.getString("USUARIO");
           String clave = rs.getString("CLAVE");

            Operario o = new Operario(idUsuario, primerNombre, segundoNombre, primerApellido, segundoApellido, documento, email, idPerfil, idDocumento, tipoDocumento, estado, userName, clave);
            return o;
        }

        return null;
    }

    public String obtenerNombreUser(int idUsuario) throws SQLException {

        String sql = "SELECT USUARIO, NOMBRE_USUARIO  FROM TBL_LOGIN WHERE USUARIO = ?";

        // La clase PreparedStatement se usa cuando la instrucción de SQL tiene parámetros
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idUsuario);

        ResultSet rs = ps.executeQuery();

        String nombreOpe = null;
        if (rs.next()) {
            nombreOpe = rs.getString("NOMBRE_USUARIO");
        }
        return nombreOpe;
    }

    public void editar(Operario o) throws SQLException {
        String sql = "UPDATE TBL_USUARIO SET PRIMER_NOMBRE= ?, SEGUNDO_NOMBRE= ?, PRIMER_APELLIDO= ?, SEGUNDO_APELLIDO= ?"
                + "NUMERO_DOCUMENTO=?, EMAIL= ?, PERFIL= ?,"
                + " TIPO_DOCUMENTO= ? WHERE ID_USUARIO=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, o.getPrimerNombre());
        ps.setString(2, o.getSegundoNombre());
        ps.setString(3, o.getPrimerApellido());
        ps.setString(4, o.getSegundoApellido());
        ps.setString(5, o.getNumDocumento());
        ps.setString(6, o.getEmail());
        ps.setInt(7, o.getIdPerfil());
        ps.setInt(8, o.getIdTipoDocumento());
        ps.setInt(9, o.getIdUsuario());

        ps.executeUpdate();

    }

    public void editarUser(Operario o) throws SQLException {
        String sql = "UPDATE TBL_LOGIN SET NOMBRE_USUARIO= ?, "
                + "CLAVE=? WHERE USUARIO=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, o.getUserName());
        ps.setString(2, o.getPassword());
        ps.setInt(3, o.getIdUsuario());

        ps.executeUpdate();

    }

    public List<Operario> obtenerTipoDocumento() throws SQLException {
        List<Operario> listaTipoDocumento = new LinkedList<>();

        try (Statement stmt = conexion.createStatement()) {
            String sql = "SELECT ID_DOCUMENTO, DESCRIPCION FROM TBL_TIPO_DOCUMENTO";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idTipoDocumento = rs.getInt("ID_DOCUMENTO");
                String descripcion = rs.getString("DESCRIPCION");

                Operario TD = new Operario(descripcion, idTipoDocumento);
                listaTipoDocumento.add(TD);
            }
        }
        return listaTipoDocumento;
    }

    public String idTipoDocumento(int idTipoDocumento) throws SQLException {

        String sql = "SELECT ID_DOCUMENTO, DESCRIPCION FROM TBL_TIPO_DOCUMENTO WHERE ID_DOCUMENTO = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idTipoDocumento);

        ResultSet rs = ps.executeQuery();

        String descripcion = null;
        if (rs.next()) {
            descripcion = rs.getString("DESCRIPCION");
        }
        return descripcion;
    }

    public String idPerfil(int idPerfil) throws SQLException {

        String sql = "SELECT ID_TIPO_USER, DESCRIPCION FROM TBL_TIPO_PERFIL WHERE ID_TIPO_USER = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idPerfil);

        ResultSet rs = ps.executeQuery();

        String descripcion = null;
        if (rs.next()) {
            descripcion = rs.getString("DESCRIPCION");
        }
        return descripcion;
    }
    
    public Usuario VerificarUsuario(String usuario) throws SQLException {
        String sql = "SELECT USUARIO, CLAVE FROM TBL_USUARIO WHERE USUARIO = ?";
        
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

         
            usuario = rs.getString("USUARIO");
            String clave = rs.getString("CLAVE");
            
            Usuario u = new Usuario (usuario, clave);
            return u;
        }

        return null;
    }
}
