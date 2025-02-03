package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.Leitor;

public interface LeitorDao {

	void inserir(Leitor leitor);

	void remover(Leitor leitor);

	void atualizar(Leitor leitor);

	Leitor pesquisarPorId(Integer id);

	List<Leitor> listarLeitores();

}
