package DAO;

import Beans.BeanConexoes;
import java.sql.*;
import java.util.*;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 @author Tiago
 */
public class operacoesDaoSQLITE {
    //Connection
    Connection conLite;
    
    //String
    String sql      = "";
    String mensagem = "";
    
    //Outros
    Statement stmt;
    ResultSet rs;
    
    //Vetores
    ArrayList dados = new ArrayList();
    
    //Beans
    BeanConexoes bc = new BeanConexoes();
    
    public operacoesDaoSQLITE(Connection con1){
        conLite = con1;
    }
        
    public String incluir (String sql1){
        sql = sql1;
        try{
            stmt = conLite.createStatement();
            stmt.executeUpdate(sql);
            
            stmt.close();
            conLite.close();
            
            return "OK";
        }catch(SQLException Erro){
            return "" + Erro;
        }
    }
    
    public String alterar(String sql1){
        sql = sql1;
        try{
            stmt = conLite.createStatement();
            stmt.execute(sql);

            stmt.close();
            conLite.close();
            return "OK";
        }catch(SQLException Erro){
            mensagem = "Erro: " + Erro;
            mostraMensagem();
            return "Erro: " + Erro;
        }
    }
        
    public ArrayList consultaConexoes(String sql1){
        sql = sql1;
        dados = new ArrayList();
        try{
            stmt = conLite.createStatement();
            rs   = stmt.executeQuery(sql);

            while(rs.next()){ //While pois pega o ultimo parametro vádilo registrado no bd, o if traz o primeiro e assim por diante 
                bc = new BeanConexoes();
                bc.codigo        = rs.getInt("codigo"); 
                bc.host          = rs.getString ("host"); 
                bc.porta         = rs.getInt ("porta"); 
                bc.usuario       = rs.getString ("usuario"); 
                bc.senha         = rs.getString ("senha"); 
                bc.dataCadastro  = rs.getString ("dataCadastro"); 
                bc.conexaoAtual  = rs.getInt ("conexaoAtual"); 
                
                dados.add(bc);
            }
            rs.close();
            stmt.close();
            conLite.close();
            return dados;
        }catch(SQLException erro){
            mensagem = "Erro: " + erro;
            mostraMensagem();
            return dados;
        }
    }
    
    public ArrayList consultaComboHost(){
        sql = "select host from tb_conexoes order by codigo desc";
        dados = new ArrayList();
        try{
            stmt = conLite.createStatement();
            rs   = stmt.executeQuery(sql);

            while(rs.next()){ //While pois pega o ultimo parametro vádilo registrado no bd, o if traz o primeiro e assim por diante 
                String host = "";
                host = rs.getString("host"); 
                
                dados.add(host);
            }
            rs.close();
            stmt.close();
            conLite.close();
            return dados;
        }catch(SQLException erro){
            mensagem = "Erro: " + erro;
            mostraMensagem();
            return dados;
        }
    }
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
}