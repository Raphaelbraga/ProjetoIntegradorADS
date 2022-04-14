/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Cleumar
 */
public class Endereco {
    private int idEndereco;
    private String rua;
    private int numero;
    private String complemento;
    private Distrito distrito;
   

    public Endereco(int idEndereco, String rua, int numero, String complemento, Distrito distrito) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.distrito = distrito;
    }
    
    

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    
    
    
}
