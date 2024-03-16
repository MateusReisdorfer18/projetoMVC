package br.com.projetoMVC.controller;

import br.com.projetoMVC.DAO.GenericDAO;
import br.com.projetoMVC.DAO.ProdutoDAOimpl;
import br.com.projetoMVC.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    public ProdutoController() {

    }
    public List<Produto> listarTodos() {
        try {
            GenericDAO dao = new ProdutoDAOimpl();
            List<Produto> lista = new ArrayList<Produto>();

            for(Object objeto:dao.listarTodos()) {
                lista.add((Produto) objeto);
            }

            return lista;
        } catch(Exception e) {
            System.out.println("Problemas no controller para listar os produtos!" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Produto listarPorId(Integer id) {
        try {
            GenericDAO dao = new ProdutoDAOimpl();
            Produto produto;

            produto = (Produto) dao.listarPorId(id);

            return produto;
        } catch(Exception e) {
            System.out.println("Problemas no controller para listar por id");
            e.printStackTrace();
            return null;
        }
    }

    public boolean cadastrar(Produto produto) {
        try {
            GenericDAO dao = new ProdutoDAOimpl();

            dao.Cadastrar(produto);

            return true;
        } catch(Exception e) {
            System.out.println("Problemas no controller para cadastrar produto");
            e.printStackTrace();
            return false;
        }
    }
}
