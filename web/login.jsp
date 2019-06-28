<%-- 
    Document   : login
    Created on : 24-jun-2019, 13:05:56
    Author     : Angelica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
                <div class="col-md-8 col-lg-6">
                    <div class="login d-flex align-items-center py-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-9 col-lg-8 mx-auto">
                                    <h3 class="login-heading mb-4">¡Bienvenido a Poli Symphony!</h3>
                                    <form method="post" class="login" id="login" action="Empresa.jsp">
                                    
                                        <label for="idUsuario" style="display: none;">Id Usuario </label>
                                        <input type="hidden" name="idUsuario" id="idUsuario" value="0" >
                                        <div class="form-label-group">
                                            <input type="text" id="userName" class="form-control" placeholder="Nombre Usuario" required autofocus>
                                            <label for="userName">Nombre Usuario</label>
                                        </div>

                                        <div class="form-label-group">
                                            <input type="password" id="clave" class="form-control" placeholder="Clave" required>
                                            <label for="clave">Clave</label>
                                        </div>

                                        <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Ingresar</button>
                                        

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
