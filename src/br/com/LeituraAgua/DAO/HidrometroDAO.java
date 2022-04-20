
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Hidrometro;
import static br.com.LeituraAgua.DAO.ConexaoDAO.connect;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class HidrometroDAO {

    public boolean cadastrar(Hidrometro obj) {
        boolean retorno = false;
        try {
            stmt = connect.createStatement();
            String mysql = "INSERT INTO hidrometro id_hidrometro,leitura_instalacao"
                    + " situacao, id_consumidor, id_endereco";

            stmt.execute(mysql);
        } catch (SQLException add) {
            add.getMessage();
        }
        return false;
    }
}
