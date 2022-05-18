
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;


import br.com.model.*;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class HidrometroDAO {


    private PreparedStatement  stmt;

    public Hidrometro cadastrar(Hidrometro obj) {
        try {
            String sqlcadastra = "INSERT INTO hidrometro ( leituraInstalacao, situação, Consumidor, Endereco ) values (?, ?, ?, ?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getLeituraInstalacao());
            stmt.setBoolean(2, obj.isSituacao());
            stmt.setString(3, obj.getConsumidor().getNome());
            stmt.setString(4, obj.getEndereco().getRua());
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

    public Hidrometro listarPorId(Integer id) {
        String sqlListar = "SELECT * FROM hidrometro WHERE id = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            ConsumidorDAO consDao = new ConsumidorDAO();
            EnderecoDAO endeDao = new EnderecoDAO();
            
            while (rs.next()) {

                Hidrometro obj = new Hidrometro();
                obj.setIdHidrometro(rs.getInt("id_hidrometro"));
                obj.setLeituraInstalacao(rs.getInt("leitura_instalacao"));
                obj.setSituacao(rs.getBoolean("situacao"));               
                obj.setConsumidor(consDao.listarPorId(rs.getInt("nome")));
                obj.setEndereco(endeDao.listarPorId(rs.getInt("rua")));
                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public List<Hidrometro> listar() {
        List<Hidrometro> lista = new ArrayList<Hidrometro>();
        String sqlListar = "SELECT * FROM hidrometro ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            ConsumidorDAO consDao = new ConsumidorDAO();
            EnderecoDAO endeDao = new EnderecoDAO();
            
            while (rs.next()) {

                Hidrometro obj = new Hidrometro();
                obj.setIdHidrometro(rs.getInt("id_hidrometro"));
                obj.setLeituraInstalacao(rs.getInt("leitura_instalacao"));
                obj.setSituacao(rs.getBoolean("situacao"));               
                obj.setConsumidor(consDao.listarPorId(rs.getInt("nome")));
                obj.setEndereco(endeDao.listarPorId(rs.getInt("rua")));
                lista.add(obj);

            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }
    
    public Hidrometro atualizar(Hidrometro obj) {
        try {
            String sqlAtualiza = "UPDATE hidrometro SET (leitura_instalacao=?,"
                    + "situacao=?, nome=?, rua=?)  WHERE id_hidrometro = ?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setInt(1, obj.getLeituraInstalacao());
            stmt.setBoolean(2, obj.isSituacao());
            stmt.setString(3, obj.getConsumidor().getNome());
            stmt.setString(4,obj.getEndereco().getRua());
            stmt.setInt(5, obj.getIdHidrometro());
            stmt.executeUpdate();
            
            return listarPorId(obj.getIdHidrometro());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }   
    
    public void deletar(Hidrometro obj) {
        String sqlDel = "DELETE FROM hidrometro WHERE id_hidrometro =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdEndereco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }    
    
}