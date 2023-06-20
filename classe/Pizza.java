package classe;

public class Pizza extends Prato{
    private String molho;
    private String borda;
    private String recheio;
    public String getRecheio() {
        return recheio;
    }

    public String getMolho() {
        return molho;
    }
    public void setMolho(String molho) {
        this.molho = molho;
    }
    public String getBorda() {
        return borda;
    }
    public void setBorda(String borda) {
        this.borda = borda;
    }
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public Pizza(String molho, String borda, String recheio, String nome, double precoVenda, double peso, String validade){
        super(nome, precoVenda, peso, validade);
        this.molho = molho;
        this.borda = borda;
        this.recheio = recheio;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\n Molho: "+ getMolho()+
        "\n Borda: "+ getBorda()+
        "\n Recheio: "+ getRecheio();
    }
}
