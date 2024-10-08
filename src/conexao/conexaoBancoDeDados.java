package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBancoDeDados {
	private static final String URL = "jdbc:mysql://localhost:3307/library";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			return null;
		}
	}
}
