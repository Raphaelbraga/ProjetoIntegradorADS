/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.leituraAgua.ConexaoDB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectDB {
    static Statement stmt = null;
    static Connection connect = null;

    public static void main(String[] args) {
        //conectDB connection = new conectDB();
        String nome = "Fulano";
        createConnection();
        insert(nome);
       }

        static void createConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/leituradb", "root", "100%Tabajara");

            System.out.println("conectado ao DB");
        }

        catch (ClassNotFoundException ex){
            Logger.getLogger(ConectDB.class.getName()).log(Level.SEVERE, null,ex);
        }
        catch (SQLException ex){
            Logger.getLogger(ConectDB.class.getName()).log(Level.SEVERE, null,ex);
            ex.printStackTrace();
        }

       }

       public static void insert (String nome){

        try {
            stmt = connect.createStatement();
            String sql = "insert into aula values ('" + nome + "')";
            stmt.execute(sql);
        } catch (SQLException add){
                add.getMessage();
        }

       }
}
