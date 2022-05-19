/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.HidrometroDAO;
import br.com.model.Hidrometro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HidrometroControler {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Hidrometro cadastraNovo(Hidrometro obj){
        HidrometroDAO solicita = new HidrometroDAO();
        Hidrometro hidrometroExist = solicita.listarPorId(obj.getIdHidrometro());

        if (hidrometroExist != null) {
            setMensagem("Erro - Hidrometro ja existe!");
        } else {
            Hidrometro novoHidrometro = solicita.cadastrar(obj);
            return novoHidrometro;
        }
        return null;
    }
    
    public List<Hidrometro> consultarLista(Hidrometro obj) {
        HidrometroDAO consulta = new HidrometroDAO();
        List<Hidrometro> hidrometroLista = consulta.listar();

        if (hidrometroLista == null) {
            setMensagem("Erro - lista de Hidrometro não existe");
        } else {
            return hidrometroLista;
        }
        return null;
    }


    public Hidrometro atualizar(Hidrometro obj) {
        HidrometroDAO atualiza = new HidrometroDAO();
        Hidrometro idHidrometro = atualiza.listarPorId(obj.getIdHidrometro());
        
        if (idHidrometro != null) {
            setMensagem("Erro - Hidrometro não existe!");
        } else {
            Hidrometro HidrometroAtual = atualiza.atualizar(obj);
            return HidrometroAtual;
        }
        return null;
    } 
    
    public Hidrometro deletar(Hidrometro obj) {
       HidrometroDAO deleta = new HidrometroDAO();
        Hidrometro idHidrometro = deleta.listarPorId(obj.getIdHidrometro());

        if (idHidrometro != null) {
            setMensagem("Erro -Hidrometro não existe!");
        } else {
            Boolean hidrometroDeletado = deleta.deletar(obj);
            if(!hidrometroDeletado){
                setMensagem("falha ao deletar Hidrometro, contate suporte");
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
