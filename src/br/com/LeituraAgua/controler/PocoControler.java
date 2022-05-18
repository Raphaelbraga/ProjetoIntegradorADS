/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.PocoDAO;
import br.com.model.Poco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PocoControler {
    
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;
    
    public Poco cadastraNovo(Poco obj){
        PocoDAO solicita = new PocoDAO();
        Poco pocoExist = solicita.listarPorId(obj.getIdPoco());

        if (pocoExist != null) {
            setMensagem("Erro - Usuário ja existe!");
        } else {
            Poco usuario = solicita.cadastrar(obj);
            return usuario;
        }
        return null;
    }
    
    public List<Poco> consultarLista(Poco obj) {
        PocoDAO consulta = new PocoDAO();
        List<Poco> pocoLista = consulta.listar();

        if (pocoLista == null) {
            setMensagem("Erro - lista de usuario não existe");
        } else {
            return pocoLista;
        }
        return null;
    }
    
    public Poco atualizar(Poco obj) {
        PocoDAO atualiza = new PocoDAO();
        Poco idPoco = atualiza.listarPorId(obj.getIdPoco());
        
        if (idPoco != null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            Poco PocoAtual = atualiza.atualizar(obj);
            return PocoAtual;
        }
        return null;
    }
    
    public Poco deletar(Poco obj) {
        PocoDAO deleta = new PocoDAO();
        Poco idPoco = deleta.listarPorId(obj.getIdPoco());

        if (idPoco != null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            Boolean pocoDeletado = deleta.deletar(obj);
            if(!pocoDeletado){
                setMensagem("falha ao deletar Poço, contate suporte");
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
