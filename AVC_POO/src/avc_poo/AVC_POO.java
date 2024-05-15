package avc_poo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AVC_POO {

    /**
     * @param args the command line arguments
     */
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
                
                String opcao = input.next();
                        
                System.out.println();
                switch (opcao.toUpperCase()){
                    case "1":
                        System.out.println("Digite o preco: ");
                        System.out.print("> ");               
                        double preco = input.nextDouble();                      
                        
                        System.out.println("Digite o nome do produto: ");
                        System.out.print("> ");              
                        String nome = input.nextLine();
                        

                        produtos.add(new Salvar(nome, preco));
                        break;

                    case "2":
                        System.out.println("Excluindo produto ...");
                        break;
                        
                    case "3":
                        System.out.println("Calcular venda do produto ...");
                        break;
                        
                    case "4":
                        try{
                            System.out.println("Dar desconto no produto ... ");
                            System.out.println("Escolha um produto pelo seu id: ");
                            int id = input.nextInt();

                            System.out.println();

                            System.out.println("Digite um desconto para o produto: ");
                            int desconto = input.nextInt();

                            produto = produtos.get(id);

                            produto.setDesconto(desconto);

                            System.out.println("Desconto de: " + desconto + "% feito para o produto de id: " + id);

                            
                            
                        } catch (InputMismatchException e){
                            System.out.println("Digite um id valido");
                        }
                        
                        break;
                        
                    case "5":
                        System.out.println(" ------ Produtos da loja ------ ");
                        
                        if(!produtos.isEmpty()){
                            
                            for(int i = 0; i < produtos.size(); i++){
                                produto = produtos.get(i);

        //                            System.out.println("| ID |\t Nome do Produto \t|\t Preco \t|");
                                System.out.print("| " + i + " |");
                                produto.info_produto();
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
