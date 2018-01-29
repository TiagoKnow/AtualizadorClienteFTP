package Main;

import DAO.fabricaConexaoSQLITE;
import java.sql.Connection;

/**
 *
 * @author Tiago
 */
public class Executavel {
    //Connection
    static Connection con;
    
    public static void main(String[] args) {
        //con = fabricaConexaoSQLITE.abrirConexao();
        Telas.Atualizador at = new Telas.Atualizador();
        at.setVisible(true);
    }
    
}
