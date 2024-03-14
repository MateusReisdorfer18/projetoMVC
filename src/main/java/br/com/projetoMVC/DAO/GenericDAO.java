package br.com.projetoMVC.DAO;

import java.util.List;

public interface GenericDAO {
    public List<Object> listarTodos();
    public Object listarPorId(Integer id);
    public boolean Cadastrar(Object objeto);
    public boolean alterar(Object objeto);
    public void excluir(Integer id);
}
