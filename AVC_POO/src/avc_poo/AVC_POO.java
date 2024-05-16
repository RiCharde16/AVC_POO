package avc_poo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AVC_POO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Salvar> produtos = new ArrayList<>();
        Salvar produto;
        
        boolean run = true;
        
        System.out.println("LOJA DE ELETRONICOS");
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
                    try{

                        System.out.println("Digite o nome do produto: ");
                        System.out.print("> ");              
                        String nome = input.nextLine();

                        System.out.println();

                        System.out.println("Digite o preco: ");
                        System.out.print("> ");               
                        double preco = input.nextDouble(); 

                        produtos.add(new Salvar(nome, preco));
                        System.out.println("\n Produto Cadastrado com Sucesso!! \n");

                    } catch (Exception e){
                        System.out.println("\n Produto Nao Cadastrado !! \n");
                    }

                    input.nextLine();
                    break;

                    case "2":
                        System.out.println("Excluindo produto ...");
                        break;
                        
                    case "3":
                        System.out.println("Calcular venda do produto ...");
                        break;
                        
                    case "4":
                        try{
                            if (!produtos.isEmpty()){
                                System.out.println("------ Definir Descontos ------");
                                System.out.println("Escolha um produto pelo seu id: ");
                                int id = input.nextInt();
    
                                produto = produtos.get(id);

                                System.out.println();
    
                                System.out.println("Digite um desconto para o produto: ");
                                int desconto = input.nextInt();
                                input.nextLine();
    
                                produto.setDesconto(desconto);
                                
                                System.out.println("\nDesconto de: " + desconto + "% feito para o produto de id: " + id);
                            } else {
                                System.out.println(" Sem produtos cadastrados !");
                            }
               
                        } catch (InputMismatchException e){
                            input.nextLine();
                            System.out.println("\nDigite um id valido!");
                        } catch (IndexOutOfBoundsException e){
                            input.nextLine();
                            System.out.println("\nId não encontrado!");
                        }
                        
                        break;
                        
                    case "5":
                        System.out.println(" ------ Produtos da loja ------ ");
                        
                        if(!produtos.isEmpty()){
                            
                            for(int i = 0; i < produtos.size(); i++){
                                produto = produtos.get(i);

                                   System.out.println("| ID |   Nome do Produto  |   Preco   |  Desconto  |");
                                System.out.print("|  " + i + " | " + produto.info_produto().replace(", ", " | "));
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
