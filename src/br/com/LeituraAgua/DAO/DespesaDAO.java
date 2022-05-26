/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Despesa;
import br.com.model.Distrito;
import br.com.model.Endereco;
import br.com.model.Poco;
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
public class DespesaDAO {
    
    private PreparedStatement stmt;

    public Despesa cadastrar(Despesa obj) {

        try {
            String sqlcadastra = "INSERT INTO despesa (mes_vigente, valor_fatura_energia, id_poco ) values (?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, (Date) obj.getMesVigente());
            stmt.setDouble(2, obj.getValorFaturaEnergia());
            stmt.setInt(3, obj.getPoco().getIdPoco());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return listarPorId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ocorreu um erro ao cadastrar o despesa!");
                }
            }

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }
    
    
        public List<Despesa> listar() {
        List<Despesa> lista = new ArrayList<Despesa>();
        String sqlListar = "SELECT * FROM despesa ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            PocoDAO poDao = new PocoDAO();

            while (rs.next()) {

                Despesa obj = new Despesa();
                obj.setIdDespesa(rs.getInt("id_despesa"));
                obj.setMesVigente(rs.getDate("mes_vigente"));
                obj.setValorFaturaEnergia(rs.getDouble("valor_fatura_energia"));
                obj.setPoco(poDao.listarPorId(rs.getInt("id_poco")));


            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }
        
        
   
     public Despesa listarPorId(Integer id) {
        String sqlListar = "SELECT * FROM despesa WHERE id_despesa = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            PocoDAO pocDao = new PocoDAO();

            while (rs.next()) {

                Despesa obj = new Despesa();
                obj.setIdDespesa(rs.getInt("id_despesa"));
                obj.setMesVigente(rs.getDate("mes_vigente"));
                obj.setValorFaturaEnergia(rs.getInt("valor_fatura_energia"));
                obj.setPoco(pocDao.listarPorId(rs.getInt("id_poco")));

                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }   
    
    
    

    
    public Despesa atualizar(Despesa obj) {
        try {
            String sqlAtualiza = "UPDATE despesa SET (mes_vigente=?,"
                    + "valor_fatura_energia=?, id_poco=?)  WHERE id_despesa = ?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setDate(1, (Date) obj.getMesVigente());
            stmt.setInt(2, obj.getValorFaturaEnergia());
            stmt.setInt(2, obj.getPoco().getIdPoco());
             stmt.executeUpdate();
            
            return listarPorId(obj.getIdDespesa());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }
    
    public Boolean deletar(Despesa obj) {
        String sqlDel = "DELETE FROM despesa WHERE id_despesa =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdDespesa());
            int retornoDelet = stmt.executeUpdate();
            
            if(retornoDelet ==1) {
                return true;    
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
       
}
