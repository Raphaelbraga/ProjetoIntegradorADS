/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.FaturaDAO;
import br.com.model.Fatura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class FaturaControler {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;
    
    public Fatura cadastrarNovo(Fatura obj) {
        FaturaDAO solicita = new FaturaDAO();
        Fatura FaturaExist = solicita.gerar(obj);

        if (FaturaExist != null) {
            setMensagem("Erro - fatura ja existe!");
        } else {
            Fatura usuario = solicita.gerar(obj);
            return usuario;
        }
        return null;
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
