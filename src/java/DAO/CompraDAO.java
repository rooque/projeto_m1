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
import modelo.Compra;
import modelo.Produto;
import util.CBD;
import static util.Consts.*;

/**
 *
 * @author rooque
 */
public class CompraDAO {

    public static void cadastrar(Compra c) throws SQLException {

        Connection co = CBD.getConexao();

        try {
            co.setAutoCommit(false);
            PreparedStatement ps = co.prepareStatement(INSERT_COMPRA, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, c.getTotal());
            ps.executeUpdate();
            int key = 0;

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(COMPRA_ID);
            }

            for (Produto p : c.getProdutos()) {
                PreparedStatement ps2 = co.prepareStatement(INSERT_PART_COMPRA);
                ps2.setInt(1, key);
                ps2.setInt(2, p.getId());
                ps2.setInt(3, p.getQtd());
                ps2.execute();
            }

            co.commit();

        } catch (SQLException ex) {
            co.rollback();
            ex.printStackTrace();
        } finally {
            co.close();
        }

    }

    public static ArrayList<Compra> listar() throws SQLException {

        Connection co = CBD.getConexao();

        try {
            ArrayList<Compra> lc = new ArrayList<>();

            PreparedStatement ps = co.prepareStatement(SELECT_COMPRA);
            ResultSet rs = ps.executeQuery();

            ArrayList<Produto> lp = new ArrayList<>();
            ProdutoDAO.listar(lp);

            

            while (rs.next()) {
                Compra c = new Compra();
                c.setId(rs.getInt(COMPRA_ID));
                c.setTotal(rs.getDouble(COMPRA_VALOR));
                PreparedStatement ps2 = co.prepareStatement(SELECT_PART_COMPRA);
                ps2.setInt(1, c.getId());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<Produto> lpc = new ArrayList<>();
                while (rs2.next()) {
                    int id_produto = rs2.getInt(COMPRA_PART_ID_PRODUTO);
                    int qtd = rs2.getInt(COMPRA_PART_QTD);
                    for (Produto px : lp) {
                        if (id_produto == px.getId()) {
                            px.setQtd(qtd);
                            lpc.add(px);
                        }
                    }
                }
                c.setProdutos(lpc);
                lc.add(c);
            }
            return lc;
        } catch (SQLException ex) {            
            ex.printStackTrace();
            return null;
        } finally {
            co.close();
        }

    }
    
    public static void deletar (int id) throws SQLException{
        
        Connection co = CBD.getConexao();
        
        try {
            co.setAutoCommit(false);
            PreparedStatement ps2 = co.prepareStatement(DELETE_PART_COMPRA);
            ps2.setInt(1, id);
            ps2.execute();
            PreparedStatement ps = co.prepareStatement(DELETE_COMPRA);
            ps.setInt(1, id);
            ps.execute();
            co.commit();
        } catch (SQLException ex) {
            co.rollback();
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            co.close();
        }
        
        
       
    }

}
