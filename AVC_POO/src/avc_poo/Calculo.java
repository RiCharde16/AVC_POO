package avc_poo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Calculo {
    protected int desconto;
    private static Scanner input = new Scanner(System.in);

    public void setDesconto(int desconto){
        this.desconto = desconto;
    }

    public int getDesconto(){
        return this.desconto;
    }

    public static void definirDesconto(ArrayList<Produto> produtos){
        try{

            Produto produto = null;

            System.out.println("------ Definir Descontos ------");
            System.out.println("Escolha um produto pelo seu id: ");
            System.out.print("> ");
            int id = input.nextInt();
            
            // produto = produtos.get(id);
            for(int i =0; i < produtos.size(); i++){
                if(produtos.get(i).getCodProduto() == id){
                    produto = produtos.get(i);
                }
            }

            if(produto == null){
                throw new IndexOutOfBoundsException();
            }
            System.out.println();

            System.out.println("Digite um desconto para o produto: ");
            System.out.print("> ");
            int desconto = input.nextInt();


            produto.setDesconto(desconto);
            
            System.out.println("\nDesconto de: " + desconto + "% feito para o produto de id: " + id);      
            
        } catch (InputMismatchException e){
            System.out.println("\nValor invalido!");

            input.nextLine();

        } catch (IndexOutOfBoundsException e){
            System.out.println("\nId não encontrado!");

            input.nextLine();
        }

    }

    public static void calcularVenda(ArrayList<Produto> produtos){
        ArrayList<Produto> produtos_vendidos = new ArrayList<>();
        int id; int id_old = 0;
        int p = 0; int desconto;
        double valor_venda = 0;
        Produto produto = null;

        try{
            System.out.println("------ Calcular venda de Produtos ------");

            System.out.println("Quantos produtos deseja vender:");
            System.out.print("> ");

            int numero_produtos = input.nextInt();

            while(p < numero_produtos){
                System.out.println();
                System.out.println("Digite o Id do "+ (p+1) +" produto: ");
                System.out.print("> ");
                id = input.nextInt();
                if(id_old == id){
                    System.out.println("\nId ja adicionado tente outro!");
                } else{
                    // ira armazenar o id do produto para que não se repita na venda
                    id_old= id;
                    int i;
                    
                    for(i = 0; i < produtos.size(); i++){
                        if(produtos.get(i).getCodProduto() == id){
                            produto = produtos.get(i); 
                            break;
                        }
                    }

                    if(produto == null){
                        throw new IndexOutOfBoundsException();
                    }

                    int qtde_old = produto.getQuantidade();
                    double preco_produto = produto.getPreco();

                    System.out.println("Digite a quantidade: ");
                    System.out.print("> ");
                    int qtde = input.nextInt();



                    if(qtde < 0){
                        throw new InputMismatchException();
                    } else{
                        if(qtde > qtde_old){
                            throw new InputMismatchException("\nQuantidade do produto ultrapasa o estoque!");
                        }  
                    }
                    produto.setQuantidade(qtde_old - qtde);
                    produtos_vendidos.add(produto);
                    desconto = produto.getDesconto();

                    if(desconto > 0){
                        double desc = desconto/ 100.00;
                        valor_venda += (preco_produto * desc) * qtde;
                    } else {
                        valor_venda += preco_produto * qtde;
                    }

                    if(produto.getQuantidade() == 0){
                        produtos.remove(i);
                    }

                    p++;
                }
            }
            
            System.out.println();

            System.out.println("Valor Total da venda: R$: " + String.format("%.2f", valor_venda));
            System.out.println("Quantidade de produtos diferentes vendidos: " + produtos_vendidos.size());

            System.out.println();

        } catch (InputMismatchException e){
            System.out.println("\nValor invalido!");

            input.nextLine();

        } catch (IndexOutOfBoundsException e){
            System.out.println("\nId não encontrado!");

            input.nextLine();
        }

        
    }   

}
