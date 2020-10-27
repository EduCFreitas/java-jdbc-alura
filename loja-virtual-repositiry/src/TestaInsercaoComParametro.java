import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false); //Tira a responsabilidade do JDBC de fazer os commits na tabela
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)"
				, Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("SmartTV", "45 polegadas", stm);
		adicionarVariavel("R�dio", "R�dio de bateria", stm);

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
//		if(nome.equals("R�dio")) {
//			throw new RuntimeException("N�o foi poss�vel adicionar o produto");
//		}
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}

}
