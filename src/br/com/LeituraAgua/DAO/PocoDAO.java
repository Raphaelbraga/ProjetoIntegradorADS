/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Distrito;
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
            
            String sqlcadastra = "INSERT INTO poco (id_poco, unidade_consumidora,id_distrito) values (?, ?, ?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1, obj.getIdPoco());
            stmt.setInt(2, obj.getUnidadeConsumidora());
            stmt.setInt(3, obj.getIdDistrito());
            ResultSet poco = stmt.executeQuery();
            
            Distrito distritoPoco = new Distrito();
            distritoPoco.setIdDistrito(poco.getInt("id_distrito"));
            
            Poco novoPoco = new Poco (poco.getInt("id_poco"),
                    poco.getInt("unidade_consumidora"),distritoPoco );
            return novoPoco;
            
        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }
    
    public List <Poco> listarPoco(){
        List<Poco> listarId = new ArrayList<Poco>();
        String sqlListar = "SELECT from poco where id_poco";
        
        try {
            ConexaoDAO conDAO = new ConexaoDAO();
            stmt= conDAO.connect.prepareStatement(sqlListar);
            stmt.setInt(1, getIdPoco);
            
        } catch (Exception e) {
        }
        
    } 

}
