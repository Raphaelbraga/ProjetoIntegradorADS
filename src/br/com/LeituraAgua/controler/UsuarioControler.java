/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.UsuarioDAO;
import br.com.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioControler {

    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    public Usuario logarUsuario(String login, int senha) {
        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = dao.logarUsuario(login, senha);

        if (usuario != null) {

            if (!usuario.getTipoUsuario().equals("admin")) {
                setMensagem("Erro - Usuário: " + usuario.getLogin() + " não possui permissão!");
            } else {
                setMensagem("Usuário: " + usuario.getLogin() + " autenticado com sucesso!");
            }

        } else {
            setMensagem("Erro - Usuário não encontrado!");
        }

        return usuario;
    }

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

    public List<Usuario> consultarLista(Usuario obj) {
        UsuarioDAO consulta = new UsuarioDAO();
        List<Usuario> usuarioLista = consulta.listar();

        if (usuarioLista == null) {
            setMensagem("Erro - lista de usuario não existe");
        } else {
            return usuarioLista;
        }
        return null;
    }

    public Usuario pesquisarPorNome(Usuario obj) {
        UsuarioDAO consulta = new UsuarioDAO();
        Usuario usuarioNome = consulta.listarPorUsuario(obj.getLogin());

        if (usuarioNome == null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            return obj;
        }
        return null;
    }

    public Usuario atualizar(Usuario obj) {
        UsuarioDAO atualiza = new UsuarioDAO();
        Usuario nomeUsuario = atualiza.listarPorUsuario(obj.getLogin());

        if (nomeUsuario != null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            Usuario usuario = atualiza.atualizar(obj);
            return usuario;
        }
        return null;
    }

    public Usuario deletar(Usuario obj) {
        UsuarioDAO deleta = new UsuarioDAO();
        Usuario usuario = deleta.listarPorUsuario(obj.getLogin());

        if (usuario == null) {
            setMensagem("Erro - Usuário não existe ou ja excluido");
        } else {
            Usuario usuDelet = deleta.deletar(obj);
            return usuDelet;
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
