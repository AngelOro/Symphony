/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.DAOArtista;
import DAO.DAOEmpresa;
import DAO.DAOTipoOperacion;
import Modelo.Artista;
import Modelo.Empresa;
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
public class ServletArtista extends HttpServlet {

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
            out.println("<title>Servlet ServletArtista</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletArtista at " + request.getContextPath() + "</h1>");
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

        if (opcion.equals("listarArtistas")) {
            listarArtistas(request, response);
        }
        /**
         * if (opcion.equals("borrar")) { int idUsuario =
         * Integer.parseInt((String) request.getParameter("IdUsuario"));
         *
         * borrarUsuario(idUsuario, request, response); }
         */

        if (opcion.equals("crearArtista")) {
            verCrearArtista(request, response);
        }

        
         if (opcion.equals("editar")) { 
             verEditarArtista(request, response); }
        
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
                crearArtista(request, response);
            }
            if (operacion.equals("editar")) {
                editarArtista(request, response);
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

    private void listarArtistas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOArtista daoArtista = new DAOArtista();
            List<Artista> listaArtista = null;
            listaArtista = daoArtista.listarArtistas();
            request.setAttribute("listaArtista", listaArtista);

            RequestDispatcher vista = request.getRequestDispatcher("/Artista.jsp");
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

    private void verCrearArtista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            List<Empresa> listaEmpresa = daoEmpresa.listarEmpresas();
            request.setAttribute("listaEmpresa", listaEmpresa);

            RequestDispatcher vista = request.getRequestDispatcher("/AgregarArtista.jsp");
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

    private void crearArtista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nombreArtista = request.getParameter("nameArt");
            int idEmpresa = Integer.parseInt(request.getParameter("empresaDifusora"));
            DAOEmpresa daoEmpresa = new DAOEmpresa();

            String empresa = daoEmpresa.obtenerNombreEmpresa(idEmpresa);
            String correo = request.getParameter("emailArt");
            String telefono = request.getParameter("phoneArt");
            String estado = request.getParameter("estado");
            
            Artista a = new Artista (0, nombreArtista, idEmpresa, empresa, correo, telefono, estado);
            DAOArtista daoArtista = new DAOArtista();
            daoArtista.guardar(a);
            listarArtistas(request, response);

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

    private void editarArtista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            int idArtista = Integer.parseInt(request.getParameter("idArtista"));
            String nombreArtista = request.getParameter("nombreArt");
            int idEmpresa = Integer.parseInt(request.getParameter("empresaDifusora"));
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            String nombreEmpresa = daoEmpresa.obtenerNombreEmpresa(idEmpresa);
            String correo = request.getParameter("emailArt");
            String telefono = request.getParameter("phoneArt");
            String estado = request.getParameter("estado");

            Artista a = new Artista(idArtista, nombreArtista, idEmpresa, nombreEmpresa, correo, telefono, estado );
            DAOArtista daoArtista = new DAOArtista();
            daoArtista.editar(a);
            listarArtistas(request, response);

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

    private void verEditarArtista(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            List<Empresa> listaEmpresa = daoEmpresa.listarEmpresas();
            request.setAttribute("listaEmpresa", listaEmpresa);
            
            int idArtista = Integer.parseInt(request.getParameter("IdArtista"));
            DAOArtista daoArtista = new DAOArtista();
            Artista a = daoArtista.artistaPorId(idArtista);
            request.setAttribute("artista", a);
            RequestDispatcher vista = request.getRequestDispatcher("/EditarArtista.jsp");
            vista.forward(request, response);

            
        }catch (Exception ex) {
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
