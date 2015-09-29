<%-- 
    Document   : Login
    Created on : Sep 29, 2015, 10:18:00 AM
    Author     : samuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div style="width: 300px;" class="well">
                <form class="form-horizontal" action="acao/Autenticacao" method="POST">
                    <label>Usuário:</label>
                    <input type="text" class="form-control" required name="usuario">
                    <label>Senha:</label>
                    <input type="password" class="form-control" required name="senha">
                    <input type="submit" class="btn btn-sm btn-success btn-block">
                </form>
            </div>
        </div>
    </body>
</html>
