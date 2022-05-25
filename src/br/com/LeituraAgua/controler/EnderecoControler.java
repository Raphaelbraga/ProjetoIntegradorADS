/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.controler;


import br.com.LeituraAgua.DAO.EnderecoDAO;
import br.com.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Cleumar
 */
public class EnderecoControler {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Endereco cadastraNovo(Endereco obj){
        EnderecoDAO solicita = new EnderecoDAO();
        Endereco enderecoExist = solicita.listarPorId(obj.getIdEndereco());

        if (enderecoExist != null) {
            setMensagem("Erro - Endereco ja existe!");
        } else {
            Endereco novoEndereco = solicita.cadastrar(obj);
            return novoEndereco;
        }
        return null;
    }
    
    public List<Endereco> consultarLista(Endereco obj) {
        EnderecoDAO consulta = new EnderecoDAO();
        List<Endereco> enderecoLista = consulta.listar();

        if (enderecoLista == null) {
            setMensagem("Erro - lista de Endereco não existe");
        } else {
            return enderecoLista;
        }
        return null;
    }


    public Endereco atualizar(Endereco obj) {
        EnderecoDAO atualiza = new EnderecoDAO();
        Endereco idEndereco = atualiza.listarPorId(obj.getIdEndereco());
        
        if (idEndereco != null) {
            setMensagem("Erro - Endereco não existe!");
        } else {
            Endereco EnderecoAtual = atualiza.atualizar(obj);
            return EnderecoAtual;
        }
        return null;
    } 
    
    public Endereco deletar(Endereco obj) {
       EnderecoDAO deleta = new EnderecoDAO();
        Endereco idEndereco = deleta.listarPorId(obj.getIdEndereco());

        if (idEndereco != null) {
            setMensagem("Erro -Endereco não existe!");
        } else {
            Boolean enderecoDeletado = deleta.deletar(obj);
            if(!enderecoDeletado){
                setMensagem("falha ao deletar Endereco, contate suporte");
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
