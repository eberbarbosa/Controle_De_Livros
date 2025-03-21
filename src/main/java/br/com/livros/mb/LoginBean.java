package br.com.livros.mb;

import java.io.Serializable;

import br.com.livros.dao.UsuarioDao;
import br.com.livros.entidades.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	@Inject
	private FuncionarioEUsuarioVerificadorBean verficadorBean;	
	private boolean opcaoCadastroUsuarioHabilitada;
	@Inject
	private UsuarioDao usuarioDao;
	private Usuario usuario = new Usuario();
	
	public String efetuarLogin() {
		
		Usuario usuarioEncontrado = usuarioDao.pesquisarUsuario(this.usuario);
		
		if(usuarioEncontrado != null) {
			
			usuarioLogado.logar(usuarioEncontrado);
			return "principal?faces-redirect=true";
			
		} else {
			this.usuario = new Usuario();
			return "login?faces-redirect=true";
		}
	}
	
	public String efetuarLogout() {
		
		usuarioLogado.deslogar();
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	public boolean isOpcaoCadastroUsuarioHabilitada() {
		
		opcaoCadastroUsuarioHabilitada = !verficadorBean.existeFuncionarioEUsuarioCadastrado();
		return opcaoCadastroUsuarioHabilitada;
	}
	
	public Usuario getUsuario() {
		
		return this.usuario;
	}	


}
