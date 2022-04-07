/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Usuario;
import static br.com.LeituraAgua.DAO.ConexaoDAO.connect;
import static br.com.LeituraAgua.DAO.ConexaoDAO.stmt;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean cadastrar(Usuario obj) {
        boolean retCadastrar = false;

        try {
            stmt = connect.createStatement();
            String mySql = "INSERT INTO usuario idUsuario,"
                    + "tipoUsuario, login, senha; ";
            stmt.execute(mySql);
            return retCadastrar;
        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }

    public boolean listar(Usuario obj) {
        boolean retListar = false;

        try {
            stmt = connect.createStatement();
            String mySql = "SELECT idUsuario, tipoUsuario FRON usuario ";
            stmt.execute(mySql);

        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }

    public boolean atualizar(Usuario obj) {
        boolean retAtualisar = false;

        try {
            stmt = connect.createStatement();
            String mySql = "UPDATE usuario SET idUsuario=?,"
                    + "tipoUsuario=?, login=?, senha=? WHERE= idUsuario";
            stmt.execute(mySql);

        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }

}
