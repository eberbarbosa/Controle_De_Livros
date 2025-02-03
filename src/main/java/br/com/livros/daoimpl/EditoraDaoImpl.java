package br.com.livros.daoimpl;

import java.io.Serializable;
import java.util.List;

import br.com.livros.dao.EditoraDao;
import br.com.livros.dao.GenericoDao;
import br.com.livros.entidades.Editora;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class EditoraDaoImpl implements EditoraDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Editora, Integer> genericoDao;

	@Inject
	EditoraDaoImpl(EntityManager entityManager) {
		genericoDao = new GenericoDaoImpl<Editora, Integer>(Editora.class, entityManager);
	}

	@Override
	public void inserir(Editora editora) {
		genericoDao.inserir(editora);
	}

	@Override
	public void remover(Editora editora) {
		genericoDao.remover(editora);

	}

	@Override
	public void atualizar(Editora editora) {
		genericoDao.atualizar(editora);
	}

	@Override
	public Editora pesquisarPorId(Integer id) {
		return genericoDao.pesquisarPorID(id);
	}

	@Override
	public List<Editora> listarEditoras() {
		return genericoDao.listarTodos();
	}

}
