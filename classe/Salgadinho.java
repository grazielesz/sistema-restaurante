package classe;

public class Salgadinho extends Prato{
    private String recheio;
    private String massa;
    private Boolean isAssado; // Se não é assado é frito

    public String getMassa() {
        return massa;
    }

    public Boolean getIsAssado() {
        return isAssado;
    }

    public void setIsAssado(Boolean isAssado) {
        this.isAssado = isAssado;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public Salgadinho(String recheio, String massa, String nome, double precoVenda, double peso, String validade, Boolean isAssado){
        super(nome, precoVenda, peso, validade);
        this.setRecheio(recheio);
        this.setMassa(massa);
        this.setIsAssado(isAssado);
    }
}