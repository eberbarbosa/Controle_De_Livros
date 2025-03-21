package br.com.livros.mb;

import java.io.Serializable;

import br.com.livros.entidades.Usuario;

public class UsuarioLogadoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void deslogar() {
		this.usuario = null;
	}
	
	public boolean isLogado() {
		return usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
