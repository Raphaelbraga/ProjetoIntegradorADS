/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradb;

/**
 *
 * @author Cleumar
 */
public class Poco {
    private int idPoco;
    private int unidadeConsumidora;
    private Distrito distrito;

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
    
    
    
}
