package br.unesp.sysmatema.dao;

import java.util.HashMap;
import java.util.Map;

import br.unesp.sysmatema.model.Pessoa;


public class PessoaDAO extends GenericDAO<Pessoa> {

	/**
	 * Número gerado pelo IDE do Eclipse (Add generated serial version ID).
	 * Esse número é baseado em algoritmo de hash (SHA) calculado com base 
	 * nos nomes de propriedades/metodos entre outros critérios.
	 */
	private static final long serialVersionUID = -2504030826558532148L;

	public PessoaDAO() {
		super(Pessoa.class);
	}
	
	public Pessoa findByEmail(String email) {
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);
		return super.findOneResult(Pessoa.FIND_BY_EMAIL, parameters);
	}
	
}
