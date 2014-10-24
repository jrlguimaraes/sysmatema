package br.unesp.sysmatema.dao;

import java.util.HashMap;
import java.util.Map;

import br.unesp.sysmatema.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	/**
	 * Número gerado pelo IDE do Eclipse (Add generated serial version ID).
	 * Esse número é baseado em algoritmo de hash (SHA) calculado com base 
	 * nos nomes de propriedades/metodos entre outros critérios.
	 */
	private static final long serialVersionUID = -7609661125798797579L;

	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario findByEmail(String email) {
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);
		return super.findOneResult(Usuario.FIND_BY_EMAIL, parameters);
	}

}
