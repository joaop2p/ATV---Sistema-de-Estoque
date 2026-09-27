import models.Estoque;
import models.ProdutoComum;
import models.ProdutoPerecivel;
import utils.exceptions.ProdutoIndisponivelException;
import utils.exceptions.QuantidadeInvalidaException;

import static java.lang.System.out;

void main() {
    Estoque estoque = new Estoque();

    try {
        estoque.adicionarProduto(new ProdutoComum("Produto inválido", 10, -5));
    } catch (QuantidadeInvalidaException e) {
        IO.println("Não foi possível cadastrar o produto: " + e.getMessage());
    }

    estoque.adicionarProduto(new ProdutoComum("Arroz", 20, 3));
    estoque.adicionarProduto(new ProdutoComum("Feijão", 15, 7));
    estoque.adicionarProduto(new ProdutoPerecivel("Leite", 10, 5, 2));
    estoque.adicionarProduto(new ProdutoPerecivel("Biscoito", 5, 10, 5));

    try {
        estoque.venderProduto(0, 2);
        IO.println("Venda realizada: 2 unidades de Arroz.");
    } catch (ProdutoIndisponivelException e) {
        IO.println("Não foi possível realizar a venda: " + e.getMessage());
    }

    try {
        estoque.venderProduto(0, 2);
    } catch (ProdutoIndisponivelException e) {
        IO.println("Venda não realizada: " + e.getMessage());
    }

    estoque.getProdutos().forEach(produto -> IO.println(produto.getDescricao()));
    out.printf("Valor total do estoque: R$ %.2f%n", estoque.calcularValorTotalEstoque());
}
