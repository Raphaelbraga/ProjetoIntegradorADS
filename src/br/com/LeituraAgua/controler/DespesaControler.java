/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.DespesaDAO;
import br.com.LeituraAgua.DAO.HidrometroDAO;
import br.com.model.Despesa;
import br.com.model.Hidrometro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Cleumar
 */
public class DespesaControler {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Despesa cadastraNovo(Despesa obj){
        DespesaDAO solicita = new DespesaDAO();
        Despesa despesaExist = solicita.listarPorId(obj.getIdDespesa());

        if (despesaExist != null) {
            setMensagem("Erro - Despesa ja existe!");
        } else {
            Despesa novoDespesa = solicita.cadastrar(obj);
            return novoDespesa;
        }
        return null;
    }
    
    public List<Despesa> consultarLista(Despesa obj) {
        DespesaDAO consulta = new DespesaDAO();
        List<Despesa> despesaLista = consulta.listar();

        if (despesaLista == null) {
            setMensagem("Erro - lista de Despesa não existe");
        } else {
            return despesaLista;
        }
        return null;
    }


    public Despesa atualizar(Despesa obj) {
        DespesaDAO atualiza = new DespesaDAO();
        Despesa idDespesa = atualiza.listarPorId(obj.getIdDespesa());
        
        if (idDespesa != null) {
            setMensagem("Erro - Despesa não existe!");
        } else {
            Despesa DespesaAtual = atualiza.atualizar(obj);
            return DespesaAtual;
        }
        return null;
    } 
    
    public Despesa deletar(Despesa obj) {
        DespesaDAO deleta = new DespesaDAO();
        Despesa idDespesa = deleta.listarPorId(obj.getIdDespesa());

        if (idDespesa != null) {
            setMensagem("Erro -Despesa não existe!");
        } else {
            Boolean despesaDeletado = deleta.deletar(obj);
            if(!despesaDeletado){
                setMensagem("falha ao deletar Despesa, contate suporte");
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
