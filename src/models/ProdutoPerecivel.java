package models;

public class ProdutoPerecivel extends Produto {
    private int diasParaVencer;

    public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer) {
        super(nome, preco, quantidade);
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    @Override
    public double valorTotal() {
        if (diasParaVencer <= 0) {
            throw new IllegalArgumentException("O produto já venceu.");
        }
        double desconto = 0;
        if (diasParaVencer <= 3) {
            desconto = 0.2;
        }
        return getPreco() * getQuantidade() * (1 - desconto);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " - Dias para vencer: " + diasParaVencer;
    }
}
