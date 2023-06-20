package classe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pedido {
    private String nomeCliente;
    private double taxaServico;
    private ArrayList<Prato> itensConsumidos;

    public Pedido(){
        itensConsumidos = new ArrayList<>();
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double calcularTotal() {
        double total = this.taxaServico;

        for (Prato prato : itensConsumidos) {
            total += prato.getPrecoVenda();
        }

        return total;
    }

    public Pedido(String nomeCliente, double taxaServico, ArrayList<Prato> itens){
        this.setNomeCliente(nomeCliente);
        this.setTaxaServico(taxaServico);
        this.itensConsumidos = itens;
    }

    // get e set
    public ArrayList<Prato> getItens() {
        return itensConsumidos;
    }
    public void setItens(ArrayList<Prato> itens) {
        this.itensConsumidos = itens;
    }

    public void mostrarFatura(double pagamento) {
        try {
            File f = new File("nota_fiscal.txt");
    
            if (!f.exists()) {
                f.createNewFile();
            }
    
            try (
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw)) {
                pw.print("Nota Fiscal | " + nomeCliente + "\n");
                pw.println("Preco: " + calcularTotal() + " | Pagamento: " + pagamento + " | Troco: " + (pagamento - calcularTotal()));
                pw.print(getItens());
            }
    
            System.out.println("Nota criada!");
        } catch (Exception e) {
        }

    }
}
