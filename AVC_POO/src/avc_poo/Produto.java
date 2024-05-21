package avc_poo;


public class Produto extends Calculo {
    private String nome;
    private int quantidade;
    private double preco;
    private int desconto;
    
    public Produto(String nome, double preco , int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public void setDesconto(int desconto){
        this.desconto = desconto;
    }
    
    public String date(){
        return nome + ", " + preco + ", " + quantidade+ ", " + desconto;
    }
}
