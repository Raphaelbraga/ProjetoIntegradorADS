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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cleumar
 */
public class LeituraDAO {
    
private PreparedStatement stmt;

    public Leitura cadastrar(Leitura obj) {

        try {
            String sqlcadastra = "INSERT INTO leitura (mes_referencia,leitura_mes_anterior,leitura_mes_atual, id_hidrometro, id_usuario ) values (?,?,?,?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);            
            stmt.setDate(1, (Date) obj.getMesReferencia());
            stmt.setDouble(2, obj.getLeituraMesAnterior());
            stmt.setDouble(3, obj.getLeituraMesAtual());
            stmt.setInt(4, obj.getHidrometro().getIdHidrometro());
            stmt.setInt(5, obj.getUsuario().getIdUsuario());
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
    
    
    public Leitura listarPorId(Integer id) {
        String sqlListar = "SELECT * FROM leitura WHERE id_leitura = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            HidrometroDAO leiDao = new HidrometroDAO();
            UsuarioDAO leDao = new UsuarioDAO();
            while (rs.next()) {

                Leitura obj = new Leitura();
                obj.setMesReferencia(rs.getDate("mes_referencia"));
                obj.setLeituraMesAnterior(rs.getInt("leitura_mes_anterior"));
                obj.setLeituraMesAtual(rs.getInt("leitura_mes_atual"));          
                obj.setHidrometro(leiDao.listarPorId(rs.getInt("id_hidrometro")));
                obj.setUsuario(leDao.listarPorId(rs.getInt("id_usuario")));
                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    public Leitura listaPorIdHidrometro(Integer id) {
        String sqlListar = "SELECT * FROM leitura WHERE id_hidrometro = ? order by id_leitura desc limit 1 ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            HidrometroDAO leiDao = new HidrometroDAO();
            UsuarioDAO leDao = new UsuarioDAO();
            while (rs.next()) {

                obj.setDateMesReferencia(rs.getDate("mes_referencia"));
                obj.setLeituraMesAnterior( rs.getDouble("leitura_mes_anterior"));
                obj.setLeituraMesAtual( rs.getDouble("leitura_mes_atual"));          
                obj.setHidrometro(leiDao.listarPorId(rs.getInt("id_hidrometro")));
                obj.setUsuario(leDao.listarPorId(rs.getInt("id_usuario")));
                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    
    public List<Leitura> listar() {
        List<Leitura> lista = new ArrayList<Leitura>();
        String sqlListar = "SELECT * FROM leitura ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            HidrometroDAO leiDao = new HidrometroDAO();
            UsuarioDAO leDao = new UsuarioDAO();
            
            while (rs.next()) {

                Leitura obj = new Leitura();

                obj.setDateMesReferencia(rs.getDate("mes_referencia"));
                obj.setLeituraMesAnterior(rs.getDouble("leitura_mes_anterior"));
                obj.setLeituraMesAtual(rs.getDouble("leitura_mes_atual"));          
                obj.setHidrometro(leiDao.listarPorId(rs.getInt("id_hidrometro")));
                obj.setUsuario(leDao.listarPorId(rs.getInt("id_usuario")));
                lista.add(obj);
                
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }


    
    public Leitura atualizar(Leitura obj) {
        try {
            String sqlAtualiza = "UPDATE leitura SET (mes_referencia=?,"
                    + "leitura_mes_anterior=?, leitura_mes_atual=?, id_hidrometro=?, id_usuario=?)  WHERE id_leitura = ?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setDate(1, (Date) obj.getMesReferencia());
            stmt.setDouble(2, obj.getLeituraMesAnterior());
            stmt.setDouble(3, obj.getLeituraMesAtual());
            stmt.setInt(4, obj.getHidrometro().getIdHidrometro());
            stmt.setInt(5, obj.getUsuario().getIdUsuario());
            stmt.executeUpdate();
            
            return listarPorId(obj.getIdLeitura());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public void deletar(Leitura obj) {
        String sqlDel = "DELETE FROM leitura WHERE id_leitura =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdLeitura());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }    
}
