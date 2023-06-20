package classe;

public class Prato{
    private String nome;
    private double precoVenda;
    private double peso;
    private String validade;

    public Prato(String nome, double precoVenda, double peso, String validade){
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.peso = peso;
        this.validade = validade;
    }

    //get
    public String getValidade(){
        return validade;
    }

    public double getPeso(){
        return peso;
    }

    public double getPrecoVenda(){
        return precoVenda;
    }
    public String getNome(){
        return nome;
    }

    //set
    public void setValidade(String validade){
        this.validade = validade;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setPrecoVenda(double precoVenda){
        this.precoVenda = precoVenda;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nProduto: "+nome+
                "\n Validade: "+ getValidade()+
                "\n Peso: "+ getPeso()+
                "\n Preco: "+ getPrecoVenda()+
                "\n"
                ;
    }
}
