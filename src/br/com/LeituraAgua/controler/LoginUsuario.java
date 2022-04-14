/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.ConexaoDAO;
import br.com.LeituraAgua.DAO.UsuarioDAO;
import br.com.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class LoginUsuario {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    public Usuario logarUsuario(String login, int senha){
         UsuarioDAO dao = new UsuarioDAO();
        
//        Usuario usuarioTeste = new Usuario();
//        usuarioTeste.setLogin("admin2");
//        usuarioTeste.setSenha(123456);
//        usuarioTeste.setTipoUsuario("admin");
//        dao.cadastrar(usuarioTeste);
                
        Usuario usuario = dao.logarUsuario(login, senha);
        
        if (usuario != null){
            
            if (!usuario.getTipoUsuario().equals("admin")){
                setMensagem("Erro - Usuário: "+usuario.getLogin()+" não possui permissão!");
            }else{
                setMensagem("Usuário: "+usuario.getLogin()+" autenticado com sucesso!");
            }
            
        }else{
            setMensagem("Erro - Usuário não encontrado!");
        }   
        
        return usuario;
    }
    
    public static void main(String[] args) {
        LoginUsuario loginController = new LoginUsuario();
        loginController.logarUsuario("admin2", 123456);
        System.out.println(loginController.getMensagem());
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
