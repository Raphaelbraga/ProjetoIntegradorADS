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
public class Consumidor {

    private int idConsumidor;
    private String nome;
    private String cpf;
    private String contato;

    public Consumidor() {
    }

    public Consumidor(int idConsumidor, String nome, String cpf, String contato) {
        this.idConsumidor = idConsumidor;
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Consumidor{" + "idConsumidor=" + idConsumidor + ", nome=" + nome + ", cpf=" + cpf + ", contato=" + contato + '}';
    }

}
