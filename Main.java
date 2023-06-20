import java.util.ArrayList;
import java.io.*;
import classe.Lanche;
import classe.Pedido;
import classe.Pizza;
import classe.Prato;
import classe.Salgadinho;

public class Main {

  public static ArrayList<Prato> pratos = new ArrayList<>();
  public static Pedido pedido = new Pedido();
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int op = 1;

    carregaDados();

    while (op > 0) {
      System.out.println("==========================================================");
      System.out.println("              LANCHERIA QUASE TRÊS LANCHES                ");
      System.out.println("==========================================================");

      System.out.println("1) Montar pizza");
      System.out.println("2) Adicionar lanche");
      System.out.println("3) Adicionar Salgadinho");
      System.out.println("4) Finalizar pedido");
      System.out.println("0) Sair");

      op = Integer.parseInt(br.readLine());
      switch (op) {
        case 1: {
          montarPizza();
          break;
        }
        case 2: {
          adicionarLanche();
          break;
        }
        case 3: {
          adicionarSalgadinho();
          break;
        }
        case 4: {
          finalizarPedido();
          break;
        }
        case 0: {
          System.out.println("Muito Obrigado. A lancheria agradece sua preferência :)");
          break;
        }
        default: {
          System.err.println("Opção invalida!");
          break;
        }
      }
    }
  }

  public static void montarPizza() {
    System.out.println("==========================================================");
    System.out.println("                  PIZZA CUSTOMIZADA                       ");
    System.out.println("==========================================================");
    try {
      System.out.println("Qual molho você quer utilizar");
      String molho = br.readLine();

      System.out.println("Qual borda você quer utilizar");
      String borda = br.readLine();

      System.out.println("Qual recheio você quer utilizar");
      String recheio = br.readLine();

      pedido.getItens().add(new Pizza(molho, borda, recheio, "PIZZA CUSTOMIZADA", 40.0, 10, "NÃO SE APLICA"));

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void adicionarLanche() {
    System.out.println("==========================================================");
    System.out.println("                    ADICIONAR LANCHE                      ");
    System.out.println("==========================================================");

    ArrayList<Lanche> lanches = new ArrayList<>();

    try {
      for (int i = 0; i < pratos.size(); i++) {

        Prato p = pratos.get(i);

        if (p instanceof Lanche) {
          lanches.add((Lanche) p);
        }
      }

      for (int i = 0; i < lanches.size(); i++) {
        System.out.println((i + 1) + ") " + lanches.get(i).getNome());
      }

      int op = Integer.parseInt(br.readLine());

      pedido.getItens().add(lanches.get(op - 1));

    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public static void adicionarSalgadinho() {
    System.out.println("==========================================================");
    System.out.println("                ADICIONAR SALGADINHO                      ");
    System.out.println("==========================================================");

    ArrayList<Salgadinho> salgados = new ArrayList<>();

    try {
      for (int i = 0; i < pratos.size(); i++) {

        Prato p = pratos.get(i);

        if (p instanceof Salgadinho) {
          salgados.add((Salgadinho) p);
        }
      }

      for (int i = 0; i < salgados.size(); i++) {
        System.out.println((i + 1) + ") " + salgados.get(i).getNome());
      }

      int op = Integer.parseInt(br.readLine());

      pedido.getItens().add(salgados.get(op - 1));

    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public static void finalizarPedido() {

    try {
      System.out.println("Nome do cliente a fazer o pedido:");
      String nomeCliente = br.readLine();

      System.out.println("Seu pedido deu R$" + pedido.calcularTotal());

      System.out.print("Qual o valor a ser pago?");
      double pagamento = Double.parseDouble(br.readLine());

      pedido.setNomeCliente(nomeCliente);
      pedido.mostrarFatura(pagamento);

      // Limpa Pedido
      pedido.setItens(new ArrayList<>());
      
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public static void carregaDados() {
    pratos.add(new Pizza("calabresa", "azeitona", "cheedar", "pizza de calabresa", 40.0, 40, "19/01/2022"));
    pratos.add(new Pizza("portuguesa", "pepperoni", "tomate", "pizza de portuguesa", 40.0, 40, "26/05/2022"));
    pratos.add(new Pizza("marinara", "cheddar", "frango", "pizza de frango", 40.0, 5, "21/03/2022"));

    pratos.add(new Lanche("queijo", "tomatinho", "francês", "torradinha", 13, 500, "30/01/2024"));
    pratos.add(new Lanche("alface", "presunto", "hamburguer", "hamburguer", 10, 398, "05/09/2023"));
    pratos.add(new Lanche("repolho", "tomate", "centeio", "lanche vegetariano", 20, 98, "26/01/20022"));

    pratos.add(new Salgadinho("frango", "mandioca", "coxinha de frango", 5, 90, "29/03/2022", false));
    pratos.add(new Salgadinho("catupiry", "mandioca", "coxinha de catupiry", 5, 90, "29/03/2022", false));
    pratos.add(new Salgadinho("carne moída", "trigo", "pastel de carne", 10, 40, "23/02/2023", true));
  }
}