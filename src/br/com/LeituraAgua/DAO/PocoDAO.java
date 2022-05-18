/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Distrito;
import br.com.model.Endereco;
import br.com.model.Poco;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PocoDAO {

    private PreparedStatement stmt;

    public Poco cadastrar(Poco obj) {

        try {

            String sqlcadastra = "INSERT INTO poco ( unidade_consumidora,id_distrito) values (?, ?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getUnidadeConsumidora());
            stmt.setInt(2, obj.getDistrito().getIdDistrito());
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

    public Poco listarPorId(Integer id) {
        String sqlListar = "SELECT * FROM poco WHERE id = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            DistritoDAO distDao = new DistritoDAO();

            while (rs.next()) {

                Poco obj = new Poco();
                obj.setIdPoco(rs.getInt("id_poco"));
                obj.setUnidadeConsumidora(rs.getInt("unidade_consumidora"));
                obj.setDistrito(distDao.listarPorId(rs.getInt("id_distrito")));

                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Poco> listar() {
        List<Poco> lista = new ArrayList<Poco>();
        String sqlListar = "SELECT * FROM poco ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            DistritoDAO distDao = new DistritoDAO();

            while (rs.next()) {

                Poco obj = new Poco();
                obj.setIdPoco(rs.getInt("id_poco"));
                obj.setUnidadeConsumidora(rs.getInt("unidade_consumidora"));
                obj.setDistrito(distDao.listarPorId(rs.getInt("id_distrito")));
                lista.add(obj);
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }

    public Poco atualizar(Poco obj) {
        try {
            String sqlAtualiza = "UPDATE poco SET (unidade_consumidora=?,"
                    + "id_distrito=?)  WHERE id_poco = ?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setInt(1, obj.getUnidadeConsumidora());
            stmt.setInt(2, obj.getDistrito().getIdDistrito());
            stmt.setInt(3, obj.getIdPoco());
            stmt.executeUpdate();
            
            return listarPorId(obj.getIdPoco());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Boolean deletar(Poco obj) {
        String sqlDel = "DELETE FROM poco WHERE id_poco =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdPoco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
