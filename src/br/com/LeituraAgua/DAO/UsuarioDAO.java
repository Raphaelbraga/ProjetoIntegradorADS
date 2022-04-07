/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Usuario;
import static br.com.LeituraAgua.DAO.ConexaoDAO.connect;
import java.awt.List;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    private PreparedStatement stmt;

    public boolean cadastrar(Usuario obj) {
        boolean retCadastrar = false;

        try {
             String mySql = "INSERT INTO usuario (login, senha, tipo_usuario) values (?, ?, ?)";
            stmt = ConexaoDAO.getInstance().connect.prepareStatement(mySql);
            stmt.setString(1, obj.getLogin());
            stmt.setInt(2, obj.getSenha());
            stmt.setString(3, obj.getTipoUsuario());
            Boolean sucesso = stmt.execute();
            
            if (sucesso){
                System.out.println("Sucesso!");
            }
            return retCadastrar;
        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }

    public boolean listar(Usuario obj) {
        boolean retListar = false;

        try {
            String mySql = "SELECT idUsuario, tipoUsuario FRON usuario ";
            stmt = ConexaoDAO.getInstance().connect.prepareStatement(mySql);
            stmt.execute(mySql);

        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }

    public boolean atualizar(Usuario obj) {
        boolean retAtualisar = false;

        try {
            String mySql = "UPDATE usuario SET idUsuario=?,"
                    + "tipoUsuario=?, login=?, senha=? WHERE= idUsuario";
            stmt = connect.prepareStatement(mySql);
            stmt.execute();

        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
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

}
