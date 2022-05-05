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
            String sqlcadastra = "INSERT INTO despesa (int id_despesa, String mes_vigente, int valor_fatura_energia, id_poco ) values (?,?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra);
            stmt.setInt(1, obj.getIdDespesa());
            stmt.setDate(2, (Date) obj.getMesVigente());
            stmt.setInt(3, obj.getValorFaturaEnergia());
            stmt.setInt(4, obj.getPoco().getIdPoco());
            ResultSet despesa = stmt.executeQuery();

            Poco pocoDespesa = new Poco();
            pocoDespesa.setIdpoco(despesa.getInt("id_poco"));

            Despesa novoDespesa = new Despesa(despesa.getInt("id_despesa"),
                    despesa.getDate("mes_vigente"),
                    despesa.getInt("valor_fatura_energia"),
                    pocoDespesa);

            return novoDespesa;
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
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                
                Poco pocoDespesa = new Poco();
                pocoDespesa.setIdPoco(result.getInt("id_poco"));
                Despesa obj = new Despesa();
                obj.setIdDespesa(result.getInt("id_despesa"));
                obj.setMesVigente(result.getDate("mes_vigente"));
                obj.setValorFaturaEnergia(result.getInt("valor_fatura_energia"));           
                obj.setPoco(pocoDespesa);
                lista.add(obj);
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
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
            ResultSet despesa = stmt.executeQuery();

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }
    
    public Despesa deletar(Despesa obj) {
        String sqlDel = "DELETE FROM detetive WHERE id_despesa =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdDespesa());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
       
}
