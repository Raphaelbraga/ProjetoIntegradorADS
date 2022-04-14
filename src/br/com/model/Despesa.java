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
public class Despesa {
    private int idDespesa;
    private Date mesVigente;
    private int valorFaturaEnergia;
    private Poco poco;

    public Despesa(int idDespesa, Date mesVigente, int valorFaturaEnergia, Poco poco) {
        this.idDespesa = idDespesa;
        this.mesVigente = mesVigente;
        this.valorFaturaEnergia = valorFaturaEnergia;
        this.poco = poco;
    }
    
    

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Date getMesVigente() {
        return mesVigente;
    }

    public void setMesVigente(Date mesVigente) {
        this.mesVigente = mesVigente;
    }

    public int getValorFaturaEnergia() {
        return valorFaturaEnergia;
    }

    public void setValorFaturaEnergia(int valorFaturaEnergia) {
        this.valorFaturaEnergia = valorFaturaEnergia;
    }

    public Poco getPoco() {
        return poco;
    }

    public void setPoco(Poco poco) {
        this.poco = poco;
    }
    
    
    
}
