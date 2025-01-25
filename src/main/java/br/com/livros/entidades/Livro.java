package br.com.livros.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String  nome;
	@ManyToOne
	@JoinColumn(name = "id_editora")
	private Editora editora;
	@ManyToMany
	@JoinTable(name = "livro_autor", 
			joinColumns = {@JoinColumn(name = "id_livro")},
			inverseJoinColumns = {@JoinColumn(name = "id_autor")})
	private List<Autor> autores;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	private String lsbn;
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimo;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getLsbn() {
		return lsbn;
	}
	public void setLsbn(String lsbn) {
		this.lsbn = lsbn;
	}
	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	
	
	

	
	

}
