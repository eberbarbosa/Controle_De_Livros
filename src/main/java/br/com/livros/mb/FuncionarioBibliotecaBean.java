package br.com.livros.mb;

import java.util.List;

import br.com.livros.dao.FuncionarioBibliotecaDao;
import br.com.livros.entidades.Endereco;
import br.com.livros.entidades.FuncionarioBiblioteca;
import br.com.livros.entidades.Telefone;
import br.com.livros.entidades.Usuario;
import br.com.livros.interceptadores.Transacional;
import br.com.livros.util.Navegador;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class FuncionarioBibliotecaBean {
	
	@Inject
	private FuncionarioBibliotecaDao funcionarioBibliotecaDao;
	@Inject
	private FuncionarioEUsuarioVerificadorBean verificadoBean;
	private FuncionarioBiblioteca funcionarioBiblioteca = new FuncionarioBiblioteca();
	private Telefone telefoneFixo = new Telefone();
	private Telefone telefoneCelular = new Telefone();
	private List<FuncionarioBiblioteca> funcionariosBiblioteca;
	@Inject
	private Navegador navegador;
	private boolean   redirecionarParaLogin;
	private boolean   campoAdminDesabilitado;
	
	
	public FuncionarioBibliotecaBean() {
		
		funcionarioBiblioteca.setEndereco(new Endereco());
		
		Usuario usuario = new Usuario();
		usuario.setFuncionarioBiblioteca(funcionarioBiblioteca);
		funcionarioBiblioteca.setUsuario(usuario);
	}
	
	// Método isCampoAdminDesabilitado
	public boolean isCampoAdminDesabilitado() {
		
		campoAdminDesabilitado = !verificadoBean.existeFuncionarioEUsuarioCadastrado();
		
		return campoAdminDesabilitado;
	}
	
	// Método Salvar
	public void salvar() {
		
		if(isCampoAdminDesabilitado()) {
			redirecionarParaLogin = true;
		}
		
		if(funcionarioBiblioteca.getId() == null) {
			vincularTelefones();
			funcionarioBibliotecaDao.inserir(funcionarioBiblioteca);
			
		} else {
			funcionarioBiblioteca.getTelefones().clear();
			vincularTelefones();
			funcionarioBibliotecaDao.atualizar(funcionarioBiblioteca);
		}
		
		telefoneFixo = new Telefone();
		telefoneCelular = new Telefone();
		funcionarioBiblioteca = new FuncionarioBiblioteca();
		funcionariosBiblioteca = funcionarioBibliotecaDao.listarFuncionariosBiblioteca();
		
	}
	
	
	// Método redirecionarParaLogin
	public void redirecionarParaLogin() {
		
		if(redirecionarParaLogin) {
			navegador.redirecionar("login");
		}
	}
	
	
	// Método vincularTelefones
	public void vincularTelefones() {
		
		telefoneFixo.setFixo(true);
		funcionarioBiblioteca.getTelefones().add(telefoneFixo);
		funcionarioBiblioteca.getTelefones().add(telefoneCelular);
		
	}
	
	
	// Método Alterar
	public void alterar(FuncionarioBiblioteca funcionarioBiblioteca) {
		
		this.funcionarioBiblioteca = funcionarioBiblioteca;
		
		for(Telefone telefone : funcionarioBiblioteca.getTelefones()) {
			if(telefone.isFixo()) {
				this.telefoneFixo = telefone;
				
			} else {
				this.telefoneCelular = telefone;
			}
		}
	}
	
	
	// Método remover
	@Transacional
	public void remover(FuncionarioBiblioteca funcionarioBiblioteca) {
		
		funcionarioBibliotecaDao.remover(funcionarioBiblioteca);
		funcionariosBiblioteca = funcionarioBibliotecaDao.listarFuncionariosBiblioteca();
	}
	
	
	// Método getFuncionariosBiblioteca	
	@Transacional
	public List<FuncionarioBiblioteca> getFuncionariosBiblioteca(){
		if(funcionariosBiblioteca == null){
			funcionariosBiblioteca = funcionarioBibliotecaDao.listarFuncionariosBiblioteca();
		}
		
		return funcionariosBiblioteca;
	}
	
	

}
