/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Distrito;
import br.com.model.Endereco;
import br.com.model.Hidrometro;
import br.com.model.Leitura;
import br.com.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cleumar
 */
public class LeituraDAO {
    
private PreparedStatement stmt;

    public Leitura cadastrar(Leitura obj) {

        try {
            String sqlcadastra = "INSERT INTO leitura (id_leitura, mes_referencia,leitura_mes_anterior,leitura_mes_atual, id_hidrometro, id_usuario ) values (?,?,?,?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1, obj.getIdLeitura());
            stmt.setDate(2, (Date) obj.getMesReferencia());
            stmt.setInt(3, obj.getLeituraMesAnterior());
            stmt.setInt(4, obj.getLeituraMesAtual());
            stmt.setInt(5, obj.getHidrometro().getIdHidrometro());
            stmt.setInt(5, obj.getUsuario().getIdUsuario());
            ResultSet leitura = stmt.executeQuery();

            Hidrometro leituraHidrometro = new Hidrometro();
            leituraHidrometro.setIdHidrometro(leitura.getInt("id_hidrometro"));
            
            Usuario leituraUsuario = new Usuario();
            leituraUsuario.setIdUsuario(leitura.getInt("id_usuario"));

            Leitura novoLeitura = new Leitura(leitura.getInt("id_leitura"),
                    leitura.getDate("mes_referencia"),
                    leitura.getInt("leitura_mes_anterior"),
                    leitura.getInt("leitura_mes_atual"),
                    leituraHidrometro,
                    leituraUsuario);

            return novoLeitura;
        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }    
    
}
