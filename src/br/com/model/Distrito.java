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
public class Distrito {
    private int idDistrito;
    private String nomeDistrito;
    private String cidade;    
    
    
    public Distrito(int idDistrito, String nomeDistrito, String cidade) {
        this.idDistrito = idDistrito;
        this.nomeDistrito = nomeDistrito;
        this.cidade = cidade;
    }

    public Distrito() {

    }


    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNomeDistrito() {
        return nomeDistrito;
    }

    public void setNomeDistrito(String nomeDistrito) {
        this.nomeDistrito = nomeDistrito;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Distrito{" + "idDistrito=" + idDistrito + ", nomeDistrito=" + nomeDistrito + ", cidade=" + cidade + '}';
    }
    
    
}
