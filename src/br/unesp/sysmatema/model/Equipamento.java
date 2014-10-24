package br.unesp.sysmatema.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
	@NamedQuery(name = "Equipamento.findByDescricao", query = "SELECT e FROM Equipamento e WHERE e.descricao LIKE :descricao"),
	@NamedQuery(name = "Equipamento.findByModelo", query = "SELECT e FROM Equipamento e WHERE e.modelo LIKE :modelo")
})
public class Equipamento implements Serializable {
	
	
	private static final long serialVersionUID = 8211429479807458135L;
	
	public final static String FIND_EQUIPAMENTO_BY_DESCRICAO = "Equipamento.findByDescricao";
	public final static String FIND_EQUIPAMENTO_BY_MODELO = "Equipamento.findByModelo";
	
	@Id
	@GeneratedValue
	@Column(name="idEquipamento")
	private Integer id;
	private String descricao;
	private String patrimonio;
	private String recad;
	private String marca;
	private String modelo;
	@Temporal(value = TemporalType.DATE)
	private Calendar dataAquisicao; 
	private double valorAquisicao;
	private String configuracao;

	// Com o mappedBy, nesta classe (Equipamento) 
	// estou afirmando que a classe OWNER é ReservaEquipamento
	@ManyToMany(mappedBy = "equipamentos")
	private List<ReservaEquipamento> reservaEquipamentos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getRecad() {
		return recad;
	}
	public void setRecad(String recad) {
		this.recad = recad;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(Calendar dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	public double getValorAquisicao() {
		return valorAquisicao;
	}
	public void setValorAquisicao(double valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}
	public String getConfiguracao() {
		return configuracao;
	}
	public void setConfiguracao(String configuracao) {
		this.configuracao = configuracao;
	}
	public List<ReservaEquipamento> getReservaEquipamentos() {
		return reservaEquipamentos;
	}
	public void setReservaEquipamentos(List<ReservaEquipamento> reservaEquipamentos) {
		this.reservaEquipamentos = reservaEquipamentos;
	}


}
