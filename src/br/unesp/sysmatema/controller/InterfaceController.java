package br.unesp.sysmatema.controller;

import org.primefaces.context.RequestContext;


interface InterfaceController {

	final static String PAGINA_LOGIN = "login";
	final static String PAGINA_INICIAL = "index";
	
	final static String USUARIO_LOGADO = "logado";	
	final static char ADMINISTRADOR = '4';
	final static char FUNCIONARIO = '3';
	final static char DOCENTE = '2';
	final static char ALUNO = '1';
	final static char VISITANTE = '0';
	
	final static String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	
	/*controle de permissões*/
	char levelPermissionUserLogged();
	
	/*mensagens no sistema*/
	void displayErrorMessageToUser(String message);
	void displayInfoMessageToUser(String message);
	void closeDialog();
	void keepDialogOpen();
	RequestContext getRequestContext() ;
	
}
