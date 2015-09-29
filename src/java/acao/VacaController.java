/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acao;

import dao.VacaDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Vaca;

/**
 *
 * @author samuel
 */
@WebServlet(urlPatterns = "/acao/VacaController")
public class VacaController extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Vaca vaca = new Vaca(
                req.getParameter("nome"),
                req.getParameter("raca"),
                Integer.parseInt(req.getParameter("litro")));
        HttpSession session = req.getSession(true);
        session.setAttribute("mensagem", this.Cadastro(vaca));
        resp.sendRedirect("../Vaca/Index.jsp");

    }

    public String Cadastro(Vaca vaquinha)
    {
        VacaDao dao = new VacaDao();
        String Mensagem = dao.Cadastro(vaquinha);
        if (Mensagem.equals("sucesso"))
        {
            int litro = vaquinha.getProducao();

            if (litro >= 30)
            {
                Mensagem = "Vaca Classe A Cadastrado com sucesso!";
            } else if (litro >= 20 && litro < 30)
            {
                Mensagem = "Vaca Classe B Cadastrado com sucesso!";
            } else if (litro < 20)
            {
                Mensagem = "Vaca Classe C Cadastrado";
            }
        }
        return Mensagem;
    }
}
