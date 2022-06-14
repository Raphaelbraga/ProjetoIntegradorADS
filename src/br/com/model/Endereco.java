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

    public Endereco() {
    }

    public int getIdDistrito() {
        return distrito.getIdDistrito();
    }

    public void setIdDistrito(int idDistrito) {
        distrito.setIdDistrito(idDistrito);
    }

    public String getNomeDistrito() {
        return distrito.getNomeDistrito();
    }

    public void setNomeDistrito(String nomeDistrito) {
        distrito.setNomeDistrito(nomeDistrito);
    }

    public String getCidade() {
        return distrito.getCidade();
    }

    public void setCidade(String cidade) {
        distrito.setCidade(cidade);
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

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", distrito=" + distrito + '}';
    }
    
    
}
