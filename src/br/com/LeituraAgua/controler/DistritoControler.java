/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.DistritoDAO;
import br.com.model.Distrito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Cleumar
 */
public class DistritoControler {
 PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Distrito cadastraNovo(Distrito obj){
        DistritoDAO solicita = new DistritoDAO();
        Distrito distritoExist = solicita.listarPorId(obj.getIdDistrito());

        if (distritoExist != null) {
            setMensagem("Erro - Distrito ja existe!");
        } else {
            Distrito novoDistrito = solicita.cadastrar(obj);
            return novoDistrito;
        }
        return null;
    }
    
    public List<Distrito> consultarLista(Distrito obj) {
        DistritoDAO consulta = new DistritoDAO();
        List<Distrito> distritoLista = consulta.listar();

        if (distritoLista == null) {
            setMensagem("Erro - lista de distrito não existe");
        } else {
            return distritoLista;
        }
        return null;
    }


    public Distrito atualizar(Distrito obj) {
        DistritoDAO atualiza = new DistritoDAO();
        Distrito idDistrito = atualiza.listarPorId(obj.getIdDistrito());
        
        if (idDistrito != null) {
            setMensagem("Erro - Distrito não existe!");
        } else {
            Distrito DistritoAtual = atualiza.atualizar(obj);
            return DistritoAtual;
        }
        return null;
    } 
    
    public Distrito deletar(Distrito obj) {
        DistritoDAO deleta = new DistritoDAO();
        Distrito idDistrito = deleta.listarPorId(obj.getIdDistrito());

        if (idDistrito != null) {
            setMensagem("Erro -Distrito não existe!");
        } else {
            Boolean distritoDeletado = deleta.deletar(obj);
            if(!distritoDeletado){
                setMensagem("falha ao deletar Distrito, contate suporte");
            }
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
