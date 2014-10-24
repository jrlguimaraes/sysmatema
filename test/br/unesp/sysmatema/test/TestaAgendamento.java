package br.unesp.sysmatema.test;

import static org.junit.Assert.*;
import static br.unesp.sysmatema.util.DataHoraUtil.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.unesp.sysmatema.model.Equipamento;
import br.unesp.sysmatema.model.ReservaEquipamento;

public class TestaAgendamento {

	private ReservaEquipamento reservaEquipamento;
	private Equipamento equipamento;
	List<Equipamento> equipamentos;

	@Before
	public void inicializa() {
		this.reservaEquipamento = new ReservaEquipamento();
		this.equipamento = new Equipamento();
		this.equipamentos = new ArrayList<Equipamento>();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void CriaAgendamentoComVariosEquipamentosTest() {
		String data1 = "24/09/2014 11:30";
		String data2 = "24/09/2014 15:00";
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		try {
			c1 = toCalendar(data1);
			c2 = toCalendar(data2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.reservaEquipamento.setDataInicio(c1);
		this.reservaEquipamento.setDataTermino(c2);

		try {
			this.equipamentos = this.getEquipamentos(20);
			this.reservaEquipamento.setEquipamentos(this.equipamentos);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(this.reservaEquipamento.getEquipamentos(),
				this.equipamentos);
		assertEquals(20, this.equipamentos.size());
		assertEquals(20, this.reservaEquipamento.getEquipamentos().size());
		assertEquals(1, this.reservaEquipamento.getEquipamentos().get(20));
		
		
		System.out.println(this.reservaEquipamento.getEquipamentos().get(19).getModelo());
		System.out.println(this.reservaEquipamento.getEquipamentos().get(0).getModelo());
	}

	@Test
	public void CriaAgendamentoComUmUnicoEquipamentoTest() {
		String data1 = "22/09/2014 13:30";
		String data2 = "22/09/2014 16:45";
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		try {
			c1 = toCalendar(data1);
			c2 = toCalendar(data2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.reservaEquipamento.setDataInicio(c1);
		this.reservaEquipamento.setDataTermino(c2);

		try {
			this.equipamentos = this.getEquipamentos(1);
			this.reservaEquipamento.setEquipamentos(this.equipamentos);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(this.reservaEquipamento.getEquipamentos(),
				this.equipamentos);
		assertEquals(1, this.equipamentos.size());
		assertEquals(1, this.reservaEquipamento.getEquipamentos().size());	

	}

	public List<Equipamento> getEquipamentos(int totalEquipamentos)
			throws Exception {

		List<Equipamento> equipamentos = new ArrayList<Equipamento>();

		for (int i = 1; i <= totalEquipamentos; i++) {

			Equipamento n = new Equipamento();
			n.setId(i);
			n.setMarca("Equipamento: " + i);
			n.setModelo("Modelo: " + i);
			n.setPatrimonio(Integer.toString(15000 + i));
			n.setRecad(Integer.toString(20000 + i));
			n.setValorAquisicao(1900.55);
			n.setDescricao("Serial Number: " + i + 1000);
			n.setConfiguracao("Configuracao: " + i);
			n.setDataAquisicao(toCalendar("01/01/2014 00:00"));
			equipamentos.add(n);
		}
		return equipamentos;
	}

	

}
