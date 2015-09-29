<%-- 
    Document   : Index
    Created on : Sep 29, 2015, 11:06:05 AM
    Author     : samuel
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Vaca"%>
<%@page import="dao.VacaDao"%>
<%


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div>
                <h1><%= session.getAttribute("mensagem") %></h1>
            </div>
            <hr>
            <h3>vaca com maior e menor produção</h3>
            <p>
                <% VacaDao dao = new VacaDao();
                Vaca vacaMenor = new Vaca(null, null, Integer.MAX_VALUE);
                for(Vaca item : dao.ListaVacas())
                {
                   if(item.getProducao() < vacaMenor.getProducao())
                   {
                       vacaMenor = item;
                   }
                }
                
               
                %>
                Menor:<%= vacaMenor %>
            </p>
            
            <h3>vaca com maior produção</h3>
            <p>
                <%
                Vaca vacaMaior = vacaMenor;
                for(Vaca item : dao.ListaVacas())
                {
                   if(item.getProducao() > vacaMaior.getProducao())
                   {
                       vacaMaior = item;
                   }
                }
                
               
                %>
                Maior:<%= vacaMaior %>
            </p>
        </div>

        <hr>
        <p>
            <a href="Cadastro.jsp" class="btn btn-sm btn-success">Cadastrar nova vaca</a>
        </p>
    </body>
</html>
