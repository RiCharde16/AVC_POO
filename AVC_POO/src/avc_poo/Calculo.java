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

    public static void definirDesconto(ArrayList<Produto> produtos){
        try{
            Produto produto = null;

            System.out.println("------ Definir Descontos ------");
            System.out.println("Escolha um produto pelo seu id: ");
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

            input.nextLine();

            produto.setDesconto(desconto);
            
            System.out.println("\nDesconto de: " + desconto + "% feito para o produto de id: " + id);
            
            
        } catch (InputMismatchException e){
            System.out.println("\nDigite um id valido!");
            
        } catch (IndexOutOfBoundsException e){
            System.out.println("\nId não encontrado!");
        }
    }
}
