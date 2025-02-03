package br.com.livros.daoimpl;

import java.io.Serializable;
import java.util.List;

import br.com.livros.dao.EmprestimoDao;
import br.com.livros.dao.GenericoDao;
import br.com.livros.entidades.Emprestimo;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class EmprestimoDaoImpl implements EmprestimoDao, Serializable{

	private static final long serialVersionUID = 1L;
	private GenericoDao<Emprestimo, Integer> genericoDao;

	@Inject
	EmprestimoDaoImpl(EntityManager entityManager) {
		genericoDao = new GenericoDaoImpl<Emprestimo, Integer>(Emprestimo.class, entityManager);
	}

	@Override
	public void inserir(Emprestimo emprestimo) {
		genericoDao.inserir(emprestimo);
	}

	@Override
	public void atualizar(Emprestimo emprestimo) {
		genericoDao.atualizar(emprestimo);
	}

	@Override
	public List<Emprestimo> listarEmprestimos() {
		return genericoDao.listarTodos();
	}

}
