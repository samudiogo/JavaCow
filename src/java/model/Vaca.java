/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "Vaca")
public class Vaca
{

    @Id
    private String Codigo;
    private String Nome;
    private String Raca;
    private int Producao;

    //construtor padrão
    public Vaca()
    {
        this.SetCodigo();
    }

    public Vaca(String Nome, String Raca, int Producao)
    {
        this.Nome = Nome;
        this.Raca = Raca;
        this.Producao = Producao;
        this.SetCodigo();
    }

    private void SetCodigo()
    {
        UUID id = UUID.randomUUID();
        Codigo = id.toString();
    }

    @Override
    public String toString()
    {
        return getNome() +
                " | "
                + getRaca() +
                " | " +
                + getProducao();
    }
    
    /**
     * @return the Codigo
     */
    public String getCodigo()
    {
        return Codigo;
    }

    /**
     * @return the Nome
     */
    public String getNome()
    {
        return Nome;
    }

    /**
     * @return the Raca
     */
    public String getRaca()
    {
        return Raca;
    }

    /**
     * @return the Producao
     */
    public int getProducao()
    {
        return Producao;
    }
}
