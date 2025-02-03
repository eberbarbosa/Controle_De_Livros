package br.com.livros.dao;

import java.util.List;

import br.com.livros.entidades.Emprestimo;

public interface EmprestimoDao {

	void inserir(Emprestimo emprestimo);

	void atualizar(Emprestimo emprestimo);

	List<Emprestimo> listarEmprestimos();

}
