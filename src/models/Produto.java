package models;

import utils.exceptions.ProdutoIndisponivelException;
import utils.exceptions.QuantidadeInvalidaException;

public abstract class Produto implements  Vendavel {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        if (preco < 0 || quantidade < 0) {
            throw new QuantidadeInvalidaException("Preço e quantidade devem ser maiores ou iguais a zero.");
        }
        if  (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract double valorTotal();

    public String getDescricao() {
        return nome + " - Preço: " + preco + " - Quantidade: " + quantidade;
    }

    public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (quantidadeDesejada <= 0) {
            throw new QuantidadeInvalidaException("Quantidade desejada deve ser maior que zero.");
        }
        if (quantidadeDesejada > quantidade) {
            throw new ProdutoIndisponivelException("Quantidade desejada maior que a disponível em estoque.");
        }
        quantidade -= quantidadeDesejada;
    }
    void aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Percentual de desconto inválido.");
        }
        preco -= preco * (percentual / 100);
    }

    void aplicarDesconto(double percentual, double descontoMaximo) {
        if (percentual < 0 || percentual > 1) {
            throw new IllegalArgumentException("Percentual de desconto inválido.");
        }
        if (descontoMaximo < 0 || descontoMaximo > 1) {
            throw new IllegalArgumentException("Desconto máximo inválido.");
        }
        double descontoAplicado = percentual;
        if (descontoAplicado > descontoMaximo) {
            descontoAplicado = descontoMaximo;
        }
        preco -= preco * descontoAplicado;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
