/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author samuel
 */
@WebServlet(urlPatterns = "/acao/Autenticacao")
public class Autenticacao extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String Nome = req.getParameter("usuario");
        String Senha = req.getParameter("senha");
        HttpSession sessao = req.getSession(true);
        if (Senha.equals("123456"))
        {
            
            sessao.setAttribute("Nome", Nome);
            sessao.setAttribute("autenticado", true);
            resp.sendRedirect("../Vaca/Cadastro.jsp");
        } 
        else
        {
            sessao.setAttribute("autenticado", false);
            resp.sendRedirect("../Login.jsp");
        }
    }

}
