package br.com.livros.entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevista;
	private LocalDate dataDevolucao;
	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;
	@ManyToOne
	@JoinColumn(name = "id_leitor")
	private Leitor leitor;
	@ManyToOne
	@JoinColumn(name = "id_funcionarioBiblioteca")
	private FuncionarioBiblioteca funcionarioBiblioteca;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDate getDataPrevista() {
		return dataPrevista;
	}
	public void setDataPrevista(LocalDate dataPrevista) {
		this.dataPrevista = dataPrevista;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Leitor getLeitor() {
		return leitor;
	}
	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}
	public FuncionarioBiblioteca getFuncionarioBiblioteca() {
		return funcionarioBiblioteca;
	}
	public void setFuncionarioBiblioteca(FuncionarioBiblioteca funcionarioBiblioteca) {
		this.funcionarioBiblioteca = funcionarioBiblioteca;
	}
	
	
	
	

}
