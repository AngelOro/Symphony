<%-- 
    Document   : AgregarEmpresa
    Created on : 22-jun-2019, 2:12:51
    Author     : Angelica
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.TipoOperacion"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOTipoOperacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                                    <li class="breadcrumb-item active">Empresas</li>
                                </ol>
                            </div>
                            <center><h2 class="text-center">Crear Empresa</h2></center><br><br>
                            <div class="row row-table col-lg-11" style="margin-top:0px;">

                                <form method="post" class="form-group" id="agregarEmpresa" action="ServletEmpresa">
                                    <input type="hidden" name="operacion" id="operacion" value="crear" >  
                                    <label for="idEmpresa" style="display: none;">Id Empresa </label>
                                    <input type="hidden" name="idEmpresa" id="idEmpresa" value="0" >
                                    <div class="form-inline">
                                        <label class="control-label col-sm-5" for="nombreEmp">Nombre empresa:</label>
                                        <div class="col-sm-6"> 
                                            <input type="text" class="form-control" id="nombreEmp" name="nombreEmp" required>
                                        </div>
                                    </div>
                                    <div class="form-inline">
                                        <label class="control-label col-sm-5" for="nit">NIT:</label>
                                        <div class="col-sm-6"> 
                                            <input type="text" class="form-control" id="nit" name="nit" required>
                                        </div>
                                    </div>
                                    <div class="form-inline">
                                        <label class="control-label col-sm-5" for="telefono">Telefono:</label>
                                        <div class="col-sm-6"> 
                                            <input type="text" class="form-control" id="telefono" name="telefono" required>
                                        </div>
                                    </div>
                                    <div class="form-inline">
                                        <label class="control-label col-sm-5" for="valorOperacion">Valor operación:</label>
                                        <div class="col-sm-6"> 
                                            <input type="text" class="form-control" id="valorOperacion" name="valorOperacion" required>
                                        </div>
                                    </div><br>
                                    <div class="form-inline">
                                        <label class="control-label col-sm-5" for="tipoOperacion">Tipo Operación:</label>
                                        <div class="col-sm-6"> 
                                            <select  class="form-control" id="tipoOperacion" name="tipoOperacion"  required>

                                                <%

                                                    DAOTipoOperacion tipoOperacion = new DAOTipoOperacion();
                                                    List<TipoOperacion> listaTipoOperacion = tipoOperacion.obtenerTipoOperacion();
                                                    Iterator<TipoOperacion> iter = listaTipoOperacion.iterator();
                                                    TipoOperacion oper = null;
                                                    out.println("<option >Seleccionar: </option>");
                                                    while (iter.hasNext()) {
                                                        oper = iter.next();

                                                        out.println("<option value='" + oper.getIdTipoOperacion() + "' >" + oper.getDescripcion() + "</option>");
                                                    }
                                                %>
                                            </select>

                                        </div>
                                    </div>

                                    <div class="form-group modal-footer"> 
                                        <div class="col-sm-offset-3 col-sm-9">
                                            <!--                                    <button type="submit" class="btn btn-info" >Registrar</button>-->
                                            <input class="btn btn-primary" type="submit" name="enviarEmp" value="Agregar">
                                            <a href="ServletEmpresa?opcion=listarEmpresas"><button id="cancel" type="button" class="btn btn-info" data-dismiss="modal">Cancelar</button></a>
                                        </div>
                                    </div>

                                </form>

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
