package br.unesp.sysmatema.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="email")})
@NamedQuery(name = "Usuario.findByEmail", query = "select u from Usuario u where u.email like :email")
public class Usuario implements Serializable {
	
	/**
	 * Número gerado pelo IDE do Eclipse (Add generated serial version ID).
	 * Esse número é baseado em algoritmo de hash (SHA) calculado com base 
	 * nos nomes de propriedades/metodos entre outros critérios.
	 */
	private static final long serialVersionUID = 1709987225096819086L;

	@Id
	private String email;
	private String senha;
	private char nivelPermissao;
	private boolean ativo;

	public static final String FIND_BY_EMAIL = "Usuario.findByEmail";
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getNivelPermissao() {
		return nivelPermissao;
	}

	public void setNivelPermissao(char nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + nivelPermissao;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nivelPermissao != other.nivelPermissao)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	

}
