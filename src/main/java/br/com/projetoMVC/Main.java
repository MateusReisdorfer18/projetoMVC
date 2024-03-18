package br.com.projetoMVC;

import br.com.projetoMVC.controller.ProdutoController;
import br.com.projetoMVC.model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoController produtoController = new ProdutoController();

        boolean continuar = true;

        do {
            int opcao;
            System.out.println("Selecione a ação que deseja fazer \n [1] Listar Produtos \n [2] Buscar produto por id \n [3] Criar Produto \n [4] Editar Produto \n [5] Excluir Produto \n [0] Sair do sistema");

            opcao = scanner.nextInt();

            if(opcao == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Lista de produtos");
                    for(int i=0; i<1; i++) {
                        System.out.println("Id, Descrição");
                        for(Produto produto:produtoController.listarTodos()) {
                            System.out.println(produto.getId() + ", " + produto.getDescricao());
                        }
                    }

                    break;
                case 2:
                    int id;
                    Produto produtoEncontrado = null;

                    do {
                        System.out.println("Digite o id do produto");
                        id = scanner.nextInt();

                        produtoEncontrado = produtoController.listarPorId(id);

                        if (produtoEncontrado == null)
                            System.out.println("Produto não encontrado, digite novamente o id");
                    } while(produtoEncontrado == null);

                    System.out.println("Produto encontrado !");
                    System.out.println("Id, Descrição");
                    System.out.println(produtoEncontrado.getId() + ", " + produtoEncontrado.getDescricao());
                    break;
                case 3:
                    Produto produto = new Produto();

                    System.out.println("Digite o nome do produto");
                    produto.setDescricao(scanner.next());

                    boolean returnCadastrarProduto = produtoController.cadastrar(produto);

                    if(!returnCadastrarProduto) {
                        System.out.println("Houve um problema ao Cadastrar o produto");
                        break;
                    }

                    System.out.println("Produto criado!");
                    break;
                case 4:
                    int idProduto;
                    Produto produtoEncontradoAlterar;
                    String nomeAlterado;

                    do {
                        for(int i=0; i<1; i++) {
                            System.out.println("Id, Descrição");
                            for(Produto produtoParams:produtoController.listarTodos()) {
                                System.out.println(produtoParams.getId() + ", " + produtoParams.getDescricao());
                            }
                        }

                        System.out.println("Digite o id do produto que gostaria de alterar");
                        idProduto = scanner.nextInt();

                        produtoEncontradoAlterar = produtoController.listarPorId(idProduto);

                        if(produtoEncontradoAlterar == null)
                            System.out.println("Produto não encontrado, digite novamente o id");
                    } while(produtoEncontradoAlterar == null);

                    System.out.println("Produto Encontrado!");
                    System.out.println(produtoEncontradoAlterar.getId() + ", " + produtoEncontradoAlterar.getDescricao());

                    System.out.println("Digite o nome do produto");
                    nomeAlterado = scanner.next();

                    produtoEncontradoAlterar.setDescricao(nomeAlterado);

                    boolean returnAlterarProduto =  produtoController.alterar(produtoEncontradoAlterar);

                    if(! returnAlterarProduto) {
                        System.out.println("Não foi possivel alterar o produto");
                        break;
                    }

                    System.out.println("Produto alterado!");
                    break;
                case 5:
                    int idProdutoExcluir;
                    boolean returnExcluirProduto;


                    do {
                        for(int i=0; i<1; i++) {
                            System.out.println("Id, Descrição");
                            for(Produto produtoParams:produtoController.listarTodos()) {
                                System.out.println(produtoParams.getId() + ", " + produtoParams.getDescricao());
                            }
                        }

                        System.out.println("Digite o id do produto que gostaria de excluir");
                        idProdutoExcluir = scanner.nextInt();

                        returnExcluirProduto = produtoController.excluir(idProdutoExcluir);

                        if(!returnExcluirProduto)
                            System.out.println("Produto não encontrado, digite novamente o id");
                    } while(!returnExcluirProduto);

                    System.out.println("Produto Excluido!");

                    break;
                default:
                    break;
            }
        } while(continuar);
    }
}