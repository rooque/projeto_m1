/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Produto;
import util.CBD;
import static util.Consts.*;

/**
 *
 * @author rooque
 */
public class ProdutoDAO {

    public static boolean listar(ArrayList<Produto> lp) {
        
        Connection c = CBD.getConexao();

        try {
            PreparedStatement ps = c.prepareStatement(SELECT_ALL_PRODUTOS);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return false;
            }

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt(PRODUTO_ID));
                p.setNome(rs.getString(PRODUTO_NOME));
                p.setValor(rs.getDouble(PRODUTO_VALOR));
                lp.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }
    }
    
   public static void cadastrar (String nome, double valor) throws SQLException {
       Connection co = CBD.getConexao();
       
       try {
       co.setAutoCommit(false);
       PreparedStatement ps = co.prepareStatement(INSERT_PRODUTO);
       ps.setString(1, nome);
       ps.setDouble(2, valor);
       ps.execute();
       co.commit();
       } catch(SQLException ex){
       ex.printStackTrace();
       co.rollback();
       }
       
   }

}
