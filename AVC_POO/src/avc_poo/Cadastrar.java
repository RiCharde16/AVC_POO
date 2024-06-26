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

    public static void modificarProduto(ArrayList<Produto> produtos){
        Produto produto = null;

        try{
            System.out.println("------ Modificar produto ------");
            System.out.println("Escolha um produto pelo seu id: ");
            System.out.print("> ");

            int id = input.nextInt();
            int i;
            for(i = 0; i < produtos.size(); i++){
                if(produtos.get(i).getCodProduto() == id){
                    // produto = produtos.remove(i);      
                    produto = produtos.get(i);
                    break;
                }
            }
            
            // System.out.print("Index do produto de Id: "+ id + " é " + i);

            if(produto == null){
                throw new IndexOutOfBoundsException();
            }
            
            input.nextLine();

            System.out.println("Caso nao deseje alterar o campo digite 0");              

            System.out.println("Edite o nome do produto: ");
            System.out.print("> ");              
            String nome = input.nextLine();
            
            System.out.println("Edite o preco do produto: ");
            System.out.print("> ");              
            double preco = input.nextDouble();

            if(preco < 0){
                throw new InputMismatchException();
            }
            
            System.out.println("Edite a quantidade do produto: ");
            System.out.print("> ");              
            int qtde = input.nextInt();

            if(qtde < 0){
                throw new InputMismatchException();
            }

            if(!nome.equals("0")){
                produto.setNome(nome);
            }
            if(preco != 0){
                produto.setPreco(preco);
            }
            if(qtde != 0){
                produto.setQuantidade(qtde);
            }
            System.out.println("\nProduto alterado com sucesso!");
            
        } catch (InputMismatchException e){
            System.out.println("\nValor invalido!");

            input.nextLine();

        } catch (IndexOutOfBoundsException e){
            System.out.println("\nId não encontrado!");

            input.nextLine();

        }
        
    }

    public static void excluirProduto(ArrayList<Produto> produtos){
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


        } catch (IndexOutOfBoundsException e){
            System.out.println("\nId não encontrado!");

            input.nextLine();

        }

    }

    public static void salvarProduto(ArrayList<Produto> produtos){
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
        
            int ultimo_cod = produtos.get(produtos.size()-1).getCodProduto()+1;

            produtos.add(new Produto(ultimo_cod,nome.trim(), preco, qtde));
            System.out.println("\n Produto Cadastrado com Sucesso!!");  

        } catch (Exception e){
            System.out.println("\n Produto Nao Cadastrado !!");

            input.nextLine();
            
        }
    }
    
    public void salvarDados(ArrayList<Produto> produtos){
        try{
            FileWriter banco_dados = new FileWriter(arquivo);
            for(Produto produto : produtos){
                banco_dados.write(produto.dados()+"\n");
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
