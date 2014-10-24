package br.unesp.sysmatema.dao;


import java.util.HashMap;
import java.util.Map;

import br.unesp.sysmatema.model.Equipamento;

public class EquipamentoDAO extends GenericDAO<Equipamento> {
	
	/**
	 * Número gerado pelo IDE do Eclipse (Add generated serial version ID).
	 * Esse número é baseado em algoritmo de hash (SHA) calculado com base 
	 * nos nomes de propriedades/metodos entre outros critérios.
	 */
	private static final long serialVersionUID = -6458143945987959553L;

	public EquipamentoDAO() {
		super(Equipamento.class);
	}
	
	public void delete(Equipamento equipamento) {
		super.delete(equipamento.getId(), Equipamento.class);
	}
	
	public Equipamento findEquipamentoByDescricao(String descricao) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("descricao", descricao);

		return super.findOneResult(Equipamento.FIND_EQUIPAMENTO_BY_DESCRICAO, parameters);
		
	}
	
	public Equipamento findEquipamentoByModelo(String modelo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("modelo", modelo);

		return super.findOneResult(Equipamento.FIND_EQUIPAMENTO_BY_MODELO, parameters);
		
	}

}
