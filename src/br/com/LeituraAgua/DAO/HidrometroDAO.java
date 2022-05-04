
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;


import br.com.model.Hidrometro;
import java.sql.SQLException;
import java.sql.*;


/**
 *
 * @author Usuario
 */
public class HidrometroDAO {


    private preparedStatement  stmt;

    public Hidrometro cadastrar(Hidrometro obj) {
        try {
            String sqlcadastra = "INSERT INTO hidrometro ( leituraInstalacao, situação, Consumidor, Endereco ) values (?, ?, ?, ?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1, obj.getLeituraInstalacao());
            stmt.setBoolean(2, obj.isSituacao());
            stmt.setString(3, obj.getConsumidor().getIdConsumidor());
            stmt.setString(4, obj.getEndereco());
            Resultset hidrometro = stmt.executeQuery();

            Hidrometro novoHidrometro = new Hidrometro(hidrometro.getInt("leituraInstalacao"),
            hidrometro.getBoolean("situacao"),
            hidrometro.getString("Consumidor"),
            hidrometro.getString("Endereco"));

            return novoHidrometro;

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;

    }

    public boolean listar(Hidrometro obj) {
        boolean retListar = false;

        try {
            String mySql = "SELECT idHidrometro, leituraInstalacao, situação, Consumidor, Endereco";
            stmt = ConexaoDAO.connect.prepareStatement(mySql);
            stmt.execute(mySql);

        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }

}
