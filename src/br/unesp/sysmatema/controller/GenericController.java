package br.unesp.sysmatema.controller;


import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import br.unesp.sysmatema.util.JSFMessageUtil;

abstract class GenericController implements InterfaceController{

	/*
	 * recupera os dados da sessão
	 */
	private LoginController loginController;

	/*
	 * verifica se existe algum tipo de usuario na sessão
	 */
	public boolean isLogged() {
		this.loginController = (LoginController) 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USUARIO_LOGADO);

		if (loginController == null)
			return false;
		else
			return true;
	}


	/*
	 * retorna qual o nivel de permissao do usuario logado
	 */
	public char levelPermissionUserLogged() {
		if(this.isLogged())
			return this.loginController.getUsuario().getNivelPermissao();
		else
			return VISITANTE;
	}

	/*
	 * mensagens no sistema
	 */
	public void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new br.unesp.sysmatema.util.JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message);
	}

	public void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}

	public void closeDialog() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}

	public void keepDialogOpen() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}

	public RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}
}