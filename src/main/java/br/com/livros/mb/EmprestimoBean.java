package br.com.livros.mb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.livros.dao.EmprestimoDao;
import br.com.livros.dao.LeitorDao;
import br.com.livros.dao.LivroDao;
import br.com.livros.entidades.Emprestimo;
import br.com.livros.entidades.FuncionarioBiblioteca;
import br.com.livros.entidades.Leitor;
import br.com.livros.entidades.Livro;
import br.com.livros.interceptadores.Transacional;
import br.com.livros.util.MensagemUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EmprestimoBean {

	@Inject
	private EmprestimoDao emprestimoDao;
	private Emprestimo emprestimo = new Emprestimo();
	@Inject
	private LivroDao livroDao;
	private Integer idLivro;
	private List<Livro> livrosDisponiveis;
	@Inject
	private LeitorDao leitorDao;
	private Integer idLeitor;
	@Inject
	private UsuarioLogadoBean usuarioLogadoBean;
	String dataEmprestimoFormatada;
	String dataPrevistaFormatada;

	public EmprestimoBean() {
		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDataPrevista(LocalDate.now().plusDays(7));

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataEmprestimoFormatada      = emprestimo.getDataEmprestimo().format(formatador);
		dataPrevistaFormatada        = emprestimo.getDataPrevista().format(formatador);
	}

	@Transacional
	public void realizarEmprestimo() {
		Livro livro = livroDao.pesquisarPorId(idLivro);
		Leitor leitor = leitorDao.pesquisarPorId(idLeitor);
		FuncionarioBiblioteca funcionarioBiblioteca = usuarioLogadoBean.getUsuario().getFuncionarioBiblioteca();

		emprestimo.setLivro(livro);
		livro.getEmprestimo().add(emprestimo);

		emprestimo.setLeitor(leitor);
		emprestimo.setFuncionarioBiblioteca(funcionarioBiblioteca);

		emprestimoDao.inserir(emprestimo);

		livrosDisponiveis = livroDao.listarLivrosDisponiveisParaEmprestimo();

		MensagemUtil.addMensagemInformativa("Sucesso - ", "Empréstimo realizado com sucesso!");
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	@Transacional
	public List<Livro> getLivrosDisponiveis() {
		if (livrosDisponiveis == null) {
			livrosDisponiveis = livroDao.listarLivrosDisponiveisParaEmprestimo();
		}

		return livrosDisponiveis;
	}

	public Integer getIdLeitor() {
		return idLeitor;
	}

	public void setIdLeitor(Integer idLeitor) {
		this.idLeitor = idLeitor;
	}

	public String getDataEmprestimoFormatada() {
		return dataEmprestimoFormatada;
	}

	public String getDataPrevistaFormatada() {
		return dataPrevistaFormatada;
	}

}
