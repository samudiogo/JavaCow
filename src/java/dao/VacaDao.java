/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import model.Vaca;

/**
 *
 * @author samuel
 */
public class VacaDao
{

    public String Cadastro(Object vaca)
    {
        try
        {
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            em.persist(vaca);
            utx.commit();
            
             return "sucesso";
        } catch (Exception e)
        {
            Logger.getLogger(VacaDao.class.getName()).log(Level.SEVERE, null, e);
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }

    public List<Vaca> ListaVacas()
    {
        try
        {
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            Query q = em.createQuery("select v FROM Vaca v");
            List<Vaca> vacas = new ArrayList<>();
            vacas = q.getResultList();
            utx.commit();
            return vacas;
        } catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

}
