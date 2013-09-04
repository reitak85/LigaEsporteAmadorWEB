package br.com.ligaesporteamador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO_SISTEMA")
public class UsuarioSistema extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "USUARIO_SISTEMA_ID", length = 10)
	private Long id;

	@Column(name = "NOME", length = 150)
	private String nome;

	@Column(name = "EMAIL", length = 150)
	private String email;

	@Column(name = "SENHA", length = 255)
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

}
