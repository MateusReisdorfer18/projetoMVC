import br.com.projetoMVC.util.ConnectionFactory;

import java.sql.Connection;

public class ConnectionTeste {
    public static void main(String[] args) throws Exception {
        try {
            Connection connection = ConnectionFactory.getConnection();

            if(connection != null) {
                System.out.println("Conectado");
                connection.close();
            }else{
                System.out.println("Algo deu errado");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
