/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.DAOEmpresa;
import DAO.DAOTipoOperacion;
import Modelo.Empresa;
import Modelo.TipoOperacion;
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
public class ServletEmpresa extends HttpServlet {

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
            out.println("<title>Servlet ServletEmpresa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEmpresa at " + request.getContextPath() + "</h1>");
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

        if (opcion.equals("listarEmpresas")) {
            listarEmpresas(request, response);
        }
        /**
         * if (opcion.equals("borrar")) { int idUsuario =
         * Integer.parseInt((String) request.getParameter("IdUsuario"));
         *
         * borrarUsuario(idUsuario, request, response); }
         */

        if (opcion.equals("crearEmpresa")) {
            verCrearEmpresa(request, response);
        }

        if (opcion.equals("editar")) {
            verEditarEmpresa(request, response);
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
                crearEmpresa(request, response);
            }
            if (operacion.equals("editar")) {
                editarEmpresa(request, response);
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

    private void listarEmpresas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            List<Empresa> listaEmpresa = null;
            listaEmpresa = daoEmpresa.listarEmpresas();

            request.setAttribute("listaEmpresa", listaEmpresa);

            RequestDispatcher vista = request.getRequestDispatcher("/Empresa.jsp");
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

    private void verCrearEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            DAOTipoOperacion daoTipoOperacion = new DAOTipoOperacion();
            List<TipoOperacion> listaTipoOperacion = daoTipoOperacion.obtenerTipoOperacion();
            request.setAttribute("listaTipoOperacion", listaTipoOperacion);

            RequestDispatcher vista = request.getRequestDispatcher("/AgregarEmpresa.jsp");
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

    private void crearEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nombreEmpresa = request.getParameter("nombreEmp");
            String nit = request.getParameter("nit");
            String telefono = request.getParameter("telefono");
            double valorOperacion = Double.parseDouble(request.getParameter("valorOperacion"));
            int idTipoOperacion = Integer.parseInt(request.getParameter("tipoOperacion"));
            DAOTipoOperacion daoTipoOperacion = new DAOTipoOperacion();

            String tipoOperacion = daoTipoOperacion.idTipoOperacion(idTipoOperacion);

            Empresa e = new Empresa(0, nombreEmpresa, nit, telefono, valorOperacion, idTipoOperacion, tipoOperacion);
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            daoEmpresa.guardar(e);
            listarEmpresas(request, response);

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

    private void verEditarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOTipoOperacion tipoOperacion = new DAOTipoOperacion();
            List<TipoOperacion> listaTipoOperacion = tipoOperacion.obtenerTipoOperacion();
            request.setAttribute("listaTipoOperacion", listaTipoOperacion);

            int idEmpresa = Integer.parseInt(request.getParameter("IdEmpresa"));
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            Empresa e = daoEmpresa.empresaPorId(idEmpresa);
            request.setAttribute("empresa", e);
            RequestDispatcher vista = request.getRequestDispatcher("EditarEmpresa.jsp");
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

    private void editarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
            String nombreEmpresa = request.getParameter("nombreEmp");
            String nit = request.getParameter("nit");
            String telefono = request.getParameter("telefono");
            double valorOperacion = Double.parseDouble(request.getParameter("valorOperacion"));
            int idTipoOperacion = Integer.parseInt(request.getParameter("tipoOperacion"));
            DAOTipoOperacion daoTipoOperacion = new DAOTipoOperacion();
            String tipoOperacion = daoTipoOperacion.idTipoOperacion(idTipoOperacion);

            Empresa e = new Empresa(idEmpresa, nombreEmpresa, nit, telefono, valorOperacion, idTipoOperacion, tipoOperacion);
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            daoEmpresa.editar(e);
            listarEmpresas(request, response);
            
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
