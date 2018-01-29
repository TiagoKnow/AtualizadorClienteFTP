package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Tiago
 */
public class fabricaConexaoSQLITE {
        
    public static Connection abrirConexao(){
        //Connection
        Connection con = null;
        
        //String
        String nomeBanco = "conf";
        
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + nomeBanco + ".db");
            System.out.println("Conexão SQLite: " + con);
        }catch(Exception erro){
            System.err.println( erro.getClass().getName() + ": " + erro.getMessage() );
            System.exit(0);
        }
        return con;
    }
}
