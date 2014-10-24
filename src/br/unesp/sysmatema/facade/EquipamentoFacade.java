package br.unesp.sysmatema.facade;

import java.util.List;

import br.unesp.sysmatema.dao.EquipamentoDAO;
import br.unesp.sysmatema.model.Equipamento;

public class EquipamentoFacade {
	
	private EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
	
	public void save(Equipamento equipamento) {
		this.equipamentoDAO.beginTransaction();
		this.equipamentoDAO.save(equipamento);
		this.equipamentoDAO.commitAndCloseTransaction();
	}
	
	public void delete(Equipamento equipamento) {
		this.equipamentoDAO.beginTransaction();
		Equipamento persisted = this.equipamentoDAO.findReferenceOnly(equipamento.getId());
		this.equipamentoDAO.delete(persisted);
		this.equipamentoDAO.commitAndCloseTransaction();
	}
	
	public List<Equipamento> listAll() {
		this.equipamentoDAO.beginTransaction();
		List<Equipamento> results = this.equipamentoDAO.findAll();
		this.equipamentoDAO.closeTransaction();
		return results;
	}
	
	public Equipamento findEquipamento(int Id) {
		this.equipamentoDAO.beginTransaction();
		Equipamento result = this.equipamentoDAO.find(Id);
		this.equipamentoDAO.closeTransaction();
		return result;
	}
	
	public void update(Equipamento equipamento) {
		this.equipamentoDAO.beginTransaction();
		Equipamento persisted = this.equipamentoDAO.find(equipamento.getId());
		
		persisted.setConfiguracao(equipamento.getConfiguracao());
		persisted.setDataAquisicao(equipamento.getDataAquisicao());
		persisted.setDescricao(equipamento.getDescricao());
		persisted.setMarca(equipamento.getMarca());
		persisted.setModelo(equipamento.getModelo());
		persisted.setPatrimonio(equipamento.getPatrimonio());
		persisted.setRecad(equipamento.getRecad());
		persisted.setValorAquisicao(equipamento.getValorAquisicao());
		
		this.equipamentoDAO.update(persisted);
		
		this.equipamentoDAO.commitAndCloseTransaction();
		
	}
	
	public Equipamento findEquipamentoByDescricao(String descricao) {
		this.equipamentoDAO.beginTransaction();
		Equipamento result = this.equipamentoDAO.findEquipamentoByDescricao(descricao);
		this.equipamentoDAO.closeTransaction();
		return result;
	}
	
	public Equipamento findEquipamentoByModelo(String modelo) {
		this.equipamentoDAO.beginTransaction();
		Equipamento result = this.equipamentoDAO.findEquipamentoByModelo(modelo);
		this.equipamentoDAO.closeTransaction();
		return result;
	}

}
