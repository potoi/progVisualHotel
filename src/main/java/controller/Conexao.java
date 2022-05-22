package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    private static Connection conn = null;

    public static Connection getConexao() throws SQLException, Exception {
        if ((conn == null) || (conn.isClosed())) {
            conn = fabricaDeConexoes();
        }
        return conn;
    }

    public static Connection fabricaDeConexoes() throws SQLException, Exception {
        
        Class.forName("org.postgresql.Driver");
        Properties prop = new Properties();
        prop.put("user", "postgres");
        prop.put("password", "admin");
        prop.put("charset", "UTF-8");
        prop.put("lc_ctype", "ISO8859_1");

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Hotel", prop);

    }

    public static void fecharConexao() throws Exception, SQLException {
        conn.close();
    }
}
