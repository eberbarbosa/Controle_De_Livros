package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.Livro;

public interface LivroDao {

	void inserir(Livro livro);

	void remover(Livro livro);

	void atualizar(Livro livro);

	Livro pesquisarPorId(Integer id);

	List<Livro> listarLivros();

	List<Livro> listarLivrosDisponiveisParaEmprestimo();

	List<Livro> listarLivrosEmprestados();

}
