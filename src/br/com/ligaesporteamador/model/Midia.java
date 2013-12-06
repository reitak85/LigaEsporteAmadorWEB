package br.com.ligaesporteamador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MIDIA")
public class Midia extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MIDIA_ID", length=10)
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="PATH")
	private String path;
	
	@Column(name="CLIENTE")
	private String cliente;
	
	@Column(name="CATEGORIA")
	private String categoria;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
