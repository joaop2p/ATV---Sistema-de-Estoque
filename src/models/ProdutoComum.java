package models;

public class ProdutoComum extends Produto {
    public ProdutoComum(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    @Override
    public double valorTotal() {
        return getPreco() * getQuantidade();
    }
}
