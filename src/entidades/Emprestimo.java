package entidades;

import java.time.LocalDate;
import java.util.Random;

import entidades.enums.SituacaoEmprestimo;

public class Emprestimo {

	private Long id;
	private Livro livro;
	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private SituacaoEmprestimo estado;
	private Double multa;

	public Emprestimo(Long id, Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao,
			SituacaoEmprestimo estado, Double multa) {
		this.id = id;
		this.livro = livro;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.estado = estado;
		this.multa = multa;
	}

	Random random = new Random();

	public Emprestimo() {
	}

	public Long getId() {
		id = random.nextLong(90000);
		return Long.valueOf(id);
	}

	public void setId(Long id2) {
		this.id = id2;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public SituacaoEmprestimo getEstado() {
		return estado;
	}

	public void setEstado(SituacaoEmprestimo situacao) {
		this.estado = situacao;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public String getTitulo() {
		return null;
	}

	public void setLivro1(String string) {

	}

	public Emprestimo getUsuario1() {
		return null;
	}

	public void setUsuario(String string) {

	}

	public void setLivro(String string) {

	}

	public void setId(String id2) {

	}

	public void setMulta(String multa2) {
		// TODO Auto-generated method stub

	}

	public void setEstado(int estado2) {
		// TODO Auto-generated method stub

	}

}
