package br.unesp.sysmatema.controller;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import java.util.regex.Pattern;

public class PhaseListenerController extends GenericController implements PhaseListener{

	/*
	 * Filtro de paginas protegidas PhaseListener referenciada em faces-config.xml
	 */

	private static final long serialVersionUID = 1L;
	private static final String FOLDER_LOGGED = "^/logged/.*";
	private static final String FOLDER_ALUNO = "^/area_aluno/.*";
	private static final String FOLDER_DOCENTE = "^/area_docente/.*";
	private static final String FOLDER_FUNCIONARIO = "/area_func/.*";
	private static final String FOLDER_ADMINISTRADOR = "^/area_admin/.*";

	/*
	 * filtro para ações depois de um evento de redirecionamento de paginas
	 */
	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext facesContext = event.getFacesContext();
		String viewId = facesContext.getViewRoot().getViewId();

		boolean isFolderLogged = Pattern.matches(FOLDER_LOGGED, viewId);
		boolean isFolderAluno = Pattern.matches(FOLDER_ALUNO, viewId);
		boolean isFolderDocente = Pattern.matches(FOLDER_DOCENTE, viewId);
		boolean isFolderFuncionario = Pattern.matches(FOLDER_FUNCIONARIO, viewId);
		boolean isFolderAdministrador = Pattern.matches(FOLDER_ADMINISTRADOR, viewId);

		if (isFolderLogged && super.levelPermissionUserLogged() == VISITANTE)
			this.redirect(facesContext, PAGINA_LOGIN);

		else if (isFolderAluno && super.levelPermissionUserLogged() < ALUNO)
			this.redirect(facesContext, PAGINA_INICIAL);

		else if (isFolderDocente && super.levelPermissionUserLogged() < DOCENTE)
			this.redirect(facesContext, PAGINA_INICIAL);

		else if (isFolderFuncionario && super.levelPermissionUserLogged() < FUNCIONARIO)
			this.redirect(facesContext, PAGINA_INICIAL);

		else if (isFolderAdministrador && super.levelPermissionUserLogged() < ADMINISTRADOR)
			this.redirect(facesContext, PAGINA_INICIAL);


	}

	public void redirect(FacesContext fc, String pagina) {
		NavigationHandler navigator = fc.getApplication().getNavigationHandler();
		navigator.handleNavigation(fc, null, pagina);
		super.displayErrorMessageToUser("Você não tem Privilégios "
				+ "para Acessar esta Funcionalidade! Contate seu Administrador!");

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}


}
