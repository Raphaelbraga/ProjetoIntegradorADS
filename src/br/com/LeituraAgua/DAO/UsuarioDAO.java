/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Usuario;
import static br.com.LeituraAgua.DAO.ConexaoDAO.connect;
import java.sql.*;



public class UsuarioDAO {

    private PreparedStatement stmt;

    public Usuario cadastrar(Usuario obj) {

        try {
         String sqlcadastra = "INSERT INTO usuario (idUsuario, tipo_usuario,login, senha ) values (?, ?, ?)";
            stmt = ConexaoDAO.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1,obj.getIdUsuario());
            stmt.setString(2, obj.getTipoUsuario());
            stmt.setString(3, obj.getLogin());
            stmt.setInt(4, obj.getSenha());
            ResultSet usuario = stmt.executeQuery();
            
            Usuario novoUsuario = new Usuario(usuario.getInt("id_usuario"), 
                    usuario.getString("tipo_usuario"), usuario.getString("login"), 
                    usuario.getInt("senha"));
            return novoUsuario;
        } catch (SQLException add) {
            add.getMessage();
        }
       return null;
    }

    public boolean listar(Usuario obj) {
       boolean retListar = false;

        try {
            String mySql = "SELECT idUsuario, tipoUsuario FRON usuario ";
            stmt = ConexaoDAO.connect.prepareStatement(mySql);
            stmt.execute(mySql);

        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }

    public Usuario atualizar(String tipoUsuario, String login, int senha) {

        try {
            String sqlAtualiza = "UPDATE usuario SET tipoUsuario=?,"
                    +"login=?, senha=? WHERE id_usuario = ?" ;
            stmt = ConexaoDAO.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, tipoUsuario);
            stmt.setString(2, login);
            stmt.setInt(3, senha);
            ResultSet usuario = stmt.executeQuery();

////            Usuario novoUsuario = new Usuario(usuario.getString("tipo_usuario"), 
////                    usuario.getString("login"),
////                    usuario.getInt("senha"));
//            return novousuario ;
        }catch (SQLException add) {
            add.getMessage();
        }
       return null;
    }

    public Usuario logarUsuario(String login, int senha) {
        String sqlLogin = "select * from usuario where login = ? and senha = ?";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlLogin);
            stmt.setString(1, login);
            stmt.setInt(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("tipo_usuario"), rs.getString("login"), rs.getInt("senha"));
                return usuario;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    
    public Usuario listarPorUsuario(String login) {
        String sqlLogin = "select * from usuario where login = ?";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlLogin);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("tipo_usuario"), rs.getString("login"), rs.getInt("senha"));
                return usuario;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
