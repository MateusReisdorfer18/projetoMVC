package br.com.projetoMVC.DAO;

import br.com.projetoMVC.model.Produto;
import br.com.projetoMVC.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOimpl implements GenericDAO {
    private Connection connection;

    public ProdutoDAOimpl() throws Exception {
        try {
            this.connection = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Object> listarTodos() {
        List<Object> lista = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM produto";

        try {
            stmt = this.connection.prepareStatement(query);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                lista.add(produto);
            }
        } catch(SQLException e) {
            System.out.println("Problemas na DAO ao listar Produto!");
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(this.connection, stmt, rs);
            } catch(Exception e) {
                System.out.println("Problemas na DAO ao fechar conexao");
            }
        }
        return lista;
    }

    @Override
    public Object listarPorId(Integer id) {
        String query = "SELECT id FROM produto WHERE id=?";
        return null;
    }

    @Override
    public boolean Cadastrar(Object objeto) {
        String query = "INSERT INTO produto WHERE id=?, descricao=?";
        return false;
    }

    @Override
    public boolean alterar(Object objeto) {
        String query = "UPDATE produto WHERE id=?, descricao=?";
        return false;
    }

    @Override
    public void excluir(Integer id) {
        String query = "DELETE produto WHERE id=?";
    }
}
