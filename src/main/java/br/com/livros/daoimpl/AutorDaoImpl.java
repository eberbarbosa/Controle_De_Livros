package br.com.livros.daoimpl;

import java.io.Serializable;
import java.util.List;

import br.com.livros.dao.AutorDao;
import br.com.livros.dao.GenericoDao;
import br.com.livros.entidades.Autor;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class AutorDaoImpl implements AutorDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Autor, Integer> genericoDao;

	@Inject
	AutorDaoImpl(EntityManager entityManager) {
		genericoDao = new GenericoDaoImpl<Autor, Integer>(Autor.class, entityManager);
	}

	@Override
	public void inserir(Autor autor) {
		genericoDao.inserir(autor);
	}

	@Override
	public void remover(Autor autor) {
		genericoDao.remover(autor);
	}

	@Override
	public void atualizar(Autor autor) {
		genericoDao.atualizar(autor);
	}

	@Override
	public Autor pesquisarPorId(Integer id) {
		return genericoDao.pesquisarPorID(id);
	}

	@Override
	public List<Autor> listarAutores() {
		return genericoDao.listarTodos();
	}

}
