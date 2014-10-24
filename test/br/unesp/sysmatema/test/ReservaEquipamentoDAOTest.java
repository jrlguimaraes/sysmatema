package br.unesp.sysmatema.test;

import static org.junit.Assert.*;
import static br.unesp.sysmatema.util.DataHoraUtil.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.unesp.sysmatema.dao.EquipamentoDAO;
import br.unesp.sysmatema.dao.ReservaEquipamentoDAO;
import br.unesp.sysmatema.model.Equipamento;
import br.unesp.sysmatema.model.ReservaEquipamento;

public class ReservaEquipamentoDAOTest {
	
	private ReservaEquipamento reservaEquipamento;
	private List<Equipamento> equipamentos;
 	
	
	@Before
	public void inicializa() {
		this.reservaEquipamento = new ReservaEquipamento();
		this.equipamentos = new ArrayList<Equipamento>();
	}
	

	@Test
	public void reservandoUmUnicoEquipamento() {
	
		String dataInicio = "26/09/2014 14:00";
		String dataTermino = "26/09/2014 17:00";
		
		EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		
		equipamentoDAO.beginTransaction();
		Equipamento equip = equipamentoDAO.find(1); //previamente cadastrado
		equipamentoDAO.closeTransaction();
		
		this.equipamentos.add(equip);
		
		try {
	
			System.out.println(this.equipamentos.get(0).getMarca());
			
			this.reservaEquipamento.setTitulo("Teste de Reserva de Equipamento");
			this.reservaEquipamento.setDataInicio(toCalendar(dataInicio));
			this.reservaEquipamento.setDataTermino(toCalendar(dataTermino));			
			
			this.reservaEquipamento.setEquipamentos(this.equipamentos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ReservaEquipamentoDAO dao = new ReservaEquipamentoDAO();
		
		dao.beginTransaction();
		dao.save(reservaEquipamento);
		dao.commitAndCloseTransaction();
	
	}
	
	@Test
	public void reservandoDoisEquipamentos() {
	
		String dataInicio = "29/09/2014 14:00";
		String dataTermino = "30/09/2014 17:00";
		
		EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		
		equipamentoDAO.beginTransaction();
		this.equipamentos.add(equipamentoDAO.find(1));
		this.equipamentos.add(equipamentoDAO.find(2));	
		equipamentoDAO.closeTransaction();
		
		try {
			System.out.println(this.equipamentos.get(0).getMarca());
			
			this.reservaEquipamento.setTitulo("Teste de Reserva de Equipamento");
			this.reservaEquipamento.setDataInicio(toCalendar(dataInicio));
			this.reservaEquipamento.setDataTermino(toCalendar(dataTermino));			
			
			this.reservaEquipamento.setEquipamentos(this.equipamentos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ReservaEquipamentoDAO dao = new ReservaEquipamentoDAO();
		
		dao.beginTransaction();
		dao.save(reservaEquipamento);
		dao.commitAndCloseTransaction();
	}

}
