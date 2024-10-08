package entidades;

import java.time.LocalDate;

public class Livro {
	private Long id;
	private String isbn;
	private String titulo;
	private String autor;
	private String genero;
	private LocalDate dataPublicacao;
	private int quantidade;

	public Livro(String titulo, String autor, LocalDate dataPublicacao, String genero, int quantidade) {
		this.titulo = titulo;
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
		this.genero = genero;
		this.quantidade = quantidade;
	}

	public Livro() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setDataPublicacao(String dataPublicacaoStr) {
		// TODO Auto-generated method stub

	}
}
