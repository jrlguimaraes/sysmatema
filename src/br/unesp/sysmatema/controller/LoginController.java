package br.unesp.sysmatema.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import br.unesp.sysmatema.facade.PessoaFacade;
import br.unesp.sysmatema.facade.UsuarioFacade;
import br.unesp.sysmatema.model.Pessoa;
import br.unesp.sysmatema.model.Usuario;

/*
 * Classe de Controle de Login e redirecionamento com controle de tempo de sessa em web.xml
 */
@SessionScoped
@ManagedBean
public class LoginController extends GenericController {

	private Usuario usuario = new Usuario();
	private Pessoa pessoa = new Pessoa();
	
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	

	/*
	 * metodo para validar e autenticar o usuario
	 */
	public String checkLogin() {	
		/*teste fork no gitHub*/
		logger.warn("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX TESTANDO LOGGING XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

		UsuarioFacade usuarioFacade = new UsuarioFacade();
		Usuario usuario = usuarioFacade.isValidLogin(this.usuario.getEmail(),
				this.usuario.getSenha());
		
		/*if (super.isLogged())
			logout();*/

		if (usuario == null) {
			displayInfoMessageToUser("Usuário Não Encontrado!");
			return null;
		}

		if (!usuario.isAtivo()){
			displayInfoMessageToUser("Usuário Ainda Não Aprovado! Aguarde a Liberação do Administrador");
			return null;
		}

		if (!usuario.getSenha().equals(this.usuario.getSenha())){
			displayInfoMessageToUser("Senha Incorreta");
			return null;
		}

		PessoaFacade pessoaFacade = new PessoaFacade();

		this.pessoa = pessoaFacade.findPessoaByUser(usuario);
		/*SALVA ESTE CONTROLADOR "LoginController" na Sessão como "usuario" */
		
		this.usuario = usuario;
		FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().put(USUARIO_LOGADO, this);
	
		return PAGINA_INICIAL;

	}

	/*
	 * Remove a Sessao "Usuario"
	 */
	public String logout() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().remove(USUARIO_LOGADO);
		facesContext.getExternalContext().invalidateSession();
		
		this.setUsuario(null);
		
		return PAGINA_LOGIN;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}





}
