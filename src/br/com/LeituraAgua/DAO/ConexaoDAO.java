/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDAO {
    public static Connection connect = null;
    
    private static ConexaoDAO INSTANCE;

    public ConexaoDAO() {
        connect = createConnection();
    }
           
    public static ConexaoDAO getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ConexaoDAO();
        }
        
        return INSTANCE;
    }
    
    public static Connection createConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/leituradb", "root", "100%Tabajara");
            return connect;     
           
        }

        catch (ClassNotFoundException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null,ex);
            System.out.println(ex);
            return null;
        }
        catch (SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null,ex);
            ex.printStackTrace();
            return null;
        }

       }

}
