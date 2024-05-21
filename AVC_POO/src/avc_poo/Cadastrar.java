package avc_poo;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

// Interface para salvamento do arquivo
interface Salvar {
   public void salvarDados();
   
   public void recuperarDados();
}

// Classe para salvar os produtos em um ArrayList produtos
public class Cadastrar implements Salvar{
    private ArrayList produtos;
    private String arquivo;
    
    public void salvarProduto(Produto item){
        this.produtos.add(item);
    }
    
    public void salvarDados(){
       try{
           FileWriter dt_loja = new FileWriter("bd_loja");
       } catch (IOException e){
           System.out.println("");
       }
   }
    
    public void recuperarDados(){
       try{
           File dt_loja = new File("bd_loja");
           Scanner reader = new Scanner(dt_loja);

           while (reader.hasNextLine()){
               String row = reader.nextLine();
           }

       } catch (FileNotFoundException e) {
           System.out.println("");
       }
    }
}
