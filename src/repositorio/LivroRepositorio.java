package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import conexao.conexaoBancoDeDados;
import entidades.Livro;

public class LivroRepositorio {

	private conexaoBancoDeDados con = new conexaoBancoDeDados();

	public boolean salvarLivro(Livro livro) {
		boolean retorno = false;

		Random random = new Random();

		String sql = "INSERT INTO livro (isbn, titulo, autor, dataPublicacao, genero, quantidade) VALUES (?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Livro livroDB = buscarLivro(livro);
			PreparedStatement statement = connection.prepareStatement(sql);

			if (livro.getDataPublicacao() != null) {
				java.sql.Date dtPublicacao = java.sql.Date.valueOf(livro.getDataPublicacao());
				statement.setDate(4, dtPublicacao);
			} else {

				System.err.println("Data de publicação não pode ser nula.");
				return retorno;
			}

			int numeroISBN = 1000000 + random.nextInt(9000000);
			livro.setIsbn(String.valueOf(numeroISBN));

			if (validaISBN(livro.getIsbn())) {

				statement.setString(1, livro.getIsbn());
				statement.setString(2, livro.getTitulo());
				statement.setString(3, livro.getAutor());
				statement.setDate(4, java.sql.Date.valueOf(livro.getDataPublicacao()));
				statement.setString(5, livro.getGenero());
				statement.setInt(6, livro.getQuantidade());

				if (livroDB == null) {
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						retorno = true;
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao inserir livro: " + e.getMessage());
		}

		return retorno;
	}

	public Livro buscarLivro(Livro livro) {
		Livro livroDB = null;
		String sql = "SELECT isbn, titulo, autor, dataPublicacao, genero, quantidade FROM livro WHERE titulo = ?";
		try {
			Connection connection = con.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, livro.getTitulo());

			ResultSet rs = st.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					livroDB = new Livro();
					livroDB.setIsbn(rs.getString("isbn"));
					livroDB.setTitulo(rs.getString("titulo"));
					livroDB.setAutor(rs.getString("autor"));
					livroDB.setDataPublicacao(rs.getDate("dataPublicacao").toLocalDate());
					livroDB.setGenero(rs.getString("genero"));
					livroDB.setQuantidade(rs.getInt("quantidade"));
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao buscar Livro: " + e.getMessage());
		}
		return livroDB;
	}

	private boolean validaISBN(String isbn) {
		return true;
	}

	public Livro buscar(Livro livro) {

		return new Livro();
	}

}
