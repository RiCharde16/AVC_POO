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
    
    public void info_produto(){
        System.out.println("Informacoes do produto");
        System.out.println("Nome: " + nome);
        System.out.println("Preo: " + nome);
        if(desconto > 0){
            System.out.println("Desconto: " + desconto + "%");
        } else {
            System.out.println("Se desconto!");
        }
    }
}
