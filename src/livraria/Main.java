
package livraria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import entidades.Autor;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import entidades.enums.SituacaoEmprestimo;
import repositorio.AutorRepositorio;
import repositorio.EmprestimoRepositorio;
import repositorio.LivroRepositorio;
import repositorio.UsuarioRepositorio;

public class Main {

	Livro livro = new Livro();
	static UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
	static LivroRepositorio livroRepositorio = new LivroRepositorio();
	static AutorRepositorio autorRepositorio = new AutorRepositorio();
	static EmprestimoRepositorio emprestimoRepositorio = new EmprestimoRepositorio();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Menu Livraria");
		System.out.println("1-Usuario");
		System.out.println("2-Livro");
		System.out.println("3-Autor");
		System.out.println("4-Emprestimo");

		System.out.println("Escolha sua opção(número): ");
		String escolha = sc.nextLine();

		boolean formatoValido = false;
		while (!formatoValido) {
			try {
				 formatoValido = true;
				switch (Integer.parseInt(escolha)) {
					case 1:
						System.out.println("Menu Usuário");
						System.out.println("------------------");
						System.out.println("1-Cadastrar Usuário");
						System.out.println("2-Buscar Usuário");
						int escolhaUsuario = sc.nextInt();
						menuUsuario(escolhaUsuario);
						break;
					case 2:
						System.out.println("Menu Livro");
						System.out.println("------------------");
						System.out.println("1-Cadastrar livro");
						System.out.println("2-Buscar livro");
						int escolhaLivro = sc.nextInt();
						menuLivro(escolhaLivro);
						break;
					case 3:
						System.out.println("Menu Autor");
						System.out.println("------------------");
						System.out.println("1-Cadastrar autor");
						System.out.println("2-Buscar autor");
						int escolhaAutor = sc.nextInt();
						menuAutor(escolhaAutor);

						break;
					case 4:
						System.out.println("Menu Emprestimo");
						System.out.println("------------------");
						System.out.println("1-Cadastrar emprestimo");
						System.out.println("2-Buscar emprestimo");
						int escolhaEmprestimo = sc.nextInt();
						menuEmprestimo(escolhaEmprestimo);
						break;
				}
			} catch (NumberFormatException e) {
				 formatoValido = false;
				System.out.println("Formato digitado incorreto, favor digitar o numero da opção");
				 escolha = sc.nextLine();
			}
			sc.close();
		}
	}


	private static void menuUsuario(int escolhaUsuario) {
		Scanner sc = new Scanner(System.in);
		Usuario usuario;
		switch (escolhaUsuario) {
			case 1:
				System.out.println("Cadastro de Usuario");
				System.out.println("Nome: ");
				String nome = sc.nextLine();
				System.out.println("Endereco: ");
				String endereco = sc.nextLine();

				LocalDate dataAssociacao = null;
				boolean dataValida = false;
				while (!dataValida) {
					System.out.print("Digite a data de Associação do usuário (yyyy-MM-dd): ");
					String dataInput = sc.nextLine();

					try {
						 dataAssociacao = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						  dataValida = true;
					} catch (DateTimeParseException e) {
						System.out.println("Data inválida, por favor insira no formato yyyy-MM-dd.");
					}
				}

				System.out.println("Email: ");
				String email = sc.nextLine();
				System.out.println("Telefone: ");
				String telefone = sc.nextLine();
				 usuario = new Usuario();
				usuario.setNome(nome);
				usuario.setDataAssociacao(dataAssociacao);
				usuario.setEmail(email);
				usuario.setEndereco(endereco);
				usuario.setTelefone(telefone);
				boolean retorno = usuarioRepositorio.salvarUsuario(usuario);
				if (retorno) {
					System.out.println("Usuario Salvo com Sucesso!");
				} else {
					System.out.println("Erro ao salvar usuario, verfique o log do console!");
				}
				break;
			case 2:
				System.out.println("Buscar Usuario");
				System.out.println("Digite o nome do usuario:");
				nome = sc.nextLine();
				usuario = new Usuario();
				usuario.setNome(nome);
				Usuario usuarioDB = usuarioRepositorio.buscarUsuario(usuario);
				System.out.println("Nome: " + usuarioDB.getNome());
				System.out.println("Id do usuário: " + usuarioDB.getId());
				System.out.println("Endereco: " + usuarioDB.getEndereco());
				System.out.println("Email: " + usuarioDB.getEmail());
				System.out.println("Telefone: " + usuarioDB.getTelefone());
				System.out.println("Data de Associacao: " + usuarioDB.getDataAssociacao());
				System.out.println("Emprestimo: " + usuarioDB.getEmprestimo());
				break;
		}
		sc.close();
	}

	private static void menuLivro(int escolhaLivro) {
		Scanner sc = new Scanner(System.in);
		Livro livro = new Livro();
		switch (escolhaLivro) {
			case 1:
				System.out.println("Cadastro de Livro");
				System.out.println("Titulo: ");
				String titulo = sc.nextLine();
				System.out.println("Autor: ");
				String autor = sc.nextLine();

				LocalDate dataPublicacao = null;
				boolean dataValida = false;
				while (!dataValida) {
					System.out.print("Digite a data de publicação do livro (yyyy-MM-dd): ");
					String dataInput = sc.nextLine();

					try {
						 dataPublicacao = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						 dataValida = true;
					} catch (DateTimeParseException e) {
						System.out.println("Data inválida, por favor insira no formato yyyy-MM-dd.");
					}
				}
				System.out.println("Genêro: ");
				String genero = sc.nextLine();
				System.out.println("Quantidade: ");
				int quantidade = sc.nextInt();

				 livro = new Livro();
				livro.setTitulo(titulo);
				livro.setAutor(autor);
				livro.setDataPublicacao(dataPublicacao);
				livro.setGenero(genero);
				livro.setQuantidade(quantidade);
				boolean retorno = livroRepositorio.salvarLivro(livro);
				if (retorno) {
					System.out.println("Livro salvo com sucesso!");
				} else {
					System.out.println("Erro ao salvar livro, verfique o log do console!");
				}
				break;
			case 2:
				System.out.println("Buscar Livro");
				System.out.println("Digite o nome do livro: ");
				 titulo = sc.nextLine();
				 livro = new Livro();
				livro.setTitulo(titulo);
				Livro livroDB = livroRepositorio.buscarLivro(livro);
				System.out.println("Título: " + livroDB.getTitulo());
				System.out.println("Isbn do livro: " + livroDB.getIsbn());
				System.out.println("Autor: " + livroDB.getAutor());
				System.out.println("Data de Publicação (yyyy/MM/dd): " + livroDB.getDataPublicacao());
				System.out.println("Genêro: " + livroDB.getGenero());
				System.out.println("Quantidade de livros: " + livroDB.getQuantidade());
				break;
		}
		sc.close();
	}

	private static void menuAutor(int escolhaAutor) {
		Scanner sc = new Scanner(System.in);
		Autor autor;
		switch (escolhaAutor) {
			case 1:
				System.out.println("Cadastro de Livro");
				System.out.println("Nome: ");
				String nome = sc.nextLine();
				System.out.println("Biografia: ");
				String biografia = sc.nextLine();
				System.out.println("Nacionalidade: ");
				String nacionalidade = sc.nextLine();

				LocalDate dataNascimento = null;
				boolean dataValida = false;
				while (!dataValida) {
					System.out.print("Digite a data de nascimento do autor (yyyy-MM-dd): ");
					String dataInput = sc.nextLine();

					try {
						dataNascimento = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						dataValida = true;
					} catch (DateTimeParseException e) {
						System.out.println("Data inválida, por favor insira no formato yyyy-MM-dd.");
					}
				}

				 autor = new Autor();
				autor.setNome(nome);
				autor.setBiografia(biografia);
				autor.setNacionalidade(nacionalidade);
				autor.setDataNascimento(dataNascimento);
				boolean retorno = autorRepositorio.salvarAutor(autor);
				if (retorno) {
					System.out.println("Autor salvo com sucesso!");
				} else {
					System.out.println("Erro ao salvar autor, verfique o log do console!");
				}
				break;
			case 2:
				System.out.println("Buscar autor");
				System.out.println("Digite o nome do autor:");
				 nome = sc.nextLine();
				 autor = new Autor();
				autor.setNome(nome);
				Autor autorDB = autorRepositorio.buscarAutor(autor);
				System.out.println("Nome: " + autorDB.getNome());
				System.out.println("Id: " + autorDB.getId());
				System.out.println("Biografia: " + autorDB.getBiografia());
				System.out.println("Nacionalidade: " + autorDB.getNacionalidade());
				System.out.println("Data de nascimento: " + autorDB.getDataNascimento());
				break;
		}
		sc.close();
	}

	private static void menuEmprestimo(int escolhaEmprestimo) {
		Scanner sc = new Scanner(System.in);
		Emprestimo emprestimo;
		switch (escolhaEmprestimo) {
			case 1:
				System.out.println("Cadastro de Emprestimo");
				System.out.println("Usuario: ");
				String usuario = sc.nextLine();
				System.out.println("Digite o título do livro:");
				String titulo = sc.nextLine();

				LocalDate dataEmprestimo = null;
				LocalDate dataDevolucao = null;
				boolean dataValida = false;

				while (!dataValida) {
					System.out.print("Digite a data de emprestimo do usuário (yyyy-MM-dd): ");
					String dataInput = sc.nextLine();

					try {
						  dataEmprestimo = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					} catch (DateTimeParseException e) {
						System.out.println("Data inválida, por favor insira no formato yyyy-MM-dd.");
						continue;
					}
				
					System.out.print("Digite a data de devolução do usuário (yyyy-MM-dd): ");
					 dataInput = sc.nextLine();

					try {
						 dataDevolucao = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						 dataValida = true;
					} catch (DateTimeParseException e) {
						System.out.println("Data inválida, por favor insira no formato yyyy-MM-dd.");
					}
				}

				System.out.println("Estado do empréstimo (1 - Em andamento, 2 - Atrasado, 3 - Concluído): ");
				int estadoCodigo = sc.nextInt();
				SituacaoEmprestimo situacao = SituacaoEmprestimo.fromCodigo(estadoCodigo);
				System.out.println("multa");
				sc.nextLine();
				double multa = sc.nextDouble();

				emprestimo = new Emprestimo();
				emprestimo.setUsuario(usuario);
				emprestimo.setLivro(titulo);
				emprestimo.setDataEmprestimo(dataEmprestimo);
				emprestimo.setDataDevolucao(dataDevolucao);
				emprestimo.setMulta(multa);
				emprestimo.setEstado(situacao);
				boolean retorno = emprestimoRepositorio.salvarEmprestimo(emprestimo, multa);
				if (retorno) {
					System.out.println("Emprestimo salvo com sucesso!");
				} else {
					System.out.println("Erro ao salvar emprestimo, verfique o log do console!");
				}
				break;
			case 2:
				System.out.println("Buscar Emprestimo");
				System.out.println("Digite o nome do usuário do usuário: ");
				 usuario = sc.nextLine();
				 emprestimo = new Emprestimo();
				emprestimo.setUsuario(usuario);
				Emprestimo emprestimoDB = emprestimoRepositorio.buscarEmprestimo(emprestimo);
				System.out.println("Livro: " + emprestimoDB.getLivro());
				System.out.println("Usuario: " + emprestimoDB.getUsuario());
				System.out.println("Situação do codigo: " + emprestimoDB.getEstado());
				System.out.println("Id do emprestimo: " + emprestimoDB.getId());
				System.out.println("Data de emprestimo (dd/MM/yyyy): " + emprestimoDB.getDataEmprestimo());
				System.out.println("Data de devolução (dd/MM/yyyy): " + emprestimoDB.getDataDevolucao());
				System.out.println("Estado: " + emprestimoDB.getEstado());
				System.out.println("Multa: " + emprestimoDB.getMulta());
				break;
			}
			sc.close();
		}
}
