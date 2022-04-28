/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Distrito;
import br.com.model.Endereco;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Cleumar
 */
public class EnderecoDAO {

    private PreparedStatement stmt;

    public Endereco cadastrar(Endereco obj) {

        try {
            String sqlcadastra = "INSERT INTO endereco (int id_endereco, String rua, int numero, String complemento, id_distrito ) values (?,?,?,?,?)";
            stmt = ConexaoDAO.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1, obj.getIdEndereco());
            stmt.setString(2, obj.getRua());
            stmt.setInt(3, obj.getNumero());
            stmt.setString(4, obj.getComplemento());
            stmt.setInt(5, obj.getDistrito().getIdDistrito());
            ResultSet endereco = stmt.executeQuery();

            Distrito distritoEndereco = new Distrito();
            distritoEndereco.setIdDistrito(endereco.getInt("id_distrito"));

            Endereco novoEndereco = new Endereco(endereco.getInt("id_endereco"),
                    endereco.getString("rua"),
                    endereco.getInt("numero"),
                    endereco.getString("complemento"),
                    distritoEndereco);

            return novoEndereco;
        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public List<Endereco> listar() {
        List<Endereco> lista = new ArrayList<Endereco>();
        String sqlListar = "SELECT * FROM endereco ";

        try {
            stmt = ConexaoDAO.connect.prepareStatement(sqlListar);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                
                Distrito distritoEndereco = new Distrito();
                distritoEndereco.setIdDistrito(result.getInt("id_distrito"));
                Endereco obj = new Endereco();
                obj.setIdEndereco(result.getInt("id_endereco"));
                obj.setRua(result.getString("rua"));
                obj.setNumero(result.getInt("numero"));
                obj.setComplemento(result.getString("complemento"));
                obj.setDistrito(distritoEndereco);
                lista.add(obj);
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }

    public Endereco atualizar(Endereco obj) {
        try {
            String sqlAtualiza = "UPDATE endereco SET (rua=?,"
                    + "numero=?, complemento=?, id_distrito=?)  WHERE id_endereco = ?";
            stmt = ConexaoDAO.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, obj.getRua());
            stmt.setInt(2, obj.getNumero());
            stmt.setString(3, obj.getComplemento());
            stmt.setInt(2, obj.getDistrito().getIdDistrito());
            ResultSet endereco = stmt.executeQuery();

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Endereco deletar(Endereco obj) {
        String sqlDel = "DELETE FROM detetive WHERE id_endereco =? ";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdEndereco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
