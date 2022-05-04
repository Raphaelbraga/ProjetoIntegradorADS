/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Consumidor;
import br.com.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cleumar
 */
public class ConsumidorDAO {
    
    private PreparedStatement stmt;

    public Consumidor cadastrar(Consumidor obj) {

        try {
            String sqlcadastra = "INSERT INTO consumidor (int id_consumidor, String nome, String cpf, String contato ) values (?,?,?,?)";
            stmt = ConexaoDAO.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1, obj.getIdConsumidor());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getContato());
            ResultSet consumidor = stmt.executeQuery();
            
            
            Consumidor novoConsumidor = new Consumidor(consumidor.getInt("id_consumidor"),
                    consumidor.getString("nome"),
                    consumidor.getString("cpf"),
                    consumidor.getString("contato"));
                               
            return novoConsumidor;
        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }
    
    public List<Consumidor> listar() {
        List<Consumidor> lista = new ArrayList<Consumidor>();
        String sqlListar = "SELECT * FROM consumidor ";

        try {
            stmt = ConexaoDAO.connect.prepareStatement(sqlListar);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                
                Consumidor obj = new Consumidor();
                obj.setIdConsumidor(result.getInt("id_consumidor"));
                obj.setNome(result.getString("nome"));
                obj.setCpf(result.getString("cpf"));
                obj.setContato(result.getString("contato"));
                lista.add(obj);
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }
    
    public Consumidor atualizar(Consumidor obj) {
        try {
            String sqlAtualiza = "UPDATE coonsumidor SET (nome=?,"
                    + "cpf=?, contato=?)  WHERE id_consumidor = ?";
            stmt = ConexaoDAO.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getContato());
            ResultSet consumidor = stmt.executeQuery();

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

      public Consumidor deletar(Consumidor obj) {
        String sqlDel = "DELETE FROM detetive WHERE id_consumidor =? ";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdConsumidor());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
