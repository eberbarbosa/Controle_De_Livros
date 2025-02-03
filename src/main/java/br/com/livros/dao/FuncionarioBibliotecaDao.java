package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.FuncionarioBiblioteca;

public interface FuncionarioBibliotecaDao {

	void inserir(FuncionarioBiblioteca funcionarioBiblioteca);

	void remover(FuncionarioBiblioteca funcionarioBiblioteca);

	void atualizar(FuncionarioBiblioteca funcionarioBiblioteca);

	List<FuncionarioBiblioteca> listarFuncionariosBiblioteca();

	boolean existeFuncionarioCadastrado();

}
