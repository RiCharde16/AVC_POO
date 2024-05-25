package avc_poo;

import java.util.ArrayList;

interface Estoque{
    public float calcularMediaPreco(ArrayList<Produto> produtos);

    public void exibirProdutos(ArrayList<Produto> produtos);
}


public class Produto extends Calculo {
    private int codProduto = 1;
    private String nome;
    private int quantidade;
    private double preco;
    
    public Produto(int codProduto, String nome, double preco , int quantidade){
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodProduto(){
        return this.codProduto;
    }
    
    public String data(){
        return codProduto+ "; "+nome + "; " + preco + "; " + quantidade+ "; " + desconto;
    }
}
