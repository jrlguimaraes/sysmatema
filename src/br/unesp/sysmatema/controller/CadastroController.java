package br.unesp.sysmatema.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import br.unesp.sysmatema.facade.PessoaFacade;
import br.unesp.sysmatema.model.Aluno;
import br.unesp.sysmatema.model.Docente;
import br.unesp.sysmatema.model.Endereco;
import br.unesp.sysmatema.model.Funcionario;
import br.unesp.sysmatema.model.Pessoa;
import br.unesp.sysmatema.model.Usuario;

@ManagedBean
@ViewScoped
public class CadastroController extends GenericController{

	private Pessoa pessoa;
	private Funcionario pessoaFuncionario;
	private Docente pessoaDocente;
	private Aluno pessoaAluno;

	private boolean funcionario = false;
	private boolean docente = false;
	private boolean aluno = false;

	private char perfil;


	@PostConstruct
	public void inicializa() {
		Endereco endereco = new Endereco();
		Usuario usuario = new Usuario();

		if (isDocente()){
			this.pessoaDocente = new Docente(); 
			this.pessoa = pessoaDocente;
		} else if (isFuncionario()){
			this.pessoaFuncionario = new Funcionario();
			this.pessoa = pessoaFuncionario;
		} else {//isAluno()
			this.pessoaAluno = new Aluno();
			this.pessoa = pessoaAluno;
		}

		/*
		 * verifica se o perfil de usuario
		 *  pode o cadastro pode definir o usuario como ativo ou não 
		 */
		if (super.levelPermissionUserLogged() >= FUNCIONARIO)
			usuario.setAtivo(true);
		else 
			usuario.setAtivo(false);

		/*
		 * seta o nivel de permissão q o usuario esta requerindo, 
		 * mas se o usuario q esta realizando o cadastro nao tiver 
		 * certos privilegios ele tem q aguardar a ativação
		 */
		usuario.setNivelPermissao(this.perfil);

		this.pessoa.setUsuario(usuario);
		this.pessoa.setEndereco(endereco);

	}


	public String cadastrar() {

		PessoaFacade pessoafacade = new PessoaFacade();

		pessoafacade.save(pessoa);;

		return "cadastrado";
	}

	public void verificar() {
		this.setAluno(false);
		this.setDocente(false);
		this.setFuncionario(false);
		if (this.getPerfil() == ALUNO) this.setAluno(true);
		if (this.getPerfil() == DOCENTE) this.setDocente(true);
		if (this.getPerfil() == FUNCIONARIO) this.setFuncionario(true);
		inicializa();
	}

	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();
	}



	public boolean isAluno() {
		return aluno;
	}

	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}

	public boolean isDocente() {
		return docente;
	}

	public void setDocente(boolean docente) {
		this.docente = docente;
	}


	public char getPerfil() {
		return perfil;
	}


	public void setPerfil(char perfil) {
		this.perfil = perfil;
	}

	
	public Docente getPessoaDocente() {
		return pessoaDocente;
	}


	public void setPessoaDocente(Docente pessoaDocente) {
		this.pessoaDocente = pessoaDocente;
	}


	public Aluno getPessoaAluno() {
		return pessoaAluno;
	}


	public void setPessoaAluno(Aluno pessoaAluno) {
		this.pessoaAluno = pessoaAluno;
	}


	public Funcionario getPessoaFuncionario() {
		return pessoaFuncionario;
	}


	public void setPessoaFuncionario(Funcionario pessoaFuncionario) {
		this.pessoaFuncionario = pessoaFuncionario;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public boolean isFuncionario() {
		return funcionario;
	}


	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}
	
}
