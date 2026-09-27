package models;

import utils.exceptions.ProdutoIndisponivelException;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();

    public Estoque() {}

    public void adicionarProduto(Produto produto) {
        IO.println("Adicionando produto: " + produto.getDescricao());
        this.produtos.add(produto);
    }

    public Produto venderProduto(int id, int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (id < 0 || id >= produtos.size()) {
            throw new IllegalArgumentException("ID do produto inválido.");
        }
        Produto produto = produtos.get(id);
        produto.vender(quantidadeDesejada);
        return produto;
    }

    public double calcularValorTotalEstoque() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.valorTotal();
        }
        return total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
