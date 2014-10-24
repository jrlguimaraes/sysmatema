package br.unesp.sysmatema.facade;

import br.unesp.sysmatema.dao.UsuarioDAO;
import br.unesp.sysmatema.model.Usuario;

public class UsuarioFacade {

	private UsuarioDAO usuariodao;

	public Usuario isValidLogin(String email, String password) {

		this.usuariodao = new UsuarioDAO();

		usuariodao.beginTransaction();
		Usuario user = usuariodao.findByEmail(email);
		usuariodao.closeTransaction();

		if (user == null) user = null;

		return user;
	}

}
