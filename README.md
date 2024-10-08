# Sistema de Gerenciamento de Biblioteca

## Desafio 01

### SP - SPRINGBOOT + AWS - SETEMBRO/2024

---

## Descrição do Projeto

Este projeto tem como objetivo desenvolver um **Sistema de Gerenciamento de Biblioteca**, que permite cadastrar livros, autores e membros, além de realizar empréstimos e devoluções, gerando relatórios pertinentes. O sistema foi implementado utilizando conceitos de Orientação a Objetos, programação funcional, e JPA/Hibernate para a persistência de dados.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação.
- **Spring Boot:** Framework para desenvolvimento de aplicações Java.
- **JPA/Hibernate:** Para persistência de dados.
- **Java Collections Framework:** Uso de `Set` e `Map`.

## Funcionalidades

- Cadastro de **Livros**, **Autores**, e **Membros**.
- Empréstimos e devoluções de livros.
- Geração de relatórios de empréstimos e multas.

## Requisitos

1. **Classes e variaveis:**
   - `Livro`: `titulo`, `autor`, `dataPublicacao`, `isbn`, `genero`, `quantidade`
   - `Autor`: `nome`, `dataNascimento`, `nacionalidade`, `biografia`
   - `Membro`: `nome`, `endereco`, `telefone`, `email`, `dataAssociacao`
   - `Emprestimo`: `livro`, `membro`, `dataEmprestimo`, `dataDevolucao`, `estado`, `multa`

2. ### Regras de Negócio

1. **Cadastro de Livros:** Cada livro deve ter um título, autor, data de publicação, ISBN único, gênero e quantidade disponível.
2. **Cadastro de Autores:** Cada autor deve ter um nome, data de nascimento, nacionalidade e biografia.
3. **Cadastro de Membros:** Cada membro deve ter um nome, endereço, telefone, e-mail e data de associação.
4. **Empréstimo de Livros:** Um membro pode emprestar um livro se houver quantidade disponível.
5. **Devolução de Livros:** O sistema calcula a multa por atraso com base no número de dias de atraso.
6. **Geração de Relatórios:** O sistema permite a geração de relatórios de livros emprestados, membros com multas, etc.

   ## Funcionalidades

- Cadastro de livros, autores e membros.
- Gerenciamento de empréstimos e devoluções.
- Cálculo de multas por atraso.
- Geração de relatórios.
