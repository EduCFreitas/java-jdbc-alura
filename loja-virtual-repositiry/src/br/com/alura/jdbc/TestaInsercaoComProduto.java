package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			
			
		}
		
		System.out.println(comoda);

	}

}
