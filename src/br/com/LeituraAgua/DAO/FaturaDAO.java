/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Fatura;
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
public class FaturaDAO {
        public Fatura gerar(Fatura obj) {

        try {
            String sqlcadastra = "INSERT INTO fatura ( taxa_administrativa,  valor_metro_cubico, valor_fatura, mes_referencia, data_vencimento, situação, leitura ) values (?,?,?,?,?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            PreparedStatement stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);           
            stmt.setInt(1, obj.getTaxaAdministrativa());
            stmt.setInt(2, obj.getValorMetroCubico());
            stmt.setInt(3, obj.getValorFatura());
            stmt.setDate(4, (Date) obj.getMesReferencia());
            stmt.setDate(5, (Date) obj.getDataVencimento());
            stmt.setBoolean(6, obj.isSituacao());
            stmt.setInt(7, obj.getLeitura().getIdLeitura());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return listarPorId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ocorreu um erro ao gerar fatura!");
                }
            }

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }
        
        
    public Fatura listarPorId(Integer id) {
        String sqlListar = "SELECT * FROM leitura WHERE id = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            PreparedStatement stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            LeituraDAO leitDao = new LeituraDAO();

            while (rs.next()) {

                Fatura obj = new Fatura();
                obj.setIdFatura(rs.getInt("id_fatura"));
                obj.setTaxaAdministrativa(rs.getInt("taxa_administrativa"));
                obj.setValorMetroCubico(rs.getInt("valor_metro_cubico"));
                obj.setValorFatura(rs.getInt("valor_fatura"));
                obj.setMesReferencia(rs.getDate("mes_referencia"));
                obj.setDataVencimento(rs.getDate("data_vencimento"));
                obj.setSituacao(rs.getBoolean("situacao"));                
                obj.setLeitura(leitDao.listarPorId(rs.getInt("id_leitura")));

                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
        public List<Fatura> listar() {
        List<Fatura> lista = new ArrayList<Fatura>();
        String sqlListar = "SELECT * FROM fatura ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            PreparedStatement stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            LeituraDAO leitDao = new LeituraDAO();

            while (rs.next()) {

                Fatura obj = new Fatura();
                obj.setIdFatura(rs.getInt("id_fatura"));
                obj.setTaxaAdministrativa(rs.getInt("taxa_administrativa"));
                obj.setValorMetroCubico(rs.getInt("valor_metro_cubico"));
                obj.setValorFatura(rs.getInt("valor_fatura"));
                obj.setMesReferencia(rs.getDate("mes_referencia"));
                obj.setDataVencimento(rs.getDate("data_vencimento"));
                obj.setSituacao(rs.getBoolean("situacao"));                
                obj.setLeitura(leitDao.listarPorId(rs.getInt("id_leitura")));
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }
       
        
        
    public Fatura atualizar(Fatura obj, PreparedStatement stmt) {
        try {
            String sqlAtualiza = "UPDATE fatura SET (taxa_administrativa=?,"
                    + "valor_metro_cubico=?,valor_fatura=?, mes_referencia=?, data_vencimento=?, situacao=?, id_leitura=?)  WHERE id_fatura = ?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setInt(1, obj.getTaxaAdministrativa());
            stmt.setInt(2, obj.getValorMetroCubico());
            stmt.setInt(3, obj.getValorFatura());
            stmt.setDate(4, (Date) obj.getMesReferencia());
            stmt.setDate(5, (Date) obj.getDataVencimento());
            stmt.setBoolean(6, obj.isSituacao());
            stmt.setInt(7, obj.getLeitura().getIdLeitura());
            stmt.executeUpdate();
            
            return listarPorId(obj.getIdFatura());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }  
    
    
    public Boolean deletar(Fatura obj, PreparedStatement stmt) {
        String sqlDel = "DELETE FROM fatura WHERE id_fatura =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdFatura());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;

    }        
}



