package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import conexao.conexaoBancoDeDados;
import entidades.Emprestimo;
import entidades.enums.SituacaoEmprestimo;

public class EmprestimoRepositorio {

	private conexaoBancoDeDados con = new conexaoBancoDeDados();

	public Long gerarIdAleatorio() {
		return (long) (Math.random() * 1_000_000L);
	}

	public double calcularMulta(Emprestimo emprestimo, double valorMultaDiaria) {
		LocalDate dataEmprestimo = emprestimo.getDataEmprestimo();
		LocalDate dataDevolucao = emprestimo.getDataDevolucao();

		if (dataEmprestimo == null || dataDevolucao == null) {
			throw new IllegalArgumentException("As datas de empréstimo e devolução não podem ser nulas.");
		}

		long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
		if (diasAtraso > 3) {
			double multa = (diasAtraso - 3) * valorMultaDiaria;
			return multa;
		}

		return 0.0;
	}

	public boolean salvarEmprestimo(Emprestimo emprestimo, double valorMultaDiaria) {
		boolean retorno = false;

		double multaCalculada = calcularMulta(emprestimo, valorMultaDiaria);
		emprestimo.setMulta(multaCalculada);

		String sql = "INSERT INTO emprestimo (id, livro, usuario, dataEmprestimo, dataDevolucao, estado, multa) VALUES (?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Emprestimo emprestimoDB = buscar(emprestimo);
			PreparedStatement statement = connection.prepareStatement(sql);

			if (emprestimo.getDataDevolucao() != null) {
				java.sql.Date dtDataDevolucao = java.sql.Date.valueOf(emprestimo.getDataDevolucao());
				statement.setDate(4, dtDataDevolucao);
			} else if (emprestimo.getDataEmprestimo() != null) {
				java.sql.Date dtDataEmprestimo = java.sql.Date.valueOf(emprestimo.getDataEmprestimo());
				statement.setDate(5, dtDataEmprestimo);
			} else {
				System.err.println("Data de emprestimo não pode ser nula.");
				return retorno;
			}

			if (emprestimo.getLivro() == null) {
				System.err.println("O livro do empréstimo não pode ser nulo.");
				return retorno;
			}

			statement.setLong(1, emprestimo.getId());
			statement.setString(2, emprestimo.getLivro().getTitulo());
			statement.setLong(3, emprestimo.getUsuario().getId());
			statement.setDate(4, java.sql.Date.valueOf(emprestimo.getDataEmprestimo()));
			statement.setDate(5, java.sql.Date.valueOf(emprestimo.getDataDevolucao()));
			statement.setString(6, emprestimo.getEstado().name());
			statement.setDouble(7, emprestimo.getMulta());

			if (emprestimoDB == null) {
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					retorno = true;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar emprestimo: " + e.getMessage());
		}

		return retorno;
	}

	public Emprestimo buscarEmprestimo(Emprestimo emprestimo) {
		Emprestimo emprestimoDB = null;
		String sql = "SELECT id, livro, usuario, dataEmprestimo, dataDevolucao, estado, multa FROM emprestimo WHERE id = ?";
		try {
			Connection connection = con.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);

			st.setLong(1, emprestimo.getId());

			ResultSet rs = st.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					emprestimoDB = new Emprestimo();
					emprestimoDB.setId(rs.getLong("id"));
					emprestimoDB.setLivro(rs.getString("livro"));
					emprestimoDB.setUsuario(rs.getString("usuario"));
					emprestimoDB.setDataEmprestimo(LocalDate.now());
					emprestimoDB.setDataDevolucao(LocalDate.now());
					emprestimoDB.setEstado(SituacaoEmprestimo.valueOf(rs.getString("estado")));
					emprestimoDB.setMulta((double) rs.getInt("multa"));
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao buscar emprestimo: " + e.getMessage());
		}
		return emprestimoDB;
	}

	public Emprestimo buscar(Emprestimo emprestimo) {

		return new Emprestimo();
	}

	public List<Emprestimo> buscarPorUsuario(Long usuarioId) {

		return null;
	}

}
