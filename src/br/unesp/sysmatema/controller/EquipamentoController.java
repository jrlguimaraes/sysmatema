package br.unesp.sysmatema.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unesp.sysmatema.facade.EquipamentoFacade;
import br.unesp.sysmatema.model.Equipamento;

@ManagedBean
@ViewScoped
public class EquipamentoController extends GenericController {
	
	private EquipamentoFacade equipamentoFacade = new EquipamentoFacade(); 
	
	private Equipamento equipamento = new Equipamento();
	private List<Equipamento> equipamentos;
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public List<Equipamento> getEquipamentos() {
		if (this.equipamentos == null) {
			this.equipamentos = this.equipamentoFacade.listAll();
		}
		return this.equipamentos;
	}
	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
	
	public String salvarEquipamento() {
		
		equipamentoFacade.save(equipamento);
		this.displayInfoMessageToUser("OPERAÇÃO CONCLUIDA!");
		
		return "sucesso";
	}
	
	public void reset() {
		this.equipamento = null;
	}

}
