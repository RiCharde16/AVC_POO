package avc_poo;
import java.util.ArrayList;
import java.util.Scanner;

public class AVC_POO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Produto> produtos = new ArrayList<>();
        Produto produto = null;
        Cadastrar database = new Cadastrar("estoque.txt");
        
        boolean run = true;
        
        
        System.out.println("LOJA DE ELETRONICOS");

        produtos = database.recuperarDados();

        while(run){
            System.out.println("--------- Menu principal ---------");
            System.out.println("Escolha uma opcao: ");
            System.out.println("  1 - Salvar Produto");
            System.out.println("  2 - Excluir Produto");
            System.out.println("  3 - Calcular a venda");
            System.out.println("  4 - Dar descontos percentuais nos produtos ");
            System.out.println("  5 - Mostrar produtos ");
            System.out.println("  S - Sair");
            System.out.print("> ");
            
            String opcao = input.nextLine();

            switch (opcao.toUpperCase()){
                case "1":        
                    // Cadastrar.salvarProduto(produtos);
                    if(Cadastrar.salvarProduto(produtos)){
                        database.salvarDados(produtos);
                        produtos = database.recuperarDados();
                    }
                    break;

                case "2":
                    System.out.println("Excluindo produto ...");
                    break;
                    
                case "3":
                    System.out.println("Calcular venda do produto ...");
                    break;
                    
                case "4":
                    if (!produtos.isEmpty()){
                        Calculo.definirDesconto(produtos);
                    } else {

                        System.out.println(" Sem produtos cadastrados !");
                    }
                        
                    break;
                    
                case "5":
                    System.out.println(" ------ Produtos da loja ------ ");
                    
                    if(!produtos.isEmpty()){
                        
                        System.out.println("| ID |   Nome do Produto  |   Preco   |  Quantidade  |  Desconto  |");
                        for(int i = 0; i < produtos.size(); i++){
                            produto = produtos.get(i);
                            System.out.print("|  " + produto.data().replace("; ", " | "));
                            System.out.println();
                        }
                    } else {
                        System.out.println("Sem produtos cadastrados !");
                    }
                    
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
