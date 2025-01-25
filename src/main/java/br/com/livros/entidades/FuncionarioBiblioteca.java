package br.com.livros.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class FuncionarioBiblioteca extends Pessoa {
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_usuario")
	Usuario usuario;
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_funcionarioBiblioteca")
	private List<Telefone> telefones = new ArrayList<Telefone>();
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	

}
