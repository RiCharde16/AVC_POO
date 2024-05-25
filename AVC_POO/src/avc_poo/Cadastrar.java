package avc_poo;
import java.util.ArrayList;
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
        return true;
        // TODO: implementar o metodoo modoficar produto pegando o ArrayList com as classes produtos
        // e aplicando o metodo .set(index, novo_valor)
    }

    public static boolean excluirProduto(ArrayList<Produto> produtos){
        // TODO: implementar o metodoo modoficar produto pegando o ArrayList com as classes produtos
        // e aplicando o metodo .set(index, novo_valor)
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

            System.out.println("Digite a quantidade: ");
            System.out.print("> ");
            int qtde = input.nextInt();

            input.nextLine();

            produtos.add(new Produto(produtos.size()+1 ,nome, preco, qtde));
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
                // System.out.println();
            }
            for(String[] dado : dados_estoque){
                int codProduto, qtde, desconto;
                double preco;
                codProduto = Integer.parseInt(dado[0].trim());
                preco = Double.parseDouble(dado[2].trim());
                qtde = Integer.parseInt(dado[3].trim());
                desconto = Integer.parseInt(dado[4].trim());
                // double preco ;

                Produto produto =  new Produto(codProduto, dado[1], preco, qtde);

                produto.setDesconto(desconto);

                // System.out.println(produto[0] + produto[1] + produto[2] + produto[3] + produto[4]);
                produtos.add(produto);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo Não encontrado");
        }

        return produtos;
        // return produtos;
    }

}
