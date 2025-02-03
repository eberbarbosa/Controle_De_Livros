package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.Autor;

public interface AutorDao {

	void inserir(Autor autor);

	void remover(Autor autor);

	void atualizar(Autor autor);

	Autor pesquisarPorId(Integer id);

	List<Autor> listarAutores();

}
