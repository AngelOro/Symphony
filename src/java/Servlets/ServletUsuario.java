/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.DAOArtista;
import DAO.DAOEmpresa;
import DAO.DAOOperario;
import Modelo.Artista;
import Modelo.Empresa;
import Modelo.Operario;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angelica
 */
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = (String) request.getParameter("opcion");

        if (opcion.equals("listarOperarios")) {
            listarOperarios(request, response);
        }
        /**
         * if (opcion.equals("borrar")) { int idUsuario =
         * Integer.parseInt((String) request.getParameter("IdUsuario"));
         *
         * borrarUsuario(idUsuario, request, response); }
         */
        if (opcion.equals("user")) {
            verUserName(request, response);
        }

        if (opcion.equals("crearOperario")) {
            CrearOperario(request, response);
        }

        
         if (opcion.equals("editar")) { 
             verEditarOperario(request, response); 
         }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");

        if (operacion != null) {
            if (operacion.equals("crear")) {
                nuevoOperario(request, response);
            }
            if (operacion.equals("editar")) {
                editarOperario(request, response);
            }
             if (operacion.equals("userName")) {
                asignarUsuario(request, response);
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarOperarios(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
        try{
            DAOOperario daoOperario = new DAOOperario ();
            List<Operario> listaOperario = null;
            listaOperario = daoOperario.listarOperario();
            request.setAttribute("listaOperario", listaOperario);

            RequestDispatcher vista = request.getRequestDispatcher("/Operario.jsp");
            vista.forward(request, response);
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);

        }
            
    }

   
    private void verEditarOperario(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
        try{
            
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);

        }
    }

    private void CrearOperario(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
       try{
             DAOOperario daoOperario = new DAOOperario();
            List<Operario> listaTipoDocumento = daoOperario.obtenerTipoDocumento();
            request.setAttribute("listaTipoDocumento", listaTipoDocumento);
            
           

            RequestDispatcher vista = request.getRequestDispatcher("/AgregarOperario.jsp");
            vista.forward(request, response);
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);

        }
    }

    private void nuevoOperario(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
             
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            String numDocumento = request.getParameter("documento");
            int idDocumento = Integer.parseInt(request.getParameter("tipoDocumento"));
            DAOOperario daoOperario = new DAOOperario();

            String documento = daoOperario.idTipoDocumento(idDocumento);
            String correo = request.getParameter("emailOpe");
            String estado = request.getParameter("estadoUser");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
           
            
            Operario o = new Operario (0, primerNombre, segundoNombre, primerApellido,  segundoApellido, numDocumento, correo, 2, idDocumento, documento, estado, userName, password);
            daoOperario.guardar(o);
//            Operario u = new Operario (userName,password,0);
//            daoOperario.guardarUser(u);
            listarOperarios(request, response);
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);

        }
    }

    private void editarOperario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         try{
             
            
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);

        }
    }

    private void asignarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
//             int idOperario = Integer.parseInt(request.getParameter("idUsuario"));
//             String userName = request.getParameter("userName");
//            String password = request.getParameter("password");
//            
//            
//
//           Operario o = new Operario(userName, password, idOperario);
//            DAOOperario daoOperario = new DAOOperario();
//            daoOperario.guardarUser(o);
//            listarOperarios(request, response);
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);

        }
    }

    private void verUserName(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
             int idOperario = Integer.parseInt(request.getParameter("idUsuario"));
            DAOOperario daoOperario = new DAOOperario();
            Operario o = daoOperario.operarioPorId(idOperario);
            request.setAttribute("operario", o);
            RequestDispatcher vista = request.getRequestDispatcher("/UserName.jsp");
            vista.forward(request, response);
            
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);

        }
    }

   
}
