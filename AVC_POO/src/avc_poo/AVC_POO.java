package avc_poo;
import java.util.ArrayList;
import java.util.Scanner;

public class AVC_POO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Produto> produtos = new ArrayList<>();
        Cadastrar database = new Cadastrar("estoque.txt");
        
        // variavel para correr infinitamente o loop, até o usuario fechar o programa, ou sair
        boolean run = true;
    
        
        System.out.println("================== LOJA DE PRODUTOS ELETRONICOS ===========================");

        produtos = database.recuperarDados();

        while(run){
            System.out.println("--------- Menu principal ---------");
            System.out.println("Escolha uma opcao: ");
            System.out.println("  1 - Salvar Produto");
            System.out.println("  2 - Excluir Produto");
            System.out.println("  3 - Modificar Produto "); 
            System.out.println("  4 - Dar descontos percentuais nos produtos "); // DONE
            System.out.println("  5 - Calcular a venda"); 
            System.out.println("  6 - Mostrar produtos "); // DONE
            System.out.println("  S - Sair");
            System.out.print("> ");
            
            String opcao = input.nextLine();


            switch (opcao.toUpperCase()){
                case "1":
                        Cadastrar.salvarProduto(produtos);
                        database.salvarDados(produtos);
                        produtos = database.recuperarDados();
                    break;

                case "2":
                    if(!produtos.isEmpty()){
                        Cadastrar.excluirProduto(produtos);
                        database.salvarDados(produtos);
                        produtos = database.recuperarDados();

                    } else{
                        System.out.println("\nsem produtos cadastrados!");
                    }
                    break;
                    
                case "3":
                    //TODO: criar o metodo para modificar um produto
                    if(!produtos.isEmpty()){
                        Cadastrar.modificarProduto(produtos);
                        database.salvarDados(produtos);
                        produtos = database.recuperarDados();

                    } else{
                        System.out.println("\nsem produtos cadastrados!");
                    }
                    break;
                    
                case "4":
                    if (!produtos.isEmpty()){
                        // Altera o desconto do produto
                        Calculo.definirDesconto(produtos);

                        // Salva o desconto no arquivo estoque.txt
                        // e depois le os dados novamente do arquivo salvo para armazenar na variavel
                        database.salvarDados(produtos);
                        database.recuperarDados();

                    } else {

                        System.out.println(" Sem produtos cadastrados !");
                    }
                        
                    break;
                    
                case "5" :
                    if(!produtos.isEmpty()){
                        Calculo.calcularVenda(produtos);
                        database.salvarDados(produtos);
                        produtos = database.recuperarDados();

                    } else{
                        System.out.println("\nsem produtos cadastrados!");
                    }
                    break;

                case "6":
                    Estoque.exibirProdutos(produtos);
                    break;
                    
                case "S":
                    run = false;
                    break;
                default:
                    System.out.println(" !Opcao invalida! ");
                    break;
                
            }      
            System.out.println();

            
        }
    }
    
}
