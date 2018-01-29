package Telas;

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
 * @author Tiago 11/05/2017 11:56 - 15/01/2018 11:29
 */
public class Atualizador extends javax.swing.JFrame {
    String mensagem = "";
        
    String host                  = "sua url";
    int    porta                 = 21;
    String usuario               = "seu user";
    String senha                 = "sua senha";
    
    //JAR                                   Relatorios//
    String diretorioSistemaLocalJAR    = "C:\\Nsys\\";                 // Diretório   do sistema nsys 11/05/2017, verificar
    String diretorioSistemaFTPJAR      = "/FTP/sistemas/nsys/JAR/";    // Repositório do sistema nsys 11/05/2017
    
    //LIB
    String diretorioSistemaLocalLIB    = "lib\\";                  // Diretório   do sistema nsys 11/05/2017, verificar
    String diretorioSistemaFTPLIB      = "/FTP/sistemas/nsys/LIB/";    // Repositório do sistema nsys 11/05/2017
    
    //JASPER
    String diretorioSistemaLocalJARPER = "Relatorios\\";             // Diretório do sistema nsys 11/05/2017, verificar
    String diretorioSistemaFTPJASPER   = "/FTP/sistemas/nsys/JASPER/"; // Repositório do sistema nsys 11/05/2017
    
    String nomeArquivo           = "";                        
   
    String remoteFile1 = "";
    
    String rodape      = "";
    
    String finalV = "";
   
    //File
    File downloadFile1 = new File("");
    OutputStream outputStream1;
   
    //Funções
    FTPClient ftp = new FTPClient();
    
