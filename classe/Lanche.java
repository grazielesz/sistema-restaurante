package classe;

public class Lanche extends Prato {
    private String recheio;
    private String molho;
    private String pao;

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getMolho() {
        return molho;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    public String getPao() {
        return pao;
    }

    public void setPao(String pao) {
        this.pao = pao;
    }

    public Lanche(String recheio, String molho, String pao, String nome, double precoVenda, double peso, String validade) {
        super(nome, precoVenda, peso, validade);
        this.recheio = recheio;
        this.molho = molho;
        this.pao = pao;
    }
}