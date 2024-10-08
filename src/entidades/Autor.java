package entidades;

import java.time.LocalDate;

public class Autor {
    private Long id;
    private String nome;
    private String biografia;
    private String nacionalidade;
    private LocalDate dataNascimento;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Autor(Long id, String nome, String biografia, String nacionalidade, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.biografia = biografia;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }
}
