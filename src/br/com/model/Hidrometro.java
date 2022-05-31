
package br.com.model;

/**
 *
 * @author Cleumar
 */
public class Hidrometro {
    private int idHidrometro;
    private double leituraInstalacao;
    private boolean situacao;
    private Consumidor consumidor;
    private Endereco endereco;

    public Hidrometro(int idHidrometro, double leituraInstalacao, boolean situacao, Consumidor consumidor, Endereco endereco) {
        this.idHidrometro = idHidrometro;
        this.leituraInstalacao = leituraInstalacao;
        this.situacao = situacao;
        this.consumidor = consumidor;
        this.endereco = endereco;
    }

    public Hidrometro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // gerado delegate methods
    public int getIdConsumidor() {
        return consumidor.getIdConsumidor();
    }

    public String getNome() {
        return consumidor.getNome();
    }

    public String getCpf() {
        return consumidor.getCpf();
    }

    public int getIdDistrito() {
        return endereco.getIdDistrito();
    }

    public String getNomeDistrito() {
        return endereco.getNomeDistrito();
    }

    public String getCidade() {
        return endereco.getCidade();
    }

    public int getIdEndereco() {
        return endereco.getIdEndereco();
    }

    public String getRua() {
        return endereco.getRua();
    }

    public int getNumero() {
        return endereco.getNumero();
    }

    public Distrito getDistrito() {
        return endereco.getDistrito();
    }
    
    
    //gerado get and sets
    public int getIdHidrometro() {
        return idHidrometro;
    }

    public void setIdHidrometro(int idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public double getLeituraInstalacao() {
        return leituraInstalacao;
    }

    public void setLeituraInstalacao(double leituraInstalacao) {
        this.leituraInstalacao = leituraInstalacao;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Hidrometro{" + "idHidrometro=" + idHidrometro + ", leituraInstalacao=" + leituraInstalacao + ", situacao=" + situacao + ", consumidor=" + consumidor + ", endereco=" + endereco + '}';
    } 
    
}
