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
public class Usuario {
    private int idUsuario;
    private String tipoUsuario;
    private String login;
    private int senha;

    public Usuario(int idUsuario, String tipoUsuario, String login, int senha) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.login = login;
        this.senha = senha;
    }
    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    
    
}
