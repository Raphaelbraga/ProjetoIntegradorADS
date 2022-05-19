/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.util.Date;

/**
 *
 * @author Cleumar
 */
public class Fatura {
    private int idFatura;
    private int taxaAdministrativa;
    private int valorMetroCubico;
    private int valorFatura;
    private Date mesReferencia;
    private Date dataVencimento;
    private boolean situacao;
    private Leitura leitura;

    public Fatura(int idFatura, int taxaAdministrativa, int valorMetroCubico, int valorFatura, Date mesReferencia, Date dataVencimento, boolean situacao, Leitura leitura) {
        this.idFatura = idFatura;
        this.taxaAdministrativa = taxaAdministrativa;
        this.valorMetroCubico = valorMetroCubico;
        this.valorFatura = valorFatura;
        this.mesReferencia = mesReferencia;
        this.dataVencimento = dataVencimento;
        this.situacao = situacao;
        this.leitura = leitura;
    }

    public Fatura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public int getTaxaAdministrativa() {
        return taxaAdministrativa;
    }

    public void setTaxaAdministrativa(int taxaAdministrativa) {
        this.taxaAdministrativa = taxaAdministrativa;
    }

    public int getValorMetroCubico() {
        return valorMetroCubico;
    }

    public void setValorMetroCubico(int valorMetroCubico) {
        this.valorMetroCubico = valorMetroCubico;
    }

    public int getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(int valorFatura) {
        this.valorFatura = valorFatura;
    }

    public Date getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(Date mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Leitura getLeitura() {
        return leitura;
    }

    public void setLeitura(Leitura leitura) {
        this.leitura = leitura;
    }
    
    
    
    
}
