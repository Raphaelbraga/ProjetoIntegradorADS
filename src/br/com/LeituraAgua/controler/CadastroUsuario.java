/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.UsuarioDAO;
import br.com.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class CadastroUsuario {


    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    public Usuario cadastrarNovo(Usuario obj) {
        UsuarioDAO solicita = new UsuarioDAO();
        Usuario usuarioexist = solicita.listarPorUsuario(obj.getLogin());

        if (usuarioexist != null) {

            setMensagem("Erro - Usuário ja existe!");
        } else {
            Usuario usuario = solicita.cadastrar(obj);
            return usuario;
        }
        return null;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
