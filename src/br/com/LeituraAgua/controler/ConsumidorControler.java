/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.ConsumidorDAO;
import br.com.model.Consumidor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Cleumar
 */
public class ConsumidorControler {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Consumidor cadastraNovo(Consumidor obj){
        ConsumidorDAO solicita = new ConsumidorDAO();
        Consumidor pocoExist = solicita.listarPorId(obj.getIdConsumidor());

        if (pocoExist != null) {
            setMensagem("Erro - Consumidor ja existe!");
        } else {
            Consumidor novoConsumidor = solicita.cadastrar(obj);
            return novoConsumidor;
        }
        return null;
    }
    
    public List<Consumidor> consultarLista(Consumidor obj) {
        ConsumidorDAO consulta = new ConsumidorDAO();
        List<Consumidor> consumidorLista = consulta.listar();

        if (consumidorLista == null) {
            setMensagem("Erro - lista de consumidor não existe");
        } else {
            return consumidorLista;
        }
        return null;
    }


    public Consumidor atualizar(Consumidor obj) {
        ConsumidorDAO atualiza = new ConsumidorDAO();
        Consumidor idConsumidor = atualiza.listarPorId(obj.getIdConsumidor());
        
        if (idConsumidor != null) {
            setMensagem("Erro - Consumidor não existe!");
        } else {
            Consumidor ConsumidorAtual = atualiza.atualizar(obj);
            return ConsumidorAtual;
        }
        return null;
    } 
    
    public Consumidor deletar(Consumidor obj) {
        ConsumidorDAO deleta = new ConsumidorDAO();
        Consumidor idConsumidor = deleta.listarPorId(obj.getIdConsumidor());

        if (idConsumidor != null) {
            setMensagem("Erro -Consumidor não existe!");
        } else {
            Boolean consumidorDeletado = deleta.deletar(obj);
            if(!consumidorDeletado){
                setMensagem("falha ao deletar Consumidor, contate suporte");
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
