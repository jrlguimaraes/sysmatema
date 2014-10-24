/*package br.unesp.sysmatema.dao;

import java.util.HashMap;
import java.util.Map;

import br.unesp.sysmatema.model.Funcionario;


public class FuncionarioDAO extends GenericDAO<Funcionario> {

	private static final long serialVersionUID = 1L;
	
	public FuncionarioDAO() {
		super(Funcionario.class);
	}
	
	public Funcionario findByEmail(String email) {
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);
		return super.findOneResult(Funcionario.FIND_BY_EMAIL, parameters);
	}
	
}
*/