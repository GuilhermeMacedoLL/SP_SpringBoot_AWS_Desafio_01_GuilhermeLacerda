package entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Autor extends Pessoa {

	private String biografia;
	private String nacionalidade;
	private LocalDate dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Autor(Long id, String nome, String biografia, String nacionalidade, LocalDate dataNascimento) {
		super(nome, id);
		this.biografia = biografia;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
	}

	public Autor() {
	}

	public String getNacionalidade1() {
		return null;
	}

	public void setDataNascimento(Date date) {
		// TODO Auto-generated method stub
		
	}
}