package br.com.livros.mb;

import br.com.livros.dao.FuncionarioBibliotecaDao;
import br.com.livros.dao.UsuarioDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class FuncionarioEUsuarioVerificadorBean {
	
	@Inject
	private FuncionarioBibliotecaDao funcionarioBibliotecaDao;
	@Inject
	private UsuarioDao usuarioDao;
	
	public boolean existeFuncionarioEUsuarioCadastrado() {
		return (funcionarioBibliotecaDao.existeFuncionarioCadastrado() && 
				usuarioDao.existeUsuarioCadastrado());
	}

}
