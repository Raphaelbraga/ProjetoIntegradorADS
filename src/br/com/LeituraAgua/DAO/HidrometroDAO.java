
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;


import br.com.model.Hidrometro;
import static br.com.LeituraAgua.DAO.ConexaoDAO.connect;
import br.com.model.Endereco;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Usuario
 */
public class HidrometroDAO {


    private preparedStatement  stmt;

    public Hidrometro cadastrar(int idHidrometro, int leituraInstalacao, boolean situacao, Consumidor consumidor, Endereco endereco) {
        try {
            String sqlcadastra = "INSERT INTO hidrometro (idHidrometro, leituraInstalacao, situação, Consumidor, Endereco ) values (?, ?, ?, ?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1, idHidrometro);
            stmt.setInt(2, leituraInstalacao);
            stmt.setBoolean(3, situacao);
            stmt.setString(4, Consumidor);
            stmt.setString(5, Endereco);
            ResultSet hidrometro = stmt.executeQuery();

            Hidrometro novoHidrometro = new Hidrometro();
            hidrometro.getInt("id_hidrometro");
            hidrometro.getInt("leituraInstalacao");
            hidrometro.getBoolean("situacao");
            hidrometro.getString("Consumidor");
            hidrometro.getString("Endereco");

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
