package br.com.projetoMVC;

import br.com.projetoMVC.controller.ProdutoController;
import br.com.projetoMVC.model.Produto;

public class Main {
    public static void main(String[] args) {

        ProdutoController produtoController = new ProdutoController();

        System.out.println("Lista de produtos");
        for(Produto produto:produtoController.listarTodos()) {
            System.out.println(produto.getDescricao());
        }

        System.out.println("Produto encontrado por id");
        System.out.println(produtoController.listarPorId(7).getDescricao());

        /*Produto produto = new Produto();
        produto.setDescricao("Teclado logitech");
        System.out.println(produtoController.cadastrar(produto));*/
    }
}