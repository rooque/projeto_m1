/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static util.Consts.*;
/**
 *
 * @author rooque
 */
public class CBD {
    
        public static Connection getConexao() {
        Connection conexao = null;
        try {

            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection("jdbc:postgresql://" + PSQL_IP + ":" + PSQL_PORT + "/" + PSQL_DB, PSQL_USER, PSQL_PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexao;
    }
    
}
