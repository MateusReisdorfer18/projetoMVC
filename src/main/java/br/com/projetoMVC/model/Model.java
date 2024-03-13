package br.com.projetoMVC.model;

import java.sql.Connection;
import java.sql.Statement;

public class Model {

    public void getPessoas(Connection connection) throws Exception {
        String query = "SELECT * FROM teste";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
