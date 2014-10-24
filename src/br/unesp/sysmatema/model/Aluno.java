package br.unesp.sysmatema.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Pessoa{

	/**
	 * Número gerado pelo IDE do Eclipse (Add generated serial version ID).
	 * Esse número é baseado em algoritmo de hash (SHA) calculado com base 
	 * nos nomes de propriedades/metodos entre outros critérios.
	 */
	private static final long serialVersionUID = 3905748951446652030L;
	
	private String ra;
	private String grau;
	private String curso;
	private int anoingresso;
	
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getGrau() {
		return grau;
	}
	public void setGrau(String grau) {
		this.grau = grau;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getAnoingresso() {
		return anoingresso;
	}
	public void setAnoingresso(int anoingresso) {
		this.anoingresso = anoingresso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anoingresso;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((grau == null) ? 0 : grau.hashCode());
		result = prime * result + ((ra == null) ? 0 : ra.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (anoingresso != other.anoingresso)
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (grau == null) {
			if (other.grau != null)
				return false;
		} else if (!grau.equals(other.grau))
			return false;
		if (ra == null) {
			if (other.ra != null)
				return false;
		} else if (!ra.equals(other.ra))
			return false;
		return true;
	}
	
	
}


