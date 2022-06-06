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
public class Leitura {
    private int idLeitura;
    private Date mesReferencia;
    private double leituraMesAnterior;
    private double leituraMesAtual;
    private Hidrometro hidrometro;
    private Usuario usuario;

    public Leitura(int idLeitura, Date mesReferencia, double leituraMesAnterior, double leituraMesAtual, Hidrometro hidrometro, Usuario usuario) {
        this.idLeitura = idLeitura;
        this.mesReferencia = mesReferencia;
        this.leituraMesAnterior = leituraMesAnterior;
        this.leituraMesAtual = leituraMesAtual;
        this.hidrometro = hidrometro;
        this.usuario = usuario;
    }

    public Leitura(int aInt, java.sql.Date date, double aInt0, double aInt1, Hidrometro leituraHidrometro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Leitura() {
        
    }

    public int getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(int idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Date getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(Date mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public double getLeituraMesAnterior() {
        return leituraMesAnterior;
    }

    public void setLeituraMesAnterior(double leituraMesAnterior) {
        this.leituraMesAnterior = leituraMesAnterior;
    }

    public double getLeituraMesAtual() {
        return leituraMesAtual;
    }

    public void setLeituraMesAtual(double leituraMesAtual) {
        this.leituraMesAtual = leituraMesAtual;
    }

    public Hidrometro getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(Hidrometro hidrometro) {
        this.hidrometro = hidrometro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
