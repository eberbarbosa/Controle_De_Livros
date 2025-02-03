package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.Categoria;

public interface CategoriaDao {

	void inserir(Categoria categoria);

	void remover(Categoria categoria);

	void atualizar(Categoria categoria);

	Categoria pesquisarPorId(Integer id);

	List<Categoria> listarCategorias();

}
