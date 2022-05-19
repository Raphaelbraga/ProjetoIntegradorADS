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
public class Poco {
    private int idPoco;
    private int unidadeConsumidora;
    private Distrito distrito;

    public int getIdDistrito() {
        return distrito.getIdDistrito();
    }
        
    public String getNomeDistrito() {
        return distrito.getNomeDistrito();
    }

    public String getCidade() {
        return distrito.getCidade();
    }

    public Poco() {
    }
    
    public Poco(int idPoco, int unidadeConsumidora, Distrito distrito) {
        this.idPoco = idPoco;
        this.unidadeConsumidora = unidadeConsumidora;
        this.distrito = distrito;
    }

    public int getIdPoco() {
        return idPoco;
    }

    public void setIdPoco(int idPoco) {
        this.idPoco = idPoco;
    }

    public int getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public void setUnidadeConsumidora(int unidadeConsumidora) {
        this.unidadeConsumidora = unidadeConsumidora;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
  

    @Override
    public String toString() {
        return "Poco{" + "idPoco=" + idPoco + ", unidadeConsumidora=" + unidadeConsumidora + ", distrito=" + distrito + '}';
    }

    public void setIdpoco(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getPoco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdConsumidor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
