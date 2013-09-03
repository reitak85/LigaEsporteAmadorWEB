package br.com.ligaesporteamador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CONTATO",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Contato  extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "CONTATO_ID", length = 10)
	private Long id;

	@Column(name = "EMAIL", length = 100)
	private String email;

	@Column(name = "TELEFONE_CELULAR", length = 50)
	private String telefoneCelular;

	@Column(name = "TELEFONE_RESIDENCIAL", length = 50)
	private String telefoneResidencial;

	@Column(name = "TELEFONE_COMERCIAL", length = 50)
	private String telefoneComercial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

}
