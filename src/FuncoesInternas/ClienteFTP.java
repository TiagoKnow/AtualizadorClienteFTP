package FuncoesInternas;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * @author Tiago
 */
public class ClienteFTP {
        String mensagem = "";
        
        String host                  = "127.0.0.1";
        int    porta                 = 21;
        String usuario               = "tiago";
        String senha                 = "adm2322";
        String diretorioSistemaLocal = "C:\\FC\\";                // Diretório   do sistema all-fc 11/05/2017 se for Cepim, verificar
        String diretorioSistemaFTP   = "/FTP/repositorio/allfc/"; // Repositório do sistema all-fc 11/05/2017
        String nomeArquivo           = "";                        // Repositório do sistema all-fc 11/05/2017
       
        String remoteFile1 = "";
       
        //File
        File downloadFile1 = new File("");
        OutputStream outputStream1;
       
        //Funções
        FTPClient ftp = new FTPClient();
public void atualizarSistema() {
    ftp = new FTPClient();
    try{
        ftp.connect(host, porta);
        ftp.login(usuario, senha);
        ftp.enterLocalPassiveMode();
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
       
        //nomeArquivo = "cbSetup.exe";
        //executar();
        testeListarPasta();
        
    }catch(IOException ex){
        System.out.println("Error: " + ex.getMessage());
        ex.printStackTrace();
    }finally{
        try {
            if(ftp.isConnected()){
                ftp.logout();
                ftp.disconnect();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
    private void executar() throws FileNotFoundException, IOException {
        try{
            remoteFile1 = diretorioSistemaFTP + nomeArquivo;
            downloadFile1 = new File(diretorioSistemaLocal + nomeArquivo);
            outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean sucesso = ftp.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
            if (sucesso){
                System.out.println("Arquivo: " + nomeArquivo + " de: " + diretorioSistemaFTP + " para: " + diretorioSistemaLocal + " Copiado com sucesso!");
            }
        }catch(Exception erro){
            mensagem = "Erro: " + erro;
            mostraMensagem();
        }
    }
    
    public void testeListarPasta() throws IOException{
        FTPFile[] files = ftp.listFiles(diretorioSistemaFTP);
        for( int i=0; i < files.length; i++ ){
            nomeArquivo = files[i].getName();
            executar();
            System.out.println(nomeArquivo);
        }
    }
    
    public void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
}