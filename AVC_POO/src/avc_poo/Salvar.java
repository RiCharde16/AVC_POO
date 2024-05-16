package avc_poo;

public class Salvar {
    private String nome;
    private double preco;
    private int desconto = 0;
    
    public Salvar(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
        
    }
    
    public void setDesconto(int desconto){
        this.desconto = desconto;
    }
    
    public String info_produto(){
        return nome + ", " + preco + ", " + desconto;
    }
}

