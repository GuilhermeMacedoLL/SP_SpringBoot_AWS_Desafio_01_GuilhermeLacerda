package repositorio;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.conexaoBancoDeDados;
import entidades.Usuario;

public class UsuarioRepositorio {

	private conexaoBancoDeDados con = new conexaoBancoDeDados();
	private EmprestimoRepositorio emprestimoRepositorio = new EmprestimoRepositorio();

	public boolean salvarUsuario(Usuario usuario) {
		boolean retorno = false;

		String sql = "INSERT INTO usuario (id, nome, endereco, email, telefone, dataAssociacao) VALUES (?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Usuario usuarioDB = buscar(usuario);
			PreparedStatement statement = connection.prepareStatement(sql);

			if (usuario.getDataAssociacao() != null) {
				java.sql.Date dtAssociacao = java.sql.Date.valueOf(usuario.getDataAssociacao());
				statement.setDate(6, dtAssociacao);
			} else {

				System.err.println("Data de associação não pode ser nula.");
				return retorno;
			}

			statement.setLong(1, usuario.getId());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getEndereco());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getTelefone());
			statement.setDate(6, java.sql.Date.valueOf(usuario.getDataAssociacao()));

			if (usuarioDB == null) {
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					retorno = true;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao inserir usuário: " + e.getMessage());
		}

		return retorno;
	}

	private Usuario buscar(Usuario usuario) {
		return null;
	}

	public Usuario buscarUsuario(Usuario usuario) {
		Usuario usuarioDB = null;
		String sql = "SELECT id, nome, endereco, email, telefone, dataAssociacao FROM usuario WHERE nome = ?";
		try {
			Connection connection = con.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, usuario.getNome());

			ResultSet rs = st.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					usuarioDB = new Usuario();
					usuarioDB.setId(rs.getLong("id"));
					usuarioDB.setNome(rs.getString("nome"));
					usuarioDB.setEmail(rs.getString("email"));
					usuarioDB.setEndereco(rs.getString("endereco"));
					usuarioDB.setTelefone(rs.getString("telefone"));
					usuarioDB.setDataAssociacao(rs.getDate("dataAssociacao").toLocalDate());
					usuarioDB.setEmprestimo(emprestimoRepositorio.buscarPorUsuario(usuarioDB.getId()));
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao buscar usuário: " + e.getMessage());
		}

		return usuarioDB;
	}
}
