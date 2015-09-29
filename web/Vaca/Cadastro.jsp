<%-- 
    Document   : Cadastro
    Created on : Sep 29, 2015, 10:29:29 AM
    Author     : samuel
--%>
<%
    Boolean autorizado = Boolean.parseBoolean(session.getAttribute("autenticado").toString());
    if (autorizado == false)
    {
        response.sendRedirect("../Login.jsp");
    }
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Hello, <%= session.getAttribute("Nome") %></h1>
            <hr>
            <div class="well" style="width: 450px;">
                <form class="form-horizontal" action="../acao/VacaController" method="POST">
                    <label>Nome: </label>
                    <input type="text" name="nome" class="form-control" required>
                    <label>Raça:</label>
                    <input type="text" name="raca" class="form-control" required>
                    <label>Litros:</label>
                    <input type="text" name="litro" class="form-control" required>
                    <input type="submit" class=" btn btn-sm btn-success">                           
                </form>
            </div>
        </div>
    </body>
</html>
