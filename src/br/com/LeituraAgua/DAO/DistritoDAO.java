/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Distrito;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 *
 * @author Usuario
 */
public class DistritoDAO {
    
    private PreparedStatement stmt;
    
    public Distrito cadastrar(Distrito dist){
        try {
            String sqlcadastra = " INSERT INTO distrito (nome_distrito, cidade) values(?,?)"; 
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, dist.getNomeDistrito());
            stmt.setString(2, dist.getCidade());
            stmt.executeUpdate();
            
             try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                dist.setIdDistrito(generatedKeys.getInt(1));
                System.out.println("id:"+ dist.getIdDistrito());
                return dist;   
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
    
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return null;
    }
    
    public Distrito listarPorNome(String nome) {
        String sqlListar = "SELECT * FROM distrito WHERE nome = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Distrito dist = new Distrito(rs.getInt("id_distrito"), rs.getString("nome"), rs.getString("cidade"));
                return dist;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
//    public static void main(String[] args) {
//        Distrito dist = new Distrito();
//        dist.setNomeDistrito("sobradinho");
//        dist.setCidade("Toledo");
//        
//        DistritoDAO dao = new DistritoDAO();
//        dao.cadastrar(dist);
//    }
          
}
