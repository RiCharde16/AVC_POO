package avc_poo;

import java.util.ArrayList;

interface Estoque{
    public static float calcularMediaPreco(ArrayList<Produto> produtos){
        float valor_total = 0.0f;

        for(Produto produto : produtos){
            double preco = produto.getPreco();

            valor_total += (float)preco;
        }
        
        float mediaPreco = valor_total / produtos.size();

        return mediaPreco;
    }

    public static void exibirProdutos(ArrayList<Produto> produtos){
        System.out.println(" ------ Produtos da loja ------ ");
                    
        if(!produtos.isEmpty()){
            
            System.out.println("| ID | \tNome do Produto \t | Preco \t|  Quantidade  |  Desconto  |");
            for(int i = 0; i < produtos.size(); i++){
                Produto produto = produtos.get(i);
                System.out.print("|  " + produto.dados().replace("; ", " | ") + " |");
                System.out.println();
            }

            System.out.println();
            System.out.println("Media preco dos produtos: " + String.format("%.2f",Estoque.calcularMediaPreco(produtos)));
            System.out.println("Quantidade de produtos cadastrados: " + produtos.size());
            
        } else {
            System.out.println("Sem produtos cadastrados !");
        }
    }
    
}


public class Produto extends Calculo implements Estoque {
    private int codProduto = 1;
    private String nome;
    private double preco;
    private int quantidade;
    
    public Produto(int codProduto, String nome, double preco , int quantidade){
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodProduto(){
        return this.codProduto;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public String dados(){
        String preco_format = String.format("%.2f", preco).replace(",", ".");

        return codProduto+ "; "+nome.trim() + "; " + preco_format + "; " + quantidade+ "; " + desconto;
    }

}
