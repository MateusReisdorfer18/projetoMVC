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
            return null;
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
        Object objeto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM produto WHERE id=?";

        try {
            stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                objeto = produto;
            }
        } catch(SQLException e) {
            System.out.println("Problemas na DAO ao buscar produto");
            e.printStackTrace();
            return null;
        } finally {
            try {
                ConnectionFactory.closeConnection(this.connection, stmt, rs);
            } catch(Exception e) {
                System.out.println("Problemas na DAO ao fechar conexão");
            }
        }

        return objeto;
    }

    @Override
    public boolean Cadastrar(Object objeto) {
        PreparedStatement stmt = null;
        String query = "INSERT INTO produto (descricao) VALUES (?)";

        try {
            stmt = this.connection.prepareStatement(query);
            Produto produto = (Produto) objeto;
            stmt.setString(1, produto.getDescricao());
            stmt.execute();
        } catch(SQLException e) {
            System.out.println("Problemas no DAO ao cadastrar produto");
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(this.connection, stmt);
            } catch(Exception e) {
                System.out.println("Problema na DAO ao fechar conexao");
            }
        }

        return true;
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
