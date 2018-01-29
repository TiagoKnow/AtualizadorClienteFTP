package FuncoesInternas;

import javax.swing.JOptionPane;

/**
 * @author Tiago e Leo
 */
public class ConverterStringEmInt {
    
    //String
    String entrada   = "";
    String var_saida = "";
    
    //Int
    int saida = 0;
    
      /**
      * Ajusta a data para determinada finalidade, como a seguir:<br>
      * o tipo 1 converte do padrão sql para o padrão que utilizamos;<br>
      * o tipo 2 converte do padrão que utilizamos para o padrão sql.<br>
      * o tipo 3 converte do padrao que utilizamos para o padrão que o access utiliza
      * @author            Leonardo Loures
      */
    public int Converter(String entrada1){
        entrada = entrada1;
        saida   = 0;
        int tamanhoString = entrada1.length();
        
         if(tamanhoString == 0){
             return 0;
         }else{
                if(tamanhoString > 6){
                    JOptionPane.showMessageDialog(null, "Esta função permite que a String tenha no máximo 6 posições!");
                    return 0;
                }else{
        
                int converter = 0;
                //Var das posições
                String var1 = "";
                String var2 = "";
                String var3 = "";
                String var4 = "";
                String var5 = "";
                String var6 = "";

                    if(tamanhoString == 1){
                        var1 = entrada.substring(0, 1);
                    }
                    if(tamanhoString == 2){
                        var1 = entrada.substring(0, 1);
                        var2 = entrada.substring(1, 2);
                    }
                    if(tamanhoString == 3){
                        var1 = entrada.substring(0, 1);
                        var2 = entrada.substring(1, 2);
                        var3 = entrada.substring(2, 3);
                    }
                    if(tamanhoString == 4){
                        var1 = entrada.substring(0, 1);
                        var2 = entrada.substring(1, 2);
                        var3 = entrada.substring(2, 3);
                        var4 = entrada.substring(3, 4);
                    }
                    if(tamanhoString == 5){
                        var1 = entrada.substring(0, 1);
                        var2 = entrada.substring(1, 2);
                        var3 = entrada.substring(2, 3);
                        var4 = entrada.substring(3, 4);
                        var5 = entrada.substring(4, 5);
                    }
                    if(tamanhoString == 6){
                        var1 = entrada.substring(0, 1);
                        var2 = entrada.substring(1, 2);
                        var3 = entrada.substring(2, 3);
                        var4 = entrada.substring(3, 4);
                        var5 = entrada.substring(4, 5);
                        var6 = entrada.substring(5, 6);
                    }

                    try{
                        converter = Integer.parseInt(var1);
                        var_saida = var_saida + ""+converter;
                    }catch(NumberFormatException e){
                        System.out.println("Exept: " + e);
                    }
                    try{
                        converter = Integer.parseInt(var2);
                        var_saida = var_saida + ""+converter;
                    }catch(NumberFormatException e){
                        System.out.println("Exept: " + e);
                    }
                    try{
                        converter = Integer.parseInt(var3);
                        var_saida = var_saida + ""+converter;
                    }catch(NumberFormatException e){
                        System.out.println("Exept: " + e);
                    }
                    try{
                        converter = Integer.parseInt(var4);
                        var_saida = var_saida + ""+converter;
                    }catch(NumberFormatException e){
                        System.out.println("Exept: " + e);
                    }              
                    try{
                        converter = Integer.parseInt(var5);
                        var_saida = var_saida + ""+converter;
                    }catch(NumberFormatException e){
                        System.out.println("Exept: " + e);
                    }      
                    try{
                        converter = Integer.parseInt(var6);
                        var_saida = var_saida + ""+converter;
                    }catch(NumberFormatException e){
                        System.out.println("Exept: " + e);
                    }          

                    if(var_saida.equals("")){
                        var_saida = "0";
                    }
                    
                    saida = Integer.parseInt(var_saida);
                    
                    var_saida = "";

                    return saida;
            }    
         }//fecha o else se o tamanhao da string é maior que 0
       
        
    }//fecha o if da função converter
}//fecha o if da classe
