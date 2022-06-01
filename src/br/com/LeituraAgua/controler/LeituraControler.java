/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.HidrometroDAO;
import br.com.LeituraAgua.DAO.LeituraDAO;
import br.com.model.Hidrometro;
import br.com.model.Leitura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class LeituraControler {

    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

   
    public Leitura novaleitura(Leitura obj){
        LeituraDAO leituraDao = new LeituraDAO();
        Leitura ultimaLeitura = leituraDao.listaPorIdHidrometro(obj.getHidrometro().getIdHidrometro());
        
        Leitura novaLeitura = new Leitura();
        
        Double valorUltimaLeitura = 0.00;
        if (ultimaLeitura != null) {
           valorUltimaLeitura = ultimaLeitura.getLeituraMesAtual();
        } else {
            valorUltimaLeitura = obj.getHidrometro().getLeituraInstalacao();
        }
        
        novaLeitura.setLeituraMesAnterior(valorUltimaLeitura);
        novaLeitura.setLeituraMesAtual(obj.getLeituraMesAtual());
        novaLeitura.setUsuario(obj.getUsuario());
        novaLeitura.setHidrometro(obj.getHidrometro());
        novaLeitura.setMesReferencia(obj.getMesReferencia());
        
        return leituraDao.cadastrar(novaLeitura);
    
    }
    
    public Leitura atualizar(Leitura obj) {
        LeituraDAO atualiza = new LeituraDAO();
        Leitura idLeitura = atualiza.listarPorId(obj.getIdLeitura());
        
        if (idLeitura != null) {
            setMensagem("Erro - leitura não existe!");
        } else {
            Leitura leituraAtual = atualiza.atualizar(obj);
            return leituraAtual;
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
