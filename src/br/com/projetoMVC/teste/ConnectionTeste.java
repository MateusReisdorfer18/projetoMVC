package br.com.projetoMVC.teste;

import br.com.projetoMVC.util.ConnectionFactory;

import java.sql.Connection;

public class ConnectionTeste {
    public static void main(String[] args) throws Exception {
        try {
            Connection connection = ConnectionFactory.getConnection();

            if(connection != null) {
                System.out.println("Conexão foi estabelecida");
                connection.close();
            }else{
                System.out.println("Houve um problema ao conectar");
            }
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
