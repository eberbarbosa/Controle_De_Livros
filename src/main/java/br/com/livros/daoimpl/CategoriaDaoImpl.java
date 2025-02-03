package br.com.livros.daoimpl;

import java.io.Serializable;
import java.util.List;

import br.com.livros.dao.CategoriaDao;
import br.com.livros.dao.GenericoDao;
import br.com.livros.entidades.Categoria;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class CategoriaDaoImpl implements CategoriaDao, Serializable {

	private static final long serialVersionUID = 1L;
	private GenericoDao<Categoria, Integer> genericoDao;

	@Inject
	CategoriaDaoImpl(EntityManager entityManager) {
		genericoDao = new GenericoDaoImpl<Categoria, Integer>(Categoria.class, entityManager);
	}

	@Override
	public void inserir(Categoria categoria) {
		genericoDao.inserir(categoria);
	}

	@Override
	public void remover(Categoria categoria) {
		genericoDao.remover(categoria);
	}

	@Override
	public void atualizar(Categoria categoria) {
		genericoDao.atualizar(categoria);
	}

	@Override
	public Categoria pesquisarPorId(Integer id) {
		return genericoDao.pesquisarPorID(id);
	}

	@Override
	public List<Categoria> listarCategorias() {
		return genericoDao.listarTodos();
	}

}
