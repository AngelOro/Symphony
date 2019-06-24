<%-- 
    Document   : Artista
    Created on : 22-jun-2019, 14:57:48
    Author     : Angelica
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Empresa"%>
<%@page import="Modelo.Artista"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOArtista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="css/simple-sidebar.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap-grid.css" type="text/css">



    </head>
    <body>
        <div class="d-flex" id="wrapper">

            <!-- Sidebar -->
            <div class="bg-light border-right" id="sidebar-wrapper">
                <div class="sidebar-heading"><img src="imagenes/logo_negro.png" alt="logo" width="150px"> </div>
                <ul class="list-group list-group-flush">
                    <li class="menu">
                        <a href="#" class="list-group-item list-group-item-action bg-light">Gestión</a>
                        <ul class="sub-menu">
                            <li><a href="Empresa.jsp" class="list-group-item list-group-item-action bg-light">Empresas</a></li>
                            <li><a href="Artista.jsp" class="list-group-item list-group-item-action bg-light">Artistas</a></li>
                            <li><a href="Empresa.jsp" class="list-group-item list-group-item-action bg-light">Ventas</a></li>
                        </ul>
                    </li>
                    <li class="menu">
                        <a href="#" class="list-group-item list-group-item-action bg-light">Informes</a>
                        <ul class="sub-menu">
                            <li><a href="Empresa.jsp" class="list-group-item list-group-item-action bg-light">Ganancia Artista</a></li>
                            <li><a href="Empresa.jsp" class="list-group-item list-group-item-action bg-light">Ganancia Empresa</a></li>
                        </ul>
                    </li>
                    <li class="menu">
                        <a href="#" class="list-group-item list-group-item-action bg-light">Log Auditoría</a>
                    </li>

                </ul>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">

                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Link</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Dropdown
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
                <section id="main-content">
                    <section id="wrapper">
                        <div class="row">
                            <div class="col-lg-12">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item">
                                        <a href="#">Gestión</a>
                                    </li>
                                    <li class="breadcrumb-item active">Artistas</li>
                                </ol>
                            </div>
                            <center><h2 class="text-center">Gestión de Artistas</h2></center><br><br>
                            <div class="row row-table col-lg-11" style="margin-top:0px;">
                                <div class="col-lg-3 bottom">
                                    <a href="ServletArtista?opcion=crearArtista"><button id="addArtista" type="button" class="btn btn-info">Agregar Artista</button></a>
                                </div>
                                <table class="table table-condensed">
                                    <thead>
                                        <tr class="cart_menu">
                                            <th class="text-center">Nombre </th>
                                            <th class="text-center">Empresa Difusora</th>
                                            <th class="text-center">Correo</th>
                                            <th class="text-center">Telefono contacto</th>
                                            <th class="text-center">Estado</th>
                                            <th ></th>
                                        </tr>
                                    </thead>
                                    <%
                                        DAOArtista artista = new DAOArtista();
                                        List<Artista> listaArtista = artista.listarArtistas();
                                        Iterator<Artista> iter = listaArtista.iterator();
                                        Artista art = null;
                                        while (iter.hasNext()) {
                                            art = iter.next();
 
                                    %> 
                                    <tbody style="border-collapse: 0;">
                                        <tr>
                                            <td id="nombreArt" class="text-center"><%= art.getNombreArtista() %></td>
                                            <td id="empDifusora" class="text-center"><%= art.getNombreEmp() %></td>
                                            <td id="correoArt" class="text-center"><%= art.getCorreo()  %></td>
                                            <td id="telefonoArt" class="text-center" ><%= art.getTelefono() %></td>
                                            <td id="estadoArt" class="text-center"><%= art.getEstado() %></td>

                                            <td class="text-center">
                                                <a id="editarArt" class="btn btn-warning" href="ServletArtista?opcion=editar&IdArtista=<%= art.getIdArtista() %>">Editar</a>
                                                
                                            </td>
                                        </tr>
                                        <%}%> 
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </section>
                </section>

            </div>
            <!-- /#page-content-wrapper -->

        </div>

        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>

    </body>
</html>
