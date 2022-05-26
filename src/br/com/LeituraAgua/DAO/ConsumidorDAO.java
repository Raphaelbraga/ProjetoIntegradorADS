/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Consumidor;
import br.com.model.Poco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Cleumar
 */
public class ConsumidorDAO {
    
    private PreparedStatement stmt;

    public Consumidor cadastrar(Consumidor obj) {

        try {
            String sqlcadastra = "INSERT INTO consumidor ( nome, cpf, contato) values (?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);     
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getContato());
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return listarPorId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ocorreu um erro ao cadastrar o endereço!");
                }
            }                               
            } catch (SQLException add) {
            add.getMessage();
        }
        return null;
        }
          
    public Consumidor listarPorId(Integer id) {
            String sqlListar = "SELECT * FROM consumidor WHERE id_consumidor = ?";
            try {
                ConexaoDAO conDao = ConexaoDAO.getInstance();
                stmt = conDao.connect.prepareStatement(sqlListar);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    Consumidor obj = new Consumidor();
                    obj.setIdConsumidor(rs.getInt("id_consumidor"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setContato(rs.getString("contato"));

                    return obj;
                }

            } catch (SQLException e) {
                    e.printStackTrace();
            }
            return null;
        }


        public List<Consumidor> listar() {
        List<Consumidor> lista = new ArrayList<>();
        String sqlListar = "SELECT * FROM consumidor ";

            try {
                ConexaoDAO conDao = ConexaoDAO.getInstance();
                stmt = conDao.connect.prepareStatement(sqlListar);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    Consumidor obj = new Consumidor();
                    obj.setIdConsumidor(rs.getInt("id_consumidor"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setContato(rs.getString("contato"));
                    lista.add(obj);

            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }
    
    public Consumidor atualizar(Consumidor obj) {
        try {
            String sqlAtualiza = "UPDATE consumidor SET (nome=?,"
                    + "cpf=?, contato=?)  WHERE id_consumidor = ?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getContato());
            stmt.setInt(4,obj.getIdConsumidor());
            stmt.executeUpdate();
            
            return listarPorId(obj.getIdConsumidor());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Boolean deletar(Consumidor obj) {
        String sqlDel = "DELETE FROM consumidor WHERE id_consumidor =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdConsumidor());
            int retornoDelet = stmt.executeUpdate();
            
            if(retornoDelet ==1) {
                return true;    
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
