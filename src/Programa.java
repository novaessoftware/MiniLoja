import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Declare abaixo a quantidade de produtos: ");
        int qndProdutos = sc.nextInt();

        double subTotalGeral = 0.0;

        for (int i = 0; i < qndProdutos; i++) {
            sc.nextLine();
            System.out.println("Lendo produto...");
            System.out.print("Escreva o nome do produto: ");
            String nomeProd = sc.nextLine();
            System.out.print("Escreva o preço do produto: ");
            double precoProd = sc.nextDouble();
            System.out.print("Escreva a quantidade de produtos: ");
            int quantProd = sc.nextInt();

            Produto p = new Produto(nomeProd, precoProd, quantProd);
            System.out.println(p);

            subTotalGeral += p.subtotal();
        }

        System.out.println("-----------------------------------");
        System.out.printf("Subtotal: R$ %.2f%n", subTotalGeral);

        double desconto = CalculadoraPreco.desconto(subTotalGeral);

        System.out.println("-----------------------------------");
        double totalComDesconto = subTotalGeral - desconto;
        System.out.printf("Desconto (10%%): R$ %.2f%n", desconto);

        System.out.println("-----------------------------------");
        double frete = CalculadoraPreco.frete(totalComDesconto);
        System.out.printf("Frete: R$ %.2f%n", frete);

        System.out.println("-----------------------------------");
        double totalComFrete = totalComDesconto + frete;
        System.out.printf("Total: R$ %.2f%n", totalComFrete);

        sc.close();
    }
}
