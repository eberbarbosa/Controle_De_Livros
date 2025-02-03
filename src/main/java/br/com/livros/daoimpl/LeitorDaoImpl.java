package br.com.livros.daoimpl;

import java.io.Serializable;
import java.util.List;

import br.com.livros.dao.GenericoDao;
import br.com.livros.dao.LeitorDao;
import br.com.livros.entidades.Leitor;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class LeitorDaoImpl implements LeitorDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Leitor, Integer> genericoDao;

	@Inject
	LeitorDaoImpl(EntityManager entityManager) {
		genericoDao = new GenericoDaoImpl<Leitor, Integer>(Leitor.class, entityManager);
	}

	@Override
	public void inserir(Leitor leitor) {
		genericoDao.inserir(leitor);
	}

	@Override
	public void remover(Leitor leitor) {
		genericoDao.remover(leitor);

	}

	@Override
	public void atualizar(Leitor leitor) {
		genericoDao.atualizar(leitor);
	}

	@Override
	public Leitor pesquisarPorId(Integer id) {
		return genericoDao.pesquisarPorID(id);
	}

	@Override
	public List<Leitor> listarLeitores() {
		return genericoDao.listarTodos();
	}

}
