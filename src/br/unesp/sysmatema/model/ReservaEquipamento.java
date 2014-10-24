package br.unesp.sysmatema.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class ReservaEquipamento {
	@Id
	@GeneratedValue
	@Column(name = "idReservaEquipamento")
	private int id;
	private String titulo;
	private Calendar dataInicio;
	private Calendar dataTermino;

	// Mudar para:
	@ManyToMany
	@JoinTable(
			name = "ReservaEquipamento_has_Equipamento", 
			joinColumns = {@JoinColumn(name = "RESERVA_EQP_ID", referencedColumnName = "idReservaEquipamento")}, 
			inverseJoinColumns = {@JoinColumn(name = "EQP_ID", referencedColumnName = "idEquipamento")})
	// @OneToMany(mappedBy = "reservaEquipamento")
	private List<Equipamento> equipamentos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

}
