package entidades;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Usuario extends Pessoa {

	private String endereco;
	private String email;
	private String telefone;
	private List<Emprestimo> emprestimo;// INNER JOIN
	private LocalDate dataAssociacao;

	Random random = new Random();

	public Long getId() {
		int id = random.nextInt(90000);
		return Long.valueOf(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAssociacao() {
		return dataAssociacao;
	}

	public void setDataAssociacao(LocalDate dataAssociacao) {
		this.dataAssociacao = dataAssociacao;
	}

	public Usuario(Long id, String endereco, String email, String telefone, List<Emprestimo> emprestimo, String nome,
			LocalDate dataAssociacao) {
		super(nome, id);
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.emprestimo = emprestimo;
		this.dataAssociacao = dataAssociacao;
	}

	public Usuario() {
		super();
	}

}
