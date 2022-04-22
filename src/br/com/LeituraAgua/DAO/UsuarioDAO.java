/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Usuario;
import static br.com.LeituraAgua.DAO.ConexaoDAO.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UsuarioDAO {

    private PreparedStatement stmt;

    public Usuario cadastrar(Usuario obj) {

        try {
         String sqlcadastra = "INSERT INTO usuario (id_Usuario, tipo_usuario,login, senha ) values (?, ?, ?)";
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

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<Usuario>();
        String sqlListar = "SELECT* FRON usuario ";

        try {
            stmt = ConexaoDAO.connect.prepareStatement(sqlListar);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(result.getInt("id_usuario"));
                obj.setTipoUsuario(result.getString("tipo_usuario"));
                lista.add(obj);
            }
        } catch (SQLException add) {
            lista = null;
        }
            return lista;    
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

        }catch (SQLException add) {
            add.getMessage();
        }
       return null;
    }

    public Usuario logarUsuario(String login, int senha) {
        String sqlLogin = "SELECT * FROM usuario where login = ? and senha = ?";
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
        String sqlLogin = "SELECT * FROM usuario WHERE login = ?";
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
    
    public Usuario deletar(Usuario obj) {
        String sqlDel = "DELETE FROM detetive WHERE id_usuario =? ";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlDel);
            stmt.setInt(1,obj.getIdUsuario());
            stmt.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
