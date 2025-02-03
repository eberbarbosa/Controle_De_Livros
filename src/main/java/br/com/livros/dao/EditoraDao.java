package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.Editora;

public interface EditoraDao {

	void inserir(Editora editora);

	void remover(Editora editora);

	void atualizar(Editora editora);

	Editora pesquisarPorId(Integer id);

	List<Editora> listarEditoras();

}
