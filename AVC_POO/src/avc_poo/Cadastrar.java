package avc_poo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

// Interface para salvamento do arquivo
interface Salvar {
   public void salvarDados(ArrayList<Produto> produtos);
   
   public ArrayList<Produto> recuperarDados();
}

// Classe para salvar os produtos em um ArrayList produtos
public class Cadastrar implements Salvar{
    private String arquivo;
    private static Scanner input = new Scanner(System.in);

    public Cadastrar(String arquivo){
        this.arquivo = arquivo;
    }

    public static boolean modificarProduto(ArrayList<Produto> produtos){
        Produto produto = null;

        try{
            System.out.println("------ Modificar produto ------");
            System.out.println("Escolha um produto pelo seu id: ");
            System.out.print("> ");

            int id = input.nextInt();
            for(int i = 0; i < produtos.size(); i++){
                if(produtos.get(i).getCodProduto() == id){
                    // produto = produtos.remove(i);      
                    produto = produtos.get(i);
                    break;
                }
            }

            if(produto == null){
                throw new IndexOutOfBoundsException();
            }
            
            
        } catch (InputMismatchException e){
            System.out.println("\nValor invalido!");

            input.nextLine();

            return false;

        } catch (IndexOutOfBoundsException e){
            System.out.println("\nId não encontrado!");

            input.nextLine();

            return false;
        }

        return true;
        
    }

    public static boolean excluirProduto(ArrayList<Produto> produtos){
        Produto produto = null;

        try{
            System.out.println("------ Excluir Produto ------");
            System.out.println("Escolha um produto pelo seu id: ");
            System.out.print("> ");

            int id = input.nextInt();
            for(int i = 0; i < produtos.size(); i++){
                if(produtos.get(i).getCodProduto() == id){
                    produto = produtos.remove(i);           
                    break;
                }
            }

            if(produto == null){
                throw new IndexOutOfBoundsException();
            }
            
            System.out.println("\nProduto de Id: " + id +" removido com sucesso!!");
            
        } catch (InputMismatchException e){
            System.out.println("\nValor invalido!");

            input.nextLine();

            return false;

        } catch (IndexOutOfBoundsException e){
            System.out.println("\nId não encontrado!");

            input.nextLine();

            return false;
        }

        return true;
    }

    public static boolean salvarProduto(ArrayList<Produto> produtos){
        try{

            System.out.println("Digite o nome do produto: ");
            System.out.print("> ");              
            String nome = input.nextLine();

            System.out.println();

            System.out.println("Digite o preco: ");
            System.out.print("> ");               
            double preco = input.nextDouble(); 

            if(preco <= 0){
                throw new Exception();
            }

            System.out.println("Digite a quantidade: ");
            System.out.print("> ");

            int qtde = input.nextInt();

            if(qtde <= 0){
                throw new Exception();
            }
            input.nextLine();

            produtos.add(new Produto(produtos.size()+1 ,nome.trim(), preco, qtde));
            System.out.println("\n Produto Cadastrado com Sucesso!! \n");  

            return true;
        } catch (Exception e){
            System.out.println("\n Produto Nao Cadastrado !! \n");

            input.nextLine();
            
            return false;
        }
    }
    
    public void salvarDados(ArrayList<Produto> produtos){
        try{
            FileWriter banco_dados = new FileWriter(arquivo);
            for(Produto produto : produtos){
                banco_dados.write(produto.data()+"\n");
            }
            banco_dados.close();
        } catch (IOException e){
            System.out.println("Não foi possivel salvar os dados");
        }
    }
    

    public ArrayList<Produto> recuperarDados(){
        ArrayList<String[]> dados_estoque = new ArrayList<String[]>();
        ArrayList<Produto> produtos = new ArrayList<>();
        try{
            File dados = new File(arquivo);
            Scanner reader = new Scanner(dados);

            while (reader.hasNextLine()){
                String row = reader.nextLine();
                dados_estoque.add(row.split(";"));
            }
            for(String[] dado : dados_estoque){
                int codProduto, qtde, desconto;
                double preco;

                // a função do metodo trim() e pegar cada valor dos dados em formato str (String)
                // e tirar os espaços antes e depois deles]
                codProduto = Integer.parseInt(dado[0].trim());
                preco = Double.parseDouble(dado[2].trim());
                qtde = Integer.parseInt(dado[3].trim());
                desconto = Integer.parseInt(dado[4].trim());

                Produto produto =  new Produto(codProduto, dado[1], preco, qtde);

                produto.setDesconto(desconto);

                produtos.add(produto);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo Não encontrado");
        }

        return produtos;
    }

}
