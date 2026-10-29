
public class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto (String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double subtotal() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return nome
                + ", R$ "
                + String.format("%.2f", preco)
                + ", "
                + quantidade
                + " unidades";
    }
}
