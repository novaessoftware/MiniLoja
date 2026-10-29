

public class CalculadoraPreco {
    public static final double TAXA_DESCONTO = 0.10;
    public static final double MINIMO_DESCONTO = 1000.00;
    public static final double VALOR_FRETE = 30.00;
    public static final double MINIMO_FRETE_GRATIS = 800.00;

    public static double desconto(double total) {
        if (total >= MINIMO_DESCONTO) {
            return total * TAXA_DESCONTO;
        } else {
            return 0;
        }
    }

    public static double frete(double total) {
        if (total < MINIMO_FRETE_GRATIS) {
            return VALOR_FRETE;
        } else {
            return 0;
        }
    }
}

