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
 @SuppressWarnings("static-access")
 
public class EnderecoDAO {

    private PreparedStatement stmt;

   
    public Endereco cadastrar(Endereco obj) {

        try {
            String sqlcadastra = "INSERT INTO endereco ( rua,  numero, complemento, id_distrito ) values (?,?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);           
            stmt.setString(1, obj.getRua());
            stmt.setInt(2, obj.getNumero());
            stmt.setString(3, obj.getComplemento());
            stmt.setInt(4, obj.getDistrito().getIdDistrito());
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

    public Endereco listarPorId(Integer id) {
        String sqlListar = "SELECT * FROM endereco WHERE id = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            DistritoDAO distDao = new DistritoDAO();

            while (rs.next()) {

                Endereco obj = new Endereco();
                obj.setIdEndereco(rs.getInt("id_endereco"));
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setDistrito(distDao.listarPorId(rs.getInt("id_distrito")));

                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Endereco> listar() {
        List<Endereco> lista = new ArrayList<Endereco>();
        String sqlListar = "SELECT * FROM endereco ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            DistritoDAO distDao = new DistritoDAO();

            while (rs.next()) {

                Endereco obj = new Endereco();
                obj.setIdEndereco(rs.getInt("id_endereco"));
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setDistrito(distDao.listarPorId(rs.getInt("id_distrito")));
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
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, obj.getRua());
            stmt.setInt(2, obj.getNumero());
            stmt.setString(3, obj.getComplemento());
            stmt.setInt(4, obj.getDistrito().getIdDistrito());
            stmt.setInt(5,obj.getIdEndereco());
            stmt.executeUpdate();
            
            return listarPorId(obj.getIdEndereco());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public void deletar(Endereco obj) {
        String sqlDel = "DELETE FROM endereco WHERE id_endereco =? ";
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
