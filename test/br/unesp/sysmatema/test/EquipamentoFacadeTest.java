package br.unesp.sysmatema.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unesp.sysmatema.facade.EquipamentoFacade;
import br.unesp.sysmatema.model.Equipamento;

public class EquipamentoFacadeTest {
	
	private EquipamentoFacade facade = new EquipamentoFacade();
	private Equipamento equipamento;
	
	private String modelo = "VAIO SVF14N13CBS";
	private String descricao = "Intel Core i3 4GB 500GB LED Full HD 14 Touchscreen Windows 8";
	

	@Before
	public void inserirEquipamento() {
		Equipamento equip1 = new Equipamento();
		equip1.setMarca("Sony");
		equip1.setModelo(this.modelo);
		equip1.setDataAquisicao(Calendar.getInstance());
		equip1.setConfiguracao("Intel Core i3 4GB 500GB LED Full HD 14 Touchscreen Windows 8");
		equip1.setDescricao(this.descricao);
		equip1.setPatrimonio("20.002");
		equip1.setRecad("15.002");
		equip1.setValorAquisicao(3399.55);
		
		facade.save(equip1);
	}
	
	@Test
	public void pesquisarEquipamentoPorDescricao() {
		this.equipamento = null;
		this.equipamento =  facade.findEquipamentoByDescricao(this.descricao);
		
		assertNotNull(this.equipamento);
		assertEquals(this.descricao, this.equipamento.getDescricao());
		
	}
	
	@Test
	public void pesquisarEquipamentoInexistentePorDescricao() {
		this.equipamento = null;
		this.equipamento =  facade.findEquipamentoByDescricao("Sala de Reunião");
		
		assertNull(this.equipamento);
		
	}
	
	@Test
	public void pesquisarEquipamentoInexistentePorModelo() {
		this.equipamento = null;
		this.equipamento = facade.findEquipamentoByModelo("ANFITEATRO DO IGCE!");
		assertNull(this.equipamento);
	}
	
	@Test
	public void pesquisarEquipamentoPorModelo() {
		this.equipamento = null;
		this.equipamento =  facade.findEquipamentoByModelo(this.modelo);
		
		assertNotNull(this.equipamento);
		assertEquals(this.modelo, this.equipamento.getModelo());
		
	}
	
	@After
	public void deletandoEquipamentoPersistido(){
		this.equipamento = null;
		this.equipamento =  facade.findEquipamentoByDescricao(this.descricao);
		this.facade.delete(this.equipamento);
	}

}
