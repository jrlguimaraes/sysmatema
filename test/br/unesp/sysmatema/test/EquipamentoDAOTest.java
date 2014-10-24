package br.unesp.sysmatema.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unesp.sysmatema.dao.EquipamentoDAO;
import br.unesp.sysmatema.model.Equipamento;

public class EquipamentoDAOTest {

	private String modelo = "VAIO SVF14N13CBS";
	private String descricao = "Intel Core i3 4GB 500GB LED Full HD 14 Touchscreen Windows 8";
	
	
	@Before
	public void inserindoUmEquipamentoNoBancoDeDados() {

		EquipamentoDAO dao = new EquipamentoDAO();

		Equipamento equip1 = new Equipamento();
		equip1.setMarca("Sony");
		equip1.setModelo(this.modelo);
		equip1.setDataAquisicao(Calendar.getInstance());
		equip1.setConfiguracao("Intel Core i3 4GB 500GB LED Full HD 14 Touchscreen Windows 8");
		equip1.setDescricao(this.descricao);
		equip1.setPatrimonio("20.002");
		equip1.setRecad("15.002");
		equip1.setValorAquisicao(3399.55);

		dao.beginTransaction();
		dao.save(equip1);
		dao.commitAndCloseTransaction();

		dao.beginTransaction();
		Equipamento persisted = dao
				.findEquipamentoByDescricao(this.descricao);
		dao.closeTransaction();
		
		System.out.println(persisted.getMarca());
		System.out.println(equip1.getMarca());

		assertEquals(persisted.getMarca(), equip1.getMarca());
		assertEquals(persisted.getModelo(), equip1.getModelo());

	}
	
	@Test
	public void buscaEquipamentoPorDescricao() {
		EquipamentoDAO dao = new EquipamentoDAO();

		Equipamento equip1;

		dao.beginTransaction();
		equip1 = dao.findEquipamentoByDescricao(this.descricao);
		dao.closeTransaction();

		assertNotNull(equip1);
		assertEquals(this.descricao, equip1.getDescricao());
		System.out.println(equip1.getDescricao());

	}

	@Test
	public void buscaEquipamentoPorDescricaoInexistente() {
		EquipamentoDAO dao = new EquipamentoDAO();

		Equipamento equip1;

		dao.beginTransaction();
		equip1 = dao.findEquipamentoByDescricao("SALA DE REUNIÃO");
		dao.closeTransaction();

		assertNull(equip1);
	}
	
	@Test
	public void buscaEquipamentoPorModelo() {
		EquipamentoDAO dao = new EquipamentoDAO();

		Equipamento equip1;

		dao.beginTransaction();
		equip1 = dao.findEquipamentoByModelo(this.modelo);
		dao.closeTransaction();

		assertNotNull(equip1);
		assertEquals(this.modelo, equip1.getModelo());
		System.out.println(equip1.getModelo());
	}

	@Test
	public void buscaEquipamentoPorModeloInexistente() {
		EquipamentoDAO dao = new EquipamentoDAO();

		Equipamento equip1;

		dao.beginTransaction();
		equip1 = dao.findEquipamentoByModelo("SALA DE REUNIÃO");
		dao.closeTransaction();

		assertNull(equip1);
	}

	@After
	public void deletandoRegistro() {
		
		EquipamentoDAO dao = new EquipamentoDAO();

		Equipamento persisted;
		
		dao.beginTransaction();
		
		persisted = dao.findEquipamentoByDescricao(this.descricao);
		
		assertNotNull(persisted);

		assertEquals(this.descricao, persisted.getDescricao());
		
		dao.delete(persisted);

		dao.commitAndCloseTransaction();
		
	}

}