    public Atualizador() {
        initComponents();
        rodape = "Servidor: " + host + " | Porta: " + porta + " | Usuário: " + usuario + " | Dir sistema: " + diretorioSistemaLocalJAR + " | Repositório: " + diretorioSistemaFTPJAR;
        txt_rodape.setText(rodape);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tamanhoTotalArquivos = new javax.swing.JTextField();
        txt_arquivoAtual = new javax.swing.JTextField();
        txt_resumoProcesso = new javax.swing.JTextField();
        txt_rodape = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_processo = new javax.swing.JTextArea();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizador do sistema - NS3 Informática");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/update.png"))); // NOI18N

        jLabel2.setText("Tamanho dos arquivos: ");

        jLabel3.setText("Arquivo atual: ");

        jLabel4.setText("Resumo do processo: ");

        txt_tamanhoTotalArquivos.setEditable(false);

        txt_arquivoAtual.setEditable(false);

        txt_resumoProcesso.setEditable(false);

        txt_rodape.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_rodape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_rodapeMouseClicked(evt);
            }
        });

        jLabel5.setText("KiB");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ok.png"))); // NOI18N
        jButton1.setText("Processar novamente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_processo.setEditable(false);
        txt_processo.setColumns(20);
        txt_processo.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        txt_processo.setLineWrap(true);
        txt_processo.setRows(5);
        txt_processo.setWrapStyleWord(true);
        txt_processo.setEnabled(false);
        jScrollPane1.setViewportView(txt_processo);

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/png/52.png"))); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rodape, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_tamanhoTotalArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txt_arquivoAtual, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_resumoProcesso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txt_tamanhoTotalArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_arquivoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txt_resumoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(){
            public void run(){
                atualizar();
            }
        }.start();
    }//GEN-LAST:event_formWindowOpened

    private void txt_rodapeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_rodapeMouseClicked
        if(evt.getClickCount() == 2){
//            Telas.Configuracoes conf = new Telas.Configuracoes();
//            conf.setVisible(true);
        }
    }//GEN-LAST:event_txt_rodapeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(){
            public void run(){
                atualizar();
            }
        }.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void atualizar() {
        ftp = new FTPClient();
        try{
            ftp.connect(host, porta);
            ftp.login(usuario, senha);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            atualizaJAR();
            atualizaJASPER();
            atualizaLIB();

        }catch(IOException ex){
            mensagem = "Erro ao conectar com o servidor, favor entrar em contato com o suporte";
            mostraMensagem();
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
    
    public void atualizaJAR() throws IOException{
        FTPFile[] files = ftp.listFiles(diretorioSistemaFTPJAR);
        
        barra.setMaximum(files.length);
        
        long tamanho      = 0;
        long tamanhoTotal = 0;
        
        int i2 = 0;
        
        for( int i=0; i < files.length; i++ ){
            nomeArquivo  = files[i].getName();
            tamanho      = files[i].getSize();
            
            tamanhoTotal = (tamanhoTotal + tamanho);
            txt_tamanhoTotalArquivos.setText(String.valueOf(tamanhoTotal));
            
            txt_arquivoAtual.setText(nomeArquivo);
            
            i2 = i;
            
            txt_resumoProcesso.setText("Reg: " + (i2 + 1) + " de: " + files.length);
            
            carregaBarra(i2, files.length);
            
            executarJAR();
            
            //System.out.println(nomeArquivo);
        }
    }
    
    public void atualizaJASPER() throws IOException{
        FTPFile[] files = ftp.listFiles(diretorioSistemaFTPJASPER);
        
        barra.setMaximum(files.length);
        
        long tamanho      = 0;
        long tamanhoTotal = 0;
        
        int i2 = 0;
        
        for( int i=0; i < files.length; i++ ){
            nomeArquivo  = files[i].getName();
            tamanho      = files[i].getSize();
            
            tamanhoTotal = (tamanhoTotal + tamanho);
            txt_tamanhoTotalArquivos.setText(String.valueOf(tamanhoTotal));
            
            txt_arquivoAtual.setText(nomeArquivo);
            
            i2 = i;
            
            txt_resumoProcesso.setText("Reg: " + (i2 + 1) + " de: " + files.length);
            
            carregaBarra(i2, files.length);
            
            executarJASPER();
            
            //System.out.println(nomeArquivo);
        }
    }
    
    public void atualizaLIB() throws IOException{
        FTPFile[] files = ftp.listFiles(diretorioSistemaFTPLIB);
        
        barra.setMaximum(files.length);
        
        finalV = "ultimo";
        
        long tamanho      = 0;
        long tamanhoTotal = 0;
        
        int i2 = 0;
        
        for( int i=0; i < files.length; i++ ){
            nomeArquivo  = files[i].getName();
            tamanho      = files[i].getSize();
            
            tamanhoTotal = (tamanhoTotal + tamanho);
            txt_tamanhoTotalArquivos.setText(String.valueOf(tamanhoTotal));
            
            txt_arquivoAtual.setText(nomeArquivo);
            
            i2 = i;
            
            txt_resumoProcesso.setText("Reg: " + (i2 + 1) + " de: " + files.length);
            
            carregaBarra(i2, files.length);
            
            executarLIB();
            
            //System.out.println(nomeArquivo);
        }
    }
    
    private void executarJAR() throws FileNotFoundException, IOException {
        try{
            remoteFile1 = diretorioSistemaFTPJAR + nomeArquivo;
            downloadFile1 = new File(diretorioSistemaLocalJAR + nomeArquivo);
            outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean sucesso = ftp.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
            if (sucesso){
                txt_processo.setText("Arquivo: " + nomeArquivo + " de: " + diretorioSistemaFTPJAR + " para: " + diretorioSistemaLocalJAR + " Copiado com sucesso!");
                System.out.println("Arquivo: " + nomeArquivo + " de: " + diretorioSistemaFTPJAR + " para: " + diretorioSistemaLocalJAR + " Copiado com sucesso!");
            }
        }catch(Exception erro){
            //mensagem = "Erro: " + erro;
            //mostraMensagem();
        }
    }
    
    private void executarJASPER() throws FileNotFoundException, IOException {
        try{
            remoteFile1 = diretorioSistemaFTPJASPER + nomeArquivo;
            downloadFile1 = new File(diretorioSistemaLocalJARPER + nomeArquivo);
            outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean sucesso = ftp.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
            if (sucesso){
                txt_processo.setText("Arquivo: " + nomeArquivo + " de: " + diretorioSistemaFTPJASPER + " para: " + diretorioSistemaLocalJARPER + " Copiado com sucesso!");
                System.out.println("Arquivo: " + nomeArquivo + " de: " + diretorioSistemaFTPJASPER + " para: " + diretorioSistemaLocalJARPER + " Copiado com sucesso!");
            }
        }catch(Exception erro){
            //mensagem = "Erro: " + erro;
            //mostraMensagem();
        }
    }
    
    private void executarLIB() throws FileNotFoundException, IOException {
        try{
            remoteFile1 = diretorioSistemaFTPLIB + nomeArquivo;
            downloadFile1 = new File(diretorioSistemaLocalLIB + nomeArquivo);
            outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean sucesso = ftp.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
            if (sucesso){
                txt_processo.setText("Arquivo: " + nomeArquivo + " de: " + diretorioSistemaFTPLIB + " para: " + diretorioSistemaLocalLIB + " Copiado com sucesso!");
                System.out.println("Arquivo: " + nomeArquivo + " de: " + diretorioSistemaFTPLIB + " para: " + diretorioSistemaLocalLIB + " Copiado com sucesso!");
            }
        }catch(Exception erro){
            //mensagem = "Erro: " + erro;
            //mostraMensagem();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_arquivoAtual;
    private javax.swing.JTextArea txt_processo;
    private javax.swing.JTextField txt_resumoProcesso;
    private javax.swing.JLabel txt_rodape;
    private javax.swing.JTextField txt_tamanhoTotalArquivos;
    // End of variables declaration//GEN-END:variables
    private void carregaBarra(int i2, int f) {
        int t = 0;
        
        t = i2 + 1;
        barra.setValue(t);
        barra.repaint();
        
        if(t == f && finalV.equals("ultimo")){
            mensagem = "Sistema atualizado com sucesso!";
            mostraMensagem();
            mensagem = "Para abrir o sistema novamente clique em ok";
            mostraMensagem();
            abrePFC();
        }
    }
    
    private void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private void abrePFC() {
        try {
            java.awt.Desktop.getDesktop().open( new File( "Nsys.jar" ) );
            dispose();
        } catch (IOException ex) {
            mensagem = "Erro: " + ex;
            mostraMensagem();
        }
    }
}
