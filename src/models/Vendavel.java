package models;

import utils.exceptions.ProdutoIndisponivelException;

public interface Vendavel {
    void vender(int quantidadeDesejada) throws ProdutoIndisponivelException;
}
